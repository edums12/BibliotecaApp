package eduardo.poo.biblioteca.Adapters

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eduardo.poo.biblioteca.Models.Livro
import eduardo.poo.biblioteca.Models.Pessoa
import eduardo.poo.biblioteca.Models.Reserva
import eduardo.poo.biblioteca.R
import eduardo.poo.biblioteca.Retrofit.RetrofitInitialize
import kotlinx.android.synthetic.main.fragment_reserva.*
import retrofit2.Call
import retrofit2.Response

class ReservaAdapter(private val context: Context, private val list: ArrayList<Livro>) : RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservaViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ReservaViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ReservaViewHolder, position: Int) {
        holder.bind(position, list[position])
    }


    inner class ReservaViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_view_locacao, parent, false)){

        private var mLayoutItem: ConstraintLayout? = null
        private var mExemplar: TextView? = null
        private var mDataLocacao: TextView? = null
        private var mDiasRestantes: TextView? = null

        init {
            mLayoutItem = itemView.findViewById(R.id.layout_item)
            mExemplar = itemView.findViewById(R.id.list_item_exemplar)
            mDataLocacao = itemView.findViewById(R.id.list_item_data_locacao)
            mDiasRestantes = itemView.findViewById(R.id.list_item_dias_restantes)
        }

        fun bind(position: Int, livro: Livro){
            mExemplar?.text = livro.titulo
            mDataLocacao?.text = livro.exemplaresDisponiveisDisplay()
            mDiasRestantes?.text = ""

            mLayoutItem?.setOnClickListener { _ ->
                val builder = AlertDialog.Builder(context)

                builder
                    .setTitle("Reservar livro")
                    .setMessage("Deseja reservar o livro \"" + livro.titulo + "\"?")

                builder.setPositiveButton("Reservar"){ _, _ ->
                    RetrofitInitialize().livros().also {
                        it.reservar(Pessoa.getInstance().id(), livro.id_livro).enqueue(object :retrofit2.Callback<Reserva>{
                            override fun onFailure(call: Call<Reserva>, t: Throwable) {
                                Toast.makeText(context, "Ops! " + t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<Reserva>, response: Response<Reserva>) {
                                response.body()?.let{ reserva ->

                                    AlertDialog.Builder(context)
                                        .setTitle("Reservar livro")
                                        .setMessage("Livro reservado com sucesso.\nVocê tem até o dia " + reserva.data_prazo_retirada_display + " para retirá-lo.")
                                        .setNeutralButton("Entendi"){ dialog, _ -> dialog.dismiss() }
                                        .create()
                                        .show()

                                    list.remove(livro)

                                    this@ReservaAdapter.notifyItemRemoved(position)
                                }
                            }
                        })
                    }
                }

                builder.setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.dismiss()
                }

                val dialog: AlertDialog = builder.create()

                dialog.show()
            }
        }
    }
}
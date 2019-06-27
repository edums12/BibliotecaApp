package eduardo.poo.biblioteca.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eduardo.poo.biblioteca.Models.Locacao
import eduardo.poo.biblioteca.R

class LocacaoAdapter(private val list: ArrayList<Locacao>) : RecyclerView.Adapter<LocacaoAdapter.LocacaoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocacaoViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return LocacaoViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LocacaoViewHolder, position: Int) {
        holder.bind(list[position])
    }


    inner class LocacaoViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_view_locacao, parent, false)){

        private var mExemplar : TextView? = null
        private var mDataLocacao: TextView? = null
        private var mDiasRestantes: TextView? = null

        init {
            mExemplar = itemView.findViewById(R.id.list_item_exemplar)
            mDataLocacao = itemView.findViewById(R.id.list_item_data_locacao)
            mDiasRestantes = itemView.findViewById(R.id.list_item_dias_restantes)
        }

        fun bind(locacao: Locacao){
            mExemplar?.text = locacao.exemplar
            mDataLocacao?.text = locacao.data_locacao
            mDiasRestantes?.text = locacao.diasRestantesDisplay()
        }
    }
}
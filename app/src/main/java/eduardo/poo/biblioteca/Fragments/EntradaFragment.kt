package eduardo.poo.biblioteca.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import eduardo.poo.biblioteca.Components.Companion.Alert
import eduardo.poo.biblioteca.Models.Pessoa
import eduardo.poo.biblioteca.R
import eduardo.poo.biblioteca.Retrofit.RetrofitInitialize
import kotlinx.android.synthetic.main.fragment_entrada.*
import retrofit2.Call
import retrofit2.Response

class EntradaFragment : Fragment() {

    companion object{
        fun newInstance(): EntradaFragment{
            return EntradaFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entrada, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Entre com o seu código"

        btnEntrar.setOnClickListener { _ ->
            if (!txtCodigo.text.toString().trim().isEmpty()) {
                RetrofitInitialize().pessoa().also {

                    it.get(txtCodigo.text.toString()).enqueue(object : retrofit2.Callback<Pessoa> {

                        override fun onFailure(call: Call<Pessoa>, t: Throwable) {
                            Toast.makeText(context, "Ops!. " + t.message, LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<Pessoa>, response: Response<Pessoa>) {
                            val pessoa: Pessoa? = response.body()

                            pessoa?.let { p ->
                                Pessoa.newInstance(p)
                            }

                            activity?.supportFragmentManager?.beginTransaction()
                                ?.replace(R.id.root_layout, InitFragment.newInstance(), "Tela Inicial")?.commit()
                        }
                    })
                }
            } else {
                Alert(context!!, "Aviso", "Insira o seu código para continuar").show()
            }
        }
    }
}

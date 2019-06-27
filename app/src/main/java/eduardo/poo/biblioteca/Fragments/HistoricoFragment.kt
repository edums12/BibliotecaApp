package eduardo.poo.biblioteca.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import eduardo.poo.biblioteca.Adapters.LocacaoAdapter
import eduardo.poo.biblioteca.Models.Locacao
import eduardo.poo.biblioteca.Models.Pessoa

import eduardo.poo.biblioteca.R
import eduardo.poo.biblioteca.Retrofit.RetrofitInitialize
import kotlinx.android.synthetic.main.fragment_historico.*
import kotlinx.android.synthetic.main.fragment_inicial.*
import retrofit2.Call
import retrofit2.Response


class HistoricoFragment : Fragment() {

    private var locacoes :ArrayList<Locacao> = arrayListOf()

    companion object{
        private var instance : HistoricoFragment? = null

        fun newInstance() :HistoricoFragment {
            instance = HistoricoFragment()

            return instance as HistoricoFragment
        }

        fun getInstance(): HistoricoFragment{
            return if (instance != null)
                instance as HistoricoFragment
            else
                newInstance()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_historico, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponents()
    }

    private fun initializeComponents() {
        RetrofitInitialize().locacoes().also {
            it.get(Pessoa.getInstance().id()).enqueue(object :retrofit2.Callback<ArrayList<Locacao>>{
                override fun onFailure(call: Call<ArrayList<Locacao>>, t: Throwable) {
                    Toast.makeText(context, "Ops! " + t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ArrayList<Locacao>>, response: Response<ArrayList<Locacao>>) {
                    response.body()?.let{ list ->
                        locacoes = list
                    }

                    recyclerViewLocacoes.apply{
                        layoutManager = LinearLayoutManager(activity)

                        adapter = LocacaoAdapter(locacoes)
                    }

                    recyclerViewLocacoes.adapter?.notifyDataSetChanged()
                }
            })
        }
    }
}

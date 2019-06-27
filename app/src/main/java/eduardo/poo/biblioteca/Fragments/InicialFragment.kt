package eduardo.poo.biblioteca.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import eduardo.poo.biblioteca.Adapters.LocacaoAdapter
import eduardo.poo.biblioteca.Models.Locacao
import eduardo.poo.biblioteca.Models.Pessoa
import eduardo.poo.biblioteca.R
import eduardo.poo.biblioteca.Retrofit.RetrofitInitialize
import kotlinx.android.synthetic.main.fragment_inicial.*
import retrofit2.Call
import retrofit2.Response

class InicialFragment : Fragment() {

    companion object{
        private var instance : InicialFragment? = null

        fun newInstance() :InicialFragment {
            instance = InicialFragment()

            return instance as InicialFragment
        }

        fun getInstance(): InicialFragment{
            return if (instance != null)
                instance as InicialFragment
            else
                newInstance()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_inicial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt_numero_locacoes.text = Pessoa.getInstance().quantidade_locacoes().toString()
        txt_numero_livros_maos.text = Pessoa.getInstance().quantidade_locacoes_em_maos().toString()
    }
}

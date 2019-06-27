package eduardo.poo.biblioteca.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import eduardo.poo.biblioteca.Adapters.ReservaAdapter
import eduardo.poo.biblioteca.Models.Livro
import eduardo.poo.biblioteca.R
import eduardo.poo.biblioteca.Retrofit.RetrofitInitialize
import kotlinx.android.synthetic.main.fragment_reserva.*
import retrofit2.Call
import retrofit2.Response

class ReservaFragment : Fragment() {

    private var reservas :ArrayList<Livro> = arrayListOf()

    companion object{
        private var instance : ReservaFragment? = null

        fun newInstance() :ReservaFragment {
            instance = ReservaFragment()

            return instance as ReservaFragment
        }

        fun getInstance(): ReservaFragment{
            return if (instance != null)
                instance as ReservaFragment
            else
                newInstance()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reserva, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeComponents()
    }

    private fun initializeComponents() {
        RetrofitInitialize().livros().also {
            it.get().enqueue(object :retrofit2.Callback<ArrayList<Livro>>{
                override fun onFailure(call: Call<ArrayList<Livro>>, t: Throwable) {
                    Toast.makeText(context, "Ops! " + t.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<ArrayList<Livro>>, response: Response<ArrayList<Livro>>) {
                    response.body()?.let{ list ->
                        reservas = list
                    }

                    recyclerViewReservas.apply{
                        layoutManager = LinearLayoutManager(activity)

                        adapter = ReservaAdapter(context, reservas)
                    }

                    recyclerViewReservas.adapter?.notifyDataSetChanged()
                }
            })
        }
    }
}

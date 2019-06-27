package eduardo.poo.biblioteca.Retrofit

import eduardo.poo.biblioteca.Retrofit.Services.LivroService
import eduardo.poo.biblioteca.Retrofit.Services.LocacaoService
import eduardo.poo.biblioteca.Retrofit.Services.PessoaService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitialize {

    companion object{
        const val BaseUrl:String = "http://172.29.6.179/biblioteca/api/"
    }

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun pessoa() :PessoaService = retrofit.create(PessoaService::class.java)

    fun locacoes() :LocacaoService = retrofit.create(LocacaoService::class.java)
    
    fun livros() :LivroService = retrofit.create(LivroService::class.java)
}
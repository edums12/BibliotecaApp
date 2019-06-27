package eduardo.poo.biblioteca.Retrofit.Services

import eduardo.poo.biblioteca.Models.Pessoa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PessoaService {

    @GET("pessoas/{codigo}")
    fun get(@Path("codigo") codigo :String) : Call<Pessoa>
}
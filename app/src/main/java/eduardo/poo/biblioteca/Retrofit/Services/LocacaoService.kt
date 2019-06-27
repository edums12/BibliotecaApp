package eduardo.poo.biblioteca.Retrofit.Services

import eduardo.poo.biblioteca.Models.Locacao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocacaoService {

    @GET("locacoes/{id_pessoa}")
    fun get(@Path("id_pessoa") id_pessoa:Int) : Call<ArrayList<Locacao>>
}
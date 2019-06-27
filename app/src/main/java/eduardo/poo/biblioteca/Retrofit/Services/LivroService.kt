package eduardo.poo.biblioteca.Retrofit.Services

import eduardo.poo.biblioteca.Models.Livro
import eduardo.poo.biblioteca.Models.Reserva
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface LivroService {
    @GET("reservas")
    fun get() : Call<ArrayList<Livro>>

    @FormUrlEncoded
    @POST("reservas")
    fun reservar(@Field("id_pessoa") idPessoa: Int, @Field("id_livro") idLivro: Int) : Call<Reserva>
}
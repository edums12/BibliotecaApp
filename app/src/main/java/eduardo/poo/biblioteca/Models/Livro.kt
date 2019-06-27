package eduardo.poo.biblioteca.Models

class Livro (val id_livro :Int, val titulo :String, val exemplares_disponiveis :Int) {

    fun exemplaresDisponiveisDisplay() :String = exemplares_disponiveis.toString() + " Exemplares disponíveis"

}
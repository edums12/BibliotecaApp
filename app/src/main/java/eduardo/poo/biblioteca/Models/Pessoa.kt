package eduardo.poo.biblioteca.Models

class Pessoa (private val id_pessoa :Int, private val codigo :String, private val nome :String, private val quantidade_locacoes :Int, private val quantidade_locacoes_em_maos :Int) {

    fun id() :Int{
        return this.id_pessoa
    }

    fun codigo() :String{
        return this.codigo
    }

    fun nome() :String{
        return this.nome
    }

    fun quantidade_locacoes() : Int {
        return this.quantidade_locacoes
    }

    fun quantidade_locacoes_em_maos() : Int {
        return this.quantidade_locacoes_em_maos
    }

    companion object{
        private lateinit var pessoa :Pessoa

        fun newInstance(pessoa :Pessoa){
            Companion.pessoa = pessoa
        }

        fun getInstance() :Pessoa = pessoa
    }
}
package eduardo.poo.biblioteca.Models

class Locacao (val id_locacao:Int, val exemplar:String, val data_locacao:String, val dias_restantes:Int, val entregue:Boolean) {

    fun diasRestantesDisplay() :String{
        if (entregue)
            return "Entregue"
        else if (dias_restantes < 0)
            return (dias_restantes * -1).toString() + " dias atrasados"
        else
            return "Restam " + dias_restantes + " dias para entregar"
    }
}
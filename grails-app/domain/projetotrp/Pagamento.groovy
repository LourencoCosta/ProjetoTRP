package projetotrp
import Enuns.*

class Pagamento {
    StatusPagamento statusPagamento
    static hasOne = [contrato:Contrato]
    static constraints = {
        statusPagamento nulable:false
    }
}

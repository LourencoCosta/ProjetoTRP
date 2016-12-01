package projetotrp
import Enuns.*

class Pagamento {
    StatusPagamento statusPagamento
    Float valor

    static belongsTo = [contrato:Contrato]
    
    static constraints = {
        statusPagamento nulable:false
	servico nullable:true
    }


    static mapping = {
        id generator:'sequence-identity', params:[sequence:'pagamento_key_seq']
    }
}

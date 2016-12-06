package projetotrp
import Enuns.*

class Pagamento {
    String statusPagamento
    Float valor

    static constraints = {
        statusPagamento nulable:false
	servico nullable:true
    }


    static mapping = {
        id generator:'sequence-identity', params:[sequence:'pagamento_key_seq']
    }
}

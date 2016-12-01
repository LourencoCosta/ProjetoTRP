package projetotrp

class PagamentoServico {
    Pagamento pagamento
    Servico servico

    static constraints = {
	pagamento nullable:false
	servico nullable:false
    }
    
    static mapping = {
	id generator:'sequence-identity', params:[sequence:'pagamentoServico_key_seq']

    }
}

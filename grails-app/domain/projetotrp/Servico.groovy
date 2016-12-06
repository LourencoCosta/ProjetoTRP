package projetotrp
import Enuns.*

class Servico {
        Profissional profissionalOperante
	Integer notaQualidadeServico
	String comentarios
	String statusServico
	Pagamento pagamento
    static belongsTo = [contrato:Contrato]

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'servico_key_seq']
    }
    
    static constraints = {
        valorServico nulable:false
        statusServico nulable:false
	pagamento nullable:true
	notaQualidadeServico nullable:true
	comentarios maxSize:32000
    }

}

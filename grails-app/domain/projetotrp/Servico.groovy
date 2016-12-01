package projetotrp
import Enuns.*

class Servico {
        Profissional profissionalOperante
	Integer notaQualidadeServico
	String comentarios
	StatusServico statusServico
	
    static belongsTo = [contrato:Contrato]

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'servico_key_seq']
    }
    
    static constraints = {
        valorServico nulable:false
        statusServico nulable:false
	pagamento nullable:true
    }

}

package projetotrp
import Enuns.*

class Servico {
    StatusServico statusServico
    String valorServico
    
    static belongsTo = [contrato:Contrato]
    static constraints = {
        valorServico nulable:false
        statusServico nulable:false
    }
}

package projetotrp

class Servico {
    Enum statusServico
    String valorServico
    
    static belongsTo = [contrato:Contrato]
    static constraints = {
        valorServico nulable:false
        statusServico nulable:false
    }
}

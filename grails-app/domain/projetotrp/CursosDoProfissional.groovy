package projetotrp

class CursosDoProfissional {
    String nomeCurso
    Date dataInicio
    Date dataFim
    String instituicao
    
    static constraints = {
        nomeCurso nullable:false, maxSize:120
        dataInicio nullable:false
        instituicao nullable:false, maxSize:120
    }
}

package projetotrp

class CursosDoProfissional {
    String nomeCurso
    Date dataInicio
    Date dataFim
    String instituicao

    static belongsTo = [profissional: Profissional]

    static constraints = {
        nomeCurso nullable:false, maxSize:120
        dataInicio nullable:false
        dataFim nullable:false
        profissional   nullable:false
    }

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'cursprof_key_seq']
    }
    
    String toString(){
	this.nomeCurso
    }
}

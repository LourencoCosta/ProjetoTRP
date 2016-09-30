package projetotrp

class Profissional  extends UsuarioSistema{
    String descricao
    
    static hasMany = [contrato:Contrato, cursos:CursosDoProfissional]
    static constraints ={
        descricao nullable:false, blank:false, minSize:10,maxSize:500
    }
}

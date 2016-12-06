package projetotrp

class Profissional extends UsuarioSistema {
       
    String descricao
    Integer mediaDasAvaliacoes
    Float precoMedioHora
	
    //para Profissional
    static hasMany = [cursos: CursosDoProfissional, midia:Midia]
    
    static constraints = {
    }
    static mapping = {
	   discriminator value:"profissional"
	   descricao nullable:true
	   mediaDasAvaliacoes nullable:true
    }
    
    
}

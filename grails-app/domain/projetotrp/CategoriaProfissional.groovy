package projetotrp

class CategoriaProfissional {
    
    static belongsTo = [profissional:Profissional, categoria:Categoria]
    
    static constraints = {
	 
    }
    static mapping = {
	id generator:'sequence-identity', params:[sequence:'categoriaProfissional_key_seq']
    }
      
}

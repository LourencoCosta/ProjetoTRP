package projetotrp

class Categoria {
    String nome
    
    static constraints = {
	nome nullable: false, maxSize: 120, unique:true
    }
    
    static mapping = { 
	id generator:'sequence-identity', params:[sequence:'categoria_key_seq']

    }
    String toString(){
	this.nome
    }
}

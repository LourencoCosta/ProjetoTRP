package projetotrp

class Midia {
   
    String url
    static belongsTo = [profissional:Profissional]
    
    static constraints = {
	id generator:'sequence-identity', params:[sequence:'midia_key_seq']
	profissional nullable:false
    }
    
    String toString(){
	this.url
    }
}

package projetotrp

class Media {
   
    String url
    static belongsTo = [profissional:Profissional]
    
    static constraints = {
	id generator:'sequence-identity', params:[sequence:'media_key_seq']
	profissional nullable:false
    }
    
    String toString(){
	this.url
    }
}

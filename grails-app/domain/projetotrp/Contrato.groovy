package projetotrp
import Enuns.*

class Contrato {
	String termos
	Date dataEmissao
	Profissional profissional
	UsuarioSistema contratante
	
    static constraints = {
        dataEmissao nullable:false
	termos nullable:false
    }

    static mappings = {
        id generator:'sequence-identity', params:[sequence:'contrato_key_seq']
    }
    
    String toString(){
	this.dataEmissao
    }
}

package projetotrp

class MenssagemController {

    def index() { }

    def menssagemEnviada(){
        String remetente
        String destinatario

    }
    def criaMensagem(){
	
    }
    
    
    def listagemDeMensagens(){
	Integer idChamador = params.id
	def menssagens = Menssagem.createCriteria().list{
	    or{
		eq ( contratante.id - idChamador)
		eq ( profissional.id - idChamador)
	    }
	}
	
	render (template:listaDeMenssagens, model:[menssagens:menssagens])
    }
}

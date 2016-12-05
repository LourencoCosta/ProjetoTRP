package projetotrp

import org.springframework.transaction.annotation.Transactional

class MenssagemController {

    def index() { }

    def menssagemEnviada(){
        String remetente
        String destinatario

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
    
    @Transactional
    def enviarMensagem(){
	def menssagem 
	if(session.usuarioSistema){
	    menssagem = Menssagem.get(params.idMensagem)
	    def corpoMenssagem = menssagem.texto
	    corpoMenssagem = corpoMensagem +"\n" + new Date() + "${session.usuarioSistema.nome}" +"Disse:" +${params.mensagemTexto}
	    menssagem.texto = corpoMenssagem;
	    menssagem.save(flush:true)
	    render (template: caixaTextoMensgagem, model:[corpoMenssagem:corpoMenssagem])
	}
    }
}

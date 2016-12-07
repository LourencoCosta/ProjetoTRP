package projetotrp

import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class ChatController {

    def index() {
	if(session.usuarioSistema){
	    render (view: '/chat/chat')
	}else{
	    redirect (uri:"/logintrp")
	}
    }
   
    @Transactional
    def criaMensagem (){
	Menssagem menssagem 
	def listagem
	if(session.usuarioSistema){
	    def idUsuario = session.usuarioSistema.id
	    boolean statusMensagemCliente
	    boolean statusMensagemProfissional
    
	    def sql = "select m from Menssagem m where m.profissional.id = " + Integer.parseInt(params.profissional) + " and m.contratante.id = " + idUsuario + "and m.statusMenssagem like" + "ABERTA"
	    listagem = Menssagem.executeQuery(sql)
	    println listagem
	    if(listagem.isEmpty()){   
		def contratante = UsuarioSistema.get(session.usuarioSistema.id)
		def profissional = Profissional.get(Integer.parseInt(params.profissional))
		menssagem = new Menssagem ()
		menssagem.setProfissional (profissional)
		menssagem.setContratante(contratante)
		menssagem.setTexto("Conversas de Negociaação" + new Date());
		menssagem.setStatusMenssagem("ABERTA")
		menssagem.save (flush:true, failOnError: true)
		render (view: '/chat/chat', model:[menssagem:menssagem])
	    } else{
		println listagem
		menssagem = listagem.get(0)
		render (view: '/chat/chat', model:[menssagem:menssagem])
	    }
	}else{
	    redirect (uri:"/logintrp")
	}
    } 
    
    def retornarMensagem (){
	if(session.usuarioSistema){
	    def menssagem = Menssagem.get(Integer.parseInt(params.menssagemAtual))
	    render (view: '/chat/chat', model:[menssagem:menssagem])
	}else{
	    redirect (uri:"/logintrp")
	}
    }


    
    @Transactional
    def enviarMensagem(){
	def menssagemObject
	def resposta = [:]
	
	if(session.usuarioSistema){
	    menssagemObject = Menssagem.get(Integer.parseInt(params.id))
	    def corpoMenssagem = menssagemObject.getTexto()
	    corpoMenssagem = corpoMenssagem +"\n" + new Date() +" "+ session.usuarioSistema.nome +" Disse: " + params.menssagem
	    menssagemObject.setTexto(corpoMenssagem)
	    menssagemObject.save(flush:true, failOnError: true)
	    resposta["corpoMenssagem"] = corpoMenssagem
	    render resposta as JSON
	}else{
	    redirect (uri:"/logintrp")
	}
    }
    
    def atualizarMenssagem(){
	if(session.usuarioSistema){
	    def resposta = [:]
	    def menssagem = Menssagem.get(params.id)
	    resposta["corpoMenssagem"] = menssagem.texto
	    render resposta as JSON
	}else{
	    redirect (uri:"/logintrp")
	}
	
    }

}
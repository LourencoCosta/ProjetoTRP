package projetotrp

import grails.converters.JSON
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
class ChatController {

    def index() {
        render (view: '/chat/chat')
    }
   
    @Transactional
    def criaMensagem (){
	Menssagem menssagem 
	def listagem
	if(session.usuarioSistema){
	    def idUsuario = session.usuarioSistema.id
	    boolean statusMensagemCliente
	    boolean statusMensagemProfissional
    
	    def sql = "select m from Menssagem m where m.profissional.id = " + Integer.parseInt(params.profissional) + " and m.contratante.id = " + idUsuario + " and m.statusMensagemCliente is true" + " and m.statusMensagemProfissional is true" 
	    listagem = Menssagem.executeQuery(sql)
	    println listagem
	    if(listagem.isEmpty()){   
		def contratante = UsuarioSistema.get(session.usuarioSistema.id)
		def profissional = Profissional.get(Integer.parseInt(params.profissional))
		menssagem = new Menssagem ()
		menssagem.setProfissional (profissional)
		menssagem.setContratante(contratante)
		menssagem.setTexto("Conversas de Negociaação" + new Date());
		menssagem.setStatusMensagemCliente(true)
		menssagem.setStatusMensagemProfissional(true)
		menssagem.save (flush:true, failOnError: true)
		render (view: '/chat/chat', model:[menssagem:menssagem])
	    } else{
		println listagem
		menssagem = listagem.get(0)
		render (view: '/chat/chat', model:[menssagem:menssagem])
	    }
	}
    } 
    
    def retornarMensagem (){
	def menssagem = Menssagem.get(Integer.parseInt(params.menssagemAtual))
	render (view: '/chat/chat', model:[menssagem:menssagem])
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
	}
    }

}
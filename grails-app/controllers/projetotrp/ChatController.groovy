package projetotrp

class ChatController {

    def index() {
        render (view: '/chat/chat')
    }
   
    def escreve(){
        if(session.usuarioSistema) {
            flash.message = params.sendChat
            String mensagem = params.sendChat
            redirect(uri: '/chat')
        }  else{
            redirect(controller:"homeController", action: "index")
        }

    }
    def criaMensagem (){
        if(session.usuarioSistema){
            if (params.idUsuario != params.idProfissional){
                try{
                    def contratante = UsuarioSistema.get(params.idContratante)
                    def profissional = UsuarioSistema(params.idProfissional)
                    def mensagem = new Menssagem ([profissional:profissional, contratante:contratante, statusMensagemCliente:true, statusMensagemProfissional:true])
                    mensagem.save flush:true
                }catch (Exception e){

                }
            }
        } else{
            redirect(uri:'/logintrp')
        }
    }
    
    def enviarMensagem(){
//	   def mensagem = new Menssagem ();
	   def usuarioSistema = UsuarioSistema.list()
           render(template:"testeTemplate", model:[usuarioSistema:usuarioSistema])
	   println "passou aqui"
    }
}
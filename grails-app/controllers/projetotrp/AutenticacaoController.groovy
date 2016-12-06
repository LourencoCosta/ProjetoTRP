package projetotrp

class AutenticacaoController {

    
    def autenticar () {
        def usuarioSistema = UsuarioSistema.findByLoginAndSenha(params.login, params.senha)
        if (usuarioSistema) {
            session.usuarioSistema = usuarioSistema
            redirect(controller:"homeController", action: "index")
        } else {
            flash.message = "Acesso negado"
            redirect(uri:'/logintrp')
        }
    }
    
    def logout (){
        session.usuarioSistema = null
        redirect(uri:"/")
    }
    
    def index (){
        redirect(uri:"/logintrp")
    }
}


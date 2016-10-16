package projetotrp

class AutenticacaoController {

    
    def autenticar () {
        def usuarioSistema = UsuarioSistema.findByLoginAndSenha(params.login, params.senha)
        if (usuarioSistema) {
            session.usuarioSistema = usuarioSistema
            flash.message = "Hello ${usuarioSistema.nome}!"
            redirect(uri:"http://localhost:8080/")
        } else {
            flash.message = "Acesso negado"
            redirect(uri:'/logintrp')
        }
    }
    
    def logout (){
        flash.message = "Goodbye ${session.usuarioSistema.nome}"
        session.usuarioSistema = null
        redirect(uri:"/")
    }
    
    def index (){
        redirect(uri:"/logintrp")
    }
}


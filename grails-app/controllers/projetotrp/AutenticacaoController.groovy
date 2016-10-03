package projetotrp

class AutenticacaoController {

    def autenticar(UsuarioSistema usuario) {
        def registro = UsuarioSistema.findByLoginAndSenha(usuario.login, usuario.senha)
        if (registro) {
            session['usuario'] = registro
            redirect(uri:"/")
        } else {
            flash.message = "Acesso negado"
            redirect(uri:'/')
        }
    }
}


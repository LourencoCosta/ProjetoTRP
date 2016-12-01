package projetotrp

class LoginTagLib {
    def loginControl = {
        if(session.usuarioSistema){
            out << "Olá ${session.usuarioSistema.nome} ${link(action:"logout", controller:"autenticacao"){"Logout"}}"
//            out << """[${link(action:"logout", controller:"autenticacao"){"Logout"}}]"""
        }
    }
}

package projetotrp

class Menssagem {

    String texto
    boolean statusMensagemCliente
    boolean statusMensagemProfissional
    UsuarioSistema contratante
    Profissional profissional

    static constraints = {
    }

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'mensagem_key_seq']
    }
    
//    String toString(){
//	"Conversa entre: ${this.contratante.nome} e ${(UsuarioSistema)this.profissional.nome}"
//    }

}



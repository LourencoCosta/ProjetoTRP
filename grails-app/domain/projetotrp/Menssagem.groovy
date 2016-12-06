package projetotrp

class Menssagem {

    String texto
    UsuarioSistema contratante
    Profissional profissional
    String statusMenssagem
    static constraints = {
	texto maxSize:32000
    }

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'mensagem_key_seq']
	version: false
    }
}



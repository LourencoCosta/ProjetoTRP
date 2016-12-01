package projetotrp

import Enuns.*

class UsuarioSistema {
    
    String nome
    String email
    String cpf
    String endereco
    byte[] foto
    String login
    String senha
    StatusAcesso statusDoAcesso
    Date dataNascimento
    boolean termoDeUsuAceito = false
    String assinaturaTrp

    static constraints = {
        nome nullable: false, maxSize: 120
        email nullable: true, maxSize: 120, unique: true
        cpf nullable: true, unique: true
	login nullable: false, maxSize: 20, unique: true
        senha nullable: false, maxSize: 20, password: true
        endereco nullable: true, maxSize: 200
        statusDoAcesso nullable: true
        foto nullable: true, maxSize: 65536
        dataNascimento nullable: true
	assinaturaTrp nullable:true
    }

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'usuario_key_seq']
	tablePerHierarchy false
    }
}

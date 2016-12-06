package projetotrp

import Enuns.*

class UsuarioSistema {
    
    String nome
    String email
    String cpf
    String cep
    String rua
    String bairro
    String cidade
    String estado
    String numero
    byte[] foto
    String login
    String senha
    String statusDoAcesso
    Date dataNascimento
    boolean termoDeUsuAceito
    String assinaturaTrp

    static constraints = {
        nome nullable: false, maxSize: 120
        email nullable: false, maxSize: 120, unique: true
        cpf nullable: false, unique: true, minSize:11, maxSize:11
	login nullable: false, maxSize: 20, unique: true
        senha nullable: false, maxSize: 20, password: true
        statusDoAcesso nullable: true
        foto nullable: true, maxSize: 65536
        dataNascimento nullable: true
	assinaturaTrp nullable:true
	cep nullable:false
	rua blank:false
	bairro: blank:false
	cidade blank:false
	estado blank:false
	numero blank:false
    }

    static mapping = {
        id generator:'sequence-identity', params:[sequence:'usuario_key_seq']
	tablePerHierarchy false
    }
}

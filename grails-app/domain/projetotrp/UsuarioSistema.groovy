package projetotrp
import Enuns.*
class UsuarioSistema {
    Date dataNascimento
    String nome
    String email
    String cpf
    String endereco
    //    String foto
    String login
    String senha
    StatusAcesso statusDoAcesso

    static constraints = {
        nome nullable:false, maxSize:120
        email nullable:false, maxSize:120, unique:true
        cpf nullable:false,  unique:true
        endereco nullable:false,  maxSize:200
        login nullable:false, maxSize:20, unique:true
        senha nullable:false, maxSize:20
        statusDoAcesso nullable:false, maxSize:1
            
    }
}

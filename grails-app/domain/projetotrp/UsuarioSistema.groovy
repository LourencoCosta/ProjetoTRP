package projetotrp
import Enuns.*
class  UsuarioSistema {
    Date dataNascimento
    String nome
    String email
    String cpf
    String endereco
    byte[] foto
    String login
    String senha
    StatusAcesso statusDoAcesso
    String descricao
    boolean teste
    
    //para Profissional
    static hasMany = [contrato:Contrato, cursos:CursosDoProfissional]
    
    static constraints = {
        nome nullable:false, maxSize:120
        email nullable:true, maxSize:120, unique:true
        cpf nullable:true,  unique:true
        endereco nullable:true,  maxSize:200
        login nullable:false, maxSize:20, unique:true
        senha nullable:false, maxSize:20, password:true
        statusDoAcesso nullable:true, maxSize:1
        foto nullable:true, maxSize:65536    
        dataNascimento nullable:true
	descricao nullable:true, minSize:10,maxSize:1000
	contrato nulable:true
    }
}

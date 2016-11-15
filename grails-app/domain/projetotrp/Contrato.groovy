package projetotrp
import Enuns.*

class Contrato {
    Date validade
    Date dataEmissao
    Float valorContrato
    StatusContrato statusAcesso
   
//    static belongsTo = [contratante:UsuarioSistema, profissional:UsuarioSistema]
    static hasOne = [pagamento:Pagamento]
    static constraints = {
        validade nullable:false
        dataEmissao nullable:false
        valorContrato nullable:false, maxSize:11
        statusAcesso nullable:false
    }
}

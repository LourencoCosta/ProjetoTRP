package projetotrp

class Contratante extends UsuarioSistema{

    static hasMany = [contrato:Contrato]
    static constraints = {
        contrato nulable:false
    }
}

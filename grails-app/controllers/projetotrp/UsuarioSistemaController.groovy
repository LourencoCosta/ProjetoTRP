package projetotrp

import org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UsuarioSistemaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UsuarioSistema.list(params), model:[usuarioSistemaCount: UsuarioSistema.count()]
    }

    def show(UsuarioSistema usuarioSistema) {
        respond usuarioSistema
    }

    def create() {
        respond new UsuarioSistema(params)
    }

    @Transactional
    def save(UsuarioSistema usuarioSistema) {
        if (usuarioSistema == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usuarioSistema.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usuarioSistema.errors, view:'create'
            return
        }

        usuarioSistema.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'usuarioSistema.label', default: 'UsuarioSistema'), usuarioSistema.id])
                redirect usuarioSistema
            }
            '*' { respond usuarioSistema, [status: CREATED] }
        }
    }

    def edit(UsuarioSistema usuarioSistema) {
        respond usuarioSistema
    }

    @Transactional
    def update(UsuarioSistema usuarioSistema) {
        if (usuarioSistema == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (usuarioSistema.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond usuarioSistema.errors, view:'edit'
            return
        }

        usuarioSistema.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'usuarioSistema.label', default: 'UsuarioSistema'), usuarioSistema.id])
                redirect usuarioSistema
            }
            '*'{ respond usuarioSistema, [status: OK] }
        }
    }

    @Transactional
    def delete(UsuarioSistema usuarioSistema) {

        if (usuarioSistema == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        usuarioSistema.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'usuarioSistema.label', default: 'UsuarioSistema'), usuarioSistema.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'usuarioSistema.label', default: 'UsuarioSistema'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

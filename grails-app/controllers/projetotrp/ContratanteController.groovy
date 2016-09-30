package projetotrp

import org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContratanteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Contratante.list(params), model:[contratanteCount: Contratante.count()]
    }

    def show(Contratante contratante) {
        respond contratante
    }

    def create() {
        respond new Contratante(params)
    }

    @Transactional
    def save(Contratante contratante) {
        if (contratante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contratante.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contratante.errors, view:'create'
            return
        }

        contratante.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contratante.label', default: 'Contratante'), contratante.id])
                redirect contratante
            }
            '*' { respond contratante, [status: CREATED] }
        }
    }

    def edit(Contratante contratante) {
        respond contratante
    }

    @Transactional
    def update(Contratante contratante) {
        if (contratante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (contratante.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contratante.errors, view:'edit'
            return
        }

        contratante.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contratante.label', default: 'Contratante'), contratante.id])
                redirect contratante
            }
            '*'{ respond contratante, [status: OK] }
        }
    }

    @Transactional
    def delete(Contratante contratante) {

        if (contratante == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        contratante.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contratante.label', default: 'Contratante'), contratante.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contratante.label', default: 'Contratante'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

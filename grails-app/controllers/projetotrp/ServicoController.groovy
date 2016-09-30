package projetotrp

import org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ServicoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Servico.list(params), model:[servicoCount: Servico.count()]
    }

    def show(Servico servico) {
        respond servico
    }

    def create() {
        respond new Servico(params)
    }

    @Transactional
    def save(Servico servico) {
        if (servico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (servico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond servico.errors, view:'create'
            return
        }

        servico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'servico.label', default: 'Servico'), servico.id])
                redirect servico
            }
            '*' { respond servico, [status: CREATED] }
        }
    }

    def edit(Servico servico) {
        respond servico
    }

    @Transactional
    def update(Servico servico) {
        if (servico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (servico.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond servico.errors, view:'edit'
            return
        }

        servico.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'servico.label', default: 'Servico'), servico.id])
                redirect servico
            }
            '*'{ respond servico, [status: OK] }
        }
    }

    @Transactional
    def delete(Servico servico) {

        if (servico == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        servico.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'servico.label', default: 'Servico'), servico.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'servico.label', default: 'Servico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

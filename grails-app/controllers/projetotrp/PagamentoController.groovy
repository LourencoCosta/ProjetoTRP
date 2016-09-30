package projetotrp

import org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PagamentoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pagamento.list(params), model:[pagamentoCount: Pagamento.count()]
    }

    def show(Pagamento pagamento) {
        respond pagamento
    }

    def create() {
        respond new Pagamento(params)
    }

    @Transactional
    def save(Pagamento pagamento) {
        if (pagamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pagamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pagamento.errors, view:'create'
            return
        }

        pagamento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), pagamento.id])
                redirect pagamento
            }
            '*' { respond pagamento, [status: CREATED] }
        }
    }

    def edit(Pagamento pagamento) {
        respond pagamento
    }

    @Transactional
    def update(Pagamento pagamento) {
        if (pagamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pagamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pagamento.errors, view:'edit'
            return
        }

        pagamento.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), pagamento.id])
                redirect pagamento
            }
            '*'{ respond pagamento, [status: OK] }
        }
    }

    @Transactional
    def delete(Pagamento pagamento) {

        if (pagamento == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pagamento.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), pagamento.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pagamento.label', default: 'Pagamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

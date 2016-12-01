package projetotrp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CategoriaProfissionalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CategoriaProfissional.list(params), model:[categoriaProfissionalCount: CategoriaProfissional.count()]
    }

    def show(CategoriaProfissional categoriaProfissional) {
        respond categoriaProfissional
    }

    def create() {
        respond new CategoriaProfissional(params)
    }

    @Transactional
    def save(CategoriaProfissional categoriaProfissional) {
        if (categoriaProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoriaProfissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoriaProfissional.errors, view:'create'
            return
        }

        categoriaProfissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoriaProfissional.label', default: 'CategoriaProfissional'), categoriaProfissional.id])
                redirect categoriaProfissional
            }
            '*' { respond categoriaProfissional, [status: CREATED] }
        }
    }

    def edit(CategoriaProfissional categoriaProfissional) {
        respond categoriaProfissional
    }

    @Transactional
    def update(CategoriaProfissional categoriaProfissional) {
        if (categoriaProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (categoriaProfissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond categoriaProfissional.errors, view:'edit'
            return
        }

        categoriaProfissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'categoriaProfissional.label', default: 'CategoriaProfissional'), categoriaProfissional.id])
                redirect categoriaProfissional
            }
            '*'{ respond categoriaProfissional, [status: OK] }
        }
    }

    @Transactional
    def delete(CategoriaProfissional categoriaProfissional) {

        if (categoriaProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        categoriaProfissional.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'categoriaProfissional.label', default: 'CategoriaProfissional'), categoriaProfissional.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoriaProfissional.label', default: 'CategoriaProfissional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

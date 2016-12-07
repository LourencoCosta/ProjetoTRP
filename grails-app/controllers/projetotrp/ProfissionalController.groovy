package projetotrp

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProfissionalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Profissional.list(params), model:[profissionalCount: Profissional.count()]
    }

    def show(Profissional profissional) {
        respond profissional
    }

    def create() {
        respond new Profissional(params)
    }

    @Transactional
    def save(Profissional profissional) {
        if (profissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (profissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond profissional.errors, view:'create'
            return
        }

        profissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Perfil de Profissional Criado com Sucesso"
                redirect (uri:"/")
            }
            '*' { respond profissional, [status: CREATED] }
        }
    }

    def edit(Profissional profissional) {
        respond profissional
    }

    @Transactional
    def update(Profissional profissional) {
        if (profissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (profissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond profissional.errors, view:'edit'
            return
        }

        profissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'profissional.label', default: 'Profissional'), profissional.id])
                redirect profissional
            }
            '*'{ respond profissional, [status: OK] }
        }
    }

    @Transactional
    def delete(Profissional profissional) {

        if (profissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        profissional.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'profissional.label', default: 'Profissional'), profissional.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'profissional.label', default: 'Profissional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    
}

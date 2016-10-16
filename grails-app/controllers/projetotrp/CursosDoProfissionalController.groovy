package projetotrp

import org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CursosDoProfissionalController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def interceptor = [action:this.&auth]
//    , except:["index", "list", "show"]]

    def auth() {
        if(!session.usuarioSistema) {
            redirect(controller:"autenticar", action:"index")
            return false
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CursosDoProfissional.list(params), model:[cursosDoProfissionalCount: CursosDoProfissional.count()]
    }

    def show(CursosDoProfissional cursosDoProfissional) {
        respond cursosDoProfissional
    }

    def create() {
        respond new CursosDoProfissional(params)
    }

    @Transactional
    def save(CursosDoProfissional cursosDoProfissional) {
        if (cursosDoProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cursosDoProfissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cursosDoProfissional.errors, view:'create'
            return
        }

        cursosDoProfissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cursosDoProfissional.label', default: 'CursosDoProfissional'), cursosDoProfissional.id])
                redirect cursosDoProfissional
            }
            '*' { respond cursosDoProfissional, [status: CREATED] }
        }
    }

    def edit(CursosDoProfissional cursosDoProfissional) {
        respond cursosDoProfissional
    }

    @Transactional
    def update(CursosDoProfissional cursosDoProfissional) {
        if (cursosDoProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (cursosDoProfissional.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond cursosDoProfissional.errors, view:'edit'
            return
        }

        cursosDoProfissional.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cursosDoProfissional.label', default: 'CursosDoProfissional'), cursosDoProfissional.id])
                redirect cursosDoProfissional
            }
            '*'{ respond cursosDoProfissional, [status: OK] }
        }
    }

    @Transactional
    def delete(CursosDoProfissional cursosDoProfissional) {

        if (cursosDoProfissional == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        cursosDoProfissional.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cursosDoProfissional.label', default: 'CursosDoProfissional'), cursosDoProfissional.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cursosDoProfissional.label', default: 'CursosDoProfissional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

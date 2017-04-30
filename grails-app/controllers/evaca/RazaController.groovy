package evaca

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RazaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Raza.list(params), model:[razaCount: Raza.count()]
    }

    def show(Raza raza) {
        respond raza
    }

    def create() {
        respond new Raza(params)
    }

    @Transactional
    def save(Raza raza) {
        if (raza == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (raza.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond raza.errors, view:'create'
            return
        }

        raza.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'raza.label', default: 'Raza'), raza.id])
                redirect raza
            }
            '*' { respond raza, [status: CREATED] }
        }
    }

    def edit(Raza raza) {
        respond raza
    }

    @Transactional
    def update(Raza raza) {
        if (raza == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (raza.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond raza.errors, view:'edit'
            return
        }

        raza.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'raza.label', default: 'Raza'), raza.id])
                redirect raza
            }
            '*'{ respond raza, [status: OK] }
        }
    }

    @Transactional
    def delete(Raza raza) {

        if (raza == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        raza.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'raza.label', default: 'Raza'), raza.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'raza.label', default: 'Raza'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

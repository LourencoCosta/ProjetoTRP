package projetotrp

import grails.test.mixin.*
import spock.lang.*

@TestFor(ContratanteController)
@Mock(Contratante)
class ContratanteControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.contratanteList
            model.contratanteCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.contratante!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def contratante = new Contratante()
            contratante.validate()
            controller.save(contratante)

        then:"The create view is rendered again with the correct model"
            model.contratante!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            contratante = new Contratante(params)

            controller.save(contratante)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/contratante/show/1'
            controller.flash.message != null
            Contratante.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def contratante = new Contratante(params)
            controller.show(contratante)

        then:"A model is populated containing the domain instance"
            model.contratante == contratante
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def contratante = new Contratante(params)
            controller.edit(contratante)

        then:"A model is populated containing the domain instance"
            model.contratante == contratante
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/contratante/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def contratante = new Contratante()
            contratante.validate()
            controller.update(contratante)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.contratante == contratante

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            contratante = new Contratante(params).save(flush: true)
            controller.update(contratante)

        then:"A redirect is issued to the show action"
            contratante != null
            response.redirectedUrl == "/contratante/show/$contratante.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/contratante/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def contratante = new Contratante(params).save(flush: true)

        then:"It exists"
            Contratante.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(contratante)

        then:"The instance is deleted"
            Contratante.count() == 0
            response.redirectedUrl == '/contratante/index'
            flash.message != null
    }
}

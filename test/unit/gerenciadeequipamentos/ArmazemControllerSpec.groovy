package gerenciadeequipamentos



import grails.test.mixin.*
import spock.lang.*

@TestFor(ArmazemController)
@Mock(Armazem)
class ArmazemControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.armazemInstanceList
            model.armazemInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.armazemInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def armazem = new Armazem()
            armazem.validate()
            controller.save(armazem)

        then:"The create view is rendered again with the correct model"
            model.armazemInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            armazem = new Armazem(params)

            controller.save(armazem)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/armazem/show/1'
            controller.flash.message != null
            Armazem.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def armazem = new Armazem(params)
            controller.show(armazem)

        then:"A model is populated containing the domain instance"
            model.armazemInstance == armazem
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def armazem = new Armazem(params)
            controller.edit(armazem)

        then:"A model is populated containing the domain instance"
            model.armazemInstance == armazem
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/armazem/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def armazem = new Armazem()
            armazem.validate()
            controller.update(armazem)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.armazemInstance == armazem

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            armazem = new Armazem(params).save(flush: true)
            controller.update(armazem)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/armazem/show/$armazem.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/armazem/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def armazem = new Armazem(params).save(flush: true)

        then:"It exists"
            Armazem.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(armazem)

        then:"The instance is deleted"
            Armazem.count() == 0
            response.redirectedUrl == '/armazem/index'
            flash.message != null
    }
}

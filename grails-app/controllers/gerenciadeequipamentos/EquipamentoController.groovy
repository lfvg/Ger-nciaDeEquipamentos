package gerenciadeequipamentos



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import gerenciadeequipamentos.Equipamento
import gerenciadeequipamentos.ArmazemController

@Transactional(readOnly = true)

class EquipamentoController {
    static allowedMethods = [update: "PUT", delete: "DELETE"]
    // save: "POST" foi retirado porque dá problema com o cucumber, que
    // provavelmente simula a chamada dessa ação como um GET




    def createEquipamento(String nome, String status, String localizacao){
        //controlador.params << [nome: nome, status: status, localizacao: localizacao, lista: false]
        //controlador.request.request.setContent(new byte[1000])
        //controlador.create()
        def equipamento = new Equipamento(nome: nome, status: status, localizacao: localizacao)
        equipamento.properties = params
        equipamento.save()

    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        Equipamento.list(params).sort{it.data}
        respond Equipamento.list(params), model:[equipamentoInstanceCount: Equipamento.count()]
    }

    def show(Equipamento equipamentoInstance) {
        respond equipamentoInstance
    }

    def create() {
        respond new Equipamento(params)
    }

    @Transactional
    def save() {

        def equipamentoInstance = new Equipamento(params)
        if (!ArmazemController.verificaVagas(params.localizacao)) {
            if (!equipamentoInstance.save(flush: true)) {
                render(view: "create", model: [equipamentoInstance: equipamentoInstance])
                return
            }
            flash.message = message(code: 'default.created.message', args: [message(code: 'equipamento.label', default: 'Equipamento'), equipamentoInstance.id])
            redirect(action: "show", id: equipamentoInstance.id)
        } else {
            flash.message = message(code: 'Erro, localização inviável', args: [message(code: 'Equipamento.label', default: 'Equipamento'), equipamentoInstance.id])
            render(view: "create", model: [equipamentoInstance: equipamentoInstance])
            return
        }
    }

    def edit(Equipamento equipamentoInstance) {
        respond equipamentoInstance
    }

    @Transactional
    def update(Equipamento equipamentoInstance) {
        if (equipamentoInstance == null) {
            notFound()
            return
        }

        if (equipamentoInstance.hasErrors()) {
            respond equipamentoInstance.errors, view:'edit'
            return
        }

        equipamentoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Equipamento.label', default: 'Equipamento'), equipamentoInstance.id])
                redirect equipamentoInstance
            }
            '*'{ respond equipamentoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Equipamento equipamentoInstance) {

        if (equipamentoInstance == null) {
            notFound()
            return
        }
        ArmazemController.diminuiLotacao(equipamentoInstance.localizacao);
        equipamentoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Equipamento.label', default: 'Equipamento'), equipamentoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'equipamento.label', default: 'Equipamento'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def setLocal(Equipamento equipamento, String localizacao){
        if(equipamento != null){
            equipamento.setLocalizacao(localizacao)
            equipamento.save(flush:true)
            flash.message = "Localizacao Alterada"
            //render("overview")
        }else {
            flash.message = "Procedimento Abortado"
            //redirect(action: "overview")
        }
    }
    def updateStatus(Equipamento equipamento, String status){
        if(equipamento != null){
            equipamento.setStatus(status)
            equipamento.save(flush:true)
            flash.message = "Success"
            //render("overview")
        }else {
            flash.message = "Error"
            //redirect(action: "overview")
        }
    }
    def busca(String nome, String localizacao, String status, boolean lista){
        def equipamento = Equipamento.findByNome(nome)

        if (!(equipamento.getLocalizacao().equals(localizacao) && equipamento.getStatus().equals(status) && equipamento.getLista() == lista )) {
            //flash.message = message(code: 'default.not.found.message', args: [message(code: '', default: 'Nome'), id])
            //redirect(action: "overview")
            return null
        }
        return equipamento
    }
}

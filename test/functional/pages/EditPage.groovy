package pages

import geb.Page

class EditPage extends Page{
    static url = "/GerenciaDeEquipamentos/armazem/edit"
    static at ={
        title ==~ /Edit Armazem/
    }
    boolean editar() {
        $("form").areaUtil = 1
    }
    def alterar() {
        $(text: "Alterar").click()
    }
}
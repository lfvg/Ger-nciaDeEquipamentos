package pages
import geb.Page
/**
 * Created by Walber on 20/06/2016.
 */

class UpdatePage extends Page {
    static url = "/GerenciaDeEquipamentos/armazem/update/1"

    static at =  {
        title ==~ /Ver Armazem/
    }
    boolean editar() {
        $("form").areaUtil = 1
    }
    def alterar() {
        $(text: "Alterar").click()
    }
}
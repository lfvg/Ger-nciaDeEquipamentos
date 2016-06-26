package pages

/**
 * Created by Walber on 20/06/2016.
 */
import geb.Page

class ListagemArmazemPage extends Page {
    static url = "/GerenciaDeEquipamentos/armazem/index"
    static at = {
        title ==~ ""
    }
    boolean armazemTemVaga(armazem) {
        $("tr", class: "clear").has("a",text: armazem)
    }
    boolean armazemCheio(armazem){
        $("tr", class: "full").has("a",text: armazem)
    }

}
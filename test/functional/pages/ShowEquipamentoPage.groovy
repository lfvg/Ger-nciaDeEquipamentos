package pages
import geb.Page
/**
 * Created by Walber on 20/06/2016.
 */

class ShowEquipamentoPage extends Page {
    static url = "/GerenciaDeEquipamentos/equipamento/show/1"

    static at =  {
        title ==~ /Show Equipamento/
    }

}
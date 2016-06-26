package pages

/**
 * Created by Walber on 20/06/2016.
 */
import geb.Page

class CreateEquipamentoPage extends Page{
    static url = "/GerenciaDeEquipamentos/equipamento/create"
    static at ={
        title ==~ /Create Equipamento/
    }
    boolean criarEquipamento(nome, localizacao) {
        $("form").status = "funcionando"
        $("form").localizacao = localizacao
        $("form").nome = nome
        $("form").data_day = "1"
        $("form").data_month = "March"
        $("form").data_year = "2016"
        $("input", name: "botaoCriar").click()
    }

}
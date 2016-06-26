package steps

import cucumber.api.PendingException
import gerenciadeequipamentos.Armazem
import gerenciadeequipamentos.ArmazemController
import pages.CreateEquipamentoPage
import pages.EditPage
import pages.InsercaoPage
import pages.ListagemArmazemPage
import pages.ShowEquipamentoPage
import pages.ShowPage
import pages.UpdatePage

/**
 * Created by lfvg on 6/21/2016.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

def controlador = new ArmazemController()

Given(~/^Eu sou um administrador e o sistema possiu a licalização "([^"]*)" configurada$/) { String nome ->
    TestDataAndOperations.createArmazem(nome, 0, 10, controlador);
    Armazem armazem = Armazem.findByNome(nome)
    assert armazem
}
And(~/^a localização "([^"]*)" não possui nem um equipamento$/) { String nome ->
    Armazem armazem = Armazem.findByNome(nome)
    assert armazem.lotacao==0
}
When(~/^eu tento remover a localização "([^"]*)"$/) { String nome ->
    TestDataAndOperations.removerLocalizacao(nome, controlador)
}
Then(~/^a localização "([^"]*)" é removida$/) { String nome ->
    Armazem armazem = Armazem.findByNome(nome)
    assert armazem
}


Given(~/^Eu sou administrador e o sistema possui a localização "([^"]*)" configurada$/) { String nome ->
    TestDataAndOperations.createArmazem(nome, 5, 10, controlador);
    Armazem armazem = Armazem.findByNome(nome)
    assert armazem
}
When(~/^eu tento diminuir a area util de "([^"]*)"$/) { String nome ->
    TestDataAndOperations.diminuirArea(nome, controlador, 7)
}
Then(~/^a area util de "([^"]*)" é diminuida$/) { String nome ->
    Armazem armazem = Armazem.findByNome(nome)
    //ta dando null point (?)
    assert armazem.areaUtil==7
}


Given(~/^eu criei o armazem "([^"]*)" com apenas um espaco livre$/) { String nome ->
    to InsercaoPage
    at InsercaoPage
    page.criarArmazem(nome)
}
And(~/^e armazenei o  equipamento "([^"]*)" em "([^"]*)"$/) { String nome, String local ->
    to CreateEquipamentoPage
    at CreateEquipamentoPage
    assert page.criarEquipamento(nome, local)
}
And(~/^eu navego até a pagina que detalha o Armazen$/) { ->
    to ShowPage
    at ShowPage
}
When(~/^eu seleciono deletar "([^"]*)"$/) { String nome ->
    to ShowPage
    page.deletar()
}
Then(~/^eu vejo uma mensagem e erro$/) { ->
    to ListagemArmazemPage
    at ListagemArmazemPage
}

Given(~/^eu criei o armazem "([^"]*)"$/) { String nome ->
    to InsercaoPage
    at InsercaoPage
    page.criarArmazem(nome)
}
And(~/^e armazenei os  equipamento "([^"]*)" e "([^"]*)" em "([^"]*)"$/) { String nome, String outro, String local ->
    to CreateEquipamentoPage
    at CreateEquipamentoPage
    assert page.criarEquipamento(nome, local)
    assert page.criarEquipamento(outro, local)
}
And(~/^eu navego até a pagina que detalha o Armazen "([^"]*)"$/) { String arg1 ->
    to ShowPage
    at ShowPage
}
When(~/^eu seleciono editar "([^"]*)"$/) { String arg1 ->
    at ShowPage
    page.editar()
}
And(~/^diminuo a sua area util pra (\d+)$/) { int arg1 ->
    to EditPage
    at EditPage
    page.editar()
    page.alterar()
}
Then(~/^eu vejo uma mensagem de erro$/) { ->
    to ListagemArmazemPage
    at ListagemArmazemPage
}
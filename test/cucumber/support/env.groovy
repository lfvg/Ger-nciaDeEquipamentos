package support


import geb.Browser
import geb.binding.BindingUpdater
import gerenciadeequipamentos.Armazem
import org.codehaus.groovy.grails.test.support.GrailsTestRequestEnvironmentInterceptor
import static cucumber.api.groovy.Hooks.*
import gerenciadeequipamentos.Equipamento

Before () {
    bindingUpdater = new BindingUpdater(binding, new Browser())
    bindingUpdater.initialize()
    scenarioInterceptor = new GrailsTestRequestEnvironmentInterceptor (appCtx)
    scenarioInterceptor.init ()
}

After () {
    Equipamento.list().each { equipamento ->
        equipamento.delete(flush:true)
    }
    Armazem.list().each{ armazem->
        armazem.delete(flush:true)
    }
    scenarioInterceptor.destroy ()
    bindingUpdater.remove ()
}
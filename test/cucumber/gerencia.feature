Feature: Como um usuario do sistema eu ao adicionar novos equipamentos eu consigo saber se posso ou nao aloca lo para determinado armazem baseando se na sua lotacao

  Scenario: Remover opções de configuração
    Given Eu sou um administrador e o sistema possiu a licalização "GRAD2" configurada
    And a localização "GRAD2" não possui nem um equipamento
    When eu tento remover a localização "GRAD2"
    Then a localização "GRAD2" é removida

  Scenario: Editar a area util de um armazem
    Given Eu sou administrador e o sistema possui a localização "GRAD2" configurada
    When eu tento diminuir a area util de "GRAD2"
    Then a area util de "GRAD2" é diminuida

  Scenario: Deletar um armazem ocupado
    Given eu criei o armazem "grad" com apenas um espaco livre
    And e armazenei o  equipamento "monitor" em "grad"
    And eu navego até a pagina que detalha o Armazen
    When eu seleciono deletar "grad"
    Then eu vejo uma mensagem e erro

  Scenario: Editar a area util para um valor menor que a ocupação
    Given eu criei o armazem "grad"
    And e armazenei os  equipamento "monitor" e "cpu" em "grad"
    And eu navego até a pagina que detalha o Armazen "grad"
    When eu seleciono editar "grad"
    And diminuo a sua area util pra 1
    Then eu vejo uma mensagem de erro
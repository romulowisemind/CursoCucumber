Feature: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar criterios de aceitação

  Scenario: Deve executar a especificação
    Given que criei um arquivo corretamente
    When executa-lo
    Then a especificacao deve finalizar com sucesso

  Scenario: Deve incrementar um contador
    Given que o valor do contador e 15
    When eu incremento em 3
    Then o valor do contador sera 18

  Scenario: Deve incrementar um contador
    Given que o valor do contador e 123
    When eu incremento em 35
    Then o valor do contador sera 158
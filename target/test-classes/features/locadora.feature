Feature: Locadora
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entregas

  Scenario: Deve alugar um filme com sucesso
    Given um filme com estoque de 2 unidades
    And que o preço do aluguel seja R$ 3
    When alugar
    Then o preço do aluguel será R$ 3
    And a data de entrega será de 1 dia
    And o estoque do filme será 1 unidades

  Scenario: Não deve alugar um filme sem estoque
    Given um filme com estoque de 0 unidades
    When alugar
    Then não será possível por falta de estoque
    And o estoque do filme será 0 unidades

  Scenario Outline: Deve dar condições conforme tipo de aluguel.
    Given um filme com estoque de 2 unidades
    And que o preço do aluguel seja R$ <preco>
    And que o tipo de aluguel seja <tipo>
    When alugar
    Then o preço do aluguel será R$ <valor>
    And a data de entrega será de <qtsDias> dias
    And a pontuação recebida será de <pontuacao> pontos

    Examples:
      | preco | tipo      | valor | qtsDias | pontuacao |
      |   4   | extendido |   8   |    3    |     2     |
      |   4   |   comum   |   4   |    1    |     1     |
      |   10  | extendido |  20   |    3    |     2     |
      |   5   |  semanal  |  15   |    7    |     3     |
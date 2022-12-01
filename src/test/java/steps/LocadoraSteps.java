package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Entidades.Filme;
import servicos.AluguelService;

public class LocadoraSteps {

    private Filme filme;
    private AluguelService aluguel;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }
    @Given("^que o preço de aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDeAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }
    @When("^alugar$")
    public void alugar() {
        aluguel.alugar(filme);
    }
    @Then("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(Integer int1) {
    }
    @Then("^a data de entrega será no dia seguinte$")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
    }
    @Then("^o estoque do filme será (\\d+) unidade$")
    public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
    }

}

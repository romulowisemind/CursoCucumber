package steps;

import Entidades.NotaAluguel;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Entidades.Filme;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import servicos.AluguelService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class LocadoraSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;

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
        try {
        nota = aluguel.alugar(filme);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Then("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(Integer int1) {
        Assertions.assertEquals(int1, nota.getPreco());
    }

    @Then("^a data de entrega será no dia seguinte$")
    public void aDataDeEntregaSeráNoDiaSeguinte() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntrega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assertions.assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assertions.assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assertions.assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Then("^o estoque do filme será (\\d+) unidades$")
    public void oEstoqueDoFilmeSeráUnidades(Integer int1) {
        Assertions.assertEquals(int1, filme.getEstoque());
    }

    @Then("não será possível por falta de estoque")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assertions.assertEquals("Filme sem estoque!!!", erro);
    }


}

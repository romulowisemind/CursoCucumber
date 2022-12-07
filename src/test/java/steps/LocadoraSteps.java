package steps;

import Entidades.NotaAluguel;
import Utils.DateUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Entidades.Filme;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import servicos.AluguelService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LocadoraSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private String tipoAluguel;

    @Given("^um filme com estoque de (\\d+) unidades$")
    public void umFilmeComEstoqueDeUnidades(Integer int1) {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Given("^que o preço de aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDeAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }
    @Given("^que o preço do aluguel seja R\\$ (\\d+)$")
    public void queOPreçoDoAluguelSejaR$(Integer int1) {
        filme.setAluguel(int1);
    }

    @When("^alugar$")
    public void alugar() {
        try {
        nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Then("^o preço do aluguel será R\\$ (\\d+)$")
    public void oPreçoDoAluguelSeráR$(Integer int1) {
        Assert.assertEquals(int1, nota.getPreco(), 8);
    }

    @Then("^o estoque do filme será (\\d+) unidades$")
    public void oEstoqueDoFilmeSeráUnidades(Integer int1) {
        Assertions.assertEquals(int1, filme.getEstoque());
    }

    @Then("^não será possível por falta de estoque$")
    public void nãoSeráPossívelPorFaltaDeEstoque() {
        Assertions.assertEquals("Filme sem estoque!!!", erro);
    }


    @Given("^que o tipo de aluguel seja (.*)$")
    public void queOTipoDeAluguelSejaExtendido(String tipo) {
        tipoAluguel = tipo;
    }


    @Then("^a data de entrega será de (\\d+) dias?$")
    public void aDataDeEntregaSeráDeDias(Integer int1) {
        Date dataEsperada = DateUtils.obterDataComDiferencaDeDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assertions.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }
    @Then("^a pontuação recebida será de (\\d+) pontos$")
    public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
        Assertions.assertEquals(int1, nota.getPontuacao());
    }


}

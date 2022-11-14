package Cods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AprenderCucumber {
    @Given("que criei um arquivo corretamente")
    public void que_criei_um_arquivo_corretamente() {
        System.out.println("Qualquer coisa");
    }

    @When("executa-lo")
    public void executa_lo() {
        System.out.println("passo 2");
    }

    @Then("a especificacao deve finalizar com sucesso")
    public void a_especificacao_deve_finalizar_com_sucesso() {
    }

    private int contador = 0;

    @Given("que o valor do contador e 15")
    public void que_o_valor_do_contador_e() {
        contador = 15;
    }

    @When("eu incremento em 3")
    public void eu_incremento_em() {
        contador = contador + 3;
    }

    @Then("o valor do contador sera 18")
    public void o_valor_do_contador_sera() {
        Assert.assertEquals((int) 18, contador);
    }
}

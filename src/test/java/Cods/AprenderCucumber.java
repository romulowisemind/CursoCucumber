package Cods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @Given("que o valor do contador e {int}")
    public void que_o_valor_do_contador_e(Integer int1) {
        contador = int1;
    }

    @When("eu incremento em {int}")
    public void eu_incremento_em(Integer int1) {
        contador = contador + int1;
    }

    @Then("o valor do contador sera {int}")
    public void o_valor_do_contador_sera(Integer int1) {
        System.out.println(int1);
        System.out.println(contador);
        System.out.println(int1 == contador);
    }
}

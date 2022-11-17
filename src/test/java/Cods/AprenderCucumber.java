package Cods;

import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sun.awt.IconInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
        Assert.assertEquals(18, contador);
    }
    @Given("que o valor do contador e 123")
    public void queOValorDoContadorE() {
        contador = 123;
    }
    @When("eu incremento em 35")
    public void euIncrementoEm() {
        contador = contador + 35;
    }
    @Then("o valor do contador sera 158")
    public void oValorDoContadorSera() {
        Assert.assertEquals(158, contador);
    }

    Date entrega = new Date();
    @Given("que a entrega é dia {int}\\/{int}\\/{int}")
    public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.YEAR, ano);
        entrega = cal.getTime();
    }
    @When("a entrega atrasar em {int} dias")
    public void aEntregaAtrasarEmDias(Integer int1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(entrega);
        cal.add(Calendar.DAY_OF_MONTH, int1);
        entrega = cal.getTime();
    }
    @Then("a entrega será efetuada {int}\\/{int}\\/{int}")
    public void aEntregaSeráEfetuada(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

}

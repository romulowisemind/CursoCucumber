package servicos;

import Entidades.Filme;
import Entidades.NotaAluguel;
import Utils.DateUtils;

import java.util.Calendar;

public class AluguelService {
    public NotaAluguel alugar(Filme filme) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque!!!");

        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}

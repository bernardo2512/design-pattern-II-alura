package br.com.alura;

import br.com.alura.http.JavaHttpClient;
import br.com.alura.orcamento.ItemOrcamento;
import br.com.alura.orcamento.Orcamento;
import br.com.alura.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class MainAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("600")));
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroDeOrcamento registroDeOrcamento = new RegistroDeOrcamento(new JavaHttpClient());
        registroDeOrcamento.registrar(orcamento);
    }
}

package br.com.alura;

import br.com.alura.imposto.CalculadoraDeImpostos;
import br.com.alura.imposto.ICMS;
import br.com.alura.imposto.ISS;
import br.com.alura.orcamento.ItemOrcamento;
import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;

public class MainImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
        System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
    }
}

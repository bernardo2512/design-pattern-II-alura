package br.com.alura.imposto;

import br.com.alura.orcamento.Orcamento;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Imposto {
    private Imposto outro;

    public Imposto(Imposto outro) {
        this.outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);
    public BigDecimal calcular(Orcamento orcamento){
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorDoOutroImposto =  BigDecimal.ZERO;
        if(Objects.nonNull(outro)){
            valorDoOutroImposto = outro.realizarCalculo(orcamento);
        }
        return valorImposto.add(valorDoOutroImposto);
    }
}

package br.com.alura.pedido.acao;

import br.com.alura.pedido.AcaoAposGerarPedido;
import br.com.alura.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedido {
    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: "+ pedido);
    }
}

package br.com.alura.pedido;

import br.com.alura.orcamento.ItemOrcamento;
import br.com.alura.orcamento.Orcamento;
import br.com.alura.pedido.acao.EnviarEmailPedido;
import br.com.alura.pedido.acao.SalvarPedidoNoBanco;

import java.time.LocalDateTime;
import java.util.List;

public class GeraPedidoHandler {
    //Observer
    private List<AcaoAposGerarPedido> acoes;

    public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void execute(GeraPedido dados){
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(dados.getValorOrcamento()));

        Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(),orcamento);
        this.acoes.forEach(a -> a.executarAcao(pedido));
    }
}

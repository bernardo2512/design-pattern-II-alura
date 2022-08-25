package br.com.alura.orcamento;

import br.com.alura.DomainException;
import br.com.alura.http.HttpAdapter;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento){
        if(!orcamento.isFinalizado()){
            throw new DomainException("Orcamento nao finalizado");
        }
        String url = "http://api.externa/orcamento";
        Map<String,Object> dados = Map.of(
                "valor",orcamento.getValor(),
                "quantidade", orcamento.getQuantidadeItens()
        );
        http.post(url,dados);

    }
}

package br.com.empresa.bridge.concrete.documento;

import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;

public class PropostaComercial extends Documento {

    private String servico;
    private double valor;
    private String prazo;

    public PropostaComercial(GeradorArquivo gerador, String servico, double valor, String prazo) {
        super(gerador);
        this.servico = servico;
        this.valor = valor;
        this.prazo = prazo;
    }

    @Override
    public void gerar() {
        String conteudo = "PROPOSTA COMERCIAL\n" +
                          "Serviço: " + servico + "\n" +
                          "Valor: R$ " + valor + "\n" +
                          "Prazo de Entrega: " + prazo;
        gerador.escrever(conteudo);
    }
}

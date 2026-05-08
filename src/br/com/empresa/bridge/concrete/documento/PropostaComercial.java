package br.com.empresa.bridge.concrete.documento;
import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class PropostaComercial extends Documento {
    private String servico;
    private double valor;
    public PropostaComercial(GeradorArquivo gerador, String servico, double valor) {
        super(gerador);
        this.servico = servico;
        this.valor = valor;
    }
    @Override
    public void gerar() {
        String conteudo = "PROPOSTA COMERCIAL\n" +
                          "Serviço: " + servico + "\n" +
                          "Valor: R$ " + valor;
        gerador.escrever(conteudo);
    }
}

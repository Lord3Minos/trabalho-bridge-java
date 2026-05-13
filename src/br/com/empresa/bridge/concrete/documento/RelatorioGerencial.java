package br.com.empresa.bridge.concrete.documento;

import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;

public class RelatorioGerencial extends Documento {

    private String indicadores;
    private String resultados;
    private String observacoes;

    public RelatorioGerencial(GeradorArquivo gerador, String indicadores, String resultados, String observacoes) {
        super(gerador);
        this.indicadores = indicadores;
        this.resultados = resultados;
        this.observacoes = observacoes;
    }

    @Override
    public void gerar() {
        String conteudo = "RELATÓRIO GERENCIAL\n" +
                          "Indicadores: " + indicadores + "\n" +
                          "Resultados: " + resultados + "\n" +
                          "Observações: " + observacoes;
        gerador.escrever(conteudo);
    }
}

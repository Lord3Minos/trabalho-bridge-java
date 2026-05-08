package br.com.empresa.bridge.concrete.documento;
import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class RelatorioGerencial extends Documento {
    private String indicadores;
    private String resultados;
    public RelatorioGerencial(GeradorArquivo gerador, String indicadores, String resultados) {
        super(gerador);
        this.indicadores = indicadores;
        this.resultados = resultados;
    }
    @Override
    public void gerar() {
        String conteudo = "RELATÓRIO GERENCIAL\n" +
                          "Indicadores: " + indicadores + "\n" +
                          "Resultados: " + resultados;
        gerador.escrever(conteudo);
    }
}

package br.com.empresa.bridge.concrete.documento;

import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;

public class ContratoSimplificado extends Documento {

    private String partes;
    private String clausulas;
    private String dataAssinatura;

    public ContratoSimplificado(GeradorArquivo gerador, String partes, String clausulas, String dataAssinatura) {
        super(gerador);
        this.partes = partes;
        this.clausulas = clausulas;
        this.dataAssinatura = dataAssinatura;
    }

    @Override
    public void gerar() {
        String conteudo = "CONTRATO SIMPLIFICADO\n" +
                          "Partes: " + partes + "\n" +
                          "Cláusulas: " + clausulas + "\n" +
                          "Data de Assinatura: " + dataAssinatura + "\n" +
                          "Assinatura: ____________________";
        gerador.escrever(conteudo);
    }
}

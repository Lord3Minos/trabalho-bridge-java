package br.com.empresa.bridge.concrete.gerador;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class GeradorXML implements GeradorArquivo {
    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO XML -----");
        System.out.println("<documento>");
        System.out.println("  <conteudo>" + conteudo + "</conteudo>");
        System.out.println("</documento>");
        System.out.println("------------------------\n");
    }
}

package br.com.empresa.bridge.concrete.gerador;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class GeradorPDF implements GeradorArquivo {
    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO PDF (Simulado) -----");
        System.out.println("[PDF Header]");
        System.out.println(conteudo);
        System.out.println("[PDF Footer - Assinatura Digital]");
        System.out.println("----------------------------------\n");
    }
}

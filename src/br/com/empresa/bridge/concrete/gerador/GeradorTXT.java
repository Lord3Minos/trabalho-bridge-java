package br.com.empresa.bridge.concrete.gerador;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class GeradorTXT implements GeradorArquivo {
    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO TXT -----");
        System.out.println(conteudo);
        System.out.println("------------------------\n");
    }
}

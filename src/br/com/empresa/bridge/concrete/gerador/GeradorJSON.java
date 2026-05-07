package br.com.empresa.bridge.concrete.gerador;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class GeradorJSON implements GeradorArquivo {
    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO JSON -----");
        System.out.println("{ \"documento\": { \"conteudo\": \"" + conteudo.replace("\n", "\\n") + "\" } }");
        System.out.println("------------------------\n");
    }
}

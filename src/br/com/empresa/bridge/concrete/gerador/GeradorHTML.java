package br.com.empresa.bridge.concrete.gerador;
import br.com.empresa.bridge.implementation.GeradorArquivo;
public class GeradorHTML implements GeradorArquivo {
    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO HTML -----");
        System.out.println("<html><body>");
        System.out.println(conteudo.replace("\n", "<br>"));
        System.out.println("</body></html>");
        System.out.println("------------------------\n");
    }
}

package br.com.empresa.bridge.concrete.documento;
import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.implementation.GeradorArquivo;
import java.util.List;
public class NotaFiscal extends Documento {
    private String cliente;
    private List<String> itens;
    private double total;
    public NotaFiscal(GeradorArquivo gerador, String cliente, List<String> itens, double total) {
        super(gerador);
        this.cliente = cliente;
        this.itens = itens;
        this.total = total;
    }
    @Override
    public void gerar() {
        StringBuilder sb = new StringBuilder();
        sb.append("NOTA FISCAL\n");
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Itens:\n");
        for (String item : itens) {
            sb.append("- ").append(item).append("\n");
        }
        sb.append("Total: R$ ").append(total);
        gerador.escrever(sb.toString());
    }
}

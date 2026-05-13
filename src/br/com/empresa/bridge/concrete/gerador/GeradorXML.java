package br.com.empresa.bridge.concrete.gerador;

import br.com.empresa.bridge.implementation.GeradorArquivo;

public class GeradorXML implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO XML -----");

        String[] linhas = conteudo.split("\n");
        StringBuilder xml = new StringBuilder();

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<documento>\n");

        for (String linha : linhas) {
            linha = linha.trim();
            if (linha.isEmpty()) continue;

            if (!linha.contains(":")) {
                // Linha de cabeçalho vira a tag <tipo>
                xml.append("  <tipo>").append(linha).append("</tipo>\n");
            } else if (linha.startsWith("-")) {
                // Item de lista (ex: "- Notebook Dell")
                String item = linha.substring(1).trim();
                xml.append("  <item>").append(item).append("</item>\n");
            } else {
                // Campo normal: "Chave: Valor" vira <chave>Valor</chave>
                int idx = linha.indexOf(":");
                String chave = linha.substring(0, idx).trim()
                        .toLowerCase()
                        .replace(" ", "_")
                        .replace("ã", "a")
                        .replace("ç", "c")
                        .replace("é", "e")
                        .replace("ó", "o")
                        .replace("ú", "u");
                String valor = linha.substring(idx + 1).trim();
                xml.append("  <").append(chave).append(">")
                   .append(valor)
                   .append("</").append(chave).append(">\n");
            }
        }

        xml.append("</documento>");
        System.out.println(xml.toString());
        System.out.println("------------------------\n");
    }
}

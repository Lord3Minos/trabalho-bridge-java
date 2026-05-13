package br.com.empresa.bridge.concrete.gerador;

import br.com.empresa.bridge.implementation.GeradorArquivo;

public class GeradorHTML implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO HTML -----");

        String[] linhas = conteudo.split("\n");
        StringBuilder html = new StringBuilder();

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"pt-BR\">\n<head>\n");
        html.append("  <meta charset=\"UTF-8\">\n");
        html.append("  <title>Documento</title>\n");
        html.append("  <style>body{font-family:Arial,sans-serif;margin:40px;} h1{color:#333;} table{border-collapse:collapse;width:100%;} td{padding:8px;border:1px solid #ccc;}</style>\n");
        html.append("</head>\n<body>\n");

        // Primeira linha vira o título H1
        if (linhas.length > 0) {
            html.append("  <h1>").append(linhas[0].trim()).append("</h1>\n");
            html.append("  <table>\n");
            for (int i = 1; i < linhas.length; i++) {
                String linha = linhas[i].trim();
                if (linha.isEmpty()) continue;
                if (linha.contains(":")) {
                    int idx = linha.indexOf(":");
                    String campo = linha.substring(0, idx).trim();
                    String valor = linha.substring(idx + 1).trim();
                    html.append("    <tr><td><strong>").append(campo).append("</strong></td><td>").append(valor).append("</td></tr>\n");
                } else {
                    html.append("    <tr><td colspan=\"2\">").append(linha).append("</td></tr>\n");
                }
            }
            html.append("  </table>\n");
        }

        html.append("</body>\n</html>");
        System.out.println(html.toString());
        System.out.println("------------------------\n");
    }
}

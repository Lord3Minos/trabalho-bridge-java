package br.com.empresa.bridge.concrete.gerador;

import br.com.empresa.bridge.implementation.GeradorArquivo;

public class GeradorJSON implements GeradorArquivo {

    @Override
    public void escrever(String conteudo) {
        System.out.println("----- GERANDO JSON -----");

        String[] linhas = conteudo.split("\n");
        StringBuilder json = new StringBuilder();
        json.append("{\n");

        // Pré-processa para agrupar itens de lista sob um array
        java.util.List<String> itensLista = new java.util.ArrayList<>();
        for (String linha : linhas) {
            if (linha.trim().startsWith("-")) {
                itensLista.add(linha.trim().substring(1).trim());
            }
        }

        boolean listaEmitida = false;
        boolean primeiroItem = true;

        for (int i = 0; i < linhas.length; i++) {
            String linha = linhas[i].trim();
            if (linha.isEmpty()) continue;

            // Linha de cabeçalho (sem dois-pontos e sem traço)
            if (!linha.contains(":") && !linha.startsWith("-")) {
                if (!primeiroItem) json.append(",\n");
                json.append("  \"tipo\": \"").append(linha).append("\"");
                primeiroItem = false;
            }
            // Item de lista: emite o array JSON uma única vez
            else if (linha.startsWith("-")) {
                if (!listaEmitida) {
                    if (!primeiroItem) json.append(",\n");
                    json.append("  \"itens\": [");
                    for (int j = 0; j < itensLista.size(); j++) {
                        json.append("\"").append(itensLista.get(j)).append("\"");
                        if (j < itensLista.size() - 1) json.append(", ");
                    }
                    json.append("]");
                    listaEmitida = true;
                    primeiroItem = false;
                }
            }
            // Linha "Itens:" sem valor — precursor da lista, não emite nada
            else if (linha.endsWith(":")) {
                // ignorado; os itens aparecem nas linhas seguintes
            }
            // Campo normal: "Chave: Valor"
            else {
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
                if (!primeiroItem) json.append(",\n");
                json.append("  \"").append(chave).append("\": \"").append(valor).append("\"");
                primeiroItem = false;
            }
        }

        json.append("\n}");
        System.out.println(json.toString());
        System.out.println("------------------------\n");
    }
}

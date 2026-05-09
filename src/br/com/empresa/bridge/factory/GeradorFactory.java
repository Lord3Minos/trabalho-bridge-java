package br.com.empresa.bridge.factory;

import br.com.empresa.bridge.implementation.GeradorArquivo;
import br.com.empresa.bridge.concrete.gerador.*;

public class GeradorFactory {
    public static GeradorArquivo criarGerador(String tipo) {
        switch (tipo.toUpperCase()) {
            case "TXT": return new GeradorTXT();
            case "HTML": return new GeradorHTML();
            case "PDF": return new GeradorPDF();
            case "JSON": return new GeradorJSON();
            case "XML": return new GeradorXML();
            default: throw new IllegalArgumentException("Tipo de gerador desconhecido: " + tipo);
        }
    }
}

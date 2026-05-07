package br.com.empresa.bridge.abstraction;

import br.com.empresa.bridge.implementation.GeradorArquivo;

public abstract class Documento {
    protected GeradorArquivo gerador;

    public Documento(GeradorArquivo gerador) {
        this.gerador = gerador;
    }

    public abstract void gerar();
}

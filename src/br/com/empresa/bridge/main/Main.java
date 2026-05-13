package br.com.empresa.bridge.main;

import br.com.empresa.bridge.abstraction.Documento;
import br.com.empresa.bridge.concrete.documento.*;
import br.com.empresa.bridge.factory.GeradorFactory;
import br.com.empresa.bridge.implementation.GeradorArquivo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE GERAÇÃO DE DOCUMENTOS (BRIDGE PATTERN) ===");

        // 1. Combinações obrigatórias
        System.out.println("\n--- 1. Executando Combinações Obrigatórias ---");

        Documento relatorio = new RelatorioGerencial(
                GeradorFactory.criarGerador("PDF"),
                "KPIs de Vendas",
                "Aumento de 20% no trimestre",
                "Meta atingida em todas as regionais");
        relatorio.gerar();

        Documento proposta = new PropostaComercial(
                GeradorFactory.criarGerador("HTML"),
                "Consultoria em TI",
                5000.00,
                "30 dias úteis");
        proposta.gerar();

        Documento nf = new NotaFiscal(
                GeradorFactory.criarGerador("JSON"),
                "João Silva",
                Arrays.asList("Notebook Dell", "Mouse Logitech", "Teclado Mecânico"),
                3550.00);
        nf.gerar();

        Documento contrato = new ContratoSimplificado(
                GeradorFactory.criarGerador("TXT"),
                "Empresa A & Empresa B",
                "Cláusula de Confidencialidade",
                "10/05/2025");
        contrato.gerar();

        // 2. Desafio Extra: sistema configurável via input
        System.out.println("\n--- 2. Desafio Extra: Escolha seu Documento e Formato ---");

        System.out.println("Escolha o documento (1: Relatório, 2: Nota Fiscal, 3: Proposta, 4: Contrato): ");
        int docOpcao = scanner.nextInt();

        System.out.println("Escolha o formato (TXT, HTML, PDF, JSON, XML): ");
        String formato = scanner.next();

        GeradorArquivo geradorEscolhido = GeradorFactory.criarGerador(formato);
        Documento docEscolhido = null;

        switch (docOpcao) {
            case 1: docEscolhido = new RelatorioGerencial(geradorEscolhido, "Indicadores Custom", "Sucesso", "Nenhuma"); break;
            case 2: docEscolhido = new NotaFiscal(geradorEscolhido, "Cliente Custom", Arrays.asList("Item 1", "Item 2"), 100.0); break;
            case 3: docEscolhido = new PropostaComercial(geradorEscolhido, "Serviço Custom", 1000.0, "15 dias"); break;
            case 4: docEscolhido = new ContratoSimplificado(geradorEscolhido, "Partes Custom", "Cláusulas Custom", "13/05/2025"); break;
        }

        if (docEscolhido != null) {
            System.out.println("\nResultado da sua escolha:");
            docEscolhido.gerar();
        }

        scanner.close();
    }
}

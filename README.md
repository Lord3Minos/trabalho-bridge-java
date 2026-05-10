# Projeto Padrão Bridge - Extensão

Este projeto implementa o padrão de projeto estrutural **Bridge** para a geração de documentos empresariais em múltiplos formatos.

## Estrutura de Pacotes
- `abstraction`: Contém a classe abstrata base para os documentos.
- `implementation`: Contém a interface para os geradores de arquivos.
- `concrete`: Implementações específicas de documentos e geradores.
- `factory`: Factory para criação dinâmica de geradores.
- `main`: Classe principal para testes.

## Como Executar
1. Compile os arquivos: `javac br/com/empresa/bridge/main/Main.java` (dentro de src)
2. Execute: `java br.com.empresa.bridge.main.Main`

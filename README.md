# Projeto QA

Este repositório contém um exemplo de automação de testes com Cypress e Playwright para execução em pipeline no GitHub Actions.

## Tecnologias utilizadas

- Node.js
- npm
- Cypress
- Playwright

## Estrutura do projeto

```text
meu-projeto-qa/
├── .github/
│   └── workflows/
│       └── qa-pipeline.yml       # O arquivo do pipeline abaixo
├── cypress/
│   └── e2e/
│       └── ui-playground.cy.js   # Testes do UI Test Automation Playground
├── tests/
│   └── demoqa.spec.js            # Testes do DemoQA com Playwright
├── postman/
│   ├── serverest_collection.json # Collection do Serverest
│   └── serverest_env.json        # Environment do Serverest
├── src/test/java/...             # Testes Selenium + JUnit (Automation Testing Practice)
├── pom.xml                       # Configuração do Maven (Java/Selenium/JUnit)
├── package.json                  # Dependências do Node.js (Cypress e Playwright)
└── playwright.config.js          # Configuração do Playwright
```

## Pré-requisitos

- Node.js 18+ instalado
- npm instalado
- Git

## Instalação

No diretório do projeto, execute:

```bash
npm install
```

## Executando os testes

### Cypress

```bash
npm run cypress:run
```

### Playwright

```bash
npm run playwright:test
```

## Executando localmente no modo interativo

```bash
npm run cypress:open
```

## Pipeline no GitHub Actions

Este projeto pode ser integrado a um workflow do GitHub Actions para executar os testes automaticamente a cada push ou pull request.

Exemplo de arquivo de workflow:

```yaml
name: QA CI

on:
  push:
    branches: [ main , master ]
  pull_request:
    branches: [ main , master ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v4

      - name: Setup Node.js
        uses: actions/setup-node@v4
        with:
          node-version: 20

      - name: Install dependencies
        run: npm install

      - name: Run Cypress tests
        run: npm run cypress:run
```

## Observações

- O teste Cypress presente no projeto valida uma interação simples na página UI Test Automation Playground.
- O projeto já está configurado para rodar em modo headless.

## Autor

Projeto de automação de testes QA.

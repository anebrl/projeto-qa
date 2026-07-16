# Projeto QA

Este repositório reúne automação de testes com Cypress, Playwright, Selenium/JUnit e Postman/Newman, com um pipeline pronto para execução no GitHub Actions.

## Tecnologias utilizadas

- Node.js
- npm
- Cypress
- Playwright
- Java + Maven
- Selenium WebDriver
- JUnit 5
- Postman/Newman

## Estrutura do projeto

```text
projeto-qa/
├── .github/
│   └── workflows/
│       └── qa-pipeline.yml       # Pipeline de CI com Cypress, Playwright, Selenium e Postman
├── cypress/
│   └── e2e/
│       └── ui-playground.cy.js   # Testes do UI Test Automation Playground
├── tests/
│   └── demoqa.spec.js            # Testes do DemoQA com Playwright
├── postman/
│   ├── serverest_collection.json # Collection do ServeRest
│   └── serverest_env.json        # Environment do ServeRest
├── src/test/java/
│   └── AutomationTestingPracticeTest.java # Teste Selenium + JUnit
├── cypress.config.js             # Configuração do Cypress
├── playwright.config.js          # Configuração do Playwright
├── package.json                  # Dependências do Node.js e scripts de execução
├── pom.xml                       # Configuração do Maven para Selenium/JUnit
└── README.md                     # Documentação do projeto
```

## Pré-requisitos

- Node.js 18+ instalado
- npm instalado
- Java 17+ para a suíte Selenium/JUnit
- Maven disponível no PATH
- Git

## Instalação

Na raiz do projeto, execute:

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

### Selenium + JUnit

```bash
mvn -B clean test -Dtest=AutomationTestingPracticeTest
```

### Postman/Newman

```bash
npx newman run postman/serverest_collection.json -e postman/serverest_env.json -r cli
```

## Executando localmente no modo interativo

```bash
npm run cypress:open
```

## Pipeline no GitHub Actions

O workflow em [.github/workflows/qa-pipeline.yml](.github/workflows/qa-pipeline.yml) executa os testes automaticamente em push, pull request e execução manual.

### Jobs do pipeline

- Cypress: valida o fluxo de UI do playground
- Playwright: executa os testes do DemoQA
- Selenium/JUnit: roda o teste de formulário no Java
- Postman/Newman: executa a collection da API ServeRest

### Artefatos gerados

- evidências do Cypress
- relatório do Playwright
- relatórios JUnit
- relatório HTML do Newman

## Observações

- O teste Cypress foi validado em modo headless.
- O Playwright precisa dos browsers instalados antes da execução; no CI isso é feito automaticamente.
- O pipeline foi preparado para rodar em ambientes Ubuntu do GitHub Actions.

## Autor

Rosiane Lima - Linkedin https://www.linkedin.com/in/rosiane-lima-b6839bbb/

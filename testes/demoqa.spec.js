const { test, expect } = require('@playwright/test');

test.describe('DemoQA - Text Box', () => {
  test('Deve preencher e enviar o formulário de Text Box', async ({ page }) => {
    // Acessa a página de Text Box
    await page.goto('https://demoqa.com/text-box');

    // Preenche os campos de input
    await page.fill('#userName', 'QA Engineer');
    await page.fill('#userEmail', 'qa@exemplo.com');
    await page.fill('#currentAddress', 'Rua dos Testes, 123');
    await page.fill('#permanentAddress', 'Avenida da Automação, 456');

    // Clica no botão de submit (forçando o clique se houver anúncios na frente)
    await page.click('#submit', { force: true });

    // Validações
    const output = page.locator('#output');
    await expect(output).toBeVisible();
    await expect(output).toContainText('Name:QA Engineer');
    await expect(output).toContainText('Email:qa@exemplo.com');
  });
});
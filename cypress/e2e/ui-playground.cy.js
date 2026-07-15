describe('UI Test Automation Playground', () => {
  beforeEach(() => {
    // Visita a página inicial do Playground
    cy.visit('http://uitestingplayground.com/');
  });

  it('Deve interagir com o Dynamic ID com sucesso', () => {
    // Navega para o desafio de ID Dinâmico
    cy.contains('Dynamic ID').click();

    // Valida se a URL mudou
    cy.url().should('include', '/dynamicid');

    // Clica no botão usando a classe CSS (já que o ID muda a cada refresh)
    cy.get('button.btn-primary')
      .should('be.visible')
      .click();
  });
});
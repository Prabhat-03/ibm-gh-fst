describe("Activity 3", () => {
  beforeEach(() => {
    cy.visit("http://localhost:3000");
  });

  it("completes full workflow: add, complete, delete todos", () => {
    cy.get('[data-cy="todo-input"]').type("Buy groceries{enter}");
    cy.get('[data-cy="todo-input"]').type("Walk the dog{enter}");
    cy.get('[data-cy="todo-input"]').type("Read a book{enter}");

    cy.get('[data-cy="todo-item"]').should("have.length", 3);

    cy.get('[data-cy="todo-checkbox"]').eq(0).click();
    cy.get('[data-cy="todo-checkbox"]').eq(0).should("be.checked");

    cy.get('[data-cy="todo-checkbox"]').eq(1).click();
    cy.get('[data-cy="todo-checkbox"]').eq(1).should("be.checked");

    cy.get('[data-cy="delete-button"]').eq(2).click();

    cy.get('[data-cy="todo-item"]').should("have.length", 2);

    cy.get('[data-cy="todo-count"]')
      .should("contain", "Total: 2")
      .and("contain", "Completed: 2");
  });
});
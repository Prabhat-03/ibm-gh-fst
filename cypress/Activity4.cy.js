describe('Todo App with API', () => {
  beforeEach(() => {
    // Stub the GET request
    cy.intercept('GET', '/api/todos', { fixture: 'todos.json' }).as('getTodos')
    
    // Stub the POST request
    cy.intercept('POST', '/api/todos', (req) => {
      req.reply({
        statusCode: 201,
        body: {
          id: Date.now(),
          ...req.body
        }
      })
    }).as('createTodo')
    
    cy.visit("http://localhost:3000")
    cy.wait('@getTodos')
  })
  
  it('loads existing todos', () => {
    cy.get('[data-cy="todo-item"]').should('have.length', 3)
  })
  
  it('adds a new todo', () => {
    cy.addTodo('New todo')
    cy.wait('@createTodo')
    cy.get('[data-cy="todo-item"]').should('have.length', 4)
  })
})
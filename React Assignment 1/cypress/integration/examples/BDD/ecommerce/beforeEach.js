beforeEach(function () {
    // runs once before each tests in the block
    cy.fixture('example').then(function (data) {
        this.data = data
    })
})
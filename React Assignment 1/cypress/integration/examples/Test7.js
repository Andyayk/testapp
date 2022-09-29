/// <reference types="Cypress" />

describe('My Second Test Suite', function () {
    it('My FirstTest case', function () {
        cy.visit("https://rahulshettyacademy.com/AutomationPractice/")

        cy.get('#opentab').then(function (el) {
            const url = el.prop('href')
            cy.log(url)
            cy.visit(url)
        })

        cy.contains('Top').click({ force: true })
        cy.url().should('include', 'top')
    })
})
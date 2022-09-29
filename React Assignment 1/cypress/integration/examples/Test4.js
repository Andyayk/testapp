/// <reference types="Cypress" />

describe('My Second Test Suite', function () {
	it('My FirstTest case', function () {
		cy.visit("https://rahulshettyacademy.com/AutomationPractice/")
		cy.get('#alertbtn').click()
		cy.get('[value="Confirm"]').click()

		//window alert
		cy.on('window:alert', (str) => {
			//mocha
			expect(str).to.equal('Hello , share this practice page and share your knowledge')
		})

		//window confirm
		cy.on('window:confirm', (str) => {
			//mocha
			expect(str).to.equal('Hello , Are you sure you want to confirm?')
		})

		//open tab in the same page for cypress
		cy.get('#opentab').invoke('removeAttr', 'target').click()
		cy.url().should('include', 'rahulshettyacademy')
		cy.go('back')
	})
})

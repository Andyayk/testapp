/// <reference types="Cypress" />

describe('My Second Test Suite', function () {
	it('My FirstTest case', function () {
		cy.visit("https://rahulshettyacademy.com/AutomationPractice/")

		//checkbox
		cy.get('#checkBoxOption1').check().should('be.checked').and('have.value', 'option1')
		cy.get('#checkBoxOption1').uncheck().should('not.be.checked')

		//select multiple checkbox at once
		cy.get('input[type="checkbox"').check(['option2', 'option3'])

		//static dropdown
		cy.get('select').select('Option2').should('have.value', 'option2')

		//dynamic dropdown
		cy.get('#autocomplete').type("si")

		cy.get('.ui-menu-item div').each(($el, index, $list) => {
			if ($el.text() === "Singapore") {
				cy.wrap($el).click()
			}
		})

		cy.get('#autocomplete').should("have.value", "Singapore")

		//invisible elements
		cy.get('#displayed-text').should('be.visible')
		cy.get('#hide-textbox').click()
		cy.get('#displayed-text').should('not.be.visible')
		cy.get('#show-textbox').click()
		cy.get('#displayed-text').should('be.visible')

		//radio
		cy.get('input[value="radio2"]').check().should('be.checked').and('have.value', 'radio2')
	})
})
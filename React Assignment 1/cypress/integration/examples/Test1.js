//cypress - Spec

describe('My First Test', () => {
	it('Visits the Kitchen Sink', () => {
		cy.visit('https://rahulshettyacademy.com/seleniumPractise/#/')
		cy.get('.search-keyword').type('ca')
		cy.wait(2000)
		cy.get('.product:visible').should('have.length', 4)

		//alias
		cy.get('.products').as('productLocator')

		//parent child chaining
		cy.get('@productLocator').find('.product').should('have.length', 4)

		//pull second indexed product, find ADD TO CART button
		cy.get('@productLocator').find('.product').eq(2).contains('ADD TO CART').click()

		//dynamically find an item using for each
		cy.get('@productLocator').find('.product').each(($el, index, $list) => {
			const textVeg = $el.find('h4.product-name').text()

			if (textVeg.includes('Capsicum')) {
				cy.wrap($el).find('button').click()
			}
		})

		//assert if logo text is displayed correctly
		cy.get(".brand").should("have.text", "GREENKART")
	})
})
Feature: End to end Ecommerce validation

    application Regression

    Scenario: : Ecommerce products delivery
    Given I open Ecommerce Page
    When I add items to cart
    And Validate the total prices
    Then select the country submit and verify Thankyou
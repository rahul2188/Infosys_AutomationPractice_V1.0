Feature: Automation Practice assignment - Placing an order

Scenario: To place a complete end to end order in the website

Given user lands on dresses section page
#When user hovers to any dress and add to cart is displayed
And user clicks on add to cart button
Then popup should be displayed
When user completes the order and reach at the shipping section
And user clicks on checkout without selecting terms and conidtions
Then user must get an error message
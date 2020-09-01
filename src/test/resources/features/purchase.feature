#author: Santiago Moncada

Feature: buy products in the Dafiti app
  I, as a user, want to buy some
  products and know the total to pay

  @BuyProducts
  Scenario: buy products from different categories
    Given the user opens the app
    When he buys some products
     ##@externaldata@./src/test/resources/datadriven/data.xlsx@Products
      | productCategory | productName | productSize |
      | Zapatos         | Reebok      | 40          |
      | Vestuario       | GAP         | L           |
    Then he should see the total of the products purchased
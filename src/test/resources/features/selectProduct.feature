# #language: pt
#  Funcionalidade: Selecionar produto na Loja
#    Cenario: Selecionar Produto com Sucesso
#      Dado que acesso a loja SauceDemo
#      Quando preencho o usuario e senha
#      E clica em Login
#      Entao Exibe o titulo da pagina como "Products"
#      E exibe o link do carrinho de compras
#      Quando clica no Produto "Sauce Labs Backpack"

  Feature: Select Product in Store
    Scenario: Selecting Product with Success
      Given I access the SauceDemo store
      When I filled username "standard_user" and password "secret_sauce"
      And I click in Login
      Then show page title as "Product"
      And shows cart's link
      When I click in product "Sauce Labs Backpack"
      Then I verify the produtc title "Sauce Labs Backpack"
      And I verify the product price "$ 29.99"
      When I click in Add to Cart
      And I click in Cart icon
      Then hen I verify then page's title "Your Cart"
      And I verify the produtc title "Sauce Labs Backpack"
      And I verify the quantity is "1"
      And I verify the product price "$ 29.99"



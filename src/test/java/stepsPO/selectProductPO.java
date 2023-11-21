package stepsPO;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class selectProductPO {
    // Atributos
    final WebDriver driver; // este é objeto final do Selenium (Uma única bola em campo)

    // Definindo objetos para receber os mapeamentos de páginas já importados
    private CartPage cartePage;
    private HomePage homePage;
    private InventoryItemPage inventoryItemPage;
    private InventoryPage inventoryPage;


    // Construtor
    public selectProductPO(BasePage basePage){
        this.driver = basePage.driver; // passagem de bola = instegração Selenium dentro e fora
    }


    @Given("I access the SauceDemo store PO")
    public void i_access_the_sauce_demo_store() {
        driver.get("https://www.saucedemo.com");


    }
    @When("I filled username {string} and password {string} PO")
    public void i_filled_username_and_password(String user, String password) {
        homePage.Logar(user, password);

    }
    @And("I click in Login PO")
    public void i_click_in_login() {
       homePage.clicarNoBotaoLogin();

    }
    //@Then("show page title as {string}")
    @Then("I verify then page's title {string} PO")
    public void show_page_title_as(String pageTitle) {
        // Verifica se o tirulo da página coincide com o informado na feature
        assertEquals(inventoryPage.lerTituloDaPagina(), pageTitle);

    }
    @And("shows cart's link PO")
    public void shows_cart_s_link() {
        // Verifica se o elemento do carrinho de compras está visivel
        assertTrue(inventoryPage.imgCarrinho.isDisplayed());

    }
    @When("I click in product {string} PO")
    public void i_click_in_product(String productId) {
        // Clica no elemento correspondente ao código do produto informado na feature
        inventoryPage.clicarNoTituloDoProduto(productId);

    }
    @Then("I verify the product title {string} PO")
    public void i_verify_the_product_title(String productTitle) {
        // Verifica se o titulo do produto corresponde ao informado na feature
        assertEquals(inventoryItemPage.lerTituloDoProduto(), productTitle);

    }
    @And("I verify the product price {string} PO")
    public void i_verify_the_product_price(String productPrice) {
        // Verifica se o preço do produto corresponde ao informado na feature
        assertEquals(inventoryItemPage.lerPrecoDoProduto(), productPrice);

    }
    @When("I click in Add to Cart PO")
    public void i_click_in_add_to_cart() {
        // Clica no botão adicionar ao carrinho
        // driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        inventoryItemPage.clicarNoBotaoAdicionarOuRemoverNoCarrinho();

    }
    @And("I click in Cart icon PO")
    public void i_click_in_cart_icon() {
        // Clica no icone do carrinho compras
        inventoryPage.clicarNoCarrinho();

    }


    @And("I verify the quantity is {string} PO")
    public void i_verify_the_quantity_is(String quantity) {
        // Verifica se a quantidade corresponde a feature
        assertEquals(cartePage.lerQuantidadeDoprodutoNoCarrinho(), quantity);


    }
    @Then("I verify the product title {string} in cart PO")
    public void i_verify_the_product_title_in_cart(String productTitle) {



        for (int i = 1; i < cartePage.contarProdutosNoCarrinho(); i++) {
            cartePage.clicarNoBotaoRemoverNoCarrinho();

        }

       assertEquals(cartePage.lerTituloProdutoNoCarrinho(), productTitle);

    }
    @Then("I verify the product price {string} in cart PO")
    public void i_verify_the_product_price_in_cart(String productPrice) {
        assertEquals(cartePage.lerPrecoProdutoNoCarrinho(), productPrice);

    }

}

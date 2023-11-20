package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    @FindBy(id = "shopping_cart_container")
    WebElement imgCarrinho;

    @FindBy(css = "span.title")
    WebElement lblTituloPagina;

    @FindBy(css = "btn btn_primary btn_small btn_inventory")
    WebElement btnAdicionarOuRemoverNoCarrinho;

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // função para retornar o titulo escrito na guia do browser
    public String lerTituloAba(){
        return driver.getTitle();
    }


    public void clicarNoCarrinho(){
       imgCarrinho.click(); // clica na imagem do carrinho
    }

    public String lerTituloDaPagina(){
        return lblTituloPagina.getText(); // retorna o que estiver escrito no elemento
    }

    // Esta função é apenas um exemplo, ela não vai ser usado no exercicio
    public String lerTextoDoBotaoAdicionarRemoverDoCarrinho(){
        return btnAdicionarOuRemoverNoCarrinho.getText();
    }

    public void clicarNoBotaoAdicionarOuRemoverNoCarrinho(){
        btnAdicionarOuRemoverNoCarrinho.click();
    }
}

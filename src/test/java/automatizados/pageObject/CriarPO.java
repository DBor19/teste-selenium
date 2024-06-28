package automatizados.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CriarPO extends BasePO {

    // Elemento do botão "Criar"
    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    // Construtor da classe que recebe um WebDriver
    public CriarPO(WebDriver driver) {
        super(driver);
    }

    // Método para clicar no botão "Criar" e abrir a tela de cadastro de produtos
    public void abrirTelaCadastroProdutos() {
        buttonCriar.click();
    }
}

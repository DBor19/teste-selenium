package automatizados.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VoltarPO extends BasePO {

    // Elemento da barra de menu para a opção "Voltar"
    @FindBy(id = "link-voltar")
    public WebElement linkVoltar;

    // Construtor da classe que recebe um WebDriver
    public VoltarPO(WebDriver driver) {
        super(driver);
    }

    // Método para clicar na opção "Voltar" e retornar para a tela de login
    public void voltarParaTelaLogin() {
        linkVoltar.click();
    }
}

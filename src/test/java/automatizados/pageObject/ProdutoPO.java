package automatizados.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "cadastro-produto")
    public WebElement modalSalvar;

    @FindBy(css = "table tbody")
    public WebElement tabelaProdutosCriados;

    @FindBy(css = "#cadastro-produto button.close")
    public WebElement closeButton;

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    public void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    public void abrirModalDeCriacao() {
        buttonAdicionar.click();
    }

    public void salvarProduto(String codigo, String nome, String quantidade, String valor, String data) {
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);
        buttonSalvar.click();
    }

    public boolean verificarCriacaoDeProduto(String codigo, String nome, String quantidade, String valor, String data) {
        return tabelaProdutosCriados.getText().contains(codigo) &&
               tabelaProdutosCriados.getText().contains(nome) &&
               tabelaProdutosCriados.getText().contains(quantidade) &&
               tabelaProdutosCriados.getText().contains(valor) &&
               tabelaProdutosCriados.getText().contains(data);
    }

    public void fecharModal() {
        closeButton.click();
    }
}

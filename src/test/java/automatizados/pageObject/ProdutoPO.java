package automatizados.pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO {

    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn-adicionar")
    public WebElement buttonCriar;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQtde;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "mensagem")
    public WebElement spanMensagem;

    @FindBy(css = "tbody")
    public WebElement tbodyProdutos;

    public String obterMensagem() {
        return this.spanMensagem.getText();
    }

    public void criarProduto(int codigo, String nome, int qtde, int valor, Date data) {
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = formatoData.format(data);

        buttonCriar.click();
        escrever(inputCodigo, Integer.toString(codigo));
        escrever(inputNome, nome);
        escrever(inputQtde, Integer.toString(qtde));
        escrever(inputValor, Integer.toString(valor));
        escrever(inputData, dataFormatada);
        buttonSalvar.click();
    }

    private void escrever(WebElement input, String texto) {
        input.clear();
        input.sendKeys(texto + Keys.TAB);
    }

    public int contaProdutos() {
        List<WebElement> linhas = tbodyProdutos.findElements(By.tagName("tr"));
        return linhas.size();
    }

    public void excluirProduto(int codigo) {
        List<WebElement> linhas = tbodyProdutos.findElements(By.tagName("tr"));
        for (WebElement linha : linhas) {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));
            if (colunas.get(0).getText().equals(Integer.toString(codigo))) {
                colunas.get(colunas.size() - 1).findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    public boolean verificarProdutoNaTabela(int codigo) {
        List<WebElement> linhas = tbodyProdutos.findElements(By.tagName("tr"));
        for (WebElement linha : linhas) {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));
            if (colunas.get(0).getText().equals(Integer.toString(codigo))) {
                return true;
            }
        }
        return false;
    }
}

package automatizados.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizados.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest {

    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    @Test
    public void TC006_deveCadastrarProdutoComCamposPreenchidos() {
        produtoPage.abrirModalDeCriacao();
        produtoPage.salvarProduto("001", "Produto Teste", "50", "199.99", "2024-07-01");
        assertTrue(produtoPage.verificarCriacaoDeProduto("001", "Produto Teste", "50", "199.99", "2024-07-01"));
    }

    @Test
    public void TC007_naoDeveCadastrarProdutoComCamposVazios() {
        produtoPage.abrirModalDeCriacao();
        produtoPage.salvarProduto("", "", "", "", "");
        String mensagem = produtoPage.obterMensagem();
        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }

    @Test
    public void TC010_deveFecharOModalDeCadastro() {
        produtoPage.abrirModalDeCriacao();
        produtoPage.fecharModal();
        String modalStyle = produtoPage.modalSalvar.getAttribute("style");
        assertTrue(modalStyle.contains("display: none;"));
    }
}

package automatizados.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class CriarProdutoTest2 extends BaseTest {

    public static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    // Caso 6: Cadastrar produto com campo vazio
    @Test
    public void TC006_naoDeveCadastrarProdutoComCampoVazio() {
        produtoPage.buttonCriar.click();
        produtoPage.buttonSalvar.click();
        String mensagemErro = produtoPage.obterMensagem();
        assertEquals("Todos os campos são obrigatórios!", mensagemErro);
    }
    // Caso 7: Ao clicar no botão Salvar deve fechar a tela e salvar na tabela
    @Test
    public void TC007_deveSalvarProdutoETabelaAtualizar() {
        int qtdeInicial = produtoPage.contaProdutos();
        produtoPage.criarProduto(1, "Produto Teste", 10, 50, new Date());
        int qtdeFinal = produtoPage.contaProdutos();
        assertTrue(qtdeFinal > qtdeInicial);
    }

    // Caso 10: Deve permitir a exclusão de um produto da tabela
    @Test
    public void TC010_devePermitirExcluirProdutoDaTabela() {
        produtoPage.criarProduto(2, "Produto a Excluir", 5, 30, new Date());

        assertTrue(produtoPage.verificarProdutoNaTabela(2));

        produtoPage.excluirProduto(2);

        assertFalse(produtoPage.verificarProdutoNaTabela(2));
    }
}

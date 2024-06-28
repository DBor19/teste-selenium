package automatizados.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.ProdutoPO;

public class ProdutoTest extends BaseTest {

    private static ProdutoPO produtoPage;

    @BeforeClass
    public static void prepararTestes() {
        produtoPage = new ProdutoPO(driver);
    }

    // Caso 6: Cadastrar produto com campo vazio
    @Test
    public void TC006_naoDeveCadastrarProdutoComCampoVazio() {
        produtoPage.criarProduto(0, "", 0, 0, new Date());
        String mensagemErro = produtoPage.obterMensagem();
        assertEquals("Todos os campos são obrigatórios!", mensagemErro);
    }

    // Caso 7: Ao clicar no botão Salvar deve fechar a tela e salvar na tabela
    @Test
    public void TC007_deveSalvarProdutoETabelaAtualizar() {
        produtoPage.criarProduto(1, "Produto Teste", 10, 50, new Date());
        int quantidadeProdutos = produtoPage.contaProdutos();
        assertTrue(quantidadeProdutos > 0);
    }

    // Caso 10: Deve permitir a exclusão de um produto da tabela
    @Test
    public void TC010_devePermitirExcluirProdutoDaTabela() {
        produtoPage.criarProduto(2, "Produto a Excluir", 5, 30, new Date());
        produtoPage.excluirProduto(2);
        int quantidadeProdutos = produtoPage.contaProdutos();
        assertTrue(quantidadeProdutos == 0);
    }
}

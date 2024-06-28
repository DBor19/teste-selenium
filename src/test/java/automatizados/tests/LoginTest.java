package automatizados.tests;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizados.pageObject.LoginPO;

public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhasVazios() {
//		loginPage.inputEmail.sendKeys("");
//		loginPage.inputSenha.sendKeys("");

		//melhoria 01
		//loginPage.escrever(loginPage.inputEmail,"");
		//loginPage.escrever(loginPage.inputSenha,"");
		
		//melhoria02
		//loginPage.buttonEntrar.click();
		loginPage.executarAcaoDeLogar("","");
		
		//melhoria 03
		//String mensagem = loginPage.spanMensagem.getText();
		String mensagem = loginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}

}
package br.com.tortiago.cases;

import java.io.IOException;

import org.junit.Test;

import br.com.tortiago.pages.TestPage;
import br.com.tortiago.util.evidencias.GerenciamentoArquivos;
import br.com.tortiago.util.rodar.GerenciamentoDriver;

public class TestCase extends GerenciamentoDriver{

	public TestPage testPage = new TestPage(driver);
	public GerenciamentoArquivos arquivo = new GerenciamentoArquivos();

	@Test
	public void testCase() throws InterruptedException, IOException{

		arquivo.setPasta("testSuper");

		arquivo.criaPasta();

		testPage.btnEntrar(arquivo.getPasta());

		testPage.txtUser(arquivo.getPasta());
		
		testPage.txtPassword(arquivo.getPasta());
//
//		Exception a = testPage.txtPassword(arquivo.getPasta());

		arquivo.contaPrint(arquivo.getCaminho()+arquivo.getPasta(), 4);
		
		
		
	}

}
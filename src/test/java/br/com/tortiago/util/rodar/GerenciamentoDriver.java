package br.com.tortiago.util.rodar;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.tortiago.util.criar.DSL;

public class GerenciamentoDriver extends Constantes{

	public GerenciamentoDriver() {
		this.driver = new ChromeDriver();
	}

	public DSL dsl;
	@Before
	public void inicializaNavegador() {
		driver.get(URL);
		driver.manage().window().maximize();
		dsl = new DSL(driver);
	}


	
	@After
	public void encerraNavegador() throws IOException {
		driver.quit();
	}

}

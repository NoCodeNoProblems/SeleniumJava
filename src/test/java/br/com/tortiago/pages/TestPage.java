package br.com.tortiago.pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;

import br.com.tortiago.util.criar.DSL;

public class TestPage extends DSL{
	
	public TestPage(ChromeDriver driver) {
		super(driver);
	}
		
	public void btnEntrar(String pasta) throws IOException {
		clicar(pasta, "btnEntrar", "btnLogin");		
	}
	
	public void txtUser(String pasta) throws InterruptedException, IOException {
		escrever(pasta, "txtUser", "username","tiago.ramos@techne.com.br");
	}
	
	public Exception txtPassword(String pasta) throws InterruptedException, IOException {
		Exception teste = escrever(pasta, "txtPassword", "passwor","teste");
		return teste;
	}
	
	
}
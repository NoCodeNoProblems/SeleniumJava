package br.com.tortiago.util.criar;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.tortiago.util.evidencias.GerenciamentoArquivos;
import br.com.tortiago.util.evidencias.Screenshot;

public class DSL extends PageElementos{

	public DSL(ChromeDriver driver) {
		super(driver);
	}

	private Screenshot print = new Screenshot(driver);
	private GerenciamentoArquivos arquivo = new GerenciamentoArquivos();
	protected String erroJUnit;
	
	public String getErroJUnit() {
		return erroJUnit;
	}

	public void setErroJUnit(String erroJUnit) {
		this.erroJUnit = erroJUnit;
	}
	
	
	public void clicar(String pasta, String printName, String id) {
		try {
			print.screenshot(arquivo.getCaminho(), pasta, printName);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		driver.findElementById(id).click();
	}

	public void clicar(String pasta, String printName, By by) {
		try {
			print.screenshot(arquivo.getCaminho(), pasta, printName);
		} catch (IOException e) {
			System.out.println("Erro na ação de print.");
			e.printStackTrace();
		}
		driver.findElement(by).click();
	}

	public Exception escrever(String pasta, String printName, String id, String texto) {
		try {
			print.screenshot(arquivo.getCaminho(), pasta, printName);
			driver.findElementById(id).sendKeys(texto);
		} catch (Exception e) {
			setErroJUnit(e.toString());
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return null;
	}


}
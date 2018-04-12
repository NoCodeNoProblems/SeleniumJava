package br.com.tortiago.util.evidencias;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.tortiago.util.criar.PageElementos;

public class Screenshot extends PageElementos{
	
	public Screenshot(ChromeDriver driver) {
		super(driver);
	}

	// Obtem a hora atual (usada no nome dos Screenshots)
	public String horaAtual() {
		Calendar time = Calendar.getInstance();
		int hora = time.get(Calendar.HOUR_OF_DAY);
		int minuto = time.get(Calendar.MINUTE);
		int segundo = time.get(Calendar.SECOND);
		int milissegundos = time.get(Calendar.MILLISECOND);
		String tempo = hora + "-" + minuto + "-" + segundo + "-" + milissegundos;
		return tempo;
	}
	

	// Executa Printscreen e salva na pasta definida
	public void screenshot(String caminho, String pasta, String printName) throws IOException {
		String hrPrint = horaAtual();
		TakesScreenshot print = (TakesScreenshot) driver;
		
		File arquivo = print.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File (caminho + pasta + printName + hrPrint + ".jpg"));
		System.out.println(caminho + pasta + printName + hrPrint + ".jpg");
		FileUtils.copyFile(arquivo, new File (caminho + pasta + printName + hrPrint + ".jpg"));
	}

	
}

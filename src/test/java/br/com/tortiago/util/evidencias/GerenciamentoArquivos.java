package br.com.tortiago.util.evidencias;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import br.com.tortiago.util.rodar.GerenciamentoDriver;

public class GerenciamentoArquivos extends GerenciamentoDriver{
	
	final String caminho = "C:\\Automacao\\";
	private JavaMail email = new JavaMail();

	private String pasta;

	public String getPasta() {
		return pasta;
	}
	
	public void setPasta(String pasta) {
		this.pasta = pasta + "\\";
	}
	
	public String getCaminho() {
		return caminho;
	}

	
	// Verifica se a pasta existe se existir deleta e cria uma nova
	public void criaPasta() {
		File path = new File(caminho + pasta);
		if(path.exists()) {
			deletarPasta(path);
		}		
		path.mkdir();
	}
	
	// Deleta tds os arquivos dentro da pasta e por final deleta a pasta
	public boolean deletarPasta(File path) {
		if (path.isDirectory()) {
			String[] arquivos = path.list();
			for (int i=0; i<arquivos.length; i++) { 
				boolean success = deletarPasta(new File(path, arquivos[i]));
				if (!success) {
					return false;
				}
			}
		}
		  return path.delete();
	}

	// Metodo usado para verificar se o CT executou todosos passos determinados 
	public void contaPrint(String caminhoEPasta, int qtdPrint) {
		File path = new File(caminhoEPasta);
		int numeroPrint = contarArquivos(caminhoEPasta);
		if(numeroPrint == qtdPrint) {
			deletarPasta(path);
		} else {
			String[] evidencia = path.list();
			for(int i=0; i<evidencia.length; i++) {
				evidencia[i] = caminhoEPasta + evidencia[i];
			}
			
			
			email.enviaEmail(evidencia);
			
			deletarPasta(path);
		}
	}
	
	// ------------------------------------------------------------------------------------------------
	// FAZ A CONTAGEM DOS ARQUIVOS NO DIRETÓRIO INDICADO SERA USADO PARA CONTAR OS PRINTS DE CADA TESTE
	public int contarArquivos(String caminho) {
		File path = new File(caminho);
		int quantidade = 0;

		if ( !path.exists() ) throw new RuntimeException("Diret?io n? existe. ["+path.getAbsolutePath()+"]");
		if ( !path.isDirectory() ) throw new RuntimeException("Deve ser informado um diret?io. ["+path.getAbsolutePath()+"]");
		if ( !path.canRead() ) throw new RuntimeException("Sem permiss? no diret?io. ["+path.getAbsolutePath()+"]");

		quantidade += path.list(new FiltroArquivo(Pattern.compile(".*"))).length;

		return quantidade;
	}

	private class FiltroArquivo implements FilenameFilter{
		private final Pattern jexl;
		public FiltroArquivo(Pattern expressaoRegular) {
			this.jexl  = expressaoRegular;
		}
		public boolean accept(File path, String nome) {
			return jexl.matcher(nome).matches();
		}
	}


}

package br.com.tortiago.cases;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;



public class Teste {
	
	public static void main(String[] args) {
		new Teste();
	}
	
	public Teste() {
		File f = new File("C:\\jdk - jre");
		System.out.println(contarArquivos(f, ".jpeg"));
	}
	
	public int contarArquivos(File path, String extensao) {
		int quantidade = 0;
		if ( path == null ) throw new RuntimeException("Deve ser informado um diret?io!");
		if ( !path.exists() ) throw new RuntimeException("Diret?io n? existe. ["+path.getAbsolutePath()+"]");
		if ( !path.isDirectory() ) throw new RuntimeException("Deve ser informado um diret?io. ["+path.getAbsolutePath()+"]");
		if ( !path.canRead() ) throw new RuntimeException("Sem permiss? no diret?io. ["+path.getAbsolutePath()+"]");
		
		quantidade += path.list(new FiltroArquivo(Pattern.compile(".*"+extensao))).length;
			
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
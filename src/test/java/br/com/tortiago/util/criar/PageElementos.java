package br.com.tortiago.util.criar;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author tiago.ramos
 *
 * Class PageElementos.java
 * Responsável por: Centralizar os elementos comuns usados na criação dos testes automatizados.
 * 					Exemplo: A variável "drive" é comum e aparecerá em todas as criações de CT.
 * 							 Declaração de teclas do teclado, para testes que não são possíveis usar sendkeys().
 *
 */
public class PageElementos {
	
	public PageElementos(ChromeDriver driver) {
		this.driver = driver;
	}

	//	### ----------------------------------------------------------------------------------------------------------------------------------------------------- ###  //
	// DRIVER DE EXECUCAO
	protected ChromeDriver driver;
	
	
	//	### ----------------------------------------------------------------------------------------------------------------------------------------------------- ###  //
	// ROBOT É RESPONSAVEL POR ACIONAR AS TECLAS DO TECLADO 
	protected Robot robot;
	
		
	//	### ----------------------------------------------------------------------------------------------------------------------------------------------------- ###  //
	// DECLARAÇÃO DE TECLAS DO TECLADO
	protected int vkControl = KeyEvent.VK_CONTROL;
	protected int vkDelete = KeyEvent.VK_DELETE;
	protected int vkEnter = KeyEvent.VK_ENTER;
	protected int vkEsc = KeyEvent.VK_ESCAPE;
	protected int vkTab = KeyEvent.VK_TAB;

	protected int vkA = KeyEvent.VK_A;
	protected int vkB = KeyEvent.VK_B;
	protected int vkC = KeyEvent.VK_C;
	protected int vkD = KeyEvent.VK_D;
	protected int vkE = KeyEvent.VK_E;
	protected int vkF = KeyEvent.VK_F;
	protected int vkG = KeyEvent.VK_G;
	protected int vkH = KeyEvent.VK_H;
	protected int vkI = KeyEvent.VK_I;
	protected int vkJ = KeyEvent.VK_J;
	protected int vkK = KeyEvent.VK_K;
	protected int vkL = KeyEvent.VK_L;
	protected int vkM = KeyEvent.VK_M;
	protected int vkN = KeyEvent.VK_N;
	protected int vkO = KeyEvent.VK_O;
	protected int vkP = KeyEvent.VK_P;
	protected int vkQ = KeyEvent.VK_Q;
	protected int vkR = KeyEvent.VK_R;
	protected int vkS = KeyEvent.VK_S;
	protected int vkT = KeyEvent.VK_T;
	protected int vkU = KeyEvent.VK_U;
	protected int vkV = KeyEvent.VK_V;
	protected int vkW = KeyEvent.VK_W;
	protected int vkX = KeyEvent.VK_X;
	protected int vkY = KeyEvent.VK_Y;
	protected int vkZ = KeyEvent.VK_Z;
	protected int vk0 = KeyEvent.VK_0;
	protected int vk1 = KeyEvent.VK_1;
	protected int vk2 = KeyEvent.VK_2;
	protected int vk3 = KeyEvent.VK_3;
	protected int vk4 = KeyEvent.VK_4;
	protected int vk5 = KeyEvent.VK_5;
	protected int vk6 = KeyEvent.VK_6;
	protected int vk7 = KeyEvent.VK_7;
	protected int vk8 = KeyEvent.VK_8;
	protected int vk9 = KeyEvent.VK_9;


}

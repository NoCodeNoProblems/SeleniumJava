package br.com.tortiago.util.criar;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class Teclado extends PageElementos{

	public Teclado(ChromeDriver driver) {
		super(driver);
	}
	
	// METODO RESPONSAVEL POR RETORNAR A RESPECTIVA LETRA DA STRING
	protected int retornaKey(String key) {
		if (key.equals("vkA")) {
			return KeyEvent.VK_A;
		}
		if (key.equals("vkB")) {
			return KeyEvent.VK_B;
		}
		if (key.equals("vkC")) {
			return KeyEvent.VK_C;
		}
		if (key.equals("vkD")) {
			return KeyEvent.VK_D;
		}
		if (key.equals("vkE")) {
			return KeyEvent.VK_E;
		}
		if (key.equals("vkF")) {
			return KeyEvent.VK_F;
		}
		if (key.equals("vkG")) {
			return KeyEvent.VK_G;
		}
		if (key.equals("vkH")) {
			return KeyEvent.VK_H;
		}
		if (key.equals("vkI")) {
			return KeyEvent.VK_I;
		}
		if (key.equals("vkJ")) {
			return KeyEvent.VK_J;
		}
		if (key.equals("vkK")) {
			return KeyEvent.VK_K;
		}
		if (key.equals("vkL")) {
			return KeyEvent.VK_L;
		}
		if (key.equals("vkM")) {
			return KeyEvent.VK_M;
		}
		if (key.equals("vkN")) {
			return KeyEvent.VK_N;
		}
		if (key.equals("vkO")) {
			return KeyEvent.VK_O;
		}
		if (key.equals("vkP")) {
			return KeyEvent.VK_P;
		}
		if (key.equals("vkQ")) {
			return KeyEvent.VK_Q;
		}
		if (key.equals("vkR")) {
			return KeyEvent.VK_R;
		}
		if (key.equals("vkS")) {
			return KeyEvent.VK_S;
		}
		if (key.equals("vkT")) {
			return KeyEvent.VK_T;
		}
		if (key.equals("vkU")) {
			return KeyEvent.VK_U;
		}
		if (key.equals("vkV")) {
			return KeyEvent.VK_V;
		}
		if (key.equals("vkW")) {
			return KeyEvent.VK_W;
		}
		if (key.equals("vkX")) {
			return KeyEvent.VK_X;
		}
		if (key.equals("vkY")) {
			return KeyEvent.VK_Y;
		}
		if (key.equals("vkZ")) {
			return KeyEvent.VK_Z;
		}
		if (key.equals("vk0")) {
			return KeyEvent.VK_0;
		}
		if (key.equals("vk1")) {
			return KeyEvent.VK_1;
		}
		if (key.equals("vk2")) {
			return KeyEvent.VK_2;
		}
		if (key.equals("vk3")) {
			return KeyEvent.VK_3;
		}
		if (key.equals("vk4")) {
			return KeyEvent.VK_4;
		}
		if (key.equals("vk5")) {
			return KeyEvent.VK_5;
		}
		if (key.equals("vk6")) {
			return KeyEvent.VK_6;
		}
		if (key.equals("vk7")) {
			return KeyEvent.VK_7;
		}
		if (key.equals("vk8")) {
			return KeyEvent.VK_8;
		}
		if (key.equals("vk9")) {
			return KeyEvent.VK_9;
		}
		if (key.equals(" ")) {
			return KeyEvent.VK_SPACE;
		} else {
			return 10000;
		}

	}

	protected void digitaTexto(String texto) throws AWTException, InterruptedException {
		Thread.sleep(1500);
		for (int i = 0; i < texto.length(); i++) {
			char te = texto.charAt(i);
			if (te == ' ') {
				System.out.println(te);
				robot.keyPress(retornaKey(" "));
				robot.keyRelease(retornaKey(" "));
			} else {

				char t = Character.toUpperCase(texto.charAt(i));
				System.out.println(t);
				robot.keyPress(retornaKey("vk" + t));
				Thread.sleep(300);
				robot.keyRelease(retornaKey("vk" + t));
				Thread.sleep(300);

			}

		}

	}

	// PRESSIONA A TECLA ENTER DO TECLADO 
	public void pressionaEnter() throws InterruptedException {
		Thread.sleep(300);
		robot.keyPress(vkEnter);
		robot.keyRelease(vkEnter);	
	}

}
package main;

import java.util.concurrent.TimeUnit;

public class OpenBox extends Comandos {

	public static boolean vai = true;
	
	public static void open() {
		
		while(vai) {
			try {
				TimeUnit.MILLISECONDS.sleep(400);
				press(Tecla.T8);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
	}
	
}

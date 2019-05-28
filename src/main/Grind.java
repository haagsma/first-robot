package main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

public class Grind extends Comandos {

	public static boolean running = false;
	
	public static BufferedImage digimonDefault;
	
	//hp tammer 196,53
	public static Color hpTammer;
	//ds tammer 191,68
	public static Color dsTammer;
	//hp digi 189,127
	public static Color hpDigi;
	//ds digi 195,140
	public static Color dsDigi;
	
	public static void putCurrencyStatus () {

//		System.out.println("putCurrencyDigimon");
		digimonDefault = getRobot().createScreenCapture(new Rectangle(1017,33,36,26));
		hpTammer = getRobot().getPixelColor(196,53);
		dsTammer = getRobot().getPixelColor(191,68);
		hpDigi = getRobot().getPixelColor(189,127);
		dsDigi = getRobot().getPixelColor(195,140);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		grindar();
	}
	
	public static void grindar () {	
		if(running) {
			food();
//			System.out.println("grindar");	
			while(!checkDigimon()) checkDigimon();
			atacar();
			
			grindar();
		}
		
	}
	
	public static boolean checkDigimon() {
		if(!running) return false;
		food();
//		System.out.println("checkDigimon");
		if (Compare.compare(digimonDefault, getRobot().createScreenCapture(new Rectangle(1017,33,36,26)))) {
//			System.out.println("S�o iguais");
			return true;
		}else {
			Comandos.press(Tecla.T4);
			Comandos.press(Tecla.T4);
			Comandos.press(Tecla.TAB);
			Comandos.press(Tecla.T4);
			Comandos.press(Tecla.T4);
			return false;
		}
	}
	
	public static void atacar() {
//		System.out.println("atacar");
		Comandos.press(Tecla.T1);
		Comandos.press(Tecla.T4);
		Comandos.press(Tecla.F2);
		Comandos.press(Tecla.T4);
		Comandos.press(Tecla.T4);
		Comandos.press(Tecla.F1);
		Comandos.press(Tecla.T4);
		Comandos.press(Tecla.T4);
	}
	
	public static void food() {
//		System.out.println("");
		if(hpTammer.getRGB() != getRobot().getPixelColor(196,53).getRGB()) Comandos.press(Tecla.T7);
		if(dsTammer.getRGB() != getRobot().getPixelColor(191,68).getRGB()) Comandos.press(Tecla.T8);
		if(hpDigi.getRGB() != getRobot().getPixelColor(189,127).getRGB()) Comandos.press(Tecla.F7);
		if(dsDigi.getRGB() != getRobot().getPixelColor(195,140).getRGB()) Comandos.press(Tecla.F8);
	}
	
}

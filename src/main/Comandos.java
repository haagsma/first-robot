package main;

import java.awt.Robot;

public class Comandos {
	
	public static Robot getRobot() {
		try {
			final Robot robot = new Robot();
			return robot;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public static void press(int key) {
		try {
			getRobot().delay(300);
			getRobot().keyPress(key);
			getRobot().keyRelease(key);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

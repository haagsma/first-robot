package main;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

public class Main extends Comandos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			TimeUnit.SECONDS.sleep(3);
//			press(Tecla.TAB);
//			press(Tecla.T1);
//			Rectangle rectangle = new Rectangle();
//			getRobot().createScreenCapture(rectangle);
//			System.out.println("Fim");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
//        final Dimension screenSize = Toolkit.getDefaultToolkit().
//                getScreenSize();
//        final BufferedImage screen = getRobot().createScreenCapture(
//                new Rectangle(screenSize));
//
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new ScreenCaptureRectangle(screen);
//            }
//        });
		
		Compare.compare();
	}
	

}

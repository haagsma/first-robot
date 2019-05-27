package main;

import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage image = getRobot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		System.out.println(image);
		
		JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(new JLabel(new ImageIcon(image)));
		frame.pack();
		frame.setVisible(true);
	}
	

}

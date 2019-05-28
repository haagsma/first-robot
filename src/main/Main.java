package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class Main extends Comandos {

	public static Thread thread;
	
	public static boolean rodarStatus = true;
	
	public static String btnStatus = "Start";
	
	public static void rodar() {
		if(rodarStatus) {
			thread.start();
			Grind.running = true;
			btnStatus = "Stop";
		}else {
			createTred();
			Grind.running = false;
			btnStatus = "Start";
		}
		rodarStatus = !rodarStatus;
//		System.out.println(rodarStatus);
	}
	
	public static void createTred() {
		try {
			thread.interrupt();
		} catch (Exception e) {
			System.out.println("Erro ao interromper a thread, mas faz parte...");
		}
		thread = new Thread() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(3);
//					System.out.println("Iniciou");
				} catch (Exception e) {
					// TODO: handle exception
				}
				Grind.putCurrencyStatus();
			}
		};
	}
	
	public static void main(String[] args) {
		createTred();
		iniciarComponentes();
		
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
	}
	
	private static void iniciarComponentes() {
        JFrame jFrame = new JFrame("Isso Aew");
//        jFrame.setLayout(new GridLayout(1,0));

        JPanel panel1 = new JPanel();
//        panel1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
        
        JLabel label = new JLabel("Press the button to start the Bot");
        JLabel ins1 = new JLabel("1 - Your game need to be in full screen ");
        JLabel ins11 = new JLabel("and with resolution 1920x1080");
        JLabel ins2 = new JLabel("2 - Leave the digimon target selectabled in game");
        JLabel ins3 = new JLabel("3 - Press Start Button and enter in game");
        

        

        JButton btn = new JButton(btnStatus);
        btn.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
        		if(rodarStatus) {

            		btn.setLabel("Stop");
        		} else {
        			btn.setLabel("Start");
        		}
        		
               rodar();
            }  
        });
        panel1.add(label);
        panel1.add(btn);
        panel1.add(ins1);
        panel1.add(ins11);
        panel1.add(ins2);
        panel1.add(ins3);

        jFrame.add(panel1);

        jFrame.pack();
        jFrame.setSize(450,200);

        jFrame.setLocationRelativeTo(null);

        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.addWindowListener(new WindowAdapter() {
        	  public void windowClosing(WindowEvent we) {
        		    System.exit(0);
        		  }
        		});
    }
	

}

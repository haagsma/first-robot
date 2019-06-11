package main;

import java.util.concurrent.TimeUnit;

import front.Login;
import front.Principal;

public class Main extends Comandos {

	public static Thread thread;
	
	public static boolean rodarStatus = true;
	
//	public static String btnStatus = "Start";
	
	public static void rodar() {
		if(rodarStatus) {
			thread.start();
			Grind.running = true;
		}else {
			createTred();
//			Grind.putCurrencyStatus();
			Grind.running = false;
		}
		rodarStatus = !rodarStatus;
//		System.out.println(rodarStatus);
	}
	
	public static void createTred() {
//		try {
//			thread.stop();
//		} catch (Exception e) {
//			System.out.println("Erro ao interromper a thread, mas faz parte...");
//		}
		thread = new Thread() {
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
					Grind.putCurrencyStatus();
//					System.out.println("Iniciou");
				} catch (Exception e) {
					System.out.println("Erro no time inicial de 5 segundos");
				}
			}
		};
	}
	
	public static void main(String[] args) {
		
		createTred();
//		new Principal();
		new Login();
		
//		iniciarComponentes();
//		OpenBox.open();
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
	
//	private static void iniciarComponentes() {
//        JFrame jFrame = new JFrame("Our Sistem");
////        jFrame.setLayout(new GridLayout(1,0));
//
//        JPanel panel1 = new JPanel();
////        panel1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
//        
//        JLabel label = new JLabel("Press the button to start the Bot");
//        JLabel ins1 = new JLabel("1 - Your game need to be in full screen ");
//        JLabel ins11 = new JLabel("and with resolution 1920x1080");
//        JLabel ins2 = new JLabel("2 - Leave the digimon target selected in game");
//        JLabel ins3 = new JLabel("3 - Press Start Button and enter in game");
//        
//
//        
//
//        JButton btn = new JButton(btnStatus);
//        btn.addActionListener(new ActionListener(){  
//        	public void actionPerformed(ActionEvent e){
//        		if(rodarStatus) {
//
//            		btn.setLabel("Stop Bot");
//        		} else {
//        			btn.setLabel("Start Bot");
//        		}
//        		
//               rodar();
//            }  
//        });
//        
//        JButton btnScreen = new JButton("Dev");
//        btnScreen.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//		    	final Dimension screenSize = Toolkit.getDefaultToolkit().
//		              getScreenSize();
//		      final BufferedImage screen = getRobot().createScreenCapture(
//		              new Rectangle(screenSize));
//		
//		      SwingUtilities.invokeLater(new Runnable() {
//		          public void run() {
//		              new ScreenCaptureRectangle(screen);
//		          }
//		      });
//			}
//		});
//        
//        panel1.add(label);
//        panel1.add(btn);
//        panel1.add(ins1);
//        panel1.add(ins11);
//        panel1.add(ins2);
//        panel1.add(ins3);
//        
//        //Botão para selecionar e capturar coordenadas de tela
//       // panel1.add(btnScreen);
//
//        jFrame.add(panel1);
//
//        jFrame.pack();
//        jFrame.setSize(450,200);
//
//        jFrame.setLocationRelativeTo(null);
//
//        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        jFrame.setVisible(true);
//        jFrame.addWindowListener(new WindowAdapter() {
//        	  public void windowClosing(WindowEvent we) {
//        		    System.exit(0);
//        		  }
//        		});
//    }
	

}

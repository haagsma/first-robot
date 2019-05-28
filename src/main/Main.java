package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends Comandos {

	public static Thread thread;
	
	public static boolean rodarStatus = true;
	
	public static void rodar() {
		if(rodarStatus) {
			thread.start();
			Grind.running = true;
		}else {
			createTred();
			Grind.running = false;
		}
		rodarStatus = !rodarStatus;
		System.out.println(rodarStatus);
	}
	
	public static void createTred() {
		try {
			thread.interrupt();
		} catch (Exception e) {
			// TODO: handle exception
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
		
//		Compare.compare();
		
		
		
		
//		try {
//			TimeUnit.SECONDS.sleep(3);
////			System.out.println("Iniciou");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Grind.putCurrencyStatus();
		
		iniciarComponentes();
	}
	
	private static void iniciarComponentes() {
        JFrame jFrame = new JFrame("Isso Aew");
        jFrame.setLayout(new GridLayout(2,2));

        /*
         * Um JPainel para adicionar os componentes JLabel e JTextField 
         * que contém respectivamente o rótulo "Nome:" e o campo para edição. 
         */
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 0));

        JButton btn = new JButton("Start/Stop");
        btn.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
               rodar();
            }  
        }); 
        

        //Adição dos componentes ao JPanel
        panel1.add(btn);


        //Adição dos componentes JPanel ao JFrame
        jFrame.add(panel1);

        //Ajusta automaticamente o tamanho da janela, alternativa ao setSize()
        jFrame.pack();

        //Centraliza a janela
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

package front;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import entidades.User;
import main.Comandos;
import main.Main;
import main.ScreenCaptureRectangle;

public class Principal extends Comandos {

	public Principal(User user) {
		JFrame jFrame = new JFrame("Our Sistem");
      jFrame.setLayout(new GridLayout(4,0));

      JPanel panel1 = new JPanel();
//      panel1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
      
      JLabel label = new JLabel("Press the button to start the Bot");
      JLabel ins1 = new JLabel("1 - Your game need to be in full screen ");
      JLabel ins11 = new JLabel("and with resolution 1920x1080");
      JLabel ins2 = new JLabel("2 - Leave the digimon target selected in game");
      JLabel ins3 = new JLabel("3 - Press Start Button and enter in game");
      

      

      JButton btn = new JButton("Start Bot");
      btn.addActionListener(new ActionListener(){  
      	public void actionPerformed(ActionEvent e){
      		if(Main.rodarStatus) {

          		btn.setLabel("Stop Bot");
      		} else {
      			btn.setLabel("Start Bot");
      		}
      		
             Main.rodar();
          }  
      });
      
      JButton btnScreen = new JButton("Dev");
      btnScreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    	final Dimension screenSize = Toolkit.getDefaultToolkit().
		              getScreenSize();
		      final BufferedImage screen = getRobot().createScreenCapture(
		              new Rectangle(screenSize));
		
		      SwingUtilities.invokeLater(new Runnable() {
		          public void run() {
		              new ScreenCaptureRectangle(screen);
		          }
		      });
			}
		});
      
      //panel1.add(label);
      //panel1.add(btn);
      panel1.add(ins1);
      panel1.add(ins11);
      panel1.add(ins2);
      panel1.add(ins3);
      
      //Botão para selecionar e capturar coordenadas de tela
      jFrame.add(titulo(user));
      jFrame.add(expire(user));
      jFrame.add(btnStart());
      jFrame.add(guide());

      jFrame.pack();
      jFrame.setSize(450,400);

      jFrame.setLocationRelativeTo(null);

      jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      jFrame.setVisible(true);
      jFrame.addWindowListener(new WindowAdapter() {
      	  public void windowClosing(WindowEvent we) {
      		    System.exit(0);
      	  }
      });
	}
	
	public JPanel titulo(User user) {
		
		JPanel painel = new JPanel();
		
		JLabel label = new JLabel("Welcome "+user.getUsername());
		
		
		painel.add(label);
		
		return painel;
	}
	public JPanel expire(User user) {
		JPanel painel = new JPanel();
		
		JLabel label = new JLabel("Expires in "+user.getExpirate().toString());
		
		painel.add(label);
		
		return painel;
		
	}
	public JPanel btnStart() {

		JPanel painel = new JPanel();
//		painel.setLayout(new GridLayout(1,0));
		
		JButton btn = new JButton("Start Bot");
		btn.addActionListener(new ActionListener(){  
	      	public void actionPerformed(ActionEvent e){
	      		if(Main.rodarStatus) {

	          		btn.setLabel("Stop Bot");
	      		} else {
	      			btn.setLabel("Start Bot");
	      		}
	      		
	             Main.rodar();
	          }  
	    });
		
		painel.add(btn);
	      
	    return painel;
		
	}
	
	public JPanel guide() {

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(4,0));
		
		JLabel ins1 = new JLabel("1 - Your game need to be in full screen ");
	    JLabel ins11 = new JLabel("    and with resolution 1920x1080");
	    JLabel ins2 = new JLabel("2 - Leave the digimon target selected in game");
	    JLabel ins3 = new JLabel("3 - Press Start Button and enter in game");
		

	      painel.add(ins1);
	      painel.add(ins11);
	      painel.add(ins2);
	      painel.add(ins3);
	      
		return painel;
	}
}

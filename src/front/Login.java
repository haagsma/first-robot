package front;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login {
	
	public Login() {
		
		JFrame frame = new JFrame("Our Sistem");
		
		JPanel painel = new JPanel();
//		painel.setLayout(new GridLayout(3,0));
		
		JLabel lbLogin = new JLabel("Login: ");
		JTextField login = new JTextField();
		login.setPreferredSize(new Dimension (100,30));
		

		JLabel lbSenha = new JLabel("Password: ");
		JTextField senha = new JTextField();
		senha.setPreferredSize(new Dimension (100,30));
		
		

		JLabel erro = new JLabel();
		
		JButton btn = new JButton("Entrar");
		btn.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
        		if(!login.getText().isEmpty() && !senha.getText().isEmpty()) {
            		entrar(login.getText(), senha.getText());
            		new Principal();
            		frame.setVisible(false);
            		frame.dispose();
        		}else {
        			erro.setText("login and password required");
        		}
            }  
        });

		painel.add(lbLogin);
		painel.add(login);
		painel.add(lbSenha);
		painel.add(senha);
		painel.add(btn);
		painel.add(erro);
		
		frame.add(painel);
		
		frame.pack();
		frame.setSize(450,100);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
	      	public void windowClosing(WindowEvent we) {
	      		System.exit(0);
	      	}
	    });
		
		
	}
	
	public void entrar(String login, String senha) {
		System.out.println(login+"\n"+senha);
	}

}

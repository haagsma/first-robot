package front;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.persistence.NoResultException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import config.DbConfig;
import entidades.User;
import entidades.Version;

public class Login {
	
	JFrame frame;
	JLabel erro;
	JTextPane wait = new JTextPane();
	
	public Login() {
		wait.setVisible(false);
		frame = new JFrame("Our Sistem");
		
		JPanel painel = new JPanel();
//		painel.setLayout(new GridLayout(3,0));
		
		JLabel loadingVersion = new JLabel("Loading version... ");
		JLabel updateVersion = new JLabel("You need update the version ");
		
		JLabel lbLogin = new JLabel("Login: ");
		JTextField login = new JTextField();
		login.setPreferredSize(new Dimension (100,30));
		

		JLabel lbSenha = new JLabel("Password: ");
		JTextField senha = new JTextField();
		senha.setPreferredSize(new Dimension (100,30));
		
		erro = new JLabel();
		
		JButton btn = new JButton("Entrar");
		btn.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
        		wait.setVisible(true);
        		if(!login.getText().isEmpty() && !senha.getText().isEmpty()) {
        			wait.setText("Wait, loading...");
            		entrar(login.getText(), senha.getText());
        		}else {
        			wait.setText("login and password required");
        		}
            }  
        });

		painel.add(loadingVersion);
		
		
		
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

		
		if(checkVersion()) {
			painel.remove(loadingVersion);
			painel.add(lbLogin);
			painel.add(login);
			painel.add(lbSenha);
			painel.add(senha);
			painel.add(btn);
			painel.add(wait);
			painel.add(erro);
		}else {
			painel.remove(loadingVersion);
			painel.add(updateVersion);
		}

		frame.add(painel);
		frame.pack();		
		
	}
	
	public boolean checkVersion() {
		DbConfig db = new DbConfig();
		try {
			db.getEm().createQuery("SELECT v FROM Version v WHERE version = :version AND status  = 1", Version.class)
			.setParameter("version", "1.0.0")
			.getSingleResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void entrar(String login, String senha) {
		DbConfig db = new DbConfig();

		try {
			User user = db.getEm().createQuery("SELECT u FROM User u "
					+ "WHERE username = :username "
					+ "AND password = :password "
					+ "AND expirate > :date", User.class)
					.setParameter("username", login)
					.setParameter("password", senha)
					.setParameter("date", new Date())
					.getSingleResult();

			new Principal(user);
			frame.setVisible(false);
			frame.dispose();
		} catch (NoResultException e) {
			wait.setText("Invalid Account...");
		}

	}

}

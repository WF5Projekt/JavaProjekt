package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import sonstiges.MD5;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Login_View extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username = new JTextField();
	private JPasswordField txt_passwort = new JPasswordField();
	private JButton btn_Login = new JButton("Login");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Login_View() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setUndecorated(true);
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 199, 151);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txt_username.setBackground(UIManager.getColor("TextField.background"));
		txt_username.setFont(new Font("Tahoma", Font.BOLD, 15));

		txt_username.setBounds(78, 11, 105, 25);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 15, 68, 14);
		contentPane.add(lblUsername);

		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setForeground(Color.BLACK);
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPasswort.setBounds(10, 53, 68, 14);
		contentPane.add(lblPasswort);
		txt_passwort.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_passwort.setBackground(UIManager.getColor("TextField.background"));

		txt_passwort.setBounds(78, 47, 105, 25);
		contentPane.add(txt_passwort);
		btn_Login.setIcon(new ImageIcon(Login_View.class.getResource("/lib/png/login.png")));
		btn_Login.setBackground(UIManager.getColor("Button.background"));
		btn_Login.setFont(new Font("Tahoma", Font.BOLD, 12));

		btn_Login.setBounds(10, 88, 173, 25);
		contentPane.add(btn_Login);

		this.setLocationRelativeTo(null);
	}

	public String getTxt_username() {
		return txt_username.getText().toString();
	}

	public String getTxt_passwort() {

		return MD5.MD5(String.valueOf(txt_passwort.getPassword()));
	}
	
	@SuppressWarnings("deprecation")
	public boolean leereFelder(){
		boolean erg = false;
		
		if(this.txt_passwort.getText().isEmpty() ||	this.txt_username.getText().isEmpty()){
			erg = true;
		}
		
		return erg;
		
	}

	public void addLoginListener(ActionListener listenForLoginButton) {
		btn_Login.addActionListener(listenForLoginButton);
	}

	public void addKeyListener(KeyListener listenForLoginEnter) {
		txt_passwort.addKeyListener(listenForLoginEnter);
		txt_username.addKeyListener(listenForLoginEnter);
	}

	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}

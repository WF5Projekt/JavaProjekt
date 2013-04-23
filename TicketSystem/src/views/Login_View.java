package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import sonstiges.MD5;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		txt_username.setBounds(79, 70, 95, 25);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 74, 70, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPasswort.setBounds(202, 74, 69, 14);
		contentPane.add(lblPasswort);

		
		txt_passwort.setBounds(272, 70, 95, 25);
		contentPane.add(txt_passwort);
		
		btn_Login.setBounds(9, 145, 357, 40);
		contentPane.add(btn_Login);
		
		this.setLocationRelativeTo(null);
	}

	public String getTxt_username() {
		return txt_username.getText().toString();
	}

	public String getTxt_passwort() {
		
		return MD5.MD5(String.valueOf(txt_passwort.getPassword()));
	}

	public void addLoginListener(ActionListener listenForLoginButton){
		btn_Login.addActionListener(listenForLoginButton);
	}
	public void addKeyListener(KeyListener listenForLoginEnter){
		txt_passwort.addKeyListener(listenForLoginEnter);
		txt_username.addKeyListener(listenForLoginEnter);
	}
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}

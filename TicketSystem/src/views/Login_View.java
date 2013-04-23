package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;

import sonstiges.MD5;

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
		setBackground(Color.DARK_GRAY);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 190, 238);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txt_username.setBackground(Color.LIGHT_GRAY);
		txt_username.setFont(new Font("Dialog", Font.BOLD, 12));
		
		
		txt_username.setBounds(79, 39, 95, 25);
		contentPane.add(txt_username);
		txt_username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(11, 43, 68, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setForeground(Color.LIGHT_GRAY);
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPasswort.setBounds(11, 83, 68, 14);
		contentPane.add(lblPasswort);
		txt_passwort.setFont(new Font("Dialog", Font.BOLD, 12));
		txt_passwort.setBackground(Color.LIGHT_GRAY);

		
		txt_passwort.setBounds(79, 79, 95, 25);
		contentPane.add(txt_passwort);
		btn_Login.setBackground(Color.LIGHT_GRAY);
		btn_Login.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btn_Login.setBounds(10, 144, 164, 56);
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

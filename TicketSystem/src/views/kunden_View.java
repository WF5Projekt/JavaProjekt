package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.AttributComboBox;
import models.Kunde;
import models.Mitarbeiter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import sonstiges.MD5;

public class kunden_View extends JFrame {

	private JPanel contentPane;
	private JPanel editKunde;

	private AttributComboBox erreichbarkeit;
	private AttributComboBox land;
	
	private Kunde k;
	
	private JComboBox c_land_edit;
	private JComboBox c_erreichbar_edit;
	private JButton btnSpeichern_edit;
	private JTextField vorname_edit;
	private JTextField name_edit;
	private JTextField strasse_edit;
	private JTextField hausnr_edit;
	private JTextField stadt_edit;
	private JTextField plz_edit;
	private JTextField geb_edit;
	private JTextField email_edit;
	private JTextField telefon_edit;
	private JTextField username_edit;
	
	public kunden_View(AttributComboBox land, AttributComboBox erreichbarkeit) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		this.land = land;
		this.erreichbarkeit = erreichbarkeit;
		
		//#######################################################
		// EDIT KUNDE
		//#######################################################
		editKunde = new JPanel();
		contentPane.add(editKunde, "name_1208962102764152");
		
		JLabel label = new JLabel("Name:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAdresse_1 = new JLabel("Adresse:");
		lblAdresse_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblGeburtstag_1 = new JLabel("Geburtstag:");
		lblGeburtstag_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGeburtstag_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblZustndigkeitsbereich_1 = new JLabel("Erreichbarkeit:");
		lblZustndigkeitsbereich_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblZustndigkeitsbereich_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail_1 = new JLabel("E-Mail:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTelefon_1 = new JLabel("Telefon:");
		lblTelefon_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefon_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNutzername_1 = new JLabel("Nutzername:");
		lblNutzername_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNutzername_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnSpeichern_edit = new JButton("Speichern");
		btnSpeichern_edit.setIcon(new ImageIcon(kunden_View.class.getResource("/lib/png/check.png")));
		btnSpeichern_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Abbrechen");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(kunden_View.class.getResource("/lib/png/cancel.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		vorname_edit = new JTextField();
		vorname_edit.setBackground(Color.WHITE);
		vorname_edit.setColumns(10);
		
		name_edit = new JTextField();
		name_edit.setColumns(10);
		name_edit.setBackground(Color.WHITE);
		
		strasse_edit = new JTextField();
		strasse_edit.setColumns(10);
		strasse_edit.setBackground(Color.WHITE);
		
		hausnr_edit = new JTextField();
		hausnr_edit.setColumns(10);
		hausnr_edit.setBackground(Color.WHITE);
		
		stadt_edit = new JTextField();
		stadt_edit.setColumns(10);
		stadt_edit.setBackground(Color.WHITE);
		
		plz_edit = new JTextField();
		plz_edit.setColumns(10);
		plz_edit.setBackground(Color.WHITE);
	
		 c_land_edit = new JComboBox();
		 c_erreichbar_edit = new JComboBox();

			AutoCompleteDecorator.decorate(c_land_edit);
			AutoCompleteDecorator.decorate(c_erreichbar_edit);
		
		geb_edit = new JTextField();
		geb_edit.setColumns(10);
		geb_edit.setBackground(Color.WHITE);
		
		JLabel lblYyyymmdd = new JLabel("YYYY-MM-DD");
		
		email_edit = new JTextField();
		email_edit.setColumns(10);
		email_edit.setBackground(Color.WHITE);
		
		telefon_edit = new JTextField();
		telefon_edit.setColumns(10);
		telefon_edit.setBackground(Color.WHITE);
		
		username_edit = new JTextField();
		username_edit.setColumns(10);
		username_edit.setBackground(Color.WHITE);
		GroupLayout gl_editKunde = new GroupLayout(editKunde);
		gl_editKunde.setHorizontalGroup(
			gl_editKunde.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editKunde.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editKunde.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_editKunde.createSequentialGroup()
							.addComponent(lblAdresse_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_editKunde.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editKunde.createSequentialGroup()
									.addComponent(strasse_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_editKunde.createSequentialGroup()
									.addGroup(gl_editKunde.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(c_land_edit, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(stadt_edit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_editKunde.createSequentialGroup()
							.addGroup(gl_editKunde.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_editKunde.createParallelGroup(Alignment.LEADING)
									.addComponent(lblGeburtstag_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblZustndigkeitsbereich_1)
									.addComponent(lblEmail_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTelefon_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutzername_1))
							.addGroup(gl_editKunde.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editKunde.createSequentialGroup()
									.addGap(4)
									.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblYyyymmdd))
								.addGroup(gl_editKunde.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_editKunde.createParallelGroup(Alignment.LEADING)
										.addComponent(email_edit, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
										.addComponent(c_erreichbar_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(telefon_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(username_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_editKunde.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_editKunde.createSequentialGroup()
								.addComponent(btnSpeichern_edit)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnNewButton_2))
							.addGroup(Alignment.LEADING, gl_editKunde.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_editKunde.setVerticalGroup(
			gl_editKunde.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editKunde.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(strasse_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresse_1)
						.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(stadt_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(c_land_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeburtstag_1)
						.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYyyymmdd))
					.addGap(32)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZustndigkeitsbereich_1)
						.addComponent(c_erreichbar_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail_1)
						.addComponent(email_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(telefon_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefon_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(username_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNutzername_1))
					.addGap(18)
					.addGroup(gl_editKunde.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSpeichern_edit)
						.addComponent(btnNewButton_2))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		editKunde.setLayout(gl_editKunde);
		//#######################################################
		
		
		this.setLocationRelativeTo(null);
	}
	
	
	
	//#######################################################
	// EDIT KUNDE
	//#######################################################
	
	public void kundeEdit(Kunde k) {
		this.setTitle("Daten ändern");
		this.editKunde.setVisible(true);
		
		this.k = k;
		
		this.vorname_edit.setText(k.vorname);
		this.name_edit.setText(k.name);
		this.telefon_edit.setText(k.telefon);
		this.username_edit.setText(k.account);
		this.email_edit.setText(k.email);
		this.strasse_edit.setText(k.strasse);
		this.hausnr_edit.setText(k.hausnummer);
		this.stadt_edit.setText(k.ort);
		this.plz_edit.setText(k.plz);
		this.geb_edit.setText(k.geburtstag);
		
		this.c_land_edit.setModel(land);
		this.c_erreichbar_edit.setModel(erreichbarkeit);
		
		
		c_land_edit.setSelectedIndex(land.getIndexOf(k.idLand));
		c_erreichbar_edit.setSelectedIndex(erreichbarkeit.getIndexOf(k.idErreichbar));
		
		setVisible(true);
	}
	public Kunde saveKundeEdit(){

		//Pflichtfelder: Alle Felder müssen ausgefüllt sein!
		
		
		String vorname = vorname_edit.getText();
		String name = name_edit.getText();
		String telefon = telefon_edit.getText();
		String account = username_edit.getText();
		String email = email_edit.getText().trim();
		String strasse = strasse_edit.getText();
		String hausnummer = hausnr_edit.getText().trim();
		String ort = stadt_edit.getText();
		String plz = plz_edit.getText().trim();
		String geburt = geb_edit.getText().trim();
		
		String idLand = land.getElementAt(c_land_edit.getSelectedIndex()).getID();
		String idErreichbarkeit = erreichbarkeit.getElementAt(c_erreichbar_edit.getSelectedIndex()).getID();
		
		if( vorname.equals("") ||
			name.equals("") ||
			telefon.equals("") ||
			account.equals("") ||
			email.equals("") ||
			strasse.equals("") ||
			hausnummer.equals("")||
			ort.equals("") ||
			plz.equals("") ||
			geburt.equals("") ||
			idLand.equals("") ||
			idErreichbarkeit.equals("")
		){
			JOptionPane
			.showMessageDialog(null, "Bitte alle Felder ausfüllen!");
			return null;
		}
		else{
			k.vorname = vorname;
			k.name = name;
			k.telefon = telefon;
			k.account = account;
			k.email = email;
			k.strasse = strasse;
			k.hausnummer = hausnummer;
			k.ort = ort;
			k.plz = plz;
			k.geburtstag = geburt;
			k.idLand = idLand;
			k.idErreichbar = idErreichbarkeit;
			return k;
		}
	}
	public void speichernEditKunde(ActionListener a){
		this.btnSpeichern_edit.addActionListener(a);
	}
	

}

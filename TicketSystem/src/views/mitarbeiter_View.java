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
import models.Mitarbeiter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import sonstiges.MD5;

public class mitarbeiter_View extends JFrame {

	private JPanel contentPane;

	private JPanel neuerMitarbeiter;
	private JPanel editMitarbeiter;
	private JPanel editAccount;
	
	
	private Mitarbeiter m;
	private JTextField vorname_edit;
	private JTextField name_edit;
	private JTextField telefon_edit;
	private JTextField username_edit;
	private JPasswordField pw_edit;
	private JTextField email_edit;
	private JTextField straﬂe_edit;
	private JTextField hausnr_edit;
	private JTextField stadt_edit;
	private JTextField plz_edit;
	private JComboBox c_land_edit;
	private JComboBox c_zustaendig_edit;
	private JComboBox c_abteilung_edit;
	private JComboBox c_level_edit;
	private JTextField geb_edit;
	private JLabel lblGeburtstag;
	private JButton btnSpeichern_edit;
	private JPasswordField pw2_edit;
	private JLabel lblWiederholen;
	private AttributComboBox kategorie;
	private AttributComboBox land;
	private AttributComboBox abteilung;
	private AttributComboBox level;
	private JLabel lblHelpdesklevel;
	private JLabel lblDdmmyyyy;
	
	public mitarbeiter_View(AttributComboBox kategorie, AttributComboBox land, AttributComboBox abteilung, AttributComboBox level) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		this.kategorie = kategorie;
		this.land = land;
		this.abteilung = abteilung;
		this.level = level;
		
		
		//#######################################################
		// NEUER MITARBEITER
		//######################################################
		neuerMitarbeiter = new JPanel();
		contentPane.add(neuerMitarbeiter, "name_1208926334503725");
		GroupLayout gl_neuerMitarbeiter = new GroupLayout(neuerMitarbeiter);
		gl_neuerMitarbeiter.setHorizontalGroup(
			gl_neuerMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		gl_neuerMitarbeiter.setVerticalGroup(
			gl_neuerMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 263, Short.MAX_VALUE)
		);
		neuerMitarbeiter.setLayout(gl_neuerMitarbeiter);
		//#######################################################
		// EDIT MITARBEITER
		//#######################################################
		editMitarbeiter = new JPanel();
		contentPane.add(editMitarbeiter, "name_1208936716956965");
		
		btnSpeichern_edit = new JButton("Speichern");
		btnSpeichern_edit.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/check.png")));
		btnSpeichern_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Abbrechen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/cancel.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNutzername = new JLabel("Nutzername:");
		lblNutzername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNutzername.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPasswort = new JLabel("Neues Passwort:");
		lblPasswort.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPasswort.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblZustndigkeitsbereich = new JLabel("Zust\u00E4ndigkeitsbereich:");
		lblZustndigkeitsbereich.setHorizontalAlignment(SwingConstants.TRAILING);
		lblZustndigkeitsbereich.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAbteilung = new JLabel("Abteilung:");
		lblAbteilung.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAbteilung.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		vorname_edit = new JTextField();
		vorname_edit.setBackground(Color.WHITE);
		vorname_edit.setColumns(10);
		
		name_edit = new JTextField();
		name_edit.setColumns(10);
		name_edit.setBackground(Color.WHITE);
		
		telefon_edit = new JTextField();
		telefon_edit.setBackground(Color.WHITE);
		telefon_edit.setColumns(10);
		
		username_edit = new JTextField();
		username_edit.setBackground(Color.WHITE);
		username_edit.setColumns(10);
		
		pw_edit = new JPasswordField();
		pw_edit.setBackground(Color.WHITE);
		
		email_edit = new JTextField();
		email_edit.setBackground(Color.WHITE);
		email_edit.setColumns(10);
		
		straﬂe_edit = new JTextField();
		straﬂe_edit.setColumns(10);
		straﬂe_edit.setBackground(Color.WHITE);
		
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
		c_zustaendig_edit = new JComboBox();
		c_abteilung_edit = new JComboBox();
		c_level_edit = new JComboBox();

		AutoCompleteDecorator.decorate(c_land_edit);

		AutoCompleteDecorator.decorate(c_level_edit);

		AutoCompleteDecorator.decorate(c_zustaendig_edit);

		AutoCompleteDecorator.decorate(c_abteilung_edit);
		
		
		geb_edit = new JTextField();
		geb_edit.setBackground(Color.WHITE);
		geb_edit.setColumns(10);
		
		lblGeburtstag = new JLabel("Geburtstag:");
		lblGeburtstag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGeburtstag.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		pw2_edit = new JPasswordField();
		pw2_edit.setBackground(Color.WHITE);
		
		lblWiederholen = new JLabel("Passwort wiederholen:");
		lblWiederholen.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWiederholen.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblHelpdesklevel = new JLabel("Helpdesk-Level:");
		lblHelpdesklevel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHelpdesklevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDdmmyyyy = new JLabel("YYYY-MM-DD");
		
		
		GroupLayout gl_editMitarbeiter = new GroupLayout(editMitarbeiter);
		gl_editMitarbeiter.setHorizontalGroup(
			gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editMitarbeiter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAbteilung, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblZustndigkeitsbereich, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHelpdesklevel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addComponent(c_abteilung_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(c_zustaendig_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(c_level_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(142))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editMitarbeiter.createSequentialGroup()
									.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNutzername, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblWiederholen, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
										.addComponent(pw_edit, 180, 180, 180)
										.addComponent(pw2_edit, 180, 180, 180)
										.addComponent(username_edit, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(email_edit, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(telefon_edit, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
								.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_editMitarbeiter.createSequentialGroup()
										.addComponent(btnSpeichern_edit)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton))
									.addGroup(gl_editMitarbeiter.createSequentialGroup()
										.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
											.addComponent(lblGeburtstag, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblAdresse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_editMitarbeiter.createSequentialGroup()
												.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
													.addComponent(stadt_edit, Alignment.TRAILING)
													.addComponent(c_land_edit, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGroup(gl_editMitarbeiter.createSequentialGroup()
														.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblDdmmyyyy))
													.addComponent(straﬂe_edit, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
													.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_editMitarbeiter.createSequentialGroup()
												.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))))))
							.addGap(118))))
		);
		gl_editMitarbeiter.setVerticalGroup(
			gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_editMitarbeiter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGeburtstag)
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
								.addComponent(straﬂe_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresse)
								.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editMitarbeiter.createSequentialGroup()
									.addComponent(stadt_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(c_land_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
										.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDdmmyyyy)))
								.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZustndigkeitsbereich)
						.addComponent(c_zustaendig_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbteilung)
						.addComponent(c_abteilung_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHelpdesklevel)
						.addComponent(c_level_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(telefon_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(email_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNutzername)
						.addComponent(username_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswort)
						.addComponent(pw_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(pw2_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWiederholen))
					.addGap(18)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnSpeichern_edit))
					.addGap(128))
		);
		editMitarbeiter.setLayout(gl_editMitarbeiter);
		
		//#######################################################
		// EDIT ACCOUNT
		//#######################################################
		editAccount = new JPanel();
		contentPane.add(editAccount, "name_1208962102764152");
		GroupLayout gl_editAccount = new GroupLayout(editAccount);
		gl_editAccount.setHorizontalGroup(
			gl_editAccount.createParallelGroup(Alignment.LEADING)
				.addGap(0, 359, Short.MAX_VALUE)
		);
		gl_editAccount.setVerticalGroup(
			gl_editAccount.createParallelGroup(Alignment.LEADING)
				.addGap(0, 451, Short.MAX_VALUE)
		);
		editAccount.setLayout(gl_editAccount);
		//#######################################################
		
		
		this.setLocationRelativeTo(null);
	}
	
	
	public void Mitarbeiterƒndern(Mitarbeiter m) {
		this.setTitle("Daten ‰ndern");
		this.editAccount.setVisible(false);
		this.editMitarbeiter.setVisible(true);
		this.neuerMitarbeiter.setVisible(false);
		
		this.m = m;
		
		this.vorname_edit.setText(m.vorname);
		this.name_edit.setText(m.name);
		this.telefon_edit.setText(m.telefon);
		this.username_edit.setText(m.account);
		this.email_edit.setText(m.email);
		this.straﬂe_edit.setText(m.strasse);
		this.hausnr_edit.setText(m.hausnummer);
		this.stadt_edit.setText(m.ort);
		this.plz_edit.setText(m.plz);
		this.geb_edit.setText(m.geburt);
		
		this.c_land_edit.setModel(land);
		this.c_abteilung_edit.setModel(abteilung);
		this.c_zustaendig_edit.setModel(kategorie);
		this.c_level_edit.setModel(level);
		
		
		c_land_edit.setSelectedIndex(land.getIndexOf(m.idLand));
		c_abteilung_edit.setSelectedIndex(abteilung.getIndexOf(m.idAbteilung));
		c_zustaendig_edit.setSelectedIndex(kategorie.getIndexOf(m.idZust‰ndigkeit));
		c_level_edit.setSelectedIndex(level.getIndexOf(m.idLevel));
		
		this.setVisible(true);
	}
	public Mitarbeiter saveEditMitarbeiter(){
		
		if(! ( pw_edit.getText().isEmpty() || pw_edit.getText().isEmpty() ) ){
			if( this.pw_edit.getPassword().toString().equals(pw2_edit.getPassword().toString() )  ){
				m.passwort = MD5.MD5(String.valueOf(pw_edit.getPassword()));
			}
			else{
				JOptionPane
				.showMessageDialog(null, "Falsches Passwort!");
				return null;
				}
		}
		
		m.vorname = vorname_edit.getText();
		m.name = name_edit.getText();
		m.telefon = telefon_edit.getText();
		m.account = username_edit.getText();
		m.email = email_edit.getText();
		m.strasse = straﬂe_edit.getText();
		m.hausnummer = hausnr_edit.getText();
		m.ort = stadt_edit.getText();
		m.plz = plz_edit.getText();
		m.geburt = geb_edit.getText();
		
		m.idLand = land.getElementAt(c_land_edit.getSelectedIndex()).getID();
		m.idAbteilung = abteilung.getElementAt(c_abteilung_edit.getSelectedIndex()).getID();
		m.idZust‰ndigkeit = kategorie.getElementAt(this.c_zustaendig_edit.getSelectedIndex()).getID();
		m.idLevel = level.getElementAt(c_level_edit.getSelectedIndex()).getID();

		return m;
	}
	public void speichernEdit(ActionListener a){
		this.btnSpeichern_edit.addActionListener(a);
	}
	
	
	
	//#######################################################
	// NEUER MITARBEITER
	//#######################################################
	
	public void MitarbeiterErstellen() {
		this.setTitle("Neuen Mitarbeiter erstellen");
		this.editAccount.setVisible(false);
		this.editMitarbeiter.setVisible(false);
		this.neuerMitarbeiter.setVisible(true);

		this.setVisible(true);
	}
}

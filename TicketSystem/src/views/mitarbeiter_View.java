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
	private JPanel editAccount;
	private JPanel editMitarbeiter;

	private AttributComboBox kategorie;
	private AttributComboBox land;
	private AttributComboBox abteilung;
	private AttributComboBox level;
	
	private Mitarbeiter m;
	private JTextField vorname_acc;
	private JTextField name_acc;
	private JTextField telefon_acc;
	private JTextField username_acc;
	private JPasswordField pw_acc;
	private JTextField email_acc;
	private JTextField straﬂe_acc;
	private JTextField hausnr_acc;
	private JTextField stadt_acc;
	private JTextField plz_acc;
	private JComboBox c_land_acc;
	private JComboBox c_zustaendig_acc;
	private JComboBox c_abteilung_acc;
	private JComboBox c_level_acc;
	private JTextField geb_acc;
	private JLabel lblGeburtstag;
	private JButton btnSpeichern_acc;
	private JPasswordField pw2_acc;
	private JLabel lblWiederholen;
	private JLabel lblHelpdesklevel;
	private JLabel lblDdmmyyyy;
	
	private JComboBox c_land_edit;
	private JComboBox c_level_edit;
	private JComboBox c_abteilung_edit;
	private JComboBox c_zustaendig_edit;
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
	
	public mitarbeiter_View(AttributComboBox kategorie, AttributComboBox land, AttributComboBox abteilung, AttributComboBox level) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 422, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		this.kategorie = kategorie;
		this.land = land;
		this.abteilung = abteilung;
		this.level = level;
		//#######################################################
		// EDIT MITARBEITER
		//#######################################################
		editAccount = new JPanel();
		contentPane.add(editAccount, "name_1208936716956965");
		
		btnSpeichern_acc = new JButton("Speichern");
		btnSpeichern_acc.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/check.png")));
		btnSpeichern_acc.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnAbbruch_acc = new JButton("Abbrechen");
		btnAbbruch_acc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAbbruch_acc.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/cancel.png")));
		btnAbbruch_acc.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		
		vorname_acc = new JTextField();
		vorname_acc.setBackground(Color.WHITE);
		vorname_acc.setColumns(10);
		
		name_acc = new JTextField();
		name_acc.setColumns(10);
		name_acc.setBackground(Color.WHITE);
		
		telefon_acc = new JTextField();
		telefon_acc.setBackground(Color.WHITE);
		telefon_acc.setColumns(10);
		
		username_acc = new JTextField();
		username_acc.setBackground(Color.WHITE);
		username_acc.setColumns(10);
		
		pw_acc = new JPasswordField();
		pw_acc.setBackground(Color.WHITE);
		
		email_acc = new JTextField();
		email_acc.setBackground(Color.WHITE);
		email_acc.setColumns(10);
		
		straﬂe_acc = new JTextField();
		straﬂe_acc.setColumns(10);
		straﬂe_acc.setBackground(Color.WHITE);
		
		hausnr_acc = new JTextField();
		hausnr_acc.setColumns(10);
		hausnr_acc.setBackground(Color.WHITE);
		
		stadt_acc = new JTextField();
		stadt_acc.setColumns(10);
		stadt_acc.setBackground(Color.WHITE);
		
		plz_acc = new JTextField();
		plz_acc.setColumns(10);
		plz_acc.setBackground(Color.WHITE);
		
		c_land_acc = new JComboBox();
		c_zustaendig_acc = new JComboBox();
		c_abteilung_acc = new JComboBox();
		c_level_acc = new JComboBox();

		AutoCompleteDecorator.decorate(c_land_acc);

		AutoCompleteDecorator.decorate(c_level_acc);

		AutoCompleteDecorator.decorate(c_zustaendig_acc);

		AutoCompleteDecorator.decorate(c_abteilung_acc);
		
		
		geb_acc = new JTextField();
		geb_acc.setBackground(Color.WHITE);
		geb_acc.setColumns(10);
		
		lblGeburtstag = new JLabel("Geburtstag:");
		lblGeburtstag.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGeburtstag.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		pw2_acc = new JPasswordField();
		pw2_acc.setBackground(Color.WHITE);
		
		lblWiederholen = new JLabel("Passwort wiederholen:");
		lblWiederholen.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWiederholen.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblHelpdesklevel = new JLabel("Helpdesk-Level:");
		lblHelpdesklevel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHelpdesklevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDdmmyyyy = new JLabel("YYYY-MM-DD");
		
		
		GroupLayout gl_editAccount = new GroupLayout(editAccount);
		gl_editAccount.setHorizontalGroup(
			gl_editAccount.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editAccount.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_editAccount.createSequentialGroup()
							.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAbteilung, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblZustndigkeitsbereich, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHelpdesklevel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
								.addComponent(c_abteilung_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(c_zustaendig_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(c_level_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(142))
						.addGroup(gl_editAccount.createSequentialGroup()
							.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editAccount.createSequentialGroup()
									.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTelefon, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNutzername, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPasswort, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblWiederholen, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
										.addComponent(pw_acc, 180, 180, 180)
										.addComponent(pw2_acc, 180, 180, 180)
										.addComponent(username_acc, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(email_acc, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
										.addComponent(telefon_acc, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
								.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_editAccount.createSequentialGroup()
										.addComponent(btnSpeichern_acc)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnAbbruch_acc))
									.addGroup(gl_editAccount.createSequentialGroup()
										.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
											.addComponent(lblGeburtstag, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblAdresse, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_editAccount.createSequentialGroup()
												.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
													.addComponent(stadt_acc, Alignment.TRAILING)
													.addComponent(c_land_acc, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGroup(gl_editAccount.createSequentialGroup()
														.addComponent(geb_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblDdmmyyyy))
													.addComponent(straﬂe_acc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING)
													.addComponent(plz_acc, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
													.addComponent(hausnr_acc, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_editAccount.createSequentialGroup()
												.addComponent(vorname_acc, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(name_acc, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))))))
							.addGap(118))))
		);
		gl_editAccount.setVerticalGroup(
			gl_editAccount.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_editAccount.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(vorname_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGeburtstag)
						.addGroup(gl_editAccount.createSequentialGroup()
							.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
								.addComponent(straﬂe_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresse)
								.addComponent(hausnr_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_editAccount.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editAccount.createSequentialGroup()
									.addComponent(stadt_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(c_land_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
										.addComponent(geb_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDdmmyyyy)))
								.addComponent(plz_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZustndigkeitsbereich)
						.addComponent(c_zustaendig_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbteilung)
						.addComponent(c_abteilung_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHelpdesklevel)
						.addComponent(c_level_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(telefon_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(email_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNutzername)
						.addComponent(username_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPasswort)
						.addComponent(pw_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(pw2_acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWiederholen))
					.addGap(18)
					.addGroup(gl_editAccount.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbruch_acc)
						.addComponent(btnSpeichern_acc))
					.addGap(128))
		);
		editAccount.setLayout(gl_editAccount);
		
		//#######################################################
		// EDIT ACCOUNT
		//#######################################################
		editMitarbeiter = new JPanel();
		contentPane.add(editMitarbeiter, "name_1208962102764152");
		
		JLabel label = new JLabel("Name:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAdresse_1 = new JLabel("Adresse:");
		lblAdresse_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresse_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblGeburtstag_1 = new JLabel("Geburtstag:");
		lblGeburtstag_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGeburtstag_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblZustndigkeitsbereich_1 = new JLabel("Helpdesk-Level:");
		lblZustndigkeitsbereich_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblZustndigkeitsbereich_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAbteilung_1 = new JLabel("Abteilung:");
		lblAbteilung_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAbteilung_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_2 = new JLabel("Zust\u00E4ndigkeitsbereich:");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
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
		btnSpeichern_edit.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/check.png")));
		btnSpeichern_edit.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("Abbrechen");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(mitarbeiter_View.class.getResource("/lib/png/cancel.png")));
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
		 c_level_edit = new JComboBox();
		 c_abteilung_edit = new JComboBox();
		 c_zustaendig_edit = new JComboBox();

			AutoCompleteDecorator.decorate(c_land_edit);

			AutoCompleteDecorator.decorate(c_level_edit);

			AutoCompleteDecorator.decorate(c_abteilung_edit);

			AutoCompleteDecorator.decorate(c_zustaendig_edit);
		
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
		GroupLayout gl_editMitarbeiter = new GroupLayout(editMitarbeiter);
		gl_editMitarbeiter.setHorizontalGroup(
			gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editMitarbeiter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(lblZustndigkeitsbereich_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(c_level_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(lblAbteilung_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(c_abteilung_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblEmail_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(lblTelefon_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNutzername_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addComponent(username_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(telefon_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
								.addComponent(email_edit, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(c_zustaendig_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(lblAdresse_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_editMitarbeiter.createSequentialGroup()
									.addComponent(strasse_edit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_editMitarbeiter.createSequentialGroup()
									.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(c_land_edit, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(stadt_edit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(lblGeburtstag_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblYyyymmdd))
						.addGroup(gl_editMitarbeiter.createSequentialGroup()
							.addComponent(btnSpeichern_edit)
							.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		gl_editMitarbeiter.setVerticalGroup(
			gl_editMitarbeiter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_editMitarbeiter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(vorname_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(name_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(strasse_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAdresse_1)
						.addComponent(hausnr_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(stadt_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(plz_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(c_land_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGeburtstag_1)
						.addComponent(geb_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYyyymmdd))
					.addGap(32)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZustndigkeitsbereich_1)
						.addComponent(c_level_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAbteilung_1)
						.addComponent(c_abteilung_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(c_zustaendig_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail_1)
						.addComponent(email_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon_1)
						.addComponent(telefon_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNutzername_1)
						.addComponent(username_edit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_editMitarbeiter.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSpeichern_edit)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		editMitarbeiter.setLayout(gl_editMitarbeiter);
		//#######################################################
		
		
		this.setLocationRelativeTo(null);
	}
	
	//#######################################################
	// EDIT ACCOUNT
	//#######################################################
	
	public void accountEdit(Mitarbeiter m) {
		this.setTitle("Daten ‰ndern");
		this.editMitarbeiter.setVisible(false);
		this.editAccount.setVisible(true);
		
		this.m = m;
		
		this.vorname_acc.setText(m.vorname);
		this.name_acc.setText(m.name);
		this.telefon_acc.setText(m.telefon);
		this.username_acc.setText(m.account);
		this.email_acc.setText(m.email);
		this.straﬂe_acc.setText(m.strasse);
		this.hausnr_acc.setText(m.hausnummer);
		this.stadt_acc.setText(m.ort);
		this.plz_acc.setText(m.plz);
		this.geb_acc.setText(m.geburt);
		
		this.c_land_acc.setModel(land);
		this.c_abteilung_acc.setModel(abteilung);
		this.c_zustaendig_acc.setModel(kategorie);
		this.c_level_acc.setModel(level);
		
		
		c_land_acc.setSelectedIndex(land.getIndexOf(m.idLand));
		c_abteilung_acc.setSelectedIndex(abteilung.getIndexOf(m.idAbteilung));
		c_zustaendig_acc.setSelectedIndex(kategorie.getIndexOf(m.idZust‰ndigkeit));
		c_level_acc.setSelectedIndex(level.getIndexOf(m.idLevel));
		
		this.setVisible(true);
	}
	public Mitarbeiter saveEditAccount(){
		
		if(! ( pw_acc.getPassword().equals(null) || pw_acc.getPassword().equals(null) ) ){
			if( this.pw_acc.getPassword().toString().equals(pw2_acc.getPassword().toString() )  ){
				m.passwort = MD5.MD5(String.valueOf(pw_acc.getPassword()));
			}
			else{
				JOptionPane
				.showMessageDialog(null, "Falsches Passwort!");
				return null;
				}
		}
		
		m.vorname = vorname_acc.getText();
		m.name = name_acc.getText();
		m.telefon = telefon_acc.getText();
		m.account = username_acc.getText();
		m.email = email_acc.getText();
		m.strasse = straﬂe_acc.getText();
		m.hausnummer = hausnr_acc.getText();
		m.ort = stadt_acc.getText();
		m.plz = plz_acc.getText();
		m.geburt = geb_acc.getText();
		
		m.idLand = land.getElementAt(c_land_acc.getSelectedIndex()).getID();
		m.idAbteilung = abteilung.getElementAt(c_abteilung_acc.getSelectedIndex()).getID();
		m.idZust‰ndigkeit = kategorie.getElementAt(this.c_zustaendig_acc.getSelectedIndex()).getID();
		m.idLevel = level.getElementAt(c_level_acc.getSelectedIndex()).getID();

		return m;
	}
	public void speichernEditAccount(ActionListener a){
		this.btnSpeichern_acc.addActionListener(a);
	}
	
	//#######################################################
	// EDIT MITARBEITER
	//#######################################################
	
	public void mitarbeiterEdit(Mitarbeiter m) {
		this.setTitle("Daten ‰ndern");
		this.editMitarbeiter.setVisible(true);
		this.editAccount.setVisible(false);
		
		this.m = m;
		
		this.vorname_edit.setText(m.vorname);
		this.name_edit.setText(m.name);
		this.telefon_edit.setText(m.telefon);
		this.username_edit.setText(m.account);
		this.email_edit.setText(m.email);
		this.strasse_edit.setText(m.strasse);
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
		
		setVisible(true);
	}
	public Mitarbeiter saveMitarbeiterEdit(){

		//Pflichtfelder: Alle Felder m¸ssen ausgef¸llt sein!
		
		
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
		String idAbteilung = abteilung.getElementAt(c_abteilung_edit.getSelectedIndex()).getID();
		String idZust‰ndigkeit = kategorie.getElementAt(this.c_zustaendig_edit.getSelectedIndex()).getID();
		String idLevel = level.getElementAt(c_level_edit.getSelectedIndex()).getID();
		
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
			idAbteilung.equals("") ||
			idZust‰ndigkeit.equals("") ||
			idLevel.equals("")
		){
			JOptionPane
			.showMessageDialog(null, "Bitte zu bearbeitenden Mitarbeiter ausw‰hlen!");
			return null;
		}
		else{
			m.vorname = vorname;
			m.name = name;
			m.telefon = telefon;
			m.account = account;
			m.email = email;
			m.strasse = strasse;
			m.hausnummer = hausnummer;
			m.ort = ort;
			m.plz = plz;
			m.geburt = geburt;
			m.idLand = idLand;
			m.idAbteilung = idAbteilung;
			m.idZust‰ndigkeit = idZust‰ndigkeit;
			m.idLevel = idLevel;
			return m;
		}
	}
	public void speichernEditMitarbeiter(ActionListener a){
		this.btnSpeichern_edit.addActionListener(a);
	}
	

}

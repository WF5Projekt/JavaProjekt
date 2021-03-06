package views;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import models.AttributComboBox;
import models.KundenCombo;
import models.MitarbeiterCombo;
import models.Ticket;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ticketBearbeitung_View extends JFrame {

	private Ticket t;
	
	private AttributComboBox kategorie;
	private AttributComboBox priorit�t;
	private KundenCombo kunden;
	private MitarbeiterCombo mitarbeiter;
	
	
	private JPanel content;
	private JPanel TicketErfassen;
	private JPanel TicketBearbeiten;
	
	//Objekte in TicketBearbeiten:
	private JButton btn_TicketSpeichern;
	private JButton btn_Abbrechen;
	
	private JTextArea text_Beschreibung;
	private JTextArea text_Loesung;
	
	private JComboBox combo_Kategorie;
	private JComboBox combo_Prioritaet;
	
	//Objekte in TicketErfassen
	private JButton btn_TicketErfassen;
	private JButton btnAbbrechen;
	private JComboBox combo_Kategorie2;
	private JComboBox combo_Prioritaet2;
	private JTextArea text_Beschreibung2;

	private JLabel label;
	private JLabel label_1;
	private JLabel label_3;
	
	//Objekte in TicketErstellen
	private JPanel TicketErstellen;
	private JTextArea text_NewBeschreibung;
	private JLabel label_2;
	public JComboBox combo_NewKategorie;
	private JLabel label_4;
	public JComboBox combo_NewPrioritaet;
	private JLabel label_5;
	public JComboBox combo_NewK;
	private JLabel lblKunde;
	private JButton button;
	private JButton btn_TicketErstellen;
	private JButton btn_Loesungsvorschlag;
	
	public ticketBearbeitung_View(AttributComboBox kategorie, AttributComboBox priorit�t, MitarbeiterCombo mitarbeiter, KundenCombo kunden) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ticketBearbeitung_View.class.getResource("/lib/png/pen.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 415);
		
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(new CardLayout(0, 0));
		
		TicketErfassen = new JPanel();
		
	
		this.kategorie = kategorie;
		this.priorit�t = priorit�t;
		this.mitarbeiter = mitarbeiter;
		this.kunden = kunden;
		
		/*
		 * ------------------------------------------------------------Layout f�r TicketBearbeiten
		 */
		content.add(TicketErfassen, "name_1015676565602887");
		
		combo_Kategorie2 = new JComboBox();
		combo_Prioritaet2 = new JComboBox();
		
		label = new JLabel("Kategorie");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		label_1 = new JLabel("Priorit\u00E4t");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		text_Beschreibung2 = new JTextArea();
		text_Beschreibung2.setWrapStyleWord(true);
		text_Beschreibung2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		label_3 = new JLabel("Problembeschreibung:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAbbrechen.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/cancel.png")));
		btnAbbrechen.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btn_TicketErfassen = new JButton("Ticket erfassen");
		btn_TicketErfassen.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/arrow-1-forward.png")));
		btn_TicketErfassen.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_TicketErfassen = new GroupLayout(TicketErfassen);
		gl_TicketErfassen.setHorizontalGroup(
			gl_TicketErfassen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TicketErfassen.createSequentialGroup()
					.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TicketErfassen.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_TicketErfassen.createSequentialGroup()
									.addComponent(btn_TicketErfassen)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAbbrechen))
								.addGroup(gl_TicketErfassen.createSequentialGroup()
									.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_TicketErfassen.createSequentialGroup()
											.addGap(10)
											.addComponent(combo_Kategorie2, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
									.addGap(52)
									.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_TicketErfassen.createSequentialGroup()
											.addGap(10)
											.addComponent(combo_Prioritaet2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
									.addGap(148))))
						.addGroup(gl_TicketErfassen.createSequentialGroup()
							.addGap(20)
							.addComponent(text_Beschreibung2, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
						.addGroup(gl_TicketErfassen.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_TicketErfassen.setVerticalGroup(
			gl_TicketErfassen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TicketErfassen.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_Beschreibung2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.BASELINE)
						.addComponent(combo_Kategorie2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_Prioritaet2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
					.addGroup(gl_TicketErfassen.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbbrechen)
						.addComponent(btn_TicketErfassen))
					.addContainerGap())
		);
		
		/*
		 * ----------------------------------------------------------------------------------------Ende TicketBearbeiten Panel
		 */
	

		
		//-----------------------------------------------------------------------------------------Ticket Er�ffnen
		
		TicketErfassen.setLayout(gl_TicketErfassen);
		
		TicketBearbeiten = new JPanel();
		content.add(TicketBearbeiten, "name_1015715148673385");
		
		
		
		JLabel label_beschreibung = new JLabel("Problembeschreibung:");
		label_beschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_L�sung = new JLabel("M\u00F6gliche L\u00F6sung:");
		label_L�sung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_kategorie = new JLabel("Kategorie");
		label_kategorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_prioritaet = new JLabel("Priorit\u00E4t");
		label_prioritaet.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		text_Beschreibung = new JTextArea();
		text_Beschreibung.setWrapStyleWord(true);
		text_Beschreibung.setLineWrap(true);
		text_Beschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));

		text_Loesung = new JTextArea();
		text_Loesung.setWrapStyleWord(true);
		text_Loesung.setLineWrap(true);
		text_Loesung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		combo_Kategorie = new JComboBox();
		combo_Prioritaet = new JComboBox();
		
		btn_Abbrechen = new JButton("Abbrechen");
		btn_Abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_Abbrechen.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/cancel.png")));
		btn_Abbrechen.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btn_TicketSpeichern = new JButton("Speichern");
		btn_TicketSpeichern.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/check.png")));
		btn_TicketSpeichern.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btn_Loesungsvorschlag = new JButton("L\u00F6sungsvorschlag geben");
		btn_Loesungsvorschlag.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/arrow-1-forward.png")));
		btn_Loesungsvorschlag.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout gl_TicketBearbeiten = new GroupLayout(TicketBearbeiten);
		gl_TicketBearbeiten.setHorizontalGroup(
			gl_TicketBearbeiten.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TicketBearbeiten.createSequentialGroup()
					.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_TicketBearbeiten.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(combo_Kategorie, Alignment.LEADING, 0, 175, Short.MAX_VALUE)
								.addComponent(label_kategorie, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_TicketBearbeiten.createSequentialGroup()
									.addComponent(combo_Prioritaet, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
									.addComponent(btn_Loesungsvorschlag, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_prioritaet, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_TicketBearbeiten.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_TicketSpeichern, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Abbrechen, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_TicketBearbeiten.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.LEADING)
								.addComponent(label_L�sung, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_Loesung)))
						.addGroup(Alignment.LEADING, gl_TicketBearbeiten.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.LEADING)
								.addComponent(label_beschreibung, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_Beschreibung))))
					.addContainerGap())
		);
		gl_TicketBearbeiten.setVerticalGroup(
			gl_TicketBearbeiten.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TicketBearbeiten.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_beschreibung, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(text_Beschreibung, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(label_L�sung, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_Loesung, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_kategorie, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_prioritaet, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.BASELINE)
						.addComponent(combo_Kategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_Prioritaet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Loesungsvorschlag))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_TicketBearbeiten.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_TicketSpeichern)
						.addComponent(btn_Abbrechen))
					.addGap(52))
		);
		TicketBearbeiten.setLayout(gl_TicketBearbeiten);
		
		//----------------------------------------------------------------------------------------------
		
		TicketErstellen = new JPanel();
		content.add(TicketErstellen, "name_1030169512649547");
		
		text_NewBeschreibung = new JTextArea();
		text_NewBeschreibung.setWrapStyleWord(true);
		text_NewBeschreibung.setLineWrap(true);
		text_NewBeschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		label_2 = new JLabel("Problembeschreibung:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		combo_NewKategorie = new JComboBox();
		combo_NewK = new JComboBox();	
		combo_NewPrioritaet = new JComboBox();
		AutoCompleteDecorator.decorate(combo_NewK);
		
		label_4 = new JLabel("Kategorie");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
	
		
		label_5 = new JLabel("Priorit\u00E4t");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		lblKunde = new JLabel("Kunde angeben:");
		lblKunde.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		button = new JButton("Abbrechen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/cancel.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btn_TicketErstellen = new JButton("Ticket erstellen");
		
		btn_TicketErstellen.setIcon(new ImageIcon(ticketBearbeitung_View.class.getResource("/lib/png/save.png")));
		btn_TicketErstellen.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_TicketErstellen = new GroupLayout(TicketErstellen);
		gl_TicketErstellen.setHorizontalGroup(
			gl_TicketErstellen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_TicketErstellen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_TicketErstellen.createSequentialGroup()
								.addGap(10)
								.addComponent(combo_NewK, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_TicketErstellen.createSequentialGroup()
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(455, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_TicketErstellen.createSequentialGroup()
								.addComponent(lblKunde, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(459, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_TicketErstellen.createSequentialGroup()
								.addComponent(btn_TicketErstellen)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(Alignment.TRAILING, gl_TicketErstellen.createSequentialGroup()
								.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_TicketErstellen.createSequentialGroup()
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addGap(186))
									.addGroup(gl_TicketErstellen.createSequentialGroup()
										.addComponent(combo_NewKategorie, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
										.addGap(65)))
								.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_TicketErstellen.createSequentialGroup()
										.addGap(10)
										.addComponent(combo_NewPrioritaet, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGap(76)))
						.addGroup(Alignment.TRAILING, gl_TicketErstellen.createSequentialGroup()
							.addComponent(text_NewBeschreibung, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_TicketErstellen.setVerticalGroup(
			gl_TicketErstellen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_TicketErstellen.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKunde, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(combo_NewK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_NewBeschreibung, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.BASELINE)
						.addComponent(combo_NewKategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_NewPrioritaet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_TicketErstellen.createParallelGroup(Alignment.TRAILING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_TicketErstellen))
					.addContainerGap())
		);
		TicketErstellen.setLayout(gl_TicketErstellen);
		
		

		this.setLocationRelativeTo(null);
		
	}
	//Panel f�r die Ticketbearbeitung wird aufgerufen und Ticket dargestellt.
	public void TicketBearbeiten(Ticket t){
		this.t = t;
		
		this.setTitle("Ticket bearbeiten");
		
		text_Beschreibung.setText(t.beschreibung);
		text_Loesung.setText(t.tmploesung);
		
		this.combo_Kategorie.setModel(kategorie);
		this.combo_Prioritaet.setModel(priorit�t);
		
		this.combo_Kategorie.setSelectedIndex(kategorie.getIndexOf(t.idKategorie));
		this.combo_Prioritaet.setSelectedIndex(priorit�t.getIndexOf(t.idPrioritaet));

		
		this.TicketErfassen.setVisible(false);
		this.TicketErstellen.setVisible(false);
		this.TicketBearbeiten.setVisible(true);
		this.setVisible(true);
	}
	
	public Ticket saveEditedTicket(){
		this.t.beschreibung = text_Beschreibung.getText();
		this.t.tmploesung = text_Loesung.getText();
		this.t.idKategorie = kategorie.getElementAt(combo_Kategorie.getSelectedIndex()).getID();
		this.t.idPrioritaet = priorit�t.getElementAt(combo_Prioritaet.getSelectedIndex()).getID();

		return this.t;
	}
	
	public void addListenerTicketSave(ActionListener a) {
		btn_TicketSpeichern.addActionListener(a);
	}
	public void addListenerTicketLoesung(ActionListener a){
		this.btn_Loesungsvorschlag.addActionListener(a);
	}
	
	//Panel f�r TicketErfassen erstellen
	public void TicketErfassen(Ticket t){
		this.t = t;
		
		this.setTitle("Ticket erfassen");
		
		text_Beschreibung2.setText(t.beschreibung);
		this.combo_Kategorie2.setModel(kategorie);
		this.combo_Prioritaet2.setModel(priorit�t);
		
		
		this.combo_Kategorie2.setSelectedIndex(kategorie.getIndexOf(t.idKategorie));
		this.combo_Prioritaet2.setSelectedIndex(priorit�t.getIndexOf(t.idPrioritaet));
		

		this.TicketErfassen.setVisible(true);
		this.TicketErstellen.setVisible(false);
		this.TicketBearbeiten.setVisible(false);
		this.setVisible(true);
	}
	public void addListenerTicketErfassen(ActionListener a){
		btn_TicketErfassen.addActionListener(a);
	}
	public Ticket erfasseTicket(){
		this.t.idKategorie = kategorie.getElementAt(combo_Kategorie2.getSelectedIndex()).getID();
		this.t.idPrioritaet =  priorit�t.getElementAt(combo_Prioritaet2.getSelectedIndex()).getID();
		this.t.beschreibung = this.text_Beschreibung2.getText();
		
		return this.t;
	}
	
	
	public void TicketErstellen(Ticket t){
		this.t = t;
		
		this.setTitle("Neues Ticket erstellen");
		
		combo_NewKategorie.setModel(kategorie);
		combo_NewPrioritaet.setModel(priorit�t);
		combo_NewK.setModel(kunden);
		
		
		this.TicketErfassen.setVisible(false);
		this.TicketErstellen.setVisible(true);
		this.TicketBearbeiten.setVisible(false);
		
		this.setVisible(true);
	}
	public void addListenerTicketErstellen(ActionListener a){
		btn_TicketErstellen.addActionListener(a);
	}
	public Ticket erstelleTicket(){
		Ticket temp = new Ticket();
		
		temp.beschreibung = text_NewBeschreibung.getText();
		temp.idKategorie = kategorie.getElementAt(combo_NewKategorie.getSelectedIndex()).getID();
		temp.idPrioritaet =  priorit�t.getElementAt(combo_NewPrioritaet.getSelectedIndex()).getID();
		temp.idKunde = kunden.getObjectAt(combo_NewK.getSelectedIndex()).idKunde;
		
		return temp;
		
	}

}

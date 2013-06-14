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

public class FAQ_View extends JFrame {

	private Ticket t;
	
	private AttributComboBox kategorie;
	private AttributComboBox priorität;
	private KundenCombo kunden;
	private MitarbeiterCombo mitarbeiter;
	
	
	private JPanel content;
	private JPanel FAQerstellen;
	
	//Objekte in TicketBearbeiten:
	private JButton btn_TicketSpeichern;
	private JButton btn_Abbrechen;
	
	private JTextArea text_Beschreibung;
	private JTextArea text_Loesung;
	
	private JComboBox combo_Kategorie;
	
	public FAQ_View(AttributComboBox kategorie) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FAQ_View.class.getResource("/lib/png/pen.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 719, 351);
		
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(new CardLayout(0, 0));
		
	
		this.kategorie = kategorie;
		this.priorität = priorität;
		this.mitarbeiter = mitarbeiter;
		this.kunden = kunden;
		
		FAQerstellen = new JPanel();
		content.add(FAQerstellen, "name_1015715148673385");
		
		
		
		JLabel label_beschreibung = new JLabel("Problembeschreibung:");
		label_beschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblLsung = new JLabel("L\u00F6sung:");
		lblLsung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_kategorie = new JLabel("Kategorie");
		label_kategorie.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		text_Beschreibung = new JTextArea();
		text_Beschreibung.setWrapStyleWord(true);
		text_Beschreibung.setLineWrap(true);
		text_Beschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));

		text_Loesung = new JTextArea();
		text_Loesung.setWrapStyleWord(true);
		text_Loesung.setLineWrap(true);
		text_Loesung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		combo_Kategorie = new JComboBox();
		
		btn_Abbrechen = new JButton("Abbrechen");
		btn_Abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btn_Abbrechen.setIcon(new ImageIcon(FAQ_View.class.getResource("/lib/png/cancel.png")));
		btn_Abbrechen.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btn_TicketSpeichern = new JButton("Speichern");
		btn_TicketSpeichern.setIcon(new ImageIcon(FAQ_View.class.getResource("/lib/png/check.png")));
		btn_TicketSpeichern.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout gl_FAQerstellen = new GroupLayout(FAQerstellen);
		gl_FAQerstellen.setHorizontalGroup(
			gl_FAQerstellen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_FAQerstellen.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_FAQerstellen.createParallelGroup(Alignment.LEADING)
						.addComponent(text_Loesung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
						.addComponent(text_Beschreibung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
						.addComponent(label_beschreibung, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLsung, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_FAQerstellen.createSequentialGroup()
							.addComponent(label_kategorie, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(combo_Kategorie, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(btn_TicketSpeichern, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Abbrechen, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_FAQerstellen.setVerticalGroup(
			gl_FAQerstellen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_FAQerstellen.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_beschreibung, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(text_Beschreibung, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLsung, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_Loesung, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_FAQerstellen.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_kategorie, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(combo_Kategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Abbrechen)
						.addComponent(btn_TicketSpeichern))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		FAQerstellen.setLayout(gl_FAQerstellen);
		
		

		this.setLocationRelativeTo(null);
		
	}
	//FAQ Erstellung wird aufgerufen und gewähltes Ticket dargestellt.
	public void newFAQ(Ticket t){
		this.t = t;
		
		this.setTitle("Ticket als FAQ speichern");
		
		text_Beschreibung.setText(t.beschreibung);
		text_Loesung.setText(t.tmploesung);
		
		this.combo_Kategorie.setModel(kategorie);
		this.combo_Kategorie.setSelectedIndex(kategorie.getIndexOf(t.idKategorie));

		this.FAQerstellen.setVisible(true);
		this.setVisible(true);
	}
	
	public Ticket saveFAQ(){
		this.t.beschreibung = text_Beschreibung.getText();
		this.t.tmploesung = text_Loesung.getText();
		this.t.idKategorie = kategorie.getElementAt(combo_Kategorie.getSelectedIndex()).getID();

		return this.t;
	}
	
	public void addListenerTicketSave(ActionListener a) {
		btn_TicketSpeichern.addActionListener(a);
	}
	
}

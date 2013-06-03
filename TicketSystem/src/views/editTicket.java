package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;

import models.AttributComboBox;
import models.Ticket;

public class editTicket extends JFrame {

	private JPanel contentPane;
	private Ticket ticket;
	
	public JComboBox<String> combo_Kategorie;

	private JTextArea textArea;
	
	public editTicket() {
		setTitle("Ticket bearbeitung");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblProblembeschreibung = new JLabel("Problembeschreibung");
		lblProblembeschreibung.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		combo_Kategorie = new JComboBox<String>();
		combo_Kategorie.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblProblembeschreibung)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(combo_Kategorie, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(620, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(9)
					.addComponent(lblProblembeschreibung)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(combo_Kategorie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(173, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
		

		
	}
	
	//Beim erstellen des Fensters wird ein Ticket zugewiesen, welches dargestellt werden soll.
	//Die Attribute des Tickets werden in die Labels/Textfelder/Comboboxen geschrieben
	public void setTicket(Ticket t){
		this.ticket = t;
		
		textArea.setText(ticket.beschreibung);
	}
	
		
	//Der MainController holt sich das geänderte Ticket und schickt es zur Datenbank
	public Ticket getTicket(){
		saveChanges();
		return this.ticket;
	}
	//Vor der Rückgabe des geänderten Tickets, werden die geänderten Werte in dieses Gesichert.
	public void saveChanges(){
		this.ticket.beschreibung = textArea.getText();
	}

	public void setCombo(AttributComboBox kategorie) {
		this.combo_Kategorie.setModel(kategorie);
		
		combo_Kategorie.setSelectedIndex(Integer.parseInt(ticket.idPrioritaet));
		
	}

	

}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import models.*;
import views.Main_View;
import views.newTicket_View;

public class Main_Controller implements ListSelectionListener {

	private Main_View MainView;
	public newTicket_View TicketNeu;

	// Objekt des eingeloggten Mitarbeiters
	private Mitarbeiter user;

	private Ticket_Table tickets;
	private Kunde_Table kunden;
	private Mitarbeiter_Table mitarbeiter;

	// Komboboxen bei Ticket
	public ComboBoxModelKategorie ComboBoxKategorie;
	public ComboBoxModelPriorität ComboBoxPriorität;
	public ComboBoxModelKunde ComboBoxKunde;
	private ArrayList<Kategorie> combo_kategorien;
	private ArrayList<Priorität> combo_prioritäten;
	private ArrayList<Kunde> combo_kunden;
	


	public Main_Controller(Mitarbeiter user) {
		
		
		this.MainView = new Main_View();
		
		//Tabellen erstellen
		//this.tickets 		= 	new Ticket_Table();
		//this.kunden 		= 	new Kunde_Table();
		this.mitarbeiter	= 	new Mitarbeiter_Table();
		
		//Erstesmal Tabellendaten Abfragen
		//tickets.refreshData();
		//kunden.refreshData();
		mitarbeiter.refreshData();

		//Aktuell eingeloggter Mitarbeiter ist hier gespeichert (kommt aus der Login_Model())
		this.user 			= 	user;

		// Initialisierung der Arrays für Comboboxen
		//combo_kategorien 	= 	Kategorie.all();
		//combo_prioritäten 	= 	Priorität.all();
		//combo_kunden 		= 	Kunde.all();

		try {
			init();
			addListener();

		} catch (Exception e) {
			JOptionPane.showInputDialog("Listener/Models können nicht Initialisiert werden");
		}

		this.MainView.setVisible(true);
	}


	// Alle Tabellen werden in der MainView verknüpft/festgelegt
	private void init() {
		//this.MainView.setModel(tickets);
		//this.MainView.setModel(kunden);
		this.MainView.setModel(mitarbeiter);
	}

	// Button-Listener werden festgelegt
	private void addListener() {
		// Buttons im Ticket-Tab
		MainView.addListenerTicketRefresh(new ticketRefreshListener());
		MainView.addListenerTicketNew(new ticketNewListener());
		MainView.addListenerTicketSuche(new ticketSucheListener());
		MainView.addKeyListenerTicketSuche(new ticketSucheKeyListener());

		//Buttons im Kunden-Tab
		MainView.addListenerKundeRefresh(new kundeRefreshListener());
		MainView.addListenerKundeSuche(new kundeSucheListener());
		MainView.addKeyListenerKundeSuche(new kundeSucheKeyListener());
		
		//Buttons im Mitarbeiter-Tab
		MainView.addListenerMitarbeiterRefresh(new mitarbeiterRefreshListener());
		MainView.addListenerMitarbeiterSuche(new mitarbeiterSucheListener());
		MainView.addKeyListenerMitarbeiterSuche(new mitarbeiterSucheKeyListener());
		
		// Tabellen-Listener
		MainView.tickets.getSelectionModel().addListSelectionListener(this);
	}

	
	/*
	 * ################################################
	 * ################################################
	 * ################################################ 
	 * ############ 						###########
	 * ############		Mitarbeiter			########### 
	 * ############ 						###########
	 * ################################################
	 * ################################################
	 */
	
	// Methode ruft Such-Procedure der Datenbank mit Werten aus Suchfeld+Suchspalte auf
		private void mitarbeiterSuche() {
			String suche = MainView.getTextSucheMitarbeiter();
			String spalte = MainView.getSpalteSucheMitarbeiter();

			if (!(suche.equals("") || spalte.equals(""))) {
				mitarbeiter.searchData(spalte, suche);
			} else {
				mitarbeiter.refreshData();
			}
		}
		
		//############### ActionListener
		
		// Refresh-Button
		class mitarbeiterRefreshListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mitarbeiter.refreshData();
			}

		}
		
		// Neuer Kunde-Button
		
		class mitarbeiterNewListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
		
		// Suchbutton ruft die KundenSuche() auf mit Klick auf Button
		class mitarbeiterSucheListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				mitarbeiterSuche();
			}

		}
		// Suchbutton ruft KundenSuche() auf bei Enter-Taste
		class mitarbeiterSucheKeyListener implements KeyListener {

			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER)
					mitarbeiterSuche();

			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		}
		
		
	
	
	
	
	/*
	 * ################################################
	 * ################################################
	 * ################################################ 
	 * ############ 						###########
	 * ############			Kunden	 		########### 
	 * ############ 						###########
	 * ################################################
	 * ################################################
	 */
	
	// Methode ruft Such-Procedure der Datenbank mit Werten aus Suchfeld+Suchspalte auf
	private void kundenSuche() {
		String suche = MainView.getTextSucheKunde();
		String spalte = MainView.getSpalteSucheKunde();

		if (!(suche.equals("") || spalte.equals(""))) {
				kunden.searchData(spalte, suche);
		} else {
				kunden.refreshData();
		}
	}
	
	//############### ActionListener
	
	// Refresh-Button
	class kundeRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			kunden.refreshData();
		}

	}
	
	// Neuer Kunde-Button
	
	class kundeNewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	// Suchbutton ruft die KundenSuche() auf mit Klick auf Button
	class kundeSucheListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			kundenSuche();
		}

	}
	// Suchbutton ruft KundenSuche() auf bei Enter-Taste
	class kundeSucheKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			if (key.getKeyCode() == KeyEvent.VK_ENTER)
				kundenSuche();

		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	
	
	/*
	 * ################################################
	 * ################################################
	 * ################################################ 
	 * ############ 						###########
	 * ############			Tickets 		########### 
	 * ############ 						###########
	 * ################################################
	 * ################################################
	 */

	// ########### ActionListener

	// Refresh-Button
	class ticketRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.refreshData();
		}

	}
	
	
	//Neues Ticket eröffnen --> Fenster wird geöffnet und Comboboxen gefüllt!
	class ticketNewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			TicketNeu = new newTicket_View();
			// Button für neues Ticket anlegen
			TicketNeu.addListenerButton(new neuesTicket());

			// ComboBoxen füllen
			ComboBoxKategorie = new ComboBoxModelKategorie();
			ComboBoxPriorität = new ComboBoxModelPriorität();
			ComboBoxKunde = new ComboBoxModelKunde();

			TicketNeu.kat.setModel(ComboBoxKategorie);
			TicketNeu.prio.setModel(ComboBoxPriorität);
			TicketNeu.kunde.setModel(ComboBoxKunde);

			TicketNeu.setVisible(true);
		}

	}
	
	// Button um neues Ticket zu speichern
	class neuesTicket implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int selIndexKat = TicketNeu.kat.getSelectedIndex();
			int selIndexPrio = TicketNeu.prio.getSelectedIndex();
			int selIndexKunde = TicketNeu.kunde.getSelectedIndex();

			String beschreibung = TicketNeu._beschreibung.getText();
			// Falls nicht alle Daten angegeben sind -> Button-Aktion abbrechen!
			// Daten vollständig: das Ticket wird erstellt mit: Beschreibung,
			// idPriorität, idKategorie, idKunde, idMitarbeiter und in Datenbank
			// mit NewTicket() gespeichert

			if (selIndexKat >= 0 && selIndexPrio >= 0 && selIndexKunde >= 0
					&& !beschreibung.trim().equals("")) {

				String priorität = combo_prioritäten.get(selIndexPrio).id;
				String kategorie = combo_kategorien.get(selIndexKat).id;
				String idKunde = combo_kunden.get(selIndexKunde).idKunde;
				String idMitarbeiter = user.idMitarbeiter;

				Ticket tmpTicket = new Ticket(beschreibung, priorität,
						kategorie, idKunde, idMitarbeiter);
				tmpTicket.newTicket();
				JOptionPane.showMessageDialog(null, "Ticket eröffnet!",
						"Erfolgreich", JOptionPane.PLAIN_MESSAGE);
				tickets.refreshData();
				TicketNeu.dispose();

			} else {
				JOptionPane.showMessageDialog(null,
						"Bitte alle geforderten Daten angeben!", "Warnung",
						JOptionPane.QUESTION_MESSAGE);
				return;
			}

		}
	}

	// Methode ruft Such-Procedure der Datenbank mit Werten aus Suchfeld+Suchspalte auf
	private void ticketSuche() {
		String suche = MainView.getTextSucheTicket();
		String spalte = MainView.getSpalteSucheTicket();

		if (!(suche.equals("") || spalte.equals(""))) {
			tickets.searchData(spalte, suche);
		} else {
			tickets.refreshData();
		}
	}

	
	// Suchbutton ruft die TicketSuche() auf mit Klick auf Button
	class ticketSucheListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ticketSuche();
		}

	}
	// Suchbutton ruft TicketSuche() auf bei Enter-Taste
	class ticketSucheKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent key) {
			if (key.getKeyCode() == KeyEvent.VK_ENTER)
				ticketSuche();

		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	

	//################ Methode zeigt bei Klick auf Ticket in der Tabelle die Details des Tickets in der TicketInfo()
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source == MainView.tickets.getSelectionModel()) {
			showTicketInfo();
		}
	}

	// Setzt die TicketInfo auf die Daten des aktuellen Ticket-Objekts aus der Tabelle
	private void showTicketInfo() {
		int selectedRow = MainView.getSelectedTicket();
		if (selectedRow != -1) {
			Ticket tmpTicket = tickets.getTicketAtRow(selectedRow);
			// Set additional Info for selected Disc
			// if no info exists label is set to '-'
			try {

				MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim()
						.equals("")) ? tmpTicket.beschreibung : "-");
				MainView.setInfoStatus(!(tmpTicket.status.trim().equals("")) ? tmpTicket.status
						: "-");
				MainView.setInfoKategorie(!(tmpTicket.kategorie.trim()
						.equals("")) ? tmpTicket.kategorie : "-");
				MainView.setInfoLevel(!(tmpTicket.level.trim().equals("")) ? tmpTicket.level
						: "-");
				MainView.setInfoPriorität(!(tmpTicket.prioritaet.trim()
						.equals("")) ? tmpTicket.prioritaet : "-");
				MainView.setInfoErstellzeitpunkt(!(tmpTicket.erstellzeitpunkt
						.trim().equals("")) ? tmpTicket.erstellzeitpunkt : "-");

				MainView.setInfoEmail_K(!(tmpTicket.email_k.equals("")) ? tmpTicket.email_k
						: "-");
				MainView.setInfoNachname_K(!(tmpTicket.nachname_k.equals("")) ? tmpTicket.nachname_k
						: "-");
				MainView.setInfoVorname_K(!(tmpTicket.vorname_k.trim()
						.equals("")) ? tmpTicket.vorname_k : "-");
				MainView.setInfoTelefon_K(!(tmpTicket.telefon_k.equals("")) ? tmpTicket.telefon_k
						: "-");

				MainView.setInfoAbteilung(!(tmpTicket.abteilung.equals("")) ? tmpTicket.abteilung
						: "-");
				MainView.setInfoEmail_M(!(tmpTicket.email_m.equals("")) ? tmpTicket.email_m
						: "-");
				MainView.setInfoNachname_M(!(tmpTicket.nachname_m.trim()
						.equals("")) ? tmpTicket.nachname_m : "-");
				MainView.setInfoVorname_M(!(tmpTicket.vorname_m.trim()
						.equals("")) ? tmpTicket.vorname_m : "-");
				MainView.setInfoTelefon_M(!(tmpTicket.telefon_m.equals("")) ? tmpTicket.telefon_m
						: "-");

			} catch (Exception e) {
				JOptionPane.showInputDialog(tmpTicket.telefon_k);
			}

		}

	}

	
	
	
	//################ Komboboxen für Ticket-Fenster
	@SuppressWarnings("serial")
	class ComboBoxModelKategorie extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_kategorien.size();
		}

		@Override
		public Kategorie getElementAt(int index) {
			return combo_kategorien.get(index);
		}
	}

	@SuppressWarnings("serial")
	class ComboBoxModelPriorität extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_prioritäten.size();
		}

		@Override
		public Priorität getElementAt(int index) {
			return combo_prioritäten.get(index);
		}
	}

	@SuppressWarnings("serial")
	class ComboBoxModelKunde extends DefaultComboBoxModel {

		@Override
		public int getSize() {
			return combo_kunden.size();
		}

		@Override
		public Kunde getElementAt(int index) {
			return combo_kunden.get(index);
		}
	}

}

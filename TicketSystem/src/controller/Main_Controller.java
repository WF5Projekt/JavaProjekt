package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Database_Operations;
import models.Kategorie;
import models.Kunde;
import models.Kunde_Table;
import models.Mitarbeiter;
import models.Mitarbeiter_Table;
import models.Priorität;
import models.Ticket;
import models.Ticket_Table;
import views.Main_View;
import views.newTicket_View;

public class Main_Controller implements ListSelectionListener {

	public static Database_Operations db = new Database_Operations();

	private Main_View MainView;
	public newTicket_View TicketNeu;

	// Objekt des eingeloggten Mitarbeiters
	private Mitarbeiter user;

	public Ticket_Table tickets;
	public Ticket_Table faq;
	public Ticket_Table gelöst;
	
	public Kunde_Table kunden;
	public Mitarbeiter_Table mitarbeiter;

	public Priorität priorität;
	public Kategorie kategorie;

	// Komboboxen bei Ticket
	public ComboBoxModelKategorie ComboBoxKategorie;
	public ComboBoxModelPriorität ComboBoxPriorität;
	public ComboBoxModelKunde ComboBoxKunde;
	public ComboBoxModelMitarbeiter ComboBoxMitarbeiter;

	public Main_Controller(Mitarbeiter user) {

		// Aktuell eingeloggter Mitarbeiter ist hier gespeichert (kommt aus der
		// Login_Model())
		this.user = user;

		try {
			init();
			addListener();
		} catch (Exception e) {
			JOptionPane
					.showInputDialog("Listener/Models können nicht Initialisiert werden");
		}

		this.MainView.setVisible(true);
	}

	// Alle Tabellen werden in der MainView verknüpft/festgelegt
	private void init() {
		// Initalisierung der Datenbank-Befehle

		// Fenster erstellen - aber nicht Sichtbar!
		this.MainView = new Main_View();

		// ComboBoxen bekommen den Wert der Mitarbeiter-Tabellenspalten
		MainView.setComboTicketSuche(Ticket.getColumnNames());
		MainView.setComboKundenSuche(Kunde.getColumnNames());
		MainView.setComboMitarbeiterSuche(Mitarbeiter.getColumnNames());

		// Tabellen erstellen und Daten laden
		this.tickets = new Ticket_Table("Tickets");
		this.faq = new Ticket_Table("FAQ");
		this.gelöst = new Ticket_Table("Gelöst");
		this.kunden = new Kunde_Table();
		this.mitarbeiter = new Mitarbeiter_Table();

		refreshTickets();
		refreshKunden();
		refreshMitarbeiter();

		// Zusatzdaten erstellen (werden beim Erstellen geladen)
		this.priorität = new Priorität();
		this.kategorie = new Kategorie();

		this.MainView.setTabelle(tickets);
		this.MainView.setModel(kunden);
		this.MainView.setModel(mitarbeiter);

	}

	// Button-Listener werden festgelegt
	private void addListener() {
		// Buttons im Ticket-Tab
		MainView.addListenerTicketRefresh(new ticketRefreshListener());
		MainView.addListenerTicketNew(new ticketNewListener());
		MainView.addListenerTicketSuche(new ticketSucheListener());
		MainView.addKeyListenerTicketSuche(new ticketSucheKeyListener());
		MainView.addListenerAllTickets(new getAllTickets());
		MainView.addListenerNeueTickets(new getNeueTickets());
		MainView.addListenerMeineTickets(new getMeineTickets());
		MainView.addListenerGeschlosseneTickets(new getGeschlosseneTickets());
		MainView.addListenerFAQTickets(new getFAQTickets());

		// Buttons im Kunden-Tab
		MainView.addListenerKundeRefresh(new kundeRefreshListener());
		MainView.addListenerKundeSuche(new kundeSucheListener());
		MainView.addKeyListenerKundeSuche(new kundeSucheKeyListener());

		// Buttons im Mitarbeiter-Tab
		MainView.addListenerMitarbeiterRefresh(new mitarbeiterRefreshListener());
		MainView.addListenerMitarbeiterSuche(new mitarbeiterSucheListener());
		MainView.addKeyListenerMitarbeiterSuche(new mitarbeiterSucheKeyListener());

		// Tabellen-Listener
		MainView.tickets.getSelectionModel().addListSelectionListener(this);
	}

	/*
	 * ################################################
	 * ################################################
	 * ################################################ ############ ###########
	 * ############ Mitarbeiter ########### ############ ###########
	 * ################################################
	 * ################################################
	 */

	private void refreshMitarbeiter() {
		mitarbeiter.setList(db.getMitarbeiter());
	}

	// Methode ruft Such-Procedure der Datenbank mit Werten aus
	// Suchfeld+Suchspalte auf
	private void mitarbeiterSuche() {
		String suche = MainView.getTextSucheMitarbeiter();
		String spalte = MainView.getSpalteSucheMitarbeiter();

		mitarbeiter.searchMitarbeiter(spalte, suche);
	}

	// ############### ActionListener

	// Refresh-Button
	class mitarbeiterRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshMitarbeiter();
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
	 * ################################################ ############ ###########
	 * ############ Kunden ########### ############ ###########
	 * ################################################
	 * ################################################
	 */

	// Refresh lädt die Liste neu aus der Datenbank
	public void refreshKunden() {
		kunden.setList(db.getKunden());
	}

	// Methode ruft Such-Procedure der Datenbank mit Werten aus
	// Suchfeld+Suchspalte auf
	public void kundenSuche() {
		String suche = MainView.getTextSucheKunde();
		String spalte = MainView.getSpalteSucheKunde();

		kunden.searchKunde(spalte, suche);
	}

	// ############### ActionListener

	// Refresh-Button
	class kundeRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshKunden();
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
	 * ################################################ ############ ###########
	 * ############ Tickets ########### ############ ###########
	 * ################################################
	 * ################################################
	 */
	public void refreshTickets() {
		tickets.setList(db.getTickets());
		faq.setList(db.getFAQTickets());
		gelöst.setList(db.getGelösteTickets());
	}


	// Methode ruft Such-Procedure der Datenbank mit Werten aus
	// Suchfeld+Suchspalte auf
	public void ticketSuche() {
		String suche = MainView.getTextSucheTicket();
		String spalte = MainView.getSpalteSucheTicket();

		tickets.searchTicket(spalte, suche);
	}

	// ########### ActionListener Klassen
	
	/*
	MainView.addListenerAllTickets(new getAllTickets());
	MainView.addListenerTicketNew(new getNeueTickets());
	MainView.addListenerMeineTickets(new getMeineTickets());
	MainView.addListenerGeschlosseneTickets(new getGeschlosseneTickets());
	MainView.addListenerFAQTickets(new getFAQTickets());
*/
	class getAllTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(tickets);
		}
		
	}
	class getNeueTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(tickets);
			tickets.getNeueTickets();
		}
		
	}
	class getMeineTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(tickets);
			tickets.getMeineTickets(user);
		}
		
	}
	class getGeschlosseneTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(gelöst);
		}
		
	}
	class getFAQTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(faq);
		}
		
	}

	// Refresh-Button
	class ticketRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshTickets();
		}

	}

	// Neues Ticket eröffnen --> Fenster wird geöffnet und Comboboxen gefüllt!
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

				String tmpPrio = priorität.getArray().get(selIndexPrio).id;
				String tmpKat = kategorie.getArray().get(selIndexKat).id;
				String idKunde = kunden.getArray().get(selIndexKunde).idKunde;
				String idMitarbeiter = user.idMitarbeiter;

				Ticket tmpTicket = new Ticket(beschreibung, tmpPrio, tmpKat,
						idKunde, idMitarbeiter);
				db.ticketNew(tmpTicket);
				JOptionPane.showMessageDialog(null, "Ticket eröffnet!",
						"Erfolgreich", JOptionPane.PLAIN_MESSAGE);

				refreshTickets();
				TicketNeu.dispose();

			} else {
				JOptionPane.showMessageDialog(null,
						"Bitte alle geforderten Daten angeben!", "Warnung",
						JOptionPane.QUESTION_MESSAGE);
				return;
			}

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

	// ################ Methode zeigt bei Klick auf Ticket in der Tabelle die
	// Details des Tickets in der TicketInfo()
	public void valueChanged(ListSelectionEvent e) {
		Object source = e.getSource();
		if (source == MainView.tickets.getSelectionModel()) {
			showTicketInfo();
		}
	}
	

	// Setzt die TicketInfo auf die Daten des aktuellen Ticket-Objekts aus der
	// Tabelle
	private void showTicketInfo() {
		int selectedRow = MainView.getSelectedTicket();
		if (selectedRow != -1) {

			Ticket tmpTicket = tickets.getTicketAtRow(selectedRow);

			if (tmpTicket != null) {

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

				if (tmpTicket.idMitarbeiter != null) {

					Mitarbeiter tmpMitarbeiter = mitarbeiter
							.getMitarbeiterWithID(tmpTicket.idMitarbeiter);

					MainView.setInfoAccount_M(!(tmpMitarbeiter.account.trim()
							.equals("")) ? tmpMitarbeiter.account : "-");
					MainView.setInfoHelpdesk(!(tmpMitarbeiter.level.trim()
							.equals("")) ? tmpMitarbeiter.level : "-");
					MainView.setInfoName_M(!(tmpMitarbeiter.name.trim()
							.equals("")) ? tmpMitarbeiter.name : "-");
					MainView.setInfoEmail_M(!(tmpMitarbeiter.email.trim()
							.equals("")) ? tmpMitarbeiter.email : "-");
					MainView.setInfoTelefon_M(!(tmpMitarbeiter.telefon.trim()
							.equals("")) ? tmpMitarbeiter.telefon : "-");
					MainView.setInfoAbteilung(!(tmpMitarbeiter.abteilung.trim()
							.equals("")) ? tmpMitarbeiter.abteilung : "-");
				} else {
					MainView.setInfoAccount_M("-");
					MainView.setInfoHelpdesk("-");
					MainView.setInfoName_M("-");
					MainView.setInfoEmail_M("-");
					MainView.setInfoTelefon_M("-");
					MainView.setInfoAbteilung("-");
				}

				if (tmpTicket.idKunde != "") {
					Kunde tmpKunde = kunden.getKundeWithID(tmpTicket.idKunde);

					MainView.setInfoEmail_K(!(tmpKunde.email.trim().equals("")) ? tmpKunde.email
							: "-");
					MainView.setInfoName_K(!(tmpKunde.name.trim().equals("")) ? tmpKunde.name
							: "-");
					MainView.setInfoErreichbarkeit(!(tmpKunde.erreichbar.trim()
							.equals("")) ? tmpKunde.erreichbar : "-");
					MainView.setInfoTelefon_K(!(tmpKunde.telefon.trim()
							.equals("")) ? tmpKunde.telefon : "-");
				} else {
					MainView.setInfoEmail_K("-");
					MainView.setInfoName_K("-");
					MainView.setInfoErreichbarkeit("-");
					MainView.setInfoTelefon_K("-");
				}
			}

		}
	}
		// ################ Komboboxen für Ticket-Fenster
		@SuppressWarnings("serial")
		class ComboBoxModelKategorie extends DefaultComboBoxModel {

			@Override
			public int getSize() {
				return kategorie.getArray().size();
			}

			@Override
			public Kategorie getElementAt(int index) {
				return kategorie.getArray().get(index);
			}
		}

		@SuppressWarnings("serial")
		class ComboBoxModelPriorität extends DefaultComboBoxModel {

			@Override
			public int getSize() {
				return priorität.getArray().size();
			}

			@Override
			public Priorität getElementAt(int index) {
				return priorität.getArray().get(index);
			}
		}

		@SuppressWarnings("serial")
		class ComboBoxModelKunde extends DefaultComboBoxModel {

			@Override
			public int getSize() {
				return kunden.getArray().size();
			}

			@Override
			public Kunde getElementAt(int index) {
				return kunden.getArray().get(index);
			}
		}

		@SuppressWarnings("serial")
		class ComboBoxModelMitarbeiter extends DefaultComboBoxModel {

			@Override
			public int getSize() {
				return mitarbeiter.getArray().size();
			}

			@Override
			public Mitarbeiter getElementAt(int index) {
				return mitarbeiter.getArray().get(index);
			}
		}
	}


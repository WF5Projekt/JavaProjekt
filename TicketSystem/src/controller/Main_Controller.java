package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.*;
import views.*;

public class Main_Controller implements ListSelectionListener {

	public static Database_Operations db = new Database_Operations();

	private Main_View MainView;
	private ticketBearbeitung_View TicketEditView;
	private FAQ_View FAQview;
	
	private mitarbeiter_View MitarbeiterView;
	private kunden_View KundenView;

	// Objekt des eingeloggten Mitarbeiters
	private Mitarbeiter user;

	public Ticket_Table tickets;
	public Ticket_Table faq;
	public Ticket_Table gelöst;
	
	public Kunde_Table kunden;
	public Mitarbeiter_Table mitarbeiter;


	// Komboboxen
	public AttributComboBox priorität;
	public AttributComboBox kategorie;
	public AttributComboBox status;
	public AttributComboBox land;
	public AttributComboBox abteilung;
	public AttributComboBox level;
	public AttributComboBox erreichbarkeit;
	
	public KundenCombo KundenCombo;	
	public MitarbeiterCombo MitarbeiterCombo;

	public Main_Controller(Mitarbeiter user) {

		// Aktuell eingeloggter Mitarbeiter ist hier gespeichert (kommt aus der
		// Login_Model())
		this.user = user;

		try {
			init();
			addListener();
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(MainView, "Listener/Models können nicht Initialisiert werden");
		}

		this.MainView.setVisible(true);
	}

	// Alle Tabellen werden in der MainView verknüpft/festgelegt
	private void init() {
		// Initalisierung der Datenbank-Befehle

		// Fenster erstellen - aber nicht Sichtbar!f
		this.MainView = new Main_View();
		this.MainView.setUserLayout(user.idLevel);

		// Tabellen erstellen und Daten laden
		this.tickets = new Ticket_Table("Tickets");
		this.faq = new Ticket_Table("FAQ");
		this.gelöst = new Ticket_Table("Gelöst");
		this.kunden = new Kunde_Table();
		this.mitarbeiter = new Mitarbeiter_Table();

		
		
		MitarbeiterCombo = new MitarbeiterCombo();
		KundenCombo = new KundenCombo();
		priorität = new AttributComboBox();
		kategorie = new AttributComboBox();
		status = new AttributComboBox();
		land = new AttributComboBox();
		abteilung = new AttributComboBox();
		level = new AttributComboBox();
		erreichbarkeit = new AttributComboBox();
		
		// Zum Suchen in den Tabellen, bekommen die Comboboxen den Wert der Tabellenspalten

		MainView.setComboTicketSuche(Ticket.getColumnNames());
		MainView.setComboKundenSuche(Kunde.getColumnNames());
		MainView.setComboMitarbeiterSuche(Mitarbeiter.getColumnNames());

		
	
		
		this.MainView.setTabelle(tickets);
		this.MainView.setModel(kunden);
		this.MainView.setModel(mitarbeiter);
		
		reload();

	}
	
	private void reload(){
		reloadTickets();
		reloadKunden();
		reloadMitarbeiter();
		
		refreshComboBoxen();
	}
	
	private void refreshComboBoxen(){
		// Zusatzdaten erstellen
		priorität.setArray(db.getAttribut("prioritaet"));
		kategorie.setArray(db.getAttribut("kategorie"));
		status.setArray(db.getAttribut("status"));
		land.setArray(db.getAttribut("land"));
		abteilung.setArray(db.getAttribut("abteilung"));
		level.setArray(db.getAttribut("helpdesk"));
		erreichbarkeit.setArray(db.getAttribut("erreichbarkeit"));
		
		KundenCombo.setArray(db.getKunden());
		MitarbeiterCombo.setArray(db.getMitarbeiter());
	}

	// Button-Listener werden festgelegt
	private void addListener() {
		MainView.addListenerRefreshAll(new RefreshAll());
		MainView.addListenerSettings(new UserSettings());
		
		// Buttons im Ticket-Tab
		MainView.addListenerTicketRefresh(new ticketRefreshListener());
		MainView.addListenerTicketNew(new ticketNewListener());
		MainView.addListenerTicketErfassen(new ticketErfassenListener());
		MainView.addListenerTicketEdit(new ticketEditListener());
		MainView.addListenerTicketSuche(new ticketSucheListener());
		MainView.addListenerTicketAnKunde(new TicketAnKundeListener());
		MainView.addListenerTicketAlsFAQ(new TicketAlsFAQ());
		
		MainView.addKeyListenerTicketSuche(new ticketSucheKeyListener());
		MainView.addListenerAllTickets(new getAllTickets());
		MainView.addListenerNeueTickets(new getNeueTickets());
		MainView.addListenerTicketsOffen(new getOffeneTickets());
		MainView.addListenerMeineTickets(new getMeineTickets());
		MainView.addListenerTicketAbgeschlossene(new getAbgeschlosseneTickets());
		MainView.addListenerFAQTickets(new getFAQTickets());
		MainView.addListenerTicketFertige(new getFertigeTickets());

		// Buttons im Kunden-Tab
		MainView.addListenerKundeRefresh(new kundeRefreshListener());
		MainView.addListenerKundeSuche(new kundeSucheListener());
		MainView.addKeyListenerKundeSuche(new kundeSucheKeyListener());
		MainView.addListenerKundeEdit(new kundeEditListener());

		// Buttons im Mitarbeiter-Tab
		MainView.addListenerMitarbeiterRefresh(new mitarbeiterRefreshListener());
		MainView.addListenerMitarbeiterSuche(new mitarbeiterSucheListener());
		MainView.addKeyListenerMitarbeiterSuche(new mitarbeiterSucheKeyListener());
		MainView.addListenerMitarbeiterEdit(new mitarbeiterEditListener());
		MainView.addListenerMitarbeiterNew(new mitarbeiterNewListener());

		// Tabellen-Listener
		MainView.tickets.getSelectionModel().addListSelectionListener(this);
	}
	
	
	class UserSettings implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MitarbeiterView = new mitarbeiter_View(kategorie, land, abteilung, level);
			
			//"Speichern Button"
			MitarbeiterView.speichernEditAccount(new editAccountSpeichern());
			MitarbeiterView.accountEdit(user);
			
			
		}
		
	}
	class editAccountSpeichern implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Mitarbeiter tmpUser = MitarbeiterView.saveEditAccount();
			if(tmpUser != null){
			user = tmpUser;
			db.mitarbeiterSave(user);

			reloadMitarbeiter();
			MitarbeiterView.dispose();
			}
			
		}
		
	}
	class RefreshAll implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			reload();
		}
		
	}

	/*
	 * ################################################
	 * ################################################
	 * ################################################ ############ ###########
	 * ############ Mitarbeiter ########### ############ ###########
	 * ################################################
	 * ################################################
	 */

	private void reloadMitarbeiter() {
		mitarbeiter.setList(db.getMitarbeiter());
	}
	private void resetMitarbeiter() {
		mitarbeiter.reset();
	}
		
	// Methode ruft Suche im Array der Tabelle mit Werten aus
	// Suchfeld+Suchspalte auf
	private void mitarbeiterSuche() {
		String suche = MainView.getTextSucheMitarbeiter();
		String spalte = MainView.getSpalteSucheMitarbeiter();

		mitarbeiter.searchMitarbeiter(spalte, suche);
	}

	// ############### ActionListener

	//Edit Mitarbeiter
	class mitarbeiterEditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			
			MitarbeiterView = new mitarbeiter_View(kategorie, land, abteilung, level);
			
			MitarbeiterView.speichernEditMitarbeiter(new saveMitarbeiterEdit());
			try{
				MitarbeiterView.mitarbeiterEdit(mitarbeiter.getMitarbeiterAtRow(MainView.getSelectedMitarbeiter()));
						
				}catch(Exception e){
					JOptionPane
					.showMessageDialog(MainView, "Bitte zu bearbeitenden Mitarbeiter auswählen!");
				}	
		}
		
	}
	class mitarbeiterNewListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			MitarbeiterView = new mitarbeiter_View(kategorie, land, abteilung, level);
			
			MitarbeiterView.speichernEditAccount(new editAccountSpeichern());
			
			MitarbeiterView.accountEdit(new Mitarbeiter());
			
		}
		
	}
	class saveMitarbeiterEdit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Mitarbeiter tmpUser = MitarbeiterView.saveMitarbeiterEdit();
			if(tmpUser != null){
			db.mitarbeiterSave(tmpUser);

			reloadMitarbeiter();
			MitarbeiterView.dispose();
			}
		}
		
	}
		
	
	// Refresh-Button
	class mitarbeiterRefreshListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			reloadMitarbeiter();
		}
	}


	// Suchbutton ruft die KundenSuche() auf mit Klick auf Button
	class mitarbeiterSucheListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mitarbeiterSuche();
		}

	}

	// Suchbutton ruft Suche() auf bei Enter-Taste
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
	public void reloadKunden() {
		kunden.setList(db.getKunden());
	}
	public void resetKunden(){
		kunden.reset();
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
			reloadKunden();
		}

	}
	class kundeEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent a) {
			KundenView = new kunden_View(land, erreichbarkeit);
			
			try{

				KundenView.kundeEdit(kunden.getKundeAtRow(MainView.getSelectedKunde()));		
				}catch(Exception e){
					JOptionPane
					.showMessageDialog(MainView, "Bitte zu bearbeitenden Kunden auswählen!");
				}
			KundenView.speichernEditKunde(new saveKundenEdit());
		}
		
	}
	class saveKundenEdit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Kunde tmpKunde = KundenView.saveKundeEdit();
			if(tmpKunde != null){
			db.kundeSave(tmpKunde);

			reloadKunden();
			KundenView.dispose();
			}
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
	public void reloadTickets() {
		tickets.setList(db.getTickets());
		faq.setList(db.getFAQTickets());
		gelöst.setList(db.getGelösteTickets());
		MainView.viewButtonsAlle();
	}
	public void refreshTickets(){
		tickets.reset();
		faq.reset();
		gelöst.reset();
	}


	// Methode ruft Such-Procedure der Datenbank mit Werten aus
	// Suchfeld+Suchspalte auf
	public void ticketSuche() {
		String suche = MainView.getTextSucheTicket();
		String spalte = MainView.getSpalteSucheTicket();

		tickets.searchTicket(spalte, suche);
	}

	
	
	class getAllTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.aktuell = "tickets";
			tickets.reset();
			MainView.setTabelle(tickets);
			showTicketInfo();
			MainView.viewDetails(true);
			MainView.viewButtonsAlle();
		}
		
	}
	class getOffeneTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			tickets.aktuell = "tickets";
			tickets.getTicketsAbteilung(user);
			MainView.setTabelle(tickets);
			showTicketInfo();
			MainView.viewDetails(true);
			MainView.viewButtonsMeine();
		}
		
	}
	class getNeueTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.aktuell = "tickets";
			MainView.setTabelle(tickets);
			MainView.viewButtonsNeue();
			showTicketInfo();
			MainView.viewDetails(true);
			tickets.getNeueTickets();
		}
		
	}
	class getMeineTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.aktuell = "tickets";
			
			MainView.setTabelle(tickets);
			MainView.viewButtonsMeine();
			showTicketInfo();
			MainView.viewDetails(true);
			tickets.getMeineTickets(user);
		}
		
	}
	class getAbgeschlosseneTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tickets.aktuell = "gelöste";
			MainView.setTabelle(gelöst);
			showTicketInfo();
			MainView.viewDetails(true);
			MainView.viewButtonsAbgeschlossene();
		}
		
	}
	class getFAQTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.viewButtonsFAQ();
			showTicketInfo();
			MainView.viewDetails(false);
			
			tickets.aktuell = "faq";
			MainView.setTabelle(faq);
		}
		
	}
	class getFertigeTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			tickets.aktuell = "tickets";
			
			MainView.setTabelle(tickets);
			showTicketInfo();
			MainView.viewButtonsFertigeTickets();
			MainView.viewDetails(true);
			tickets.getFertigeTickets();
		}
		
	}

	// Refresh-Button
	class ticketRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reloadTickets();
			showTicketInfo();
		}

	}

	// Neues Ticket eröffnen --> Fenster wird geöffnet und Comboboxen gefüllt!
	class ticketNewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			TicketEditView = new ticketBearbeitung_View( kategorie, priorität,MitarbeiterCombo, KundenCombo);
			TicketEditView.TicketErstellen(new Ticket());
			TicketEditView.addListenerTicketErstellen(new neuesTicket());
			
			}

	}

	// Button um neues Ticket zu speichern
	class neuesTicket implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// Falls nicht alle Daten angegeben sind -> Button-Aktion abbrechen!
			// Daten vollständig: das Ticket wird erstellt mit: Beschreibung,
			// idPriorität, idKategorie, idKunde, idMitarbeiter und in Datenbank
			// mit NewTicket() gespeichert	
			Ticket tmpTicket = TicketEditView.erstelleTicket();
		
			if (! ( tmpTicket.idKategorie.equals("") || tmpTicket.idPrioritaet.equals("") || tmpTicket.idKunde.equals("")	
					|| tmpTicket.beschreibung.trim().equals("") ) ) {

				Ticket neuesTicket = db.ticketNew(tmpTicket);
				reloadTickets();
				MainView.viewButtonsAlle();
				JOptionPane.showMessageDialog(null, "Ticket eröffnet!",
						"Erfolgreich", JOptionPane.PLAIN_MESSAGE);
			
				TicketEditView.dispose();

			} else {
				JOptionPane.showMessageDialog(null,
						"Bitte alle geforderten Daten angeben!", "Warnung",
						JOptionPane.QUESTION_MESSAGE);
				return;
			}

		}
	}
	
	//Edit Ticket: 
	//1. Fenster wird erzeugt
	//2. Selektiertes Ticket wird Fenster übergeben
	//3. Fenster stellt das Ticket dar (auch Komboboxen zeigen den Selektierten wert)
	//4. Ticket kann bearbeitet werden
	//5. wird Ticket gespeichert, wird Ticket an Datenbank geschickt
	class ticketEditListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				Ticket tmpTicket = tickets.getTicketAtRow(MainView
						.getSelectedTicket());

				if (tmpTicket.idMitarbeiter == null) {
					
					int entscheidung = JOptionPane.showConfirmDialog(null,

					"Ticket wird Ihnen zugewiesen.", "Sind Sie sicher?",
							JOptionPane.YES_NO_OPTION);
					// 0 = Ja, 1= Nein
					if (entscheidung == 1) {
						return;
					} else {
							// Falls Ticket bearbeitet wird, wird Status auf "In Bearbeitung" gesetzt
							tmpTicket.idStatus = "3";
							//Statusupdate an Datenbank und Mitarbeiter zuweisen
							db.ticketZumBearbeiten(tmpTicket, user);

							
							//Ticket Lokal update 
							tickets.ticketUpdate(tmpTicket);
							
							tickets.getMeineTickets(user);

					}
				}
				try{
							
							TicketEditView = new ticketBearbeitung_View(
									kategorie, priorität, MitarbeiterCombo,
									KundenCombo);

							TicketEditView.TicketBearbeiten(tmpTicket);
							TicketEditView
									.addListenerTicketSave(new EditTicketListener());
							TicketEditView
									.addListenerTicketLoesung(new EditTicketLoesungListener());

						} catch (Exception e) {
							JOptionPane
									.showMessageDialog(MainView,
											"Ups! Da ging wohl etwas beim Öffnen des Ticket-Bearbeiten Fensters schief.");
						}
					
			
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(MainView,
						"Bitte zu bearbeitendes Ticket auswählen!");
			}
			
			
		}
	}

	class EditTicketListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Ticket temp = TicketEditView.saveEditedTicket();
			
			
			
			db.ticketSaveEdit(temp);
			reloadTickets();
			MainView.viewButtonsMeine();
			
			tickets.getMeineTickets(user);

		
			TicketEditView.dispose();
			
		
		}

	}

	class EditTicketLoesungListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Ticket temp = TicketEditView.saveEditedTicket();
			if(temp.idMitarbeiter == null){
				
			}
			else if(!temp.tmploesung.trim().equals("")){
				int entscheidung = JOptionPane.showConfirmDialog(null,
						"Ihr Ticket wird nun an das Level 1 zurückgeleitet!",
						"Sind Sie sicher?", JOptionPane.YES_NO_OPTION);
				// 0 = Ja, 1= Nein
				if (entscheidung == 0) {
					db.ticketGelöst(temp);

					reloadTickets();
					tickets.getMeineTickets(user);

					TicketEditView.dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(TicketEditView, "Kein Lösungsvorschlag!");
			}
			
		}

	}

	class ticketErfassenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
			try{
				TicketEditView = new ticketBearbeitung_View(kategorie, priorität, MitarbeiterCombo, KundenCombo);
				TicketEditView.TicketErfassen(tmpTicket);
				TicketEditView.addListenerTicketErfassen(new ErfasseTicketListener());
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Ups! Da ging wohl etwas beim öffnen des Ticket-Erfassen-Fensters schief!");
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Bitte erst zu erfassendes Ticket auswählen!");	
			}
		}
		
	}
	class ErfasseTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Ticket temp = TicketEditView.erfasseTicket();
			temp.idStatus = "2"; //Erfasst
			db.ticketErfassen(temp);

			tickets.getNeueTickets();
			refreshTickets();
			
			TicketEditView.dispose();
			
		}
		
	}
	class TicketAlsFAQ implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try{
			Ticket tmpTicket = gelöst.getTicketAtRow(MainView.getSelectedTicket());
			
			FAQview = new FAQ_View(kategorie);
			FAQview.addListenerTicketSave(new SaveFAQ());
			
			
			} catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Dazu muss man ein Ticket auswählen!");	
			}
		}
		
	}
	class SaveFAQ implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Ticket temp = FAQview.saveFAQ();

					db.ticketAlsFAQ(temp);
					
					reloadTickets();
					MainView.viewButtonsFAQ();
					showTicketInfo();
					MainView.viewDetails(false);
					
					tickets.aktuell = "faq";
					MainView.setTabelle(faq);
				
					TicketEditView.dispose();
				
			
	
		}
		
	}
	
	class TicketAnKundeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			try{
				Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
				int entscheidung = JOptionPane.showConfirmDialog(null,
						"Ticket an Kunde zurückschicken?!",
						"Bitte bestätigen!", JOptionPane.YES_NO_OPTION);
				// 0 = Ja, 1= Nein
				if (entscheidung == 0) {
					tmpTicket.idStatus = "5";
					db.ticketSaveEdit(tmpTicket);

					reloadTickets();
				}
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Dazu muss man ein Ticket auswählen!");	
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

	// Methode zeigt bei Klick auf Ticket die TicketInfo()
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

			if (tmpTicket != null
					&& (tickets.aktuell.matches("tickets") || tickets.aktuell
							.matches("gelöste"))) {

				MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim()
						.equals("")) ? tmpTicket.beschreibung : "-");
				if (!(tmpTicket.tmploesung == null))
					MainView.setInfoLösung(!(tmpTicket.equals("")) ? tmpTicket.tmploesung
							: "-");

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

			else if (tmpTicket != null && tickets.aktuell.equals("faq")) {
				MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim()
						.equals("")) ? tmpTicket.beschreibung : "-");
				if (!(tmpTicket.tmploesung == null))
					MainView.setInfoLösung(!(tmpTicket.equals("")) ? tmpTicket.tmploesung
							: "-");

			}

			else {
				MainView.setInfoHelpdesk("-");
				MainView.setInfoName_M("-");
				MainView.setInfoEmail_M("-");
				MainView.setInfoTelefon_M("-");
				MainView.setInfoAbteilung("-");
				MainView.setInfoEmail_K("-");
				MainView.setInfoName_K("-");
				MainView.setInfoErreichbarkeit("-");
				MainView.setInfoTelefon_K("-");

				MainView.setInfoBeschreibung("-");
				MainView.setInfoLösung("-");

				MainView.setInfoStatus("-");
				MainView.setInfoKategorie("-");
				MainView.setInfoLevel("-");
				MainView.setInfoPriorität("-");
				MainView.setInfoErstellzeitpunkt("-");
			}
		}
	}
}
		

	


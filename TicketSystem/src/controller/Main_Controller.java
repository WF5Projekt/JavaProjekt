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

	// Objekt des eingeloggten Mitarbeiters
	private Mitarbeiter user;

	public Ticket_Table tickets;
	public Ticket_Table faq;
	public Ticket_Table gel�st;
	
	public Kunde_Table kunden;
	public Mitarbeiter_Table mitarbeiter;


	// Komboboxen
	public AttributComboBox priorit�t;
	public AttributComboBox kategorie;
	public AttributComboBox status;
	
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
					.showMessageDialog(MainView, "Listener/Models k�nnen nicht Initialisiert werden");
		}

		this.MainView.setVisible(true);
	}

	// Alle Tabellen werden in der MainView verkn�pft/festgelegt
	private void init() {
		// Initalisierung der Datenbank-Befehle

		// Fenster erstellen - aber nicht Sichtbar!f
		this.MainView = new Main_View();
		this.MainView.setUserLayout(user.idLevel);

		// Tabellen erstellen und Daten laden
		this.tickets = new Ticket_Table("Tickets");
		this.faq = new Ticket_Table("FAQ");
		this.gel�st = new Ticket_Table("Gel�st");
		this.kunden = new Kunde_Table();
		this.mitarbeiter = new Mitarbeiter_Table();

		
		
		MitarbeiterCombo = new MitarbeiterCombo();
		KundenCombo = new KundenCombo();
		priorit�t = new AttributComboBox();
		kategorie = new AttributComboBox();
		status = new AttributComboBox();
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
		priorit�t.setArray(db.getAttribut("prioritaet"));
		kategorie.setArray(db.getAttribut("kategorie"));
		status.setArray(db.getAttribut("status"));
		KundenCombo.setArray(db.getKunden());
		MitarbeiterCombo.setArray(db.getMitarbeiter());
	}

	// Button-Listener werden festgelegt
	private void addListener() {
		MainView.addListenerRefreshAll(new RefreshAll());
		
		// Buttons im Ticket-Tab
		MainView.addListenerTicketRefresh(new ticketRefreshListener());
		MainView.addListenerTicketNew(new ticketNewListener());
		MainView.addListenerTicketErfassen(new ticketErfassenListener());
		MainView.addListenerTicketEdit(new ticketEditListener());
		MainView.addListenerTicketSuche(new ticketSucheListener());
		MainView.addKeyListenerTicketSuche(new ticketSucheKeyListener());
		MainView.addListenerAllTickets(new getAllTickets());
		MainView.addListenerNeueTickets(new getNeueTickets());
		MainView.addListenerMeineTickets(new getMeineTickets());
		MainView.addListenerTicketAbgeschlossene(new getAbgeschlosseneTickets());
		MainView.addListenerFAQTickets(new getFAQTickets());
		MainView.addListenerTicketFertige(new getFertigeTickets());

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

	// Refresh-Button
	class mitarbeiterRefreshListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			reloadMitarbeiter();
		}
	}

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

	// Refresh l�dt die Liste neu aus der Datenbank
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
	public void reloadTickets() {
		tickets.setList(db.getTickets());
		faq.setList(db.getFAQTickets());
		gel�st.setList(db.getGel�steTickets());
		MainView.viewButtonsAlle();
	}
	public void refreshTickets(){
		tickets.reset();
		faq.reset();
		gel�st.reset();
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
			tickets.reset();
			MainView.setTabelle(tickets);
			MainView.viewButtonsAlle();
		}
		
	}
	class getNeueTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(tickets);
			MainView.viewButtonsNeue();
			tickets.getNeueTickets();
		}
		
	}
	class getMeineTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(tickets);
			MainView.viewButtonsMeine();
			tickets.getMeineTickets(user);
		}
		
	}
	class getAbgeschlosseneTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.setTabelle(gel�st);
			MainView.viewButtonsAbgeschlossene();
		}
		
	}
	class getFAQTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainView.viewButtonsFAQ();
			MainView.setTabelle(faq);
		}
		
	}
	class getFertigeTickets implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			MainView.setTabelle(tickets);
			MainView.viewButtonsFertigeTickets();
			tickets.getFertigeTickets();
		}
		
	}

	// Refresh-Button
	class ticketRefreshListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			reloadTickets();
		}

	}

	// Neues Ticket er�ffnen --> Fenster wird ge�ffnet und Comboboxen gef�llt!
	class ticketNewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			TicketEditView = new ticketBearbeitung_View();
			TicketEditView.TicketErstellen(new Ticket(), kategorie, priorit�t, KundenCombo);
			TicketEditView.addListenerTicketErstellen(new neuesTicket());
			
			}

	}

	// Button um neues Ticket zu speichern
	class neuesTicket implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			// Falls nicht alle Daten angegeben sind -> Button-Aktion abbrechen!
			// Daten vollst�ndig: das Ticket wird erstellt mit: Beschreibung,
			// idPriorit�t, idKategorie, idKunde, idMitarbeiter und in Datenbank
			// mit NewTicket() gespeichert	
			Ticket tmpTicket = new Ticket();
			
			int idKat = TicketEditView.combo_NewKategorie.getSelectedIndex();
			tmpTicket.idKategorie = kategorie.getObjectAt(idKat).id;
			int idPrio = TicketEditView.combo_NewPrioritaet.getSelectedIndex();
			tmpTicket.idPrioritaet = priorit�t.getObjectAt(idPrio).id;
			int idKunde = TicketEditView.combo_NewK.getSelectedIndex();
			tmpTicket.idKunde = KundenCombo.getObjectAt(idKunde).idKunde;

			tmpTicket.beschreibung = TicketEditView.erstelleTicket();
		

			if (! ( tmpTicket.idKategorie.equals("") || tmpTicket.idPrioritaet.equals("") || tmpTicket.idKunde.equals("")	
					|| tmpTicket.beschreibung.trim().equals("") ) ) {

				Ticket neuesTicket = db.ticketNew(tmpTicket);
				tickets.ticketUpdate(neuesTicket);
				tickets.reset();
				
				JOptionPane.showMessageDialog(null, "Ticket er�ffnet!",
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
	//2. Selektiertes Ticket wird Fenster �bergeben
	//3. Fenster stellt das Ticket dar (auch Komboboxen zeigen den Selektierten wert)
	//4. Ticket kann bearbeitet werden
	//5. wird Ticket gespeichert, wird Ticket an Datenbank geschickt
	class ticketEditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
			try{
				
				
				TicketEditView = new ticketBearbeitung_View();
				TicketEditView.TicketBearbeiten(tmpTicket, kategorie, priorit�t, status);
				TicketEditView.addListenerTicketSave(new EditTicketListener());
				TicketEditView.addListenerTicketLoesung(new EditTicketLoesungListener());
				
				} catch(Exception e){
						JOptionPane
								.showMessageDialog(MainView, "Ups! Da ging wohl etwas beim �ffnen des Ticket-Bearbeiten Fensters schief.");
					
				}
			}catch(Exception e){
				JOptionPane
				.showMessageDialog(MainView, "Bitte zu bearbeitendes Ticket ausw�hlen!");
			}
			
	
		}
		
	}

	class EditTicketListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Ticket temp = TicketEditView.saveEditedTicket();

			// Falls Ticket bearbeitet wird, wird Status auf "In Bearbeitung"
			// gesetzt.
			if (temp.idStatus.equals("2"))
				temp.idStatus = "3";
			
			db.ticketSaveEdit(temp);
			//Ticket lokal updaten
			tickets.ticketUpdate(temp);
			//Tabelle aktualisieren
			refreshTickets();
			tickets.getMeineTickets(user);

			JOptionPane.showMessageDialog(null, "Ticket bearbeitet!",
					"Erfolgreich", JOptionPane.PLAIN_MESSAGE);

			TicketEditView.dispose();
		}

	}

	class EditTicketLoesungListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Ticket temp = TicketEditView.saveEditedTicket();
			if(!temp.tmploesung.trim().equals("")){
				int entscheidung = JOptionPane.showConfirmDialog(null,
						"Ihr Ticket wird nun an das Level 1 zur�ckgeleitet!",
						"Sind Sie sicher?", JOptionPane.YES_NO_OPTION);
				// 0 = Ja, 1= Nein
				if (entscheidung == 0) {
					db.ticketGel�st(temp);

					//Ticket lokal updaten
					tickets.ticketUpdate(temp);
					//Tabelle aktualisieren
					refreshTickets();
					tickets.getMeineTickets(user);

					TicketEditView.dispose();
				}
			}
			else{
				JOptionPane.showMessageDialog(TicketEditView, "Kein L�sungsvorschlag!");
			}
			
		}

	}

	class ticketErfassenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
			try{
				TicketEditView = new ticketBearbeitung_View();
				TicketEditView.TicketErfassen(tmpTicket, kategorie, priorit�t, MitarbeiterCombo);
				TicketEditView.addListenerTicketErfassen(new ErfasseTicketListener());
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Ups! Da ging wohl etwas beim �ffnen des Ticket-Erfassen-Fensters schief!");
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(MainView, "Bitte erst zu erfassendes Ticket ausw�hlen!");	
			}
		}
		
	}
	class ErfasseTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Ticket temp = TicketEditView.erfasseTicket();
			
			db.ticketErfassen(temp);
			JOptionPane.showMessageDialog(null, "Ticket erfasst und Mitarbeiter zugewiesen!",
					"Erfolgreich", JOptionPane.PLAIN_MESSAGE);

			//Ticket lokal updaten
			tickets.ticketUpdate(temp);
			//Tabelle aktualisieren
			refreshTickets();
			tickets.getNeueTickets();
			
			TicketEditView.dispose();
			
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

			if (tmpTicket != null) {

				MainView.setInfoBeschreibung(!(tmpTicket.beschreibung.trim()
						.equals("")) ? tmpTicket.beschreibung : "-");
				if(!(tmpTicket.tmploesung == null))
				MainView.setInfoL�sung(!(tmpTicket.equals("")) ? tmpTicket.tmploesung : "-");
			
				MainView.setInfoStatus(!(tmpTicket.status.trim().equals("")) ? tmpTicket.status
						: "-");
				MainView.setInfoKategorie(!(tmpTicket.kategorie.trim()
						.equals("")) ? tmpTicket.kategorie : "-");
				MainView.setInfoLevel(!(tmpTicket.level.trim().equals("")) ? tmpTicket.level
						: "-");
				MainView.setInfoPriorit�t(!(tmpTicket.prioritaet.trim()
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

		}
	}
		

	
}

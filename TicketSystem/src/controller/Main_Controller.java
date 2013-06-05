package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.AttributComboBox;
import models.Database_Operations;
import models.Kunde;
import models.Kunde_Table;
import models.Mitarbeiter;
import models.Mitarbeiter_Table;
import models.Ticket;
import models.Ticket_Table;
import views.Main_View;
import views.ticketBearbeitung_View;

public class Main_Controller implements ListSelectionListener {

	public static Database_Operations db = new Database_Operations();

	private Main_View MainView;
	private ticketBearbeitung_View TicketEditView;

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

		refreshTickets();
		refreshKunden();
		refreshMitarbeiter();
		
		refreshComboBoxen();

		// Zum Suchen in den Tabellen, bekommen die Comboboxen den Wert der Tabellenspalten
		MainView.setComboTicketSuche(Ticket.getColumnNames());
		MainView.setComboKundenSuche(Kunde.getColumnNames());
		MainView.setComboMitarbeiterSuche(Mitarbeiter.getColumnNames());

		
	
		
		this.MainView.setTabelle(tickets);
		this.MainView.setModel(kunden);
		this.MainView.setModel(mitarbeiter);

	}
	
	private void reload(){
		refreshTickets();
		refreshKunden();
		refreshMitarbeiter();
		
		refreshComboBoxen();
	}
	
	private void refreshComboBoxen(){
		// Zusatzdaten erstellen
		priorität = new AttributComboBox(db.getAttribut("prioritaet"));
		kategorie = new AttributComboBox(db.getAttribut("kategorie"));
		status = new AttributComboBox(db.getAttribut("status"));
		ComboBoxKunde = new ComboBoxModelKunde();
		ComboBoxMitarbeiter = new ComboBoxModelMitarbeiter();
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

	private void refreshMitarbeiter() {
		mitarbeiter.setList(db.getMitarbeiter());
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
			refreshMitarbeiter();
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
		MainView.viewButtonsAlle();
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
			MainView.setTabelle(gelöst);
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
			refreshTickets();
		}

	}

	// Neues Ticket eröffnen --> Fenster wird geöffnet und Comboboxen gefüllt!
	class ticketNewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			TicketEditView = new ticketBearbeitung_View();
			TicketEditView.TicketErstellen(new Ticket(), kategorie, priorität, ComboBoxKunde);
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

				db.ticketNew(tmpTicket);
				JOptionPane.showMessageDialog(null, "Ticket eröffnet!",
						"Erfolgreich", JOptionPane.PLAIN_MESSAGE);

				refreshTickets();
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
	class ticketEditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
			try{
				
				
				TicketEditView = new ticketBearbeitung_View();
				TicketEditView.TicketBearbeiten(tmpTicket, kategorie, priorität, status);
				TicketEditView.addListenerTicketSave(new EditTicketListener());
				
				} catch(Exception e){
						JOptionPane
								.showMessageDialog(MainView, "Ups! Da ging wohl etwas beim Öffnen des Ticket-Bearbeiten Fensters schief.");
					
				}
			}catch(Exception e){
				JOptionPane
				.showMessageDialog(MainView, "Bitte zu bearbeitendes Ticket auswählen!");
			}
			
	
		}
		
	}
	class EditTicketListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Ticket temp = TicketEditView.saveEditedTicket();
			
			if(temp.idStatus.equals("4")){
				int entscheidung = JOptionPane.showConfirmDialog(null,
                        "Ihr Ticket wird nun an das Level 1 zurückgeleitet!", "Sind Sie sicher?",
                        JOptionPane.YES_NO_OPTION);
				// 0 = Ja, 1= Nein
				if( entscheidung == 0){
				db.ticketGelöst(temp);
				}
				else return;
			}
			else{
				db.ticketSaveEdit(temp);
				JOptionPane.showMessageDialog(null, "Ticket geändert!",
						"Erfolgreich", JOptionPane.PLAIN_MESSAGE);
			}
			
			refreshTickets();
			TicketEditView.dispose();
		}
		
	}
	
	class ticketErfassenListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			try{
			Ticket tmpTicket = tickets.getTicketAtRow(MainView.getSelectedTicket());
			try{
				TicketEditView = new ticketBearbeitung_View();
				TicketEditView.TicketErfassen(tmpTicket, kategorie, priorität, ComboBoxMitarbeiter);
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
			
			db.ticketErfassen(temp);
			JOptionPane.showMessageDialog(null, "Ticket erfasst und Mitarbeiter zugewiesen!",
					"Erfolgreich", JOptionPane.PLAIN_MESSAGE);
			
			refreshTickets();
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
				MainView.setInfoLösung(!(tmpTicket.equals("")) ? tmpTicket.tmploesung : "-");
			
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

		}
	}
		
	
	// ################ Komboboxen für Ticket-Fenster

	@SuppressWarnings({ "serial", "rawtypes" })
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

	@SuppressWarnings({ "serial", "rawtypes" })
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

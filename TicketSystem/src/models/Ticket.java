package models;

public class Ticket{

	

	public String idTicket;

	public String erstellzeitpunkt;
	public String beschreibung;
	public String tmploesung;
	
	public String ersteller;
	public String idKunde;
	public String kunde;

	public String idKategorie;
	public String kategorie;
	public String idPrioritaet;
	public String prioritaet;
	public String idStatus;
	public String status;
	public String idLevel;
	public String level;

	public String idMitarbeiter;
	public String mitarbeiter;

	//Falls ein FAQ erstellt wird:
	public String idFAQ;
	

	public Ticket(String idTicket, String erstellzeitpunkt,
			String beschreibung, String tmploesung, String ersteller,
			String idKunde, String idKategorie, String kategorie,
			String idPrioritaet, String prioritaet, String idStatus,
			String status, String idLevel, String level, String idMitarbeiter) {
	
		this.idTicket = idTicket;
		this.erstellzeitpunkt = erstellzeitpunkt;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.ersteller = ersteller;
		this.idKunde = idKunde;
		this.idKategorie = idKategorie;
		this.kategorie = kategorie;
		this.idPrioritaet = idPrioritaet;
		this.prioritaet = prioritaet;
		this.idStatus = idStatus;
		this.status = status;
		this.idLevel = idLevel;
		this.level = level;
		this.idMitarbeiter = idMitarbeiter;
	}
	//Wenn ein FAQ erstellt wird:
	public Ticket(String idFAQ, String beschreibung, String tmploesung,
			String idKategorie, String kategorie, String idTicket, String idKunde, String idMitarbeiter) {
		this.idFAQ = idFAQ;
		this.idTicket = idTicket;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.idKunde = idKunde;
		this.idKategorie = idKategorie;
		this.kategorie = kategorie;
		this.idMitarbeiter = idMitarbeiter;
	}
	
	//Wenn ein Gelöstes Ticket erstellt wird:
	public Ticket(String idTicket, String erstellzeitpunkt,
			String beschreibung, String tmploesung, String ersteller,
			String idKunde, String kunde, String idKategorie, String kategorie,
			String idMitarbeiter, String mitarbeiter) {
	
		this.idTicket = idTicket;
		this.erstellzeitpunkt = erstellzeitpunkt;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.ersteller = ersteller;
		this.idKunde = idKunde;
		this.kunde = kunde;
		this.idKategorie = idKategorie;
		this.kategorie = kategorie;
		this.idMitarbeiter = idMitarbeiter;
		this.mitarbeiter = mitarbeiter;
	}
	

	// Konstruktur zum Erstellen eines Tickets für die neu-Anlage eines Tickets
	public Ticket(String beschr, String prio, String kat, String idK, String idM) {
		this.beschreibung = beschr;
		this.idPrioritaet = prio;
		this.idKunde = idK;
		this.idKategorie = kat;
		this.idMitarbeiter = idM;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	// Für die Daten in der Tabelle , nicht alle Daten verwendet -> restliche
	// Daten werden in Detail_Fenster angezeigt.
	public Object[] toJTableArray() {
		Object[] ticketAttributeArray = {

		this.idTicket, this.beschreibung, this.level, this.kategorie,
				this.prioritaet, this.status };
		return ticketAttributeArray;
	}

	public Object getValue(int col) {
		
		switch (col) {
		case 0:
			return this.idTicket;
		case 1:
			return this.beschreibung;
		case 2:
			return this.level;
		case 3:
			return this.kategorie;
		case 4:
			return this.prioritaet;
		case 5:
			return this.status;
		}
		return null;
	}

	// Spaltennamen für die Tabelle
	public static String[] getColumnNames() {

		String[] columnNames = { "ID", "Beschreibung", "Level", "Kategorie",
				"Priorität", "Status" };

		return columnNames;
	}
	
	//Spaltenname und Werte für FAQ-Tabelle
	public static String[] getFAQColumnNames() {

		String[] columnNames = { "FAQ", "Kategorie", "Problem", "Lösung"};

		return columnNames;
	}
	public Object getFAQValue(int col) {
		
		switch (col) {
		case 0:
			return this.idTicket;
		case 1:
			return this.kategorie;
		case 2:
			return this.beschreibung;
		case 3:
			return this.tmploesung;
		}
		return null;
	}
	
	//Spaltennamen und Werte für Gelöste-Tickets-Tabelle
	public static String[] getGelöstColumnNames() {
		String[] columnNames = { "Ticket", "Kategorie", "Problem", "Lösung",
				"Erstellt von", "Kunde", "Mitarbeiter"};

		return columnNames;
	}
	public Object getGelöstValue(int col) {
		
		switch (col) {
		case 0:
			return this.idTicket;
		case 1:
			return this.kategorie;
		case 2:
			return this.beschreibung;
		case 3:
			return this.tmploesung;
		case 4:
			return this.ersteller;
		case 5:
			return this.kunde;
		case 6:
			return this.mitarbeiter;
		
		}
		
		return null;
	}
	
	public String toString(){
		return this.idTicket;
	}
	

}

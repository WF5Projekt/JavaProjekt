package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ticket extends Database_Model {

	public String idKunde;
	public String idMitarbeiter;
	public String ersteller;
	
	//Daten Ticket
	public String idTicket;
	public String level;
	public String kategorie;
	public String prioritaet;
	public String status;
	public String beschreibung;
	public String tmploesung;
	public String erstellzeitpunkt;
	
	public String idPriorität;
	public String idKategorie;
	public String idLevel;
	public String idStatus;


	
	public Ticket(String idKunde, String idMitarbeiter, String ersteller, String idTicket,
			String level, String kategorie, String prioritaet, String status,
			String beschreibung, String tmploesung, String erstellzeitpunkt) {
		this.idKunde = idKunde;
		this.idMitarbeiter = idMitarbeiter;
		this.ersteller = ersteller;
		this.idTicket = idTicket;
		this.level = level;
		this.kategorie = kategorie;
		this.prioritaet = prioritaet;
		this.status = status;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.erstellzeitpunkt = erstellzeitpunkt;
	}

	// Konstruktur zum Erstellen eines Tickets für die neu-Anlage eines Tickets
	public Ticket(String beschr, String prio, String kat, String idK, String idM) {
		this.beschreibung = beschr;
		this.idPriorität = prio;
		this.idKunde = idK;
		this.idKategorie = kat;
		this.idMitarbeiter = idM;
	}

	// Rufe Kundentabelle von Datenbank ab und bilde Ticket-Array tickets
	public static ArrayList<Ticket> all() {

		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allTickets`";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Ticket-Abfrage)");
		}
		return tickets;
	}
	
	//Rufe nur Tickets von einem Kunden auf
	public static ArrayList<Ticket> allFromKunde(String idKunde) {

		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "call showallTickets('"+ idKunde +"','0')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler bei Ticket-Abfrage für Kunden-Tickets)");
		}
		return tickets;
	}
	//Rufe nur Tickets von einem Mitarbeiter auf
		public static ArrayList<Ticket> allFromMitarbeiter(String idMitarbeiter) {

			Connection con = getConnection();
			ArrayList<Ticket> tickets = new ArrayList<Ticket>();

			Statement query;
			try {
				query = con.createStatement();
				//showAllTickets liefert für Mitarb
				String sql = "call showallTickets('"+ idMitarbeiter +"', '1')";

				ResultSet result = query.executeQuery(sql);
				// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
				// mit Methode...
				while (result.next()) {
					tickets.add(getTicketsWithResultSet(result));
				}
				query.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Fehler bei Ticket-Abfrage für Mitarbeiter-Tickets)");
			}
			return tickets;
		}
	
	
	
	public static ArrayList<Ticket> search(String spalte, String suche){
		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();

			String sql = "call search( 'tickets', '" + spalte + "', '"+ suche +"')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fehler bei Ticket-Suche)");
		}
		return tickets;
			
	}	
	
	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Ticket
	private static Ticket getTicketsWithResultSet(ResultSet result) {

		Ticket newTicket = null;

		try {
			
			//Daten Ticket
			String idTicket = result.getString(1);
			String erstellzeitpunkt = result.getString(2);
			String beschreibung = result.getString(3);
			String tmploesung = result.getString(4);
			String ersteller = result.getString(5);
			String kategorie = result.getString(6);
			
			//Ticketdaten Kunde
			String idKunde = result.getString(7);

			String prioritaet = result.getString(9);
			String status = result.getString(10);
			String level = result.getString(11);

			//Ticketdaten Mitarbeiter
			String idMitarbeiter = result.getString(12);
			
			
			newTicket = new Ticket( idKunde,  idMitarbeiter,  ersteller,  idTicket,
					 level,  kategorie,  prioritaet,  status,
					 beschreibung,  tmploesung,  erstellzeitpunkt);

		} catch (SQLException e) {
			JOptionPane
					.showMessageDialog(null, "Fehler in Ticket_GetTicketWithResultSet");
		}

		return newTicket;

	}

	// Zur Darstellung in Tabelle , nicht alle Daten -> restliche Daten werden in Detail_Fenster angezeigt.
	public Object[] toJTableArray() {
		Object[] ticketAttributeArray = { 
				//Ticketdaten
				this.idTicket,
				this.beschreibung,
				this.level,
				this.kategorie,
				this.prioritaet,
				this.status
		};
		return ticketAttributeArray;
	}
	
	public static String[] getColumnNames(){
		
		String[] columnNames = {
				"ID",
				"Beschreibung",
				"Level",
				"Kategorie",
				"Priorität",
				"Status"
		};
		
		return columnNames;
	}
	

	// Speichern der Tabelle

	public void save() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void newTicket() {
	
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "call erstelleTicketJava( '"
							+ this.beschreibung +"', '"
							+ this.idKunde +"', '"
							+ this.idKategorie + "', '"
							+ this.idPriorität +"', '" 
							+ this.idMitarbeiter + "')";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	// Lösche Kunde
	public void delete() {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM ticket WHERE idTicket = '"+ this.idTicket + "';";
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

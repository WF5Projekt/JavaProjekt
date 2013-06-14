package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Database_Operations extends Database_Model {


	
	/*
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 * 
	 * TICKETS
	 * 
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 */
	// Methode wandelt die ResultSets in ein Objekt Ticket
	private static Ticket getTicketsWithResultSet(ResultSet result) {

		Ticket newTicket = null;

		try {

			// Daten Ticket
			String idTicket = result.getString(1);
			String erstellzeitpunkt = result.getString(2);
			String beschreibung = result.getString(3);
			String tmploesung = result.getString(4);
			String ersteller = result.getString(5);

			// Ticketdaten Kunde
			String idKunde = result.getString(6);

			String idKategorie = result.getString(8);
			String kategorie = result.getString(9);
			String idPrioritaet = result.getString(10);
			String prioritaet = result.getString(11);
			String idStatus = result.getString(12);
			String status = result.getString(13);
			String idLevel = result.getString(14);
			String level = result.getString(15);

			// Ticketdaten Mitarbeiter
			String idMitarbeiter = result.getString(16);

			newTicket = new  Ticket( idTicket,  erstellzeitpunkt,
					 beschreibung,  tmploesung,  ersteller,
					 idKunde,  idKategorie,  kategorie,
					 idPrioritaet,  prioritaet,  idStatus,
					 status,  idLevel,  level,  idMitarbeiter);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler in Ticket_GetTicketWithResultSet");
		}

		return newTicket;

	}
	private static Ticket getFAQticketsWithResultSet(ResultSet result) {

		Ticket newTicket = null;

		try {

			// Daten Ticket
			String idFAQ = result.getString(1);
			String beschreibung = result.getString(2);
			String tmploesung = result.getString(3);

			String idKategorie = result.getString(4);
			String kategorie = result.getString(5);
			String idTicket = result.getString(6);
			String idKunde = result.getString(7);
			String idMitarbeiter = result.getString(9);

			newTicket = new  Ticket( idFAQ,  beschreibung,  tmploesung,
					 idKategorie,  kategorie,  idTicket,  idKunde,  idMitarbeiter);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler in FAQTicket_GetTicketWithResultSet");
		}

		return newTicket;

	}
	private static Ticket getGelöstesTicketWithResultSet(ResultSet result) {

		Ticket newTicket = null;

		try {

			// Daten Ticket
			String idTicket = result.getString(1);
			String erstellzeitpunkt = result.getString(2);
			String beschreibung = result.getString(3);
			String tmploesung = result.getString(4);
			String ersteller = result.getString(5);
			String idKunde = result.getString(6);
			String kunde = result.getString(7);
			String idKategorie = result.getString(8);
			String kategorie = result.getString(9);
			String idMitarbeiter = result.getString(10);
			String mitarbeiter = result.getString(11);

			newTicket = new  Ticket( idTicket,  erstellzeitpunkt,
					 beschreibung,  tmploesung,  ersteller,
					 idKunde,  kunde,  idKategorie,  kategorie,
					 idMitarbeiter,  mitarbeiter);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler in Gelöstes-Ticket_GetTicketWithResultSet");
		}

		return newTicket;

	}
	
	// Gibt eine Liste aller Tickets zurück
	public ArrayList<Ticket> getTickets() {

		// DB verbinden
		Connection con = getConnection();

		// Liste der Tickets erstellen
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
	
	// Gibt eine Liste aller FAQ-Tickets zurück
	public ArrayList<Ticket> getFAQTickets() {

		// DB verbinden
		Connection con = getConnection();

		// Liste der Tickets erstellen
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allFAQtickets`";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getFAQticketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei FAQ-Ticket-Abfrage)");
		}
		return tickets;
	}
	
	// Gibt die Liste der Gelösten Tickets zurück
	public ArrayList<Ticket> getGelösteTickets() {

		// DB verbinden
		Connection con = getConnection();

		// Liste der Tickets erstellen
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "select * FROM `allgelöste`";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getGelöstesTicketWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showInputDialog("Fehler bei Gelöstes-Ticket-Abfrage)");
		}
		return tickets;
	}
	

	// Neues Ticket in Datenbank erstellen
	// gleichzeitig wird das neu erstellte Ticket an die Ticket-Table gegeben
	public Ticket ticketNew(Ticket t) {

		Connection con = getConnection();
		try {
			
			String query = "call erstelleTicketJava( '" + t.beschreibung
					+ "', '" + t.idKunde + "', '" + t.idKategorie + "', '"
					+ t.idPrioritaet + "')";


			Statement stmt = con.createStatement();
			int test = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
		
			
		
			query = "select * from `alltickets` where `idTicket` = '"+test +"'";
			
			ResultSet result = stmt.executeQuery(query);
			
			Ticket neuesTicket = null;
			while (result.next()) {
				neuesTicket = getTicketsWithResultSet(result);
			}
			
			stmt.close();
			con.close();

			return neuesTicket;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
		

	}
	
	
	
	public void ticketGelöst(Ticket t) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * idTicket, idMitarbeiter werden wieder getrennt
			 */
			String query = "call sp_unbindTicket(' " + t.idTicket + "', '"+ t.idMitarbeiter + "')";

			stmt.execute(query);
			
			t.idStatus = "4";
			//Ticket wird gespeichert
			query = "call sp_updateTicket(' " + t.idTicket + "', '"+ t.beschreibung + "', '"+ t.tmploesung + "', '"+ t.idKategorie
					+ "', '"+ t.idPrioritaet + "', '"+ t.idStatus + "', '"+ t.idLevel + "')";
			stmt.execute(query);
			
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	
	// Ticket in Datenbank speichern
	public void ticketSaveEdit(Ticket t) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * idTicket, beschreibung, tmploesung, idKategorie, idPrioritaet, idStatus, idLevel
			 */
			String tmpLoesung = "";
			if(t.tmploesung != null) tmpLoesung = t.tmploesung;
			
			String query = "call sp_updateTicket(' " + t.idTicket + "', '"+ t.beschreibung + "', '"+ tmpLoesung + "', '"+ t.idKategorie
					+ "', '"+ t.idPrioritaet + "', '"+ t.idStatus + "', '"+ t.idLevel + "')";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	// Ticket Erfassen
	public void ticketErfassen(Ticket t) {
			Connection con = getConnection();
			try {
				Statement stmt = con.createStatement();
				/*
				 * Ticket updaten, falls Kategorie oder Ähnliches geändert wurde
				 */
				String query = "call sp_updateTicket(' " + t.idTicket + "', '"+ t.beschreibung + "', '', '"+ t.idKategorie
						+ "', '"+ t.idPrioritaet + "', '"+ t.idStatus + "', '"+ t.idLevel + "')";
				
				stmt.execute(query);
				stmt.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

	public void ticketZumBearbeiten(Ticket t, Mitarbeiter user){
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			/*
			 * Ticket wird einem Mitarbeiter zugewiesen
			 */
			String query = "call sp_updateTicket(' " + t.idTicket + "', '"+ t.beschreibung + "', '', '"+ t.idKategorie
					+ "', '"+ t.idPrioritaet + "', '"+ t.idStatus + "', '"+ t.idLevel + "')";
			stmt.execute(query);
			stmt.close();
			
			stmt = con.createStatement();
			
			query = "call sp_bindTicket(' " + t.idTicket + "', '"+ user.idMitarbeiter + "')";
			
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	
	public void ticketAlsFAQ(Ticket t){
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			
			
			String query = "call newFAQ2(' " + t.idTicket + "', '"+ t.beschreibung + "', '" + t.tmploesung
			+ "', '"+ t.idKategorie + "')";
			
			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 * 
	 * KUNDEN
	 * 
	 * ######################################################################
	 * ######################################################################
	 * ######################################################################
	 */
	
	// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Kunde
		private static Kunde getCustomersWithResultSet(ResultSet result) {

			Kunde newCustomer = null;

			try {
				String idKunde = result.getString(1); // getString(1)
				String vorname = result.getString(2);
				String name = result.getString(3);
				String geburtstag  = result.getString(4);
				String strasse = result.getString(5);
				String hausnummer = result.getString(6);
				String plz = result.getString(7);
				String ort = result.getString(8);
				String idLand = result.getString(9);
				String land = result.getString(10);
				String idErreichbar = result.getString(11);
				String erreichbar = result.getString(12);
				String idAccount = result.getString(13);
				String account = result.getString(14);
				String passwort = result.getString(15);
				String email = result.getString(16);
				String telefon = result.getString(17);
				
				
				newCustomer = new Kunde ( idKunde, vorname, name,  geburtstag,  strasse,
						 hausnummer,  plz,  ort,  idLand, land, idErreichbar,
						 erreichbar,  idAccount,  account, passwort,  email,
						 telefon);

			} catch (SQLException e) {
				JOptionPane
						.showInputDialog("Fehler in Kunden_getCustomerWithResultSet");
			}

			return newCustomer;

		}
		
		
		// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
		public ArrayList<Kunde> getKunden() {

			Connection con = getConnection();
			ArrayList<Kunde> customers = new ArrayList<Kunde>();

			Statement sta;
			try {
				sta = con.createStatement();
				String sql = "select * FROM `allkunden`";
				
				ResultSet result = sta.executeQuery(sql);
		
				// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Customer
				// mit Methode...
				while (result.next()) {
					customers.add(getCustomersWithResultSet(result));
				}
				sta.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showInputDialog("Fehler bei Kunden-all()");
			}
			return customers;
		}
		
		
		// Speichern der Tabelle
		public void kundeSave(Kunde k) {
			Connection con = getConnection();
			try {
				Statement stmt = con.createStatement();
				String query = "call sp_updateKunde('"
						+ k.idKunde +"','"
						+ k.vorname+"','"
						+ k.name+"','"
						+ k.geburtstag+"','"
						+ k.strasse+"','"
						+ k.hausnummer+"','"
						+ k.ort+"','"
						+ k.plz+"','"
						+ k.account+"','"
						+ k.passwort+"','"
						+ k.email+"','"
						+ k.telefon+"','"
						+ k.idLand+"','"
						+ k.idErreichbar +"')";
				
				stmt.execute(query);
				stmt.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		// Lösche Kunde
		public void kundeDelete(Kunde k) {
			Connection con = getConnection();
			try {
				Statement stmt = con.createStatement();
				String query = "DELETE FROM kunde " + "WHERE idKunde = '"
								+ k.idKunde + "';";
				stmt.execute(query);
				stmt.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		//Lege neuen Kunden in Datenbank an
		public void kundeNew(Kunde k){
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
		
		/*
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 * 
		 * MITARBEITER
		 * 
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 */
		
		
		// Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Mitarbeiter
		private Mitarbeiter getMitarbeiterWithResultSet(ResultSet result) {

			Mitarbeiter newMitarbeiter = null;

			try {
				
				String idMitarbeiter= result.getString(1);				
				String name= result.getString(3);
				String vorname = result.getString(2);
				String geburt= result.getString(4);
				
				String strasse= result.getString(5);
				String hausnummer= result.getString(6);
				String plz= result.getString(7);
				String ort= result.getString(8);
				String idLand = result.getString(9);
				String land= result.getString(10);

				String idAbteilung= result.getString(11);
				String abteilung= result.getString(12);

				String idAccount= result.getString(13);
				String account= result.getString(14);
				String passwort = result.getString(15);
				String email= result.getString(16);
				String telefon= result.getString(17);
				String idLevel= result.getString(18);
				String level= result.getString(19);
				String idZuständigkeit = result.getString(20);
				String zuständigkeit = result.getString(21);
				
				newMitarbeiter = new Mitarbeiter( idMitarbeiter,  name,  vorname,
						 geburt,  strasse,  hausnummer,  plz,
						 ort,  idLand,  land,  idAbteilung,
						 abteilung,  idAccount,  account,
						 passwort,  email,  telefon,  idLevel,
						 level,  idZuständigkeit,  zuständigkeit);

			} catch (SQLException e) {
				JOptionPane
						.showInputDialog("Fehler in Mitarbeiter_getMitarbeiterWithResultSet");
			}

			return newMitarbeiter;

		}
		
		//Mitarbeiter wird beim Login durch den Account erstellt.
		public Mitarbeiter getMitarbeiterWithID(String idAcc) throws SQLException {
			Connection con = getConnection();
			Statement query;
			Mitarbeiter m = null;
			try {
				query = con.createStatement();

				String sql = "select * FROM `allmitarbeiter` WHERE idAccount = '"+ idAcc + "' LIMIT 1";

				ResultSet result = query.executeQuery(sql);
				// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Mitarbeiter
				// mit Methode...
				while (result.next()) {
					
					m = getMitarbeiterWithResultSet(result);				
				}
				query.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showInputDialog("Fehler bei Mitarbeiter By Account)");
			}
			return m;
		}

		//Login erstellt einen Mitarbeiter, welchen er mit dem richtigne Username+Passwort findet und dann erstellt.
		
		public Mitarbeiter login(String username, String pw){
			
			Mitarbeiter user = null;
			
			
			try {
				Connection con = getConnection();
				String ergebnis = "";
				
				Statement query = con.createStatement();
				String sql = "SELECT login_ma('"
						+ username + "','"
						+ pw + "')";

				ResultSet result = query.executeQuery(sql);

				while (result.next()) {
					ergebnis = result.getString(1);
				}
				query.close();
				con.close();
				
				//Kein User
				if (ergebnis.equals("fehler"))
				{
					JOptionPane.showMessageDialog(null,
							"User nicht vorhanden!", "Error",
							JOptionPane.ERROR_MESSAGE);
				} 
				//Falsches Passwort
				else if(ergebnis.equals("falsch"))
				{
					JOptionPane.showMessageDialog(null,
							"Passwort falsch!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				//Richtig, ID kam zurück, damit wird User erstellt
				else if(!ergebnis.equals("")){
					
					user = getMitarbeiterWithID(ergebnis);
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Fehler beim Login!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "Fehler bei LoginMethode...");

			}
			//Entweder der neue User oder NULL wird zurückgegeben. -> Siehe Login_Controller
			return user;

		}

		// Rufe Mitarbeitertabelle von Datenbank ab und bilde Mitarbeiter-Array mitarbeiter
		public ArrayList<Mitarbeiter> getMitarbeiter() {

			Connection con = getConnection();
			ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();

			Statement query;
			try {
				query = con.createStatement();
				String sql = "select * FROM `allmitarbeiter` ORDER BY idMitarbeiter";

				ResultSet result = query.executeQuery(sql);
				// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Mitarbeiter
				// mit Methode...
				while (result.next()) {
					mitarbeiter.add(getMitarbeiterWithResultSet(result));
				}
				query.close();
				con.close();
			} catch (SQLException e) {
				JOptionPane.showInputDialog("Fehler bei Mitarbeiter-all()");
			}
			return mitarbeiter;
		}

		// Speichern des Mitarbeiters2

		public void mitarbeiterSave(Mitarbeiter m) {
			Connection con = getConnection();
			try {
				Statement stmt = con.createStatement();
				String query = "call sp_updateMitarbeiter('"
						+ m.idMitarbeiter 	+ "','" 
						+ m.vorname 		+ "','"
						+ m.name 			+ "','"
						+ m.geburt			+ "','"
						+ m.idLand			+ "','"
						+ m.idAbteilung		+ "','"
						+ m.idLevel			+ "','"
						+ m.idZuständigkeit	+ "','"
						+ m.account			+ "','"
						+ m.passwort		+ "','"
						+ m.email			+ "','"
						+ m.telefon			+ "','"
						+ m.strasse			+ "','"
						+ m.hausnummer		+ "','"
						+ m.ort				+ "','"
						+ m.plz				+ "')";
		

				
				stmt.execute(query);
				stmt.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		// Lösche Kunde
		public void mitarbeiterDelete(String idMitarbeiter) {
			Connection con = getConnection();
			try {
				Statement stmt = con.createStatement();
				String query = "DELETE FROM mitarbeiter " + "WHERE idMitarbeiter = '"
								+ idMitarbeiter + "';";
				stmt.execute(query);
				stmt.close();
				con.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		/*
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 * 
		 * ATTRIBUTE
		 * 
		 * ######################################################################
		 * ######################################################################
		 * ######################################################################
		 */
		
		private static Attribut getAttributWithResultSet(ResultSet result) {
			Attribut a = null;

			try {

				String id = result.getString(1);
				String bezeichnung = result.getString(2);

				a = new Attribut(id, bezeichnung);

			} catch (SQLException e) {
				JOptionPane.showInputDialog("Fehler beim Erstellen des Attribut-Objekts");
			}

			return a;

		}
		public Vector getAttribut(String attribut) {
			Connection con = getConnection();
			
			Vector attribute = new Vector();
			
			Statement query;
			try {
				query = con.createStatement();
				String sql = "SELECT * FROM "+attribut+""; // Tabelle eintragen

				ResultSet result = query.executeQuery(sql);
				while (result.next()) {
					attribute.add(getAttributWithResultSet(result));
				}
				query.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return attribute;
		}
}

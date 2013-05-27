package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			String kategorie = result.getString(6);

			// Ticketdaten Kunde
			String idKunde = result.getString(7);

			String prioritaet = result.getString(9);
			String status = result.getString(10);
			String level = result.getString(11);

			// Ticketdaten Mitarbeiter
			String idMitarbeiter = result.getString(12);

			newTicket = new Ticket(idKunde, idMitarbeiter, ersteller, idTicket,
					level, kategorie, prioritaet, status, beschreibung,
					tmploesung, erstellzeitpunkt);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler in Ticket_GetTicketWithResultSet");
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

	// Rufe nur Tickets von einem Kunden auf
	public static ArrayList<Ticket> getTicketsKunde(String idKunde) {

		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			String sql = "call showallTickets('" + idKunde + "','0')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler bei Ticket-Abfrage für Kunden-Tickets)");
		}
		return tickets;
	}

	// Tickets von einem Mitarbeiter auf
	public static ArrayList<Ticket> getTicketsMitarbeiter(String idMitarbeiter) {

		Connection con = getConnection();
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Statement query;
		try {
			query = con.createStatement();
			// showAllTickets liefert für Mitarb
			String sql = "call showallTickets('" + idMitarbeiter + "', '1')";

			ResultSet result = query.executeQuery(sql);
			// Jede Abfrage = Eine Zeile -> Bilde aus der Zeile ein Ticket
			// mit Methode...
			while (result.next()) {
				tickets.add(getTicketsWithResultSet(result));
			}
			query.close();
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Fehler bei Ticket-Abfrage für Mitarbeiter-Tickets)");
		}
		return tickets;
	}
	
	// Neues Ticket in Datenbank erstellen
	public void ticketNew(Ticket t) {

		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "call erstelleTicketJava( '" + t.beschreibung
					+ "', '" + t.idKunde + "', '" + t.idKategorie + "', '"
					+ t.idPriorität + "', '" + t.idMitarbeiter + "')";

			stmt.execute(query);
			stmt.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	// Ticket in Datenbank speichern
	public void ticketSave(Ticket t) {
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

	// Lösche Ticket aus Datenbank
	public void ticketDelete(Ticket t) {
		Connection con = getConnection();
		try {
			Statement stmt = con.createStatement();
			String query = "DELETE FROM ticket WHERE idTicket = '" + t.idTicket
					+ "';";
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
				String name = result.getString(2);
				String geburtstag  = result.getString(3);
				String strasse = result.getString(4);
				String hausnummer = result.getString(5);
				String plz = result.getString(6);
				String ort = result.getString(7);
				String land = result.getString(8);
				
				String erreichbar = result.getString(9);
				String idAccount = result.getString(10);
				String account = result.getString(11);
				String email = result.getString(12);
				String telefon = result.getString(13);
				
				
				newCustomer = new Kunde ( idKunde,  name,  geburtstag,  strasse,
						 hausnummer,  plz,  ort,  land,
						 erreichbar,  idAccount,  account,  email,
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
				String query = "";
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
				String name= result.getString(2);
				String geburt= result.getString(3);
				
				String strasse= result.getString(4);
				String hausnummer= result.getString(5);
				String plz= result.getString(6);
				String ort= result.getString(7);
				String land= result.getString(8);

				String abteilung= result.getString(10);
				String idAbteilung= result.getString(9);
				String level= result.getString(16);
				String idLevel= result.getString(15);
				
				String email= result.getString(13);
				String telefon= result.getString(14);
				String account= result.getString(12);
				String idAccount= result.getString(11);
				
				newMitarbeiter = new Mitarbeiter( idMitarbeiter,  name,  geburt,
						 strasse,  hausnummer,  plz,  ort,
						 land,  abteilung,  idAbteilung,  level,
						 idLevel,  email,  telefon,  account,
						 idAccount);

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

		// Speichern der Tabelle

		public void mitarbeiterSave() {
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


}

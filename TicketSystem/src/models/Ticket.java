package models;



import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ticket extends Database_Model {

  

	public String idTicket;
    public String erstellzeitpunkt;
    public String beschreibung;
    public String tmploesung;
    public String status;
    public String kategorie;
    public String prioritaet;
    public String level;
    public String idKunde;
    public String vorname;
    public String nachname;


	public Ticket(String idTicket, String erstellzeitpunkt,
			String beschreibung, String tmploesung, String status,
			String kategorie, String prioritaet, String level, String idKunde,
			String vorname, String nachname) {
		this.idTicket = idTicket;
		this.erstellzeitpunkt = erstellzeitpunkt;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.status = status;
		this.kategorie = kategorie;
		this.prioritaet = prioritaet;
		this.level = level;
		this.idKunde = idKunde;
		this.vorname = vorname;
		this.nachname = nachname;
	}
    
	public Ticket(String erstellzeitpunkt,
			String beschreibung, String tmploesung, String status,
			String kategorie, String prioritaet, String level, String idKunde,
			String vorname, String nachname) {
		this.erstellzeitpunkt = erstellzeitpunkt;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
		this.status = status;
		this.kategorie = kategorie;
		this.prioritaet = prioritaet;
		this.level = level;
		this.idKunde = idKunde;
		this.vorname = vorname;
		this.nachname = nachname;
	}
    
	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array tickets
    public static ArrayList<Ticket> all() {
        
        Connection con = getConnection();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        Statement query;
        try {
            query = con.createStatement();
            String sql = "select * FROM `allTickets` ORDER BY idTicket";

            ResultSet result = query.executeQuery(sql);
            //Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter mit Methode...
            while (result.next()) {
                tickets.add(getTicketsWithResultSet(result));
            }
            query.close();
            con.close();
        } catch (SQLException e) {
        	JOptionPane.showInputDialog("Fehler bei Ticket-all()");
        }
        return tickets;
    }
    
    //Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Ticket
    private static Ticket getTicketsWithResultSet(ResultSet result) {
    	
        Ticket newTicket = null;
        
        try { 
           	String idTicket = result.getString("idTicket");
            String erstellzeitpunkt = result.getString("erstellzeitpunkt");
            String beschreibung = result.getString("beschreibung");
            String tmploesung = result.getString("tmploesung");
            String status = result.getString("status");
            String kategorie = result.getString("kategorie");
            String prioritaet = result.getString("prioritaet");
            String level = result.getString("level");
            String idKunde = result.getString("idKunde");
            String vorname = result.getString("vorname");
            String nachname = result.getString("nachname");
            
            newTicket = new Ticket( idTicket,  erstellzeitpunkt,
        			 beschreibung,  tmploesung,  status,
        			 kategorie,  prioritaet,  level,  idKunde,
        			 vorname,  nachname);
            
        } catch (SQLException e) {
        	JOptionPane.showInputDialog("Fehler in Ticket_GetTicketWithResultSet");
        }
        
        return newTicket;

    }
    // 
    public Object[] toJTableArray() {
        Object[] ticketAttributeArray = {		
        		this.idTicket,
				this.erstellzeitpunkt,
				this.beschreibung,
				this.tmploesung,
				this.status,
				this.kategorie,
				this.prioritaet,
				this.level,
				this.idKunde,
				this.vorname,
				this.nachname};
        return ticketAttributeArray;
    }
    
    // Speichern der Tabelle
    
    public void save() {
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "UPDATE ticket SET "
                    + "idTicket = '" + this.idTicket + "', "
                    + "beschreibung = '" + this.beschreibung + "', "
                    + "tmploesung = '" + this.tmploesung
                    + "WHERE idTicket = '" + this.idTicket +"';";
            
            stmt.execute(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void newTicket(){
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
    
    //Lösche Kunde
    public void delete(){
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "DELETE FROM ticket "
                    + "WHERE idTicket = '" + this.idTicket +"';";
            stmt.execute(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public String toString() {
    return this.beschreibung + " " + this.tmploesung;
    }
}



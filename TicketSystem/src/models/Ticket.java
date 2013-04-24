package models;



import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ticket extends Database_Model {

    public String idTicket;
    public String beschreibung;
    public String tmploesung;



    public Ticket(String idTicket, String beschreibung, String tmploesung) {
		this.idTicket = idTicket;
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
	}
    
	public Ticket(String beschreibung, String tmploesung) {
		this.beschreibung = beschreibung;
		this.tmploesung = tmploesung;
	}


	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array tickets
    public static ArrayList<Ticket> all() {
        
        Connection con = getConnection();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        
        Statement query;
        try {
            query = con.createStatement();
            String sql = "select * FROM `ticket` ORDER BY idTicket";

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
            String beschreibung = result.getString("beschreibung");
            String tmploesung = result.getString("tmploesung");
            
            newTicket = new Ticket(idTicket, beschreibung, tmploesung);
            
        } catch (SQLException e) {
        	JOptionPane.showInputDialog("Fehler in Ticket_GetTicketWithResultSet");
        }
        
        return newTicket;

    }
    // 
    public Object[] toJTableArray() {
        Object[] ticketAttributeArray = {this.idTicket, this.beschreibung, this.tmploesung};
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



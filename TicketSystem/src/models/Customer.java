package models;



import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Customer extends Database_Model {

    public String idKunde;
    public String nachname;
    public String vorname;



    public Customer(String idKunde, String nachname, String vorname) {
		this.idKunde = idKunde;
		this.nachname = nachname;
		this.vorname = vorname;
	}
    
	public Customer(String nachname, String vorname) {
		this.nachname = nachname;
		this.vorname = vorname;
	}


	// Rufe Kundentabelle von Datenbank ab und bilde Customer-Array customers
    public static ArrayList<Customer> all() {
        
        Connection con = getConnection();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        Statement query;
        try {
            query = con.createStatement();
            String sql = "select * FROM `kunde` ORDER BY idKunde";

            ResultSet result = query.executeQuery(sql);
            //Jede Abfrage = Eine Zeile -> Bilde aus der Zeile einen Cusomter mit Methode...
            while (result.next()) {
                customers.add(getCustomersWithResultSet(result));
            }
            query.close();
            con.close();
        } catch (SQLException e) {
        	JOptionPane.showInputDialog("Fehler bei Kunden-all()");
        }
        return customers;
    }
    
    //Methode wandelt ein ResultSet (eine Zeile) in ein Objekt Kunde
    private static Customer getCustomersWithResultSet(ResultSet result) {
    	
        Customer newCustomer = null;
        
        try { 
            String idKunde = result.getString("idKunde");
            String nachname = result.getString("nachname");
            String vorname = result.getString("vorname");
            newCustomer = new Customer(idKunde, nachname, vorname);
            
        } catch (SQLException e) {
        	JOptionPane.showInputDialog("Fehler in Kunden_getCustomerWithResultSet");
        }
        
        return newCustomer;

    }
    // 
    public Object[] toJTableArray() {
        Object[] customerAttributeArray = {this.idKunde, this.nachname, this.vorname};
        return customerAttributeArray;
    }
    
    // Speichern der Tabelle
    
    public void save() {
        Connection con = getConnection();
        try {
            Statement stmt = con.createStatement();
            String query = "UPDATE kunde SET "
                    + "idKunde = '" + this.idKunde + "', "
                    + "name = '" + this.nachname + "', "
                    + "surname = '" + this.vorname
                    + "WHERE idKunde = '" + this.idKunde +"';";
            
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
            String query = "DELETE FROM kunde "
                    + "WHERE idKunde = '" + this.idKunde +"';";
            stmt.execute(query);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public String toString() {
    return this.nachname + " " + this.vorname;
    }
}



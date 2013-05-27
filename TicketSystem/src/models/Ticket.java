package models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ticket{

	public String idKunde;
	public String idMitarbeiter;
	public String ersteller;

	// Daten Ticket
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

	public Ticket(String idKunde, String idMitarbeiter, String ersteller,
			String idTicket, String level, String kategorie, String prioritaet,
			String status, String beschreibung, String tmploesung,
			String erstellzeitpunkt) {
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
	
	public String toString(){
		return this.idTicket;
	}

}

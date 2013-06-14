package models;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Kunde_Table extends AbstractTableModel {

	
	private String[] columnNames = Kunde.getColumnNames();
	private ArrayList<Kunde> kunden;
	private ArrayList<Kunde> backup;
	
	public ArrayList<Kunde> getArray(){
		return this.kunden;
	}
	
	//backup-liste wird nur bei der Datenbankabfrage aller Kunden gefüllt, somit immer alle Kunden enthalten
	//kunden-liste wird zum filtern genutzt.
	public void setList(ArrayList<Kunde> kunden){
		this.kunden = kunden;
		this.backup = kunden;
		fireTableDataChanged();
	}
	//Reset setzt das Backup in die Tabelle.
	public void reset(){
		this.kunden = backup;
		fireTableDataChanged();
	}
	
	//Returned Backup, weil dort immer die komplette Liste enthalten ist.
	public ArrayList<Kunde> getList(){
		return this.kunden;
	}
	
	//Search filtert das "kunden"-Array
	public void searchKunde(String spalte, String suche){
		
		suche = suche.trim().toUpperCase();
		
		if (!(suche.equals("") || spalte.equals(""))) {
			

			ArrayList<Kunde> searchList = new ArrayList<Kunde>();
			
			for (Kunde k : backup) {
				switch (spalte) {
					case "ID":
						if (k.idKunde.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Name":
						if (k.idKunde.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Geburtstag":
						if (k.idKunde.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Adresse":
						if (k.getAdresse().toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Land":
						if (k.land.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Erreichbarkeit":
						if (k.erreichbar.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "E-Mail":
						if (k.email.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Telefon":
						if (k.telefon.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
					case "Username":
						if (k.account.toUpperCase().matches(
								"(.*)" + suche + "(.*)"))
							searchList.add(k);
					break;
				}
			}
			this.kunden = searchList;
		} else {
			//bei leerem Suchfeld werden wieder alle Daten angezeigt.
			reset();
		}
		fireTableDataChanged();
	}
	
	public Kunde getKundeWithID(String idKunde){
		Kunde tmpKunde = new Kunde();
		for (Kunde k : backup)
				if(k.idKunde.matches(idKunde.trim()))
					tmpKunde = k;
		return tmpKunde;
	}
	
	public Kunde getKundeAtRow(int row) {
		return kunden.get(row);
	}

	public int getRowOfKunde(Kunde c) {
		return kunden.indexOf(c);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return kunden.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return kunden.get(row).getValue(col);
	}

}

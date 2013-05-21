package models;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Mitarbeiter_Table extends AbstractTableModel{
	
	private String[] columnNames = { 
			"ID", 
			"Name", 
			"Geburtstag", 
			"Straße",
			"Hausnummer", 
			"PLZ", 
			"Ort",
			"Land",
			"Abteilung", 
			"Level",
			"E-Mail",
			"Telefon"
	};

	
	private Object[][] data = {};
	private ArrayList<Mitarbeiter> mitarbeiter;

	// Refresh der Daten für die Tabelle
		public void refreshData() {
			try {
				mitarbeiter = Mitarbeiter.all();
				data = new Object[mitarbeiter.size()][];
				for (int i = 0; i < mitarbeiter.size(); i++) {
					Mitarbeiter tmp = mitarbeiter.get(i);
					data[i] = tmp.toJTableArray();
				}
				this.fireTableDataChanged();
			} catch (Exception e) {
				JOptionPane.showInputDialog("Fehler in Refresh_Data Mitarbeiter");
			}
		}
		
		public void searchData(String spalte, String suche){
			try{
				mitarbeiter = Mitarbeiter.search(spalte, suche);
				data = new Object[mitarbeiter.size()][];
				for (int i = 0; i < mitarbeiter.size(); i++) {
					Mitarbeiter tmp = mitarbeiter.get(i);
					data[i] = tmp.toJTableArray();
				}
				this.fireTableDataChanged();	
			}catch( Exception e){
				JOptionPane.showInputDialog("Fehler bei Ticket Suche");
			}
		}
		
		public Mitarbeiter getMitarbeiterWithID(String idMitarbeiter){
			
			
			int index = -1;

		    for (int i = 0; (i < mitarbeiter.size()) && (index == -1); i++) {
		        if (mitarbeiter.get(i).idMitarbeiter.equals(idMitarbeiter)) {
		            index = i;
		        }
		    }
		    
		    if(index == -1){
		    	return null;
		    }
		    else{
		    	return mitarbeiter.get(index);
		    }
			
			
		}
		
		// AbstractTable bietet automatisch folgende Funktionen

		public Mitarbeiter getEmployeeAtRow(int row) {
			return mitarbeiter.get(row);
		}

		public int getRowOfEmployee(Mitarbeiter c) {
			return mitarbeiter.indexOf(c);
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

}

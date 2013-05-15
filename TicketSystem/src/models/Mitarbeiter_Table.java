package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Mitarbeiter_Table extends AbstractTableModel{
	
	private String[] columnNames = { 
			"ID", 
			"Vorname", 
			"Nachname", 
			"Abteilung", 
			"Geb.Datum", 
			"E-Mail", 
			"Telefonnr", 
			"Username", 
			"Standort"
	};
	private Object[][] data = {};
	private ArrayList<Mitarbeiter> employees;

	// Refresh der Daten für die Tabelle
		public void refreshData() {
			try {
				employees = Mitarbeiter.all();
				data = new Object[employees.size()][];
				for (int i = 0; i < employees.size(); i++) {
					Mitarbeiter c = employees.get(i);
					data[i] = c.toJTableArray();
				}
				this.fireTableDataChanged();
			} catch (Exception e) {
				JOptionPane.showInputDialog("Fehler in Mitarbeiter_Table");
			}
		}
		
		public void searchData(String spalte, String suche){
			try{
				employees = Mitarbeiter.search(spalte, suche);
				data = new Object[employees.size()][];
				for (int i = 0; i < employees.size(); i++) {
					Mitarbeiter mitarbeiter = employees.get(i);
					data[i] = mitarbeiter.toJTableArray();
				}
				this.fireTableDataChanged();	
			}catch( Exception e){
				JOptionPane.showInputDialog("Fehler bei Ticket Suche");
			}
		}
		// AbstractTable bietet automatisch folgende Funktionen

		public Mitarbeiter getEmployeeAtRow(int row) {
			return employees.get(row);
		}

		public int getRowOfEmployee(Mitarbeiter c) {
			return employees.indexOf(c);
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

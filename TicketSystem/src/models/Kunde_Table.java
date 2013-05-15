package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Kunde_Table extends AbstractTableModel {

	private String[] columnNames = { "ID", "Nachname", "Vorname" };
	private Object[][] data = {};
	private ArrayList<Kunde> customers;

	// Refresh der Daten f�r die Tabelle
	public void refreshData() {
		try {
			customers = Kunde.all();
			data = new Object[customers.size()][];
			for (int i = 0; i < customers.size(); i++) {
				Kunde c = customers.get(i);
				data[i] = c.toJTableArray();
			}
			this.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showInputDialog("Fehler in Kunden_Table");
		}
	}

	// AbstractTable bietet automatisch folgende Funktionen

	public Kunde getCustomerAtRow(int row) {
		return customers.get(row);
	}

	public int getRowOfCustomer(Kunde c) {
		return customers.indexOf(c);
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
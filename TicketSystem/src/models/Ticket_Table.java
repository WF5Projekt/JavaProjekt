package models;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Ticket_Table extends AbstractTableModel {

	private String[] columnNames = {
			"Status",
			"Ticketlevel",
			"Kategorie",
			"Priorität",
			"Beschreibung"
			
	};
	private Object[][] data = {};
	private ArrayList<Ticket> tickets;

	// Refresh der Daten für die Tabelle
	public void refreshData() {
		try {
			tickets = Ticket.all();
			data = new Object[tickets.size()][];
			for (int i = 0; i < tickets.size(); i++) {
				Ticket ticket = tickets.get(i);
				data[i] = ticket.toJTableArray();
			}
			this.fireTableDataChanged();
		} catch (Exception e) {
			JOptionPane.showInputDialog("Fehler in Ticket_Table");
		}
	}

	// AbstractTable bietet automatisch folgende Funktionen

	public Ticket getTicketAtRow(int row) {
		return tickets.get(row);
	}

	public int getRowOfTicket(Ticket ticket) {
		return tickets.indexOf(ticket);
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

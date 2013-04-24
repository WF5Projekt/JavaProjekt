package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.Customer_Table;
import models.Ticket_Table;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class Tab_View extends JPanel {

	private JTable table;
	private JPanel tab;
	private String titel = "Kunden";
	
	public Tab_View(String titel) {

		tab = new JPanel();
		tab.setBorder(null);
		tab.setBackground(Color.LIGHT_GRAY);
		this.titel = titel;
		
		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBorder(null);
		
		scrollPane.setViewportView(table);
		tab.setLayout(new BorderLayout(0, 0));
		tab.add(scrollPane);
		
		
	}
	//SetModel legt die verknüpfte abstrakte Tabelle da (z.B. CustomerTableModel)

	public void setModel(Customer_Table customerTable) {
		table.setModel(customerTable);
	}
	
	public JPanel getTab(){
		return this.tab;
	}
	
	public String getTitel(){
		return this.titel;
	}

	public void setModel(Ticket_Table ticketTable) {
		table.setModel(ticketTable);
		
	}
}

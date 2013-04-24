package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.Customer_Table;
import java.awt.GridLayout;


@SuppressWarnings("serial")
public class Tab_View extends JPanel {

	private JTable table;
	private JPanel tab;
	private String titel = "Kunden";
	
	public Tab_View(String titel) {

		tab = new JPanel();
		this.titel = titel;
		
		tab.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		
		scrollPane.setViewportView(table);
		
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
}

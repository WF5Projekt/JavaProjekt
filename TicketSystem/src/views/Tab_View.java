package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import models.Customer_Table;
import models.Ticket_Table;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Tab_View extends JPanel {

	private JTable table;
	private JPanel tab;
	private String titel;
	private JPanel panel;
	private JButton btn_Add;
	private JButton btn_Refresh;
	private JPanel panel_1;
	
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
		
		panel = new JPanel();
		tab.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn_Refresh = new JButton("Aktualisieren");
		panel_1.add(btn_Refresh);
		
		btn_Add = new JButton();
		panel_1.add(btn_Add);
		
		
	}
	public void addListenerButton_Add(ActionListener listenForButton_add){
		btn_Add.addActionListener(listenForButton_add);
	}
	public void addListenerButton_Refresh(ActionListener listenForButton_refresh){
		btn_Refresh.addActionListener(listenForButton_refresh);
	}
	
	//SetModel legt die verknüpfte abstrakte Tabelle da (z.B. CustomerTableModel)

	public void setModel(Customer_Table customerTable) {
		table.setModel(customerTable);
		btn_Add.setText("Neuer Kunde");
	}
	
	public JPanel getTab(){
		return this.tab;
	}
	
	public String getTitel(){
		return this.titel;
	}

	public void setModel(Ticket_Table ticketTable) {
		table.setModel(ticketTable);
		btn_Add.setText("Neues Ticket");
	}
}

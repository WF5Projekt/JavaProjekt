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
import javax.swing.UIManager;
import java.awt.Font;


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
 
		tab.setBackground(Color.DARK_GRAY);
		this.titel = titel;
		
		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setSelectionBackground(new Color(204, 204, 204));
		table.setGridColor(Color.LIGHT_GRAY);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(null);
		
		scrollPane.setViewportView(table);
		tab.setLayout(new BorderLayout(0, 0));
		tab.add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		tab.add(panel, BorderLayout.WEST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn_Refresh = new JButton("Aktualisieren");
		btn_Refresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Refresh.setBackground(Color.LIGHT_GRAY);
		btn_Refresh.setForeground(Color.DARK_GRAY);
		btn_Refresh.setBorder(UIManager.getBorder("Button.border"));
		panel_1.add(btn_Refresh);
		
		btn_Add = new JButton();
		btn_Add.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Add.setBackground(Color.LIGHT_GRAY);
		btn_Add.setForeground(Color.DARK_GRAY);
		btn_Add.setBorder(UIManager.getBorder("Button.border"));
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

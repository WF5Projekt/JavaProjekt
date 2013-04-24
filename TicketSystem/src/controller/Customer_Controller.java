package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.Tab_View;
import models.Customer_Table;


public class Customer_Controller {

	private Customer_Table CustomerTable;
	private Tab_View CustomerTab;
	
	
	public Customer_Controller(){
		
		CustomerTable = new Customer_Table();
		CustomerTab = new Tab_View("Kunden");
		


		this.CustomerTab.addListenerButton_Add(new addButtonListener());
		this.CustomerTab.addListenerButton_Refresh(new refreshButtonListener());
		
		CustomerTab.setModel(CustomerTable);
		
		try{
			CustomerTable.refreshData();
			
		} catch(Exception e){
			JOptionPane.showInputDialog("Fehler bei erstem Laden der Kunden-Daten");
		}
    }
	public Tab_View getTab(){
		return this.CustomerTab;
	}
	
	class refreshButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CustomerTable.refreshData();
		}
		
	}
	
	class addButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(null, "Kunde anlegen", "Hinweis", JOptionPane.OK_CANCEL_OPTION);
		}

	}
}

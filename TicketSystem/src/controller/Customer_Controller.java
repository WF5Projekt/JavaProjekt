package controller;

import javax.swing.JOptionPane;

import views.Tab_View;
import models.Customer_Table;


public class Customer_Controller {

	private Customer_Table CustomerTable;
	private Tab_View CustomerTab;
	
	
	public Customer_Controller(){
		
		CustomerTable = new Customer_Table();
		CustomerTab = new Tab_View("Kunden");
		
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
	
	
}

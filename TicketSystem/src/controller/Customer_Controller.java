package controller;

import views.Tab_View;
import models.Customer_Table;


public class Customer_Controller {

	private Customer_Table CustomerTable;
	private Tab_View CustomerTab;
	
	
	public Customer_Controller(){
		CustomerTable = new Customer_Table();
		CustomerTab = new Tab_View("Kunden");
		
		CustomerTab.setModel(CustomerTable);
		
		CustomerTable.refreshData();
		
    }
	public Tab_View getTab(){
		return this.CustomerTab;
	}
	
	
}

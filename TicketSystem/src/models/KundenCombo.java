package models;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


public class KundenCombo extends DefaultComboBoxModel {
	
	public ArrayList<Kunde> kunden;
	private int index = -1;

	public void setArray(ArrayList<Kunde> kunden){
		this.kunden = kunden;
	}

	public ArrayList<Kunde> getKunden() {
		return this.kunden;
	}
	
	public Object[] getArray(){
		return this.kunden.toArray();
	}
	@Override
	public int getSize() {
		return kunden.size();
	}

	@Override
	public String getElementAt(int index) {
		return kunden.get(index).toString();
	}

	public Kunde getObjectAt(int index) {
		return kunden.get(index);
	}
	
	
	
}


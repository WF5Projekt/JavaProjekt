package models;

import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import models.Mitarbeiter;

public class MitarbeiterCombo extends DefaultComboBoxModel {
	
	private ArrayList<Mitarbeiter> mitarbeiter;
	private int index = -1;

	public void setArray(ArrayList<Mitarbeiter> mitarbeiter){
		this.mitarbeiter = mitarbeiter;
	}

	public ArrayList<Mitarbeiter> getMitarbeiter() {
		return this.mitarbeiter;
	}
	public Attribut[] getMitarbeiterArray(){
		return (Attribut[]) this.mitarbeiter.toArray();
	}

	@Override
	public int getSize() {
		return mitarbeiter.size();
	}

	@Override
	public String getElementAt(int index) {
		return mitarbeiter.get(index).toString();
	}

	public Mitarbeiter getObjectAt(int index) {
		return mitarbeiter.get(index);
	}

}
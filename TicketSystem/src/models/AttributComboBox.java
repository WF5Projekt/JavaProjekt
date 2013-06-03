package models;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class AttributComboBox extends DefaultComboBoxModel<String>{

	private ArrayList<Attribut> attribute;
	private int index = -1;
	
	public AttributComboBox(ArrayList<Attribut> attribute){
		this.attribute = attribute;
	}
	
	public ArrayList<Attribut> getAttribute(){
		return this.attribute;
	}
	@Override
	public int getSize() {
		return attribute.size();
	}

	@Override
	public String getElementAt(int index) {
		return attribute.get(index).toString();
	}
	public Attribut getObjectAt(int index){
		return attribute.get(index);
	}


	
}

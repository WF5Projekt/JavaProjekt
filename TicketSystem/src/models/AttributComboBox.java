package models;

import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class AttributComboBox extends DefaultComboBoxModel{
	
	//neuer Vector wird erstellt
	private Vector<Attribut> attribute = new Vector<Attribut>();


	public void setArray(Vector<Attribut> attribute){
		this.attribute = attribute;
	}
	
	public Vector<Attribut> getArray(){
		return this.attribute;
	}
	@Override
	public int getSize() {
		return attribute.size();
	}
	
	@Override
	public int getIndexOf(Object arg0){
		int index = -1;
		for(int i = 0; i<attribute.size(); i++){
			if(	attribute.elementAt(i).getID().equals(arg0)){
				index = i;
			}
		}
		return index;
		
	}

	@Override
	public Attribut getElementAt(int index) {
		return attribute.elementAt(index);
	}



	
}

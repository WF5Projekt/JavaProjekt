package models;


public class Attribut{

	public String id;
	public String bezeichnung;

	public Attribut(String id, String bezeichnung) {
		this.id = id;
		this.bezeichnung = bezeichnung;
	}
	
	public Object[] toArray(){
			Object[] array = { this.id, this.bezeichnung};
			return array;	
	}
	
	public String getID(){
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.id + " - " + this.bezeichnung;
	}
}

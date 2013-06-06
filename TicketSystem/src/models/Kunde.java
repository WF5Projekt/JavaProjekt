package models;

public class Kunde{

	public String idKunde;
	public String name;
	public String geburtstag;
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public String land;
	
	public String erreichbar;
	public String idAccount;
	public String account;
	public String email;
	public String telefon;

	public Kunde(String idKunde, String name, String geburtstag, String strasse,
			String hausnummer, String plz, String ort, String land,
			String erreichbar, String idAccount, String account, String email,
			String telefon) {
		this.idKunde = idKunde;
		this.geburtstag = geburtstag;
		this.name = name;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.erreichbar = erreichbar;
		this.idAccount = idAccount;
		this.account = account;
		this.email = email;
		this.telefon = telefon;
	}

	public Kunde() {
		// TODO Auto-generated constructor stub
	}

	public String getAdresse(){
		return this.strasse +" "+ this.hausnummer + " - " + this.plz + " " + this.ort;
	}
	
	public Object[] toJTableArray() {
		Object[] kundenAttributeArray = { 
				this.idKunde,
				this.name,
				this.geburtstag,
				this.getAdresse(),
				this.land,
				this.erreichbar,
				this.email,
				this.telefon,
				this.account	
		};
		return kundenAttributeArray;
	}
	
	public Object getValue(int col){
		switch (col) {
		case 0:
			return this.idKunde;
		case 1:
			return this.name;
		case 2:
			return this.geburtstag;
		case 3:
			return this.getAdresse();
		case 4:
			return this.land;
		case 5:
			return this.erreichbar;
		case 6:
			return this.email;
		case 7:
			return this.telefon;
		case 8:
			return this.account;
		}
		return null;
	}
		
	public static String[] getColumnNames(){
		String[] columnNames ={
			"ID",
			"Name",
			"Geburtstag",
			"Adresse",
			"Land",
			"Erreichbarkeit",
			"E-Mail",
			"Telefon",
			"Username"
		};
		return columnNames;
	}
	
	public String toString(){
		return this.idKunde + "-" + this.name;
	}
	public String toID(){
		return this.idKunde;
	}
}

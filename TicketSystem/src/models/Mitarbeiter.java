package models;

public class Mitarbeiter extends Database_Model {
	
	public String idMitarbeiter;
	public String name;
	public String geburt;
	
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public String land;

	public String abteilung;
	public String idAbteilung;
	public String level;
	public String idLevel;
	public String idZuständigkeit;
	public String zuständigkeit;
	
	public String email;
	public String telefon;
	public String account;
	public String idAccount;
	
	

	public Mitarbeiter(String idMitarbeiter, String name, String geburt,
			String strasse, String hausnummer, String plz, String ort,
			String land, String abteilung, String idAbteilung, String level,
			String idLevel, String idZuständigkeit, String zuständigkeit, String email, String telefon, String account,
			String idAccount) {
		this.idMitarbeiter = idMitarbeiter;
		this.name = name;
		this.geburt = geburt;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.land = land;
		this.abteilung = abteilung;
		this.idAbteilung = idAbteilung;
		this.level = level;
		this.idLevel = idLevel;
		this.idZuständigkeit = idZuständigkeit;
		this.zuständigkeit = zuständigkeit;
		this.email = email;
		this.telefon = telefon;
		this.account = account;
		this.idAccount = idAccount;
	}
	
	public Mitarbeiter() {
	}
	
	public String getAdresse(){
		return this.strasse + " "+ this.hausnummer + " - "+ this.plz + " " + this.ort;
	}
	
	//
	public Object[] toJTableArray() {
		Object[] mitarbeiterAttributeArray = { 	
				this.idMitarbeiter,
				this.name,
				this.getAdresse(),
				this.land,
				this.abteilung,
				this.level,
				this.zuständigkeit,
				this.email,
				this.telefon,
				this.account
		};
		return mitarbeiterAttributeArray;
	}
	
	public static String[] getColumnNames(){
		String[] columnNames = { 
				"ID", 
				"Name",  
				"Adresse",
				"Land",
				"Abteilung",
				"Level",
				"Zuständig für",
				"E-Mail",
				"Telefon",
				"Username"
		};
		return columnNames;

	}

	public Object getValue(int col){
		switch (col) {
		case 0:
			return this.idMitarbeiter;
		case 1:
			return this.name;
		case 2:
			return this.getAdresse();
		case 3:
			return this.land;
		case 4:
			return this.abteilung;
		case 5:
			return this.level;
		case 6:
			return this.zuständigkeit;
		case 7:
			return this.email;
		case 8:
			return this.telefon;
		case 9:
			return this.account;
		}
		return null;
	}
	
	

	
	@Override
	public String toString() {
		return this.name;
	}
}

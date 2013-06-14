package models;

public class Mitarbeiter extends Database_Model {
	


	public String idMitarbeiter;
	public String name;
	public String vorname;
	public String geburt;
	
	public String strasse;
	public String hausnummer;
	public String plz;
	public String ort;
	public String idLand;
	public String land;

	public String idAbteilung;
	public String abteilung;
	public String idAccount;
	public String account;
	public String passwort;
	public String email;
	public String telefon;
	public String idLevel;
	public String level;
	public String idZuständigkeit;
	public String zuständigkeit;
	
	public Mitarbeiter(String idMitarbeiter, String name, String vorname,
			String geburt, String strasse, String hausnummer, String plz,
			String ort, String idLand, String land, String idAbteilung,
			String abteilung, String idAccount, String account,
			String passwort, String email, String telefon, String idLevel,
			String level, String idZuständigkeit, String zuständigkeit) {

		this.idMitarbeiter = idMitarbeiter;
		this.name = name;
		this.vorname = vorname;
		this.geburt = geburt;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.plz = plz;
		this.ort = ort;
		this.idLand = idLand;
		this.land = land;
		this.idAbteilung = idAbteilung;
		this.abteilung = abteilung;
		this.idAccount = idAccount;
		this.account = account;
		this.passwort = passwort;
		this.email = email;
		this.telefon = telefon;
		this.idLevel = idLevel;
		this.level = level;
		this.idZuständigkeit = idZuständigkeit;
		this.zuständigkeit = zuständigkeit;
	}




	public Mitarbeiter() {
	}
	
	public String getAdresse(){
		return this.strasse + " "+ this.hausnummer + " - "+ this.plz + " " + this.ort;
	}
	public String getName(){
		return this.vorname + " " + this.name;
	}
	//
	public Object[] toJTableArray() {
		Object[] mitarbeiterAttributeArray = { 	
				this.idMitarbeiter,
				this.getName(),
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
			return this.getName();
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
		return this.getName();
	}
}

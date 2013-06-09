package models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Mitarbeiter_Table extends AbstractTableModel {

	private String[] columnNames = Mitarbeiter.getColumnNames();
	
	private ArrayList<Mitarbeiter> mitarbeiter;
	private ArrayList<Mitarbeiter> backup;

	public ArrayList<Mitarbeiter> getArray() {
		return this.mitarbeiter;
	}

	public void setList(ArrayList<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
		this.backup = mitarbeiter;
		fireTableDataChanged();
	}

	public void reset() {
		this.mitarbeiter = backup;
		fireTableDataChanged();
	}

	public ArrayList<Mitarbeiter> getList() {
		return this.mitarbeiter;
	}

	// Search filtert das "mitarbeiter"-Array
	public void searchMitarbeiter(String spalte, String suche) {

		suche = suche.trim().toUpperCase();

	

		if (!(suche.equals("") || spalte.equals(""))) {
			

			ArrayList<Mitarbeiter> searchList = new ArrayList<Mitarbeiter>();
			
			for (Mitarbeiter m : backup) {
				switch (spalte) {
				case "ID":
					if (m.idMitarbeiter.toUpperCase().matches(
							"(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Name":
					if (m.name.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Adresse":
					if (m.getAdresse().toUpperCase()
							.matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Land":
					if (m.land.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Abteilung":
					if (m.land.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Level":
					if (m.level.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Zuständigkeit":
					if(m.zuständigkeit.toUpperCase().matches("(.*)" + suche +"(.*)"))
						searchList.add(m);
				case "E-Mail":
					if (m.email.toUpperCase().matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Telefon":
					if (m.telefon.toUpperCase()
							.matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				case "Username":
					if (m.account.toUpperCase()
							.matches("(.*)" + suche + "(.*)"))
						searchList.add(m);
					break;
				default:
					break;
				}
			}
			this.mitarbeiter = searchList;
		} else {
			// bei leerem Suchfeld werden wieder alle Daten angezeigt.
			reset();
		}
		fireTableDataChanged();
	}

	public Mitarbeiter getMitarbeiterWithID(String idMitarbeiter) {
		Mitarbeiter tmpMitarbeiter = null;
		for (Mitarbeiter m : backup)
			if (m.idMitarbeiter.matches(idMitarbeiter.trim()))
				tmpMitarbeiter = m;
		return tmpMitarbeiter;
	}

	public Mitarbeiter getMitarbeiterAtRow(int row) {
		return mitarbeiter.get(row);
	}

	public int getRowOfMitarbeiter(Mitarbeiter c) {
		return mitarbeiter.indexOf(c);
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return mitarbeiter.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return mitarbeiter.get(row).getValue(col);
	}

}

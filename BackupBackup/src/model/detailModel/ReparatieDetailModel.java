package model.detailModel;

import java.util.Observable;

public class ReparatieDetailModel extends Observable {
	private String autoKenteken, status, opmerking;
	private int reparatieID, persoonID, autoID;
	private Object[][] geplandeAfspraken, onderdelen;
	private String[] afsprakenHeader, onderdelenHeader;
	
	public ReparatieDetailModel(Object[][] data) {
		setAfsprakenHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "ReparatieID", "Monteur" });
		setOnderdelenHeader(new String[] { "Onderdeelnummer", "Onderdeelnaam", "Prijs",
				"Leverancier", "Aantal" });

		geplandeAfspraken = data;
		onderdelen = data;

		autoKenteken = "kenteken";
		status = "not implemented";
		opmerking = "Auto ist kaput";
	}
	
	public void dataChanged() {
		setChanged();
		notifyObservers("dataChanged");
	}

	private void setOnderdelenHeader(String[] onderdelen) {
		onderdelenHeader = onderdelen;
	}

	private void setAfsprakenHeader(String[] afspraken) {
		afsprakenHeader = afspraken;
		
	}
	
	public void setGeplandeAfspraken(Object[][] geplandeAfspraken) {
		this.geplandeAfspraken = geplandeAfspraken;
	}
	
	public void setAutos(Object[][] onderdelen) {
		this.onderdelen = onderdelen;
	}

	public Object[][] getGeplandeAfspraken() {
		return geplandeAfspraken;
	}

	public String[] getAfsprakenHeader() {
		return afsprakenHeader;
	}

	public Object[][] getGebruikteOnderdelen() {
		return onderdelen;
	}

	public String[] getOnderdelenHeader() {
		return onderdelenHeader;
	}

	public int getReparatieID() {
		return reparatieID;
	}

	public int getPersoonID() {
		return persoonID;
	}

	public int getAutoID() {
		return autoID;
	}

	public String getKenteken() {
		return autoKenteken;
	}

	public String getStatus() {
		return status;
	}

	public String getOpmerkingen() {
		return opmerking;
	}
	
	public void setOpmerking(String opmerking){
		this.opmerking = opmerking;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
	public void setKenteken(String kenteken){
		autoKenteken = kenteken;
	}
	
	public void setAutoID(int ID){
		autoID = ID;
	}
	
	public void setKlantID(int ID){
		persoonID = ID;
	}
	
	public void setReparatieID(int ID){
		reparatieID = ID;
	}
}

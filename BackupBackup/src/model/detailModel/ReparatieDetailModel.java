package model.detailModel;

import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ReparatieDetailModel extends Observable {
	private String autoKenteken, opmerking;
	private int reparatieID, persoonID, status, autoID;
	private JComboBox<Object> statusC, onderdelenC;
	private JTextArea opmerkingenA;
	private Object[][] geplandeAfspraken, gebruikteOnderdelen;
	private String[] afsprakenHeader, onderdelenHeader, onderdelen;
	private boolean wijzigInfo;
	
	public ReparatieDetailModel(Object[][] data) {
		setAfsprakenHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "Monteur" });
		setOnderdelenHeader(new String[] { "Onderdeelnummer", "Onderdeelnaam",
				"Leverancier", "Prijs", "Aantal", "Totaal prijs" });

		geplandeAfspraken = data;
		gebruikteOnderdelen = data;
		onderdelen = new String[] { "", "", "" };

		autoKenteken = "kenteken";
		status = 0;
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
	
	public void setOnderdelen(Object[][] onderdelen) {
		this.gebruikteOnderdelen = onderdelen;
	}

	public Object[][] getGeplandeAfspraken() {
		return geplandeAfspraken;
	}

	public String[] getAfsprakenHeader() {
		return afsprakenHeader;
	}

	public Object[][] getGebruikteOnderdelen() {
		return gebruikteOnderdelen;
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

	public int getStatus() {
		return status;
	}

	public String getOpmerkingen() {
		return opmerking;
	}
	
	public void setOpmerking(String opmerking){
		this.opmerking = opmerking;
	}
	
	public void setStatus(int status) {
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

	/**
	 * @return the wijzigInfo
	 */
	public boolean isWijzigInfo() {
		return wijzigInfo;
	}

	/**
	 * @param wijzigInfo the wijzigInfo to set
	 */
	public void wijzigInfo() {
		wijzigInfo = !wijzigInfo;

		setChanged();
		notifyObservers("wijzigData");
	}

	public String[] getData() {
		String[] data = new String[2];
		
		data[0] = "" + statusC.getSelectedIndex();
		data[1] = opmerkingenA.getText();

		return data;		
	}

	/**
	 * @return the statusT
	 */
	public JComboBox<Object> getStatusT() {
		return statusC;
	}

	/**
	 * @param statusT
	 *            the statusT to set
	 */
	public void setStatusC(JComboBox<Object> statusC) {
		this.statusC = statusC;
	}

	/**
	 * @return the opmerkingenA
	 */
	public JTextArea getOpmerkingenA() {
		return opmerkingenA;
	}

	/**
	 * @param opmerkingenA
	 *            the opmerkingenA to set
	 */
	public void setOpmerkingenA(JTextArea opmerkingenA) {
		this.opmerkingenA = opmerkingenA;
	}

	/**
	 * @return the onderdelen
	 */
	public String[] getOnderdelen() {
		return onderdelen;
	}

	/**
	 * @param onderdelen the onderdelen to set
	 */
	public void setOnderdelen(String[] onderdelen) {
		this.onderdelen = onderdelen;
	}

	/**
	 * @return the onderdelenC
	 */
	public JComboBox<Object> getOnderdelenC() {
		return onderdelenC;
	}

	/**
	 * @param onderdelenC the onderdelenC to set
	 */
	public void setOnderdelenC(JComboBox<Object> onderdelenC) {
		this.onderdelenC = onderdelenC;
	}
}

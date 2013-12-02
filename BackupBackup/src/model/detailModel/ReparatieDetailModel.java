package model.detailModel;

import java.util.Observable;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * De class die gebruikt wordt voor de detailpagina van een reparatie en daar data in op te slaan. Het extends een Observable.
 * @author Stef en Roald
 * @since 25-11-2013
 * @version 2.0
 */
public class ReparatieDetailModel extends Observable {
	private String autoKenteken, opmerking;
	private int reparatieID, persoonID, status, autoID;
	private JComboBox<Object> statusC, onderdelenC;
	private JTextField nieuwOnderdeelAantalT;
	private JTextArea opmerkingenA;
	private Object[][] geplandeAfspraken, gebruikteOnderdelen;
	private String[] afsprakenHeader, onderdelenHeader, onderdelen;
	private boolean wijzigInfo;
	
	/**
	 * De constructor van ReparatieDetailModel.
	 * @param data Een 2D-array met daarin de de data van een reparatie.
	 */
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
	
	/**
	 * De method om aan te geven dat er iets verandert is en door te geven aan de observers.
	 */
	public void dataChanged() {
		setChanged();
		notifyObservers("dataChanged");
	}
	
	/**
	 * De methode om de onderdelenheader te setten.
	 * @param onderdelen String array met daarin de kolomnamen.
	 */
	private void setOnderdelenHeader(String[] onderdelen) {
		onderdelenHeader = onderdelen;
	}

	/**
	 * De methode om de afsprakenheader te setten.
	 * @param onderdelen String array met daarin de kolomnamen.
	 */
	private void setAfsprakenHeader(String[] afspraken) {
		afsprakenHeader = afspraken;
		
	}
	
	/**
	 * De methode om geplandeafspraken te setten
	 * @param geplandeAfspraken De geplandeAfspraken to set
	 */
	public void setGeplandeAfspraken(Object[][] geplandeAfspraken) {
		this.geplandeAfspraken = geplandeAfspraken;
	}
	
	/**
	 * De methode om onderdelen te setten.
	 * @param onderdelen De onderdelen to set.
	 */
	public void setOnderdelen(Object[][] onderdelen) {
		this.gebruikteOnderdelen = onderdelen;
	}

	/**
	 * De methode om de geplande afspraken op te halen.
	 * @return De 2D-array met geplande afspraken
	 */
	public Object[][] getGeplandeAfspraken() {
		return geplandeAfspraken;
	}

	/**
	 * De methode om de afsprakenheader op te halen.
	 * @return De afsprakenheader.
	 */
	public String[] getAfsprakenHeader() {
		return afsprakenHeader;
	}

	/**
	 * De methode om de gebruikte onderdelen op te halen.
	 * @return De 2D-array met gebruikte onderdelen.
	 */
	public Object[][] getGebruikteOnderdelen() {
		return gebruikteOnderdelen;
	}

	/**
	 * De methode om de onderdelenheader op te halen.
	 * @return De onderdelenheader.
	 */
	public String[] getOnderdelenHeader() {
		return onderdelenHeader;
	}

	/**
	 * De methode om de reparatieid op te halen.
	 * @return De reparatieID.
	 */
	public int getReparatieID() {
		return reparatieID;
	}

	/**
	 * De methode om de persoonid op te halen.
	 * @return De persoonID.
	 */
	public int getPersoonID() {
		return persoonID;
	}

	/**
	 * De methode om de autoid op te halen.
	 * @return De autoID.
	 */
	public int getAutoID() {
		return autoID;
	}

	/**
	 * De methode om het kenteken op te halen.
	 * @return Het kenteken.
	 */
	public String getKenteken() {
		return autoKenteken;
	}

	/**
	 * De methode om de status op te halen.
	 * @return De status.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * De methode om de Opmerkingen op te halen.
	 * @return De opmerkingen.
	 */
	public String getOpmerkingen() {
		return opmerking;
	}
	
	/**
	 * De methode om de opmerking te setten.
	 * @param opmerking De opmerking to set.
	 */
	public void setOpmerking(String opmerking){
		this.opmerking = opmerking;
	}
	
	/**
	 * De methode om de status te setten.
	 * @param opmerking De status to set.
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	/**
	 * De methode om het kenteken te setten.
	 * @param opmerking Het kenteken to set.
	 */
	public void setKenteken(String kenteken){
		autoKenteken = kenteken;
	}
	
	/**
	 * De methode om de AutoID te setten.
	 * @param opmerking De AutoID to set.
	 */
	public void setAutoID(int ID){
		autoID = ID;
	}
	
	/**
	 * De methode om de KlantID te setten.
	 * @param opmerking De KlantID to set.
	 */
	public void setKlantID(int ID){
		persoonID = ID;
	}
	
	/**
	 * De methode om de ReparatieID te setten.
	 * @param opmerking De ReparatieID to set.
	 */
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

	/**
	 * De methode om data op te halen uit de huidige pagina.
	 * @return Een String array met daarin data.
	 */
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

	/**
	 * @return the nieuwOnderdeelAantalT
	 */
	public JTextField getNieuwOnderdeelAantalT() {
		return nieuwOnderdeelAantalT;
	}

	/**
	 * @param nieuwOnderdeelAantalT the nieuwOnderdeelAantalT to set
	 */
	public void setNieuwOnderdeelAantalT(JTextField nieuwOnderdeelAantalT) {
		this.nieuwOnderdeelAantalT = nieuwOnderdeelAantalT;
	}

	/**
	 * De methode om data over de ondelen op te halen.
	 * @return Een String Array met data van de onderdelen.
	 */
	public String[] getOnderdeelData() {
		String[] data = new String[2];

		data[0] = (String) onderdelenC.getSelectedItem();
		data[1] = nieuwOnderdeelAantalT.getText();

		return data;
	}
}

package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

/**
 * De class die gebruikt wordt voor de detailpagina van een monteur en daar data in op te slaan. Het extends een Observable.
 * @author Stef en Roald
 * @since 25-11-2013
 * @version 2.0
 */
public class MonteurDetailModel extends Observable {
	private String voorNaam, achterNaam, adres, woonplaats, postcode;
	private int persoonID;
	private double uurLoon;
	private JTextField monteurNummerT, monteurVoorNaamT, monteurAchterNaamT,
			monteurAdresT, monteurWoonplaatsT, monteurPostcodeT, uurLoonT;
	private Object[][] geplandeAfspraken, autos;
	private String[] afsprakenHeader, autoHeader;
	private boolean wijzigInfo;

	/**
	 * De constructor van monteurDetailModel.
	 * @param data Een 2D-array met daarin de de data van een monteur.
	 */
	public MonteurDetailModel(Object[][] data) {
		setAfsprakenHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "ReparatieID", "Monteur" });
		setAutoHeader(new String[] { "Auto nummer", "Kenteken", "BouwJaar",
				"Merk", "Model" });

		geplandeAfspraken = data;
		autos = data;

		voorNaam = "Voornaam";
		achterNaam = "Achternaam";
		adres = "Straatnaam etc";
		woonplaats = "Kutgat";
		postcode = "Vage nummers";

		uurLoon = 20.00;
		persoonID = 1337;
	}
	
	/**
	 * De method om aan te geven dat er iets verandert is en door te geven aan de observers.
	 */
	public void dataChanged() {
		if (wijzigInfo)
			wijzigInfo();

		setChanged();
		notifyObservers("dataChanged");
	}

	/**
	 * De methode om de voornaam te setten.
	 * @param voorNaam De voornaam to set.
	 */
	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}

	/**
	 * De methode om de voornaam op te halen.
	 * @return De voornaam.
	 */
	public String getVoorNaam() {
		return voorNaam;
	}

	/**
	 * De methode om de postcode op te halen.
	 * @return De postcode.
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * De methode om de postcode te setten.
	 * @param voorNaam De postcode to set.
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the woonplaats
	 */
	public String getWoonplaats() {
		return woonplaats;
	}

	/**
	 * @param woonplaats
	 *            the woonplaats to set
	 */
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	/**
	 * @return the adres
	 */
	public String getAdres() {
		return adres;
	}

	/**
	 * @param adres
	 *            the adres to set
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	/**
	 * @return the achterNaam
	 */
	public String getAchterNaam() {
		return achterNaam;
	}

	/**
	 * @param achterNaam
	 *            the achterNaam to set
	 */
	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}

	/**
	 * @return the aantalAutos
	 */
	public double getUurLoon() {
		return uurLoon;
	}

	/**
	 * @param aantalAutos the aantalAutos to set
	 */
	public void setUurLoon(double uurLoon) {
		this.uurLoon = uurLoon;
	}

	/**
	 * @return the persoonID
	 */
	public int getPersoonID() {
		return persoonID;
	}

	/**
	 * @param persoonID the persoonID to set
	 */
	public void setPersoonID(int persoonID) {
		this.persoonID = persoonID;
	}

	/**
	 * @return the geplandeAfspraken
	 */
	public Object[][] getGeplandeAfspraken() {
		return geplandeAfspraken;
	}

	/**
	 * @param geplandeAfspraken
	 *            the geplandeAfspraken to set
	 */
	public void setGeplandeAfspraken(Object[][] geplandeAfspraken) {
		this.geplandeAfspraken = geplandeAfspraken;
	}

	/**
	 * @return the autos
	 */
	public Object[][] getAutos() {
		return autos;
	}

	/**
	 * @param autos
	 *            the autos to set
	 */
	public void setAutos(Object[][] autos) {
		this.autos = autos;
	}

	/**
	 * @return the afsprakenHeader
	 */
	public String[] getAfsprakenHeader() {
		return afsprakenHeader;
	}

	/**
	 * @param afsprakenHeader the afsprakenHeader to set
	 */
	public void setAfsprakenHeader(String[] afsprakenHeader) {
		this.afsprakenHeader = afsprakenHeader;
	}

	/**
	 * @return the autoHeader
	 */
	public String[] getAutoHeader() {
		return autoHeader;
	}

	/**
	 * @param autoHeader the autoHeader to set
	 */
	public void setAutoHeader(String[] autoHeader) {
		this.autoHeader = autoHeader;
	}

	/**
	 * @return the klantNummerT
	 */
	public JTextField getKlantNummerT() {
		return monteurNummerT;
	}

	/**
	 * @param klantNummerT
	 *            the klantNummerT to set
	 */
	public void setKlantNummerT(JTextField klantNummerT) {
		this.monteurNummerT = klantNummerT;
	}

	/**
	 * @return the klantVoorNaamT
	 */
	public JTextField getKlantVoorNaamT() {
		return monteurVoorNaamT;
	}

	/**
	 * @param klantVoorNaamT
	 *            the klantVoorNaamT to set
	 */
	public void setKlantVoorNaamT(JTextField klantVoorNaamT) {
		this.monteurVoorNaamT = klantVoorNaamT;
	}

	/**
	 * @return the klantAchterNaamT
	 */
	public JTextField getKlantAchterNaamT() {
		return monteurAchterNaamT;
	}

	/**
	 * @param klantAchterNaamT
	 *            the klantAchterNaamT to set
	 */
	public void setKlantAchterNaamT(JTextField klantAchterNaamT) {
		this.monteurAchterNaamT = klantAchterNaamT;
	}

	/**
	 * @return the klantAdresT
	 */
	public JTextField getKlantAdresT() {
		return monteurAdresT;
	}

	/**
	 * @param klantAdresT
	 *            the klantAdresT to set
	 */
	public void setKlantAdresT(JTextField klantAdresT) {
		this.monteurAdresT = klantAdresT;
	}

	/**
	 * @return the klantWoonplaatsT
	 */
	public JTextField getKlantWoonplaatsT() {
		return monteurWoonplaatsT;
	}

	/**
	 * @param klantWoonplaatsT
	 *            the klantWoonplaatsT to set
	 */
	public void setKlantWoonplaatsT(JTextField klantWoonplaatsT) {
		this.monteurWoonplaatsT = klantWoonplaatsT;
	}

	/**
	 * @return the klantPostcodeT
	 */
	public JTextField getKlantPostcodeT() {
		return monteurPostcodeT;
	}

	/**
	 * @param klantPostcodeT
	 *            the klantPostcodeT to set
	 */
	public void setKlantPostcodeT(JTextField klantPostcodeT) {
		this.monteurPostcodeT = klantPostcodeT;
	}

	/**
	 * @return the klantAantalAutosT
	 */
	public JTextField getKlantAantalAutosT() {
		return uurLoonT;
	}

	/**
	 * @param klantAantalAutosT
	 *            the klantAantalAutosT to set
	 */
	public void setKlantAantalAutosT(JTextField klantAantalAutosT) {
		this.uurLoonT = klantAantalAutosT;
	}

	/**
	 * @return the wijzigInfo
	 */
	public boolean isWijzigInfo() {
		return wijzigInfo;
	}

	/**
	 * @param wijzigInfo
	 *            the wijzigInfo to set
	 */
	public void wijzigInfo() {
		wijzigInfo = !wijzigInfo;
		
		setChanged();
		notifyObservers("wijzigData");
	}

	/**
	 * De methode om textfieldData op te halen.
	 * @return Een String array met monteur data.
	 */
	public String[] getTextFieldData() {
		String[] data = new String[6];
		
		data[0] = monteurVoorNaamT.getText();
		data[1] = monteurAchterNaamT.getText();
		data[2] = monteurAdresT.getText();
		data[3] = monteurWoonplaatsT.getText();
		data[4] = monteurPostcodeT.getText();
		data[5] = uurLoonT.getText();

		return data;
	}
}

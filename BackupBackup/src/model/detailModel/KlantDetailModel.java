package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

public class KlantDetailModel extends Observable {
	private String voorNaam, achterNaam, adres, woonplaats, postcode;
	private int aantalAutos, persoonID;
	private JTextField klantNummerT, klantVoorNaamT, klantAchterNaamT,
			klantAdresT, klantWoonplaatsT, klantPostcodeT, klantAantalAutosT,
			nieuweAutoKentekenT, nieuweAutoBouwjaarT, nieuweAutoMerkT,
			nieuweAutoModelT;
	private Object[][] geplandeAfspraken, autos;
	private String[] afsprakenHeader, autoHeader;
	private boolean wijzigInfo;

	public KlantDetailModel(Object[][] data) {
		setAfsprakenHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "Auto Nummer", "Monteur" });
		setAutoHeader(new String[] { "Auto nummer", "Kenteken", "BouwJaar",
				"Merk", "Model" });

		geplandeAfspraken = data;
		autos = data;

		voorNaam = "Voornaam";
		achterNaam = "Achternaam";
		adres = "Straatnaam etc";
		woonplaats = "Kutgat";
		postcode = "Vage nummers";

		aantalAutos = 0;
		persoonID = 1337;
	}
	
	public void dataChanged() {
		if (wijzigInfo)
			wijzigInfo();

		setChanged();
		notifyObservers("dataChanged");
	}

	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}

	public String getVoorNaam() {
		return voorNaam;
	}

	public String getPostcode() {
		return postcode;
	}

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
	public int getAantalAutos() {
		return aantalAutos;
	}

	/**
	 * @param aantalAutos the aantalAutos to set
	 */
	public void setAantalAutos(int aantalAutos) {
		this.aantalAutos = aantalAutos;
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
		return klantNummerT;
	}

	/**
	 * @param klantNummerT
	 *            the klantNummerT to set
	 */
	public void setKlantNummerT(JTextField klantNummerT) {
		this.klantNummerT = klantNummerT;
	}

	/**
	 * @return the klantVoorNaamT
	 */
	public JTextField getKlantVoorNaamT() {
		return klantVoorNaamT;
	}

	/**
	 * @param klantVoorNaamT
	 *            the klantVoorNaamT to set
	 */
	public void setKlantVoorNaamT(JTextField klantVoorNaamT) {
		this.klantVoorNaamT = klantVoorNaamT;
	}

	/**
	 * @return the klantAchterNaamT
	 */
	public JTextField getKlantAchterNaamT() {
		return klantAchterNaamT;
	}

	/**
	 * @param klantAchterNaamT
	 *            the klantAchterNaamT to set
	 */
	public void setKlantAchterNaamT(JTextField klantAchterNaamT) {
		this.klantAchterNaamT = klantAchterNaamT;
	}

	/**
	 * @return the klantAdresT
	 */
	public JTextField getKlantAdresT() {
		return klantAdresT;
	}

	/**
	 * @param klantAdresT
	 *            the klantAdresT to set
	 */
	public void setKlantAdresT(JTextField klantAdresT) {
		this.klantAdresT = klantAdresT;
	}

	/**
	 * @return the klantWoonplaatsT
	 */
	public JTextField getKlantWoonplaatsT() {
		return klantWoonplaatsT;
	}

	/**
	 * @param klantWoonplaatsT
	 *            the klantWoonplaatsT to set
	 */
	public void setKlantWoonplaatsT(JTextField klantWoonplaatsT) {
		this.klantWoonplaatsT = klantWoonplaatsT;
	}

	/**
	 * @return the klantPostcodeT
	 */
	public JTextField getKlantPostcodeT() {
		return klantPostcodeT;
	}

	/**
	 * @param klantPostcodeT
	 *            the klantPostcodeT to set
	 */
	public void setKlantPostcodeT(JTextField klantPostcodeT) {
		this.klantPostcodeT = klantPostcodeT;
	}

	/**
	 * @return the klantAantalAutosT
	 */
	public JTextField getKlantAantalAutosT() {
		return klantAantalAutosT;
	}

	/**
	 * @param klantAantalAutosT
	 *            the klantAantalAutosT to set
	 */
	public void setKlantAantalAutosT(JTextField klantAantalAutosT) {
		this.klantAantalAutosT = klantAantalAutosT;
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

	public String[] getKlantData() {
		String[] data = new String[5];

		data[0] = klantVoorNaamT.getText();
		data[1] = klantAchterNaamT.getText();
		data[2] = klantAdresT.getText();
		data[3] = klantWoonplaatsT.getText();
		data[4] = klantPostcodeT.getText();

		return data;
	}

	public String[] getNieuweAutoData() {
		String[] data = new String[4];
		
		data[0] = nieuweAutoKentekenT.getText();
		data[1] = nieuweAutoBouwjaarT.getText();
		data[2] = nieuweAutoMerkT.getText();
		data[3] = nieuweAutoModelT.getText();

		return data;
	}

	/**
	 * @return the nieuweAutoKentekenT
	 */
	public JTextField getNieuweAutoKentekenT() {
		return nieuweAutoKentekenT;
	}

	/**
	 * @param nieuweAutoKentekenT
	 *            the nieuweAutoKentekenT to set
	 */
	public void setNieuweAutoKentekenT(JTextField nieuweAutoKentekenT) {
		this.nieuweAutoKentekenT = nieuweAutoKentekenT;
	}

	/**
	 * @return the nieuweAutoBouwjaarT
	 */
	public JTextField getNieuweAutoBouwjaarT() {
		return nieuweAutoBouwjaarT;
	}

	/**
	 * @param nieuweAutoBouwjaarT
	 *            the nieuweAutoBouwjaarT to set
	 */
	public void setNieuweAutoBouwjaarT(JTextField nieuweAutoBouwjaarT) {
		this.nieuweAutoBouwjaarT = nieuweAutoBouwjaarT;
	}

	/**
	 * @return the nieuweAutoMerkT
	 */
	public JTextField getNieuweAutoMerkT() {
		return nieuweAutoMerkT;
	}

	/**
	 * @param nieuweAutoMerkT
	 *            the nieuweAutoMerkT to set
	 */
	public void setNieuweAutoMerkT(JTextField nieuweAutoMerkT) {
		this.nieuweAutoMerkT = nieuweAutoMerkT;
	}

	/**
	 * @return the nieuweAutoModelT
	 */
	public JTextField getNieuweAutoModelT() {
		return nieuweAutoModelT;
	}

	/**
	 * @param nieuweAutoModelT
	 *            the nieuweAutoModelT to set
	 */
	public void setNieuweAutoModelT(JTextField nieuweAutoModelT) {
		this.nieuweAutoModelT = nieuweAutoModelT;
	}
}

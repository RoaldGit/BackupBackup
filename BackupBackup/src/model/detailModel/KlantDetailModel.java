package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

/**
 * De class die gebruikt wordt voor de detailpagina van een klant en daar data in op te slaan. Het extends een Observable.
 * @author Stef en Roald
 * @since 25-11-2013
 * @version 2.0
 */
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

	/**
	 * De constructor van KlantDetailModel.
	 * @param data Een 2D-array met daarin de de data van een auto.
	 */
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
	 * De methode om de woonplaats op te halen.
	 * @return De woonplaats
	 */
	public String getWoonplaats() {
		return woonplaats;
	}

	/**
	 * De methode om woonplaats te setten
	 * @param woonplaats De woonplaats to set
	 */
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	/**
	 * De methode om het adres op te halen.
	 * @return Het adres
	 */
	public String getAdres() {
		return adres;
	}

	/**
	 * De methode om het adres te setten.
	 * @param adres Het adres to set
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	/**
	 * De methode om de achternaam op te halen.
	 * @return De achternaam
	 */
	public String getAchterNaam() {
		return achterNaam;
	}

	/**
	 * De methode om de achternaam te setten.
	 * @param achterNaam De achterNaam to set
	 */
	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}

	/**
	 * De methode om het aantal autos op te halen.
	 * @return Het aantal autos
	 */
	public int getAantalAutos() {
		return aantalAutos;
	}

	/**
	 * De methode om het aantal autos te setten.
	 * @param aantalAutos De aantalAutos to set
	 */
	public void setAantalAutos(int aantalAutos) {
		this.aantalAutos = aantalAutos;
	}

	/**
	 * De methode om de persoonID op te halen.
	 * @return De persoonID
	 */
	public int getPersoonID() {
		return persoonID;
	}

	/**
	 * De methode om het persoonID te setten.
	 * @param persoonID De persoonID to set
	 */
	public void setPersoonID(int persoonID) {
		this.persoonID = persoonID;
	}

	/**
	 * De methode om de geplande afspraken op te halen.
	 * @return De 2D-array met geplande afspraken
	 */
	public Object[][] getGeplandeAfspraken() {
		return geplandeAfspraken;
	}

	/**
	 * De methode om geplandeafspraken te setten
	 * @param geplandeAfspraken De geplandeAfspraken to set
	 */
	public void setGeplandeAfspraken(Object[][] geplandeAfspraken) {
		this.geplandeAfspraken = geplandeAfspraken;
	}

	/**
	 * De methode om de autos op te halen.
	 * @return De 2D-array met autos
	 */
	public Object[][] getAutos() {
		return autos;
	}

	/**
	 * De methode om autos te setten
	 * @param autos De autos to set
	 */
	public void setAutos(Object[][] autos) {
		this.autos = autos;
	}

	/**
	 * De methode om de afspraken header op te halen.
	 * @return De String array met de headers van de afspraken.
	 */
	public String[] getAfsprakenHeader() {
		return afsprakenHeader;
	}

	/**
	 * De methode om de afsprakenHeader te setten.
	 * @param afsprakenHeader De afsprakenHeader to set
	 */
	public void setAfsprakenHeader(String[] afsprakenHeader) {
		this.afsprakenHeader = afsprakenHeader;
	}

	/**
	 * De methode om de autoheader op te halen
	 * @return De String array met de headers van de afspraken.
	 */
	public String[] getAutoHeader() {
		return autoHeader;
	}

	/**
	 * De methode om de autoheader te setten.
	 * @param autoHeader De autoHeader to set
	 */
	public void setAutoHeader(String[] autoHeader) {
		this.autoHeader = autoHeader;
	}

	/**
	 * De methode om JTextField klantNummerT ophalen
	 * @return De klantNummerT
	 */
	public JTextField getKlantNummerT() {
		return klantNummerT;
	}

	/**
	 * De methode om JTextField klantNummerT te setten.
	 * @param klantNummerT De klantNummerT to set
	 */
	public void setKlantNummerT(JTextField klantNummerT) {
		this.klantNummerT = klantNummerT;
	}

	/**
	 * De methode om JTextField klantVoorNaamT ophalen
	 * @return De klantVoorNaamT
	 */
	public JTextField getKlantVoorNaamT() {
		return klantVoorNaamT;
	}

	/**
	 * De methode om JTextField klantVoorNaamT te setten.
	 * @param klantVoornaamT De klantVoorNaamT to set
	 */
	public void setKlantVoorNaamT(JTextField klantVoorNaamT) {
		this.klantVoorNaamT = klantVoorNaamT;
	}

	/**
	 * De methode om JTextField klantAchternaamT ophalen
	 * @return De klantAchternaamT
	 */
	public JTextField getKlantAchterNaamT() {
		return klantAchterNaamT;
	}

	/**
	 * De methode om JTextField klantAchternaamT te setten.
	 * @param klantAchternaamT De klantAchternaamT to set
	 */
	public void setKlantAchterNaamT(JTextField klantAchterNaamT) {
		this.klantAchterNaamT = klantAchterNaamT;
	}

	/**
	 * De methode om JTextField klantAdresT ophalen
	 * @return De klantAdresT
	 */
	public JTextField getKlantAdresT() {
		return klantAdresT;
	}

	/**
	 * De methode om JTextField klantAdresT te setten.
	 * @param klantAdresT De klantAdresT to set
	 */
	public void setKlantAdresT(JTextField klantAdresT) {
		this.klantAdresT = klantAdresT;
	}

	/**
	 * De methode om JTextField klantWoonplaatsT ophalen
	 * @return De klantWoonplaatsT
	 */
	public JTextField getKlantWoonplaatsT() {
		return klantWoonplaatsT;
	}

	/**
	 * De methode om JTextField klantWoonplaatsT te setten.
	 * @param klantWoonplaatsT De klantWoonplaatsT to set
	 */
	public void setKlantWoonplaatsT(JTextField klantWoonplaatsT) {
		this.klantWoonplaatsT = klantWoonplaatsT;
	}

	/**
	 * De methode om JTextField klantPostcodeT ophalen
	 * @return De klantPostcodeT
	 */
	public JTextField getKlantPostcodeT() {
		return klantPostcodeT;
	}

	/**
	 * De methode om JTextField klantPostcodeT te setten.
	 * @param klantPostcodeT De klantPostcodeT to set
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
	 * De methode om te kijken of info gewijzigd is.
	 * @return De wijzigInfo
	 */
	public boolean isWijzigInfo() {
		return wijzigInfo;
	}

	/**
	 * De methode om wijzigInfo te setten.
	 * @param wijzigInfo De wijzigInfo to set
	 */
	public void wijzigInfo() {
		wijzigInfo = !wijzigInfo;
		
		setChanged();
		notifyObservers("wijzigData");
	}

	/**
	 * De methode om KlantData op te halen.
	 * @return Een String array met klant data.
	 */
	public String[] getKlantData() {
		String[] data = new String[5];

		data[0] = klantVoorNaamT.getText();
		data[1] = klantAchterNaamT.getText();
		data[2] = klantAdresT.getText();
		data[3] = klantWoonplaatsT.getText();
		data[4] = klantPostcodeT.getText();

		return data;
	}

	/**
	 * De methode om autoData op te halen.
	 * @return Een String array met auto data.
	 */
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

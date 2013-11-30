package model.detailModel;

import java.util.Observable;

public class KlantDetailModel extends Observable {
	private String voorNaam, achterNaam, adres, woonplaats, postcode;
	private int aantalAutos, persoonID;
	private Object[][] geplandeAfspraken, autos;
	private String[] afsprakenHeader, autoHeader;

	public KlantDetailModel(Object[][] data) {
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

		aantalAutos = 0;
		persoonID = 1337;
	}
	
	public void dataChanged() {
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
}

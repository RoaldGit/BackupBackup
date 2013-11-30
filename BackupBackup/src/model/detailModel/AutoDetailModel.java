package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

public class AutoDetailModel extends Observable {
	private int autoNummer, klantNummer, bouwjaar;
	private String merk, model, klantnaam, kenteken;
	private String[] reparatieHeader, afspraakHeader;
	private Object[][] reparatieData, afspraakData;

	public AutoDetailModel(Object[][] data) {
		setAfspraakHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "ReparatieID", "Monteur" });
		setReparatieHeader(new String[] { "Reparatie nummer", "Bezigheid",
				"Factuur verzonden", "Monteur" });

		afspraakData = data;
		reparatieData = data;

		autoNummer = 0;
		klantNummer = 0;
		bouwjaar = 0;
		merk = "Fiets";
		model = "Driewieller";
		klantnaam = "Sinterklaas";
	}

	public void dataChanged() {
		setChanged();
		notifyObservers("dataChanged");
	}

	/**
	 * @return the autoNummer
	 */
	public int getAutoNummer() {
		return autoNummer;
	}

	/**
	 * @param autoNummer
	 *            the autoNummer to set
	 */
	public void setAutoNummer(int autoNummer) {
		this.autoNummer = autoNummer;
	}

	/**
	 * @return the bouwjaar
	 */
	public int getBouwjaar() {
		return bouwjaar;
	}

	/**
	 * @param bouwjaar
	 *            the bouwjaar to set
	 */
	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	/**
	 * @return the klantNummer
	 */
	public int getKlantNummer() {
		return klantNummer;
	}

	/**
	 * @param klantNummer
	 *            the klantNummer to set
	 */
	public void setKlantNummer(int klantNummer) {
		this.klantNummer = klantNummer;
	}

	/**
	 * @return the merk
	 */
	public String getMerk() {
		return merk;
	}

	/**
	 * @param merk
	 *            the merk to set
	 */
	public void setMerk(String merk) {
		this.merk = merk;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the klantnaam
	 */
	public String getKlantnaam() {
		return klantnaam;
	}

	/**
	 * @param klantnaam
	 *            the klantnaam to set
	 */
	public void setKlantnaam(String klantnaam) {
		this.klantnaam = klantnaam;
	}

	/**
	 * @return the reparatieHeader
	 */
	public String[] getReparatieHeader() {
		return reparatieHeader;
	}

	/**
	 * @param reparatieHeader
	 *            the reparatieHeader to set
	 */
	public void setReparatieHeader(String[] reparatieHeader) {
		this.reparatieHeader = reparatieHeader;
	}

	/**
	 * @return the reparatieData
	 */
	public Object[][] getReparatieData() {
		return reparatieData;
	}

	/**
	 * @param reparatieData
	 *            the reparatieData to set
	 */
	public void setReparatieData(Object[][] reparatieData) {
		this.reparatieData = reparatieData;
	}

	/**
	 * @return the kenteken
	 */
	public String getKenteken() {
		return kenteken;
	}

	/**
	 * @param kenteken the kenteken to set
	 */
	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}

	/**
	 * @return the afspraakHeader
	 */
	public String[] getAfspraakHeader() {
		return afspraakHeader;
	}

	/**
	 * @param afspraakHeader
	 *            the afspraakHeader to set
	 */
	public void setAfspraakHeader(String[] afspraakHeader) {
		this.afspraakHeader = afspraakHeader;
	}

	/**
	 * @return the afspraakData
	 */
	public Object[][] getAfspraakData() {
		return afspraakData;
	}

	/**
	 * @param afspraakData
	 *            the afspraakData to set
	 */
	public void setAfspraakData(Object[][] afspraakData) {
		this.afspraakData = afspraakData;
	}
}

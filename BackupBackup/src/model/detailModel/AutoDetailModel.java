package model.detailModel;

public class AutoDetailModel {
	private int autoNummer, klantNummer, bouwjaar;
	private String merk, model, klantnaam;
	private String[] reparatieHeader;
	private Object[][] reparatieData;

	public AutoDetailModel(Object[][] data) {
		reparatieHeader = new String[] { "Reparatie nummer", "Opmerkingen",
				"Factuur verzonden" };
		reparatieData = data;

		autoNummer = 0;
		klantNummer = 0;
		bouwjaar = 0;
		merk = "Fiets";
		model = "Driewieller";
		klantnaam = "Sinterklaas";
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
}

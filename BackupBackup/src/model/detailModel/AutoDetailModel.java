package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

public class AutoDetailModel extends Observable {
	private int autoNummer, klantNummer, bouwjaar;
	private String merk, model, klantnaam, kenteken;
	private JTextField autoNummerT, autoKentekenT, autoBouwjaarT,
			autoMerkNaamT, autoModelT, klantNummerT, klantAchternaamT;
	private String[] reparatieHeader, afspraakHeader;
	private Object[][] reparatieData, afspraakData;
	private boolean wijzigInfo;

	public AutoDetailModel(Object[][] data) {
		setAfspraakHeader(new String[] { "Start Tijd", "Eind Tijd",
				"Bezigheid", "ReparatieID", "Monteur" });
		setReparatieHeader(new String[] { "Reparatie nummer", "Afgerond",
				"Factuur verzonden", "Factuur betaald" });

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

	public String[] getAutoData() {
		String[] data = new String[4];

		data[0] = autoKentekenT.getText();
		data[1] = autoBouwjaarT.getText();
		data[2] = autoMerkNaamT.getText();
		data[3] = autoModelT.getText();

		// TODO klant veranderen

		return data;
	}

	/**
	 * @return the autoNummerT
	 */
	public JTextField getAutoNummerT() {
		return autoNummerT;
	}

	/**
	 * @param autoNummerT
	 *            the autoNummerT to set
	 */
	public void setAutoNummerT(JTextField autoNummerT) {
		this.autoNummerT = autoNummerT;
	}

	/**
	 * @return the autoKentekenT
	 */
	public JTextField getAutoKentekenT() {
		return autoKentekenT;
	}

	/**
	 * @param autoKentekenT
	 *            the autoKentekenT to set
	 */
	public void setAutoKentekenT(JTextField autoKentekenT) {
		this.autoKentekenT = autoKentekenT;
	}

	/**
	 * @return the autoBouwjaarT
	 */
	public JTextField getAutoBouwjaarT() {
		return autoBouwjaarT;
	}

	/**
	 * @param autoBouwjaarT
	 *            the autoBouwjaarT to set
	 */
	public void setAutoBouwjaarT(JTextField autoBouwjaarT) {
		this.autoBouwjaarT = autoBouwjaarT;
	}

	/**
	 * @return the autoMerkNaamT
	 */
	public JTextField getAutoMerkNaamT() {
		return autoMerkNaamT;
	}

	/**
	 * @param autoMerkNaamT
	 *            the autoMerkNaamT to set
	 */
	public void setAutoMerkNaamT(JTextField autoMerkNaamT) {
		this.autoMerkNaamT = autoMerkNaamT;
	}

	/**
	 * @return the autoModelT
	 */
	public JTextField getAutoModelT() {
		return autoModelT;
	}

	/**
	 * @param autoModelT
	 *            the autoModelT to set
	 */
	public void setAutoModelT(JTextField autoModelT) {
		this.autoModelT = autoModelT;
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
	 * @return the klantAchternaamT
	 */
	public JTextField getKlantAchternaamT() {
		return klantAchternaamT;
	}

	/**
	 * @param klantAchternaamT
	 *            the klantAchternaamT to set
	 */
	public void setKlantAchternaamT(JTextField klantAchternaamT) {
		this.klantAchternaamT = klantAchternaamT;
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
}

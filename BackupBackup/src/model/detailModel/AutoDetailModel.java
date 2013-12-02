package model.detailModel;

import java.util.Observable;

import javax.swing.JTextField;

/**
 * De class die gebruikt wordt voor de detailpagina van een auto en daar data in op te slaan. Het extends een Observable.
 * @author Stef en Roald
 * @since 25-11-2013
 * @version 2.0
 */
public class AutoDetailModel extends Observable {
	private int autoNummer, klantNummer, bouwjaar;
	private String merk, model, klantnaam, kenteken;
	private JTextField autoNummerT, autoKentekenT, autoBouwjaarT,
			autoMerkNaamT, autoModelT, klantNummerT, klantAchternaamT;
	private String[] reparatieHeader, afspraakHeader;
	private Object[][] reparatieData, afspraakData;
	private boolean wijzigInfo;

	/**
	 * De constructor van AutoDetailModel.
	 * @param data Een 2D-array met daarin de de data van een auto.
	 */
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

	/**
	 * De method om aan te geven dat er iets verandert is en door te geven aan de observers.
	 */
	public void dataChanged() {
		setChanged();
		notifyObservers("dataChanged");
	}

	/**
	 * De method om het autonummer te returnen.
	 * @return Het autoNummer
	 */
	public int getAutoNummer() {
		return autoNummer;
	}

	/**
	 * De methode om een autonummer te setten.
	 * @param autoNummer Het autonummer om te setten.
	 */
	public void setAutoNummer(int autoNummer) {
		this.autoNummer = autoNummer;
	}

	/**
	 * De methode om het bouwjaar op te halen.
	 * @return Het bouwjaar.
	 */
	public int getBouwjaar() {
		return bouwjaar;
	}

	/**
	 * De methode om het bouwjaar te setten.
	 * @param bouwjaar het bouwjaar dat geset moet worden.
	 */
	public void setBouwjaar(int bouwjaar) {
		this.bouwjaar = bouwjaar;
	}

	/**
	 * De method om het klantnummer op te halen.
	 * @return Het klantNummer
	 */
	public int getKlantNummer() {
		return klantNummer;
	}

	/**
	 * De methode om het klantnummer te setten.
	 * @param klantNummer De klantNummer dat geset moet worden.
	 */
	public void setKlantNummer(int klantNummer) {
		this.klantNummer = klantNummer;
	}

	/**
	 * De methode om het merk op te halen
	 * @return Het merk.
	 */
	public String getMerk() {
		return merk;
	}

	/**
	 * De methode om het merk te setten.
	 * @param merk het merk dat geset moet worden.
	 */
	public void setMerk(String merk) {
		this.merk = merk;
	}

	/**
	 * De methode om het model te returnen
	 * @return Het model van de auto.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * De methode om het model te setten.
	 * @param model Het model van de auto om te setten.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * De methode om de naam van de klant op te halen.
	 * @return De klantnaam
	 */
	public String getKlantnaam() {
		return klantnaam;
	}

	/**
	 * De methode om de naam van de klant te setten.
	 * @param klantnaam De klantnaam.
	 */
	public void setKlantnaam(String klantnaam) {
		this.klantnaam = klantnaam;
	}

	/**
	 * De methode om de reparatieHeader op te halen.
	 * @return De reparatieHeader
	 */
	public String[] getReparatieHeader() {
		return reparatieHeader;
	}

	/**
	 * De methode om de reparatieHeader te setten.
	 * @param reparatieHeader De reparatieHeader to set
	 */
	public void setReparatieHeader(String[] reparatieHeader) {
		this.reparatieHeader = reparatieHeader;
	}

	/**
	 * De methode om reparatiedata op te halen
	 * @return Een 2D-array met daarin de reparatieData
	 */
	public Object[][] getReparatieData() {
		return reparatieData;
	}

	/**
	 * De methode om de reparatiedata te setten.
	 * @param reparatieData De reparatieData to set
	 */
	public void setReparatieData(Object[][] reparatieData) {
		this.reparatieData = reparatieData;
	}

	/**
	 * De methode om het kenteken op te halen.
	 * @return Het kenteken
	 */
	public String getKenteken() {
		return kenteken;
	}

	/**
	 * De methode om het kenteken te setten.
	 * @param kenteken Het kenteken to set
	 */
	public void setKenteken(String kenteken) {
		this.kenteken = kenteken;
	}

	/**
	 * De methode om de afspraakheader op te halen.
	 * @return De afspraakHeader
	 */
	public String[] getAfspraakHeader() {
		return afspraakHeader;
	}

	/**
	 * De methode om de afspraakHeader te setten.
	 * @param afspraakHeader De afspraakHeader to set
	 */
	public void setAfspraakHeader(String[] afspraakHeader) {
		this.afspraakHeader = afspraakHeader;
	}

	/**
	 * De methode om de afspraakData op te halen.
	 * @return De afspraakData
	 */
	public Object[][] getAfspraakData() {
		return afspraakData;
	}

	/**
	 * De methode om de afspraakdata te setten.
	 * @param afspraakData De afspraakData to set
	 */
	public void setAfspraakData(Object[][] afspraakData) {
		this.afspraakData = afspraakData;
	}

	/**
	 * De methode om auto data op te halen.
	 * @return Een String Array met daarin de Auto data.
	 */
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
	 * De methode om JTextField autoNummerT ophalen
	 * @return De autoNummerT
	 */
	public JTextField getAutoNummerT() {
		return autoNummerT;
	}

	/**
	 * De methode om autoNummerT te kunnen setten.
	 * @param autoNummerT De autoNummerT to set
	 */
	public void setAutoNummerT(JTextField autoNummerT) {
		this.autoNummerT = autoNummerT;
	}

	/**
	 * De methode om JTextField autoKentekenT ophalen
	 * @return De autoKentekenT
	 */
	public JTextField getAutoKentekenT() {
		return autoKentekenT;
	}

	/**
	 * De methode om JTextField autoKentekenT te setten.
	 * @param autoKentekenT De autoKentekenT to set
	 */
	public void setAutoKentekenT(JTextField autoKentekenT) {
		this.autoKentekenT = autoKentekenT;
	}

	/**
	 * De methode om JTextField autoBouwJaarT ophalen
	 * @return De autoBouwjaarT
	 */
	public JTextField getAutoBouwjaarT() {
		return autoBouwjaarT;
	}

	/**
	 * De methode om JTextField autoKentekenT te setten.
	 * @param autoBouwjaarT De autoBouwjaarT to set
	 */
	public void setAutoBouwjaarT(JTextField autoBouwjaarT) {
		this.autoBouwjaarT = autoBouwjaarT;
	}

	/**
	 * De methode om JTextField autoMerkNaamT ophalen
	 * @return De autoMerkNaamT
	 */
	public JTextField getAutoMerkNaamT() {
		return autoMerkNaamT;
	}

	/**
	 * De methode om JTextField autoMerkNaamT te setten
	 * @param autoMerkNaamT De autoMerkNaamT to set
	 */
	public void setAutoMerkNaamT(JTextField autoMerkNaamT) {
		this.autoMerkNaamT = autoMerkNaamT;
	}

	/**
	 * De methode om JTextField autoModelT ophalen
	 * @return De autoModelT
	 */
	public JTextField getAutoModelT() {
		return autoModelT;
	}

	/**
	 * De methode om JTextField autoModelT te setten.
	 * @param autoModelT De autoModelT to set
	 */
	public void setAutoModelT(JTextField autoModelT) {
		this.autoModelT = autoModelT;
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
	 * De methode om JTextField klantAchternaamT ophalen
	 * @return De klantAchternaamT
	 */
	public JTextField getKlantAchternaamT() {
		return klantAchternaamT;
	}

	/**
	 * De methode om JTextField klantAchternaamT te setten.
	 * @param klantAchternaamT De klantAchternaamT to set
	 */
	public void setKlantAchternaamT(JTextField klantAchternaamT) {
		this.klantAchternaamT = klantAchternaamT;
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
}

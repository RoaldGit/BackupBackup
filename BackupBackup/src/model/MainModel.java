package model;

import java.util.Observable;

import model.detailModel.AutoDetailModel;
import model.detailModel.KlantDetailModel;
import model.detailModel.ReparatieDetailModel;
import control.DOAs;

public class MainModel extends Observable{
	private String activePage;
	private SearchModel autoModel, klantModel, reparatieModel, monteurModel,
			roosterModel;
	private KlantDetailModel klantDetail;
	private ReparatieDetailModel reparatieDetail;
	private AutoDetailModel autoDetail;
	private String[] autoHeader, klantHeader, reparatieHeader, monteurHeader,
			roosterHeader;
	private DOAs doa;

	public MainModel(){
		activePage = "home";

		doa = new DOAs(this);

		setHeaders();
		setModels();
	}

	public void setHeaders() {
		autoHeader = new String[] { "Autonummer", "Kenteken", "BouwJaar",
				"Klantnummer", "Merknaam", "Model" };
		klantHeader = new String[] { "Klantnummer", "Achternaam", "Voornaam",
				"Adres", "Woonplaats", "Postcode" };
		reparatieHeader = new String[] { "Reparatienummer", "Autonummer",
				"Opmerkingen", "Klaar", "Factuur Verzonden", "Factuur Betaald" };
		monteurHeader = new String[] { "Personeelnummer", "Achternaam",
				 "Voornaam","Adres", "Woonplaats", "Postcode", "Uurloon" };
		roosterHeader = new String[] { "Start tijd", "Eind tijd", "Bezigheid",
				"Reparatie nummer", "Monteur" };
	}
	
	public void setModels() {
		Object[][] data = new Object[][] { { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" } };

		autoModel = new SearchModel(data, autoHeader);
		klantModel = new SearchModel(data, klantHeader);
		reparatieModel = new SearchModel(data, reparatieHeader);
		monteurModel = new SearchModel(data, monteurHeader);
		roosterModel = new SearchModel(data, roosterHeader);

		klantDetail = new KlantDetailModel(data);
		autoDetail = new AutoDetailModel(data);
		reparatieDetail = new ReparatieDetailModel(data);
	}

	public void setPage(String page) {
		activePage = page;
		setChanged();
		notifyObservers(page);
	}

	public String getActivePage() {
		return activePage;
	}

	public DOAs getDoa() {
		return doa;
	}

	public SearchModel getAutoModel() {
		return autoModel;
	}

	public SearchModel getKlantModel() {
		return klantModel;
	}

	public SearchModel getReparatieModel() {
		return reparatieModel;
	}

	public SearchModel getMonteurModel() {
		return monteurModel;
	}

	public SearchModel getRoosterModel() {
		return roosterModel;
	}

	public KlantDetailModel getKlantDetail() {
		return klantDetail;
	}
	
	public ReparatieDetailModel getReparatieDetail() {
		return reparatieDetail;
	}
	
	/**
	 * @return the autoDetail
	 */
	public AutoDetailModel getAutoDetail() {
		return autoDetail;
	}

	/**
	 * @param autoDetail the autoDetail to set
	 */
	public void setAutoDetail(AutoDetailModel autoDetail) {
		this.autoDetail = autoDetail;
	}
}

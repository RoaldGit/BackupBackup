package model;

import java.util.Observable;

import model.detailModel.KlantDetailModel;

public class MainModel extends Observable{
	private String activePage;
	private SearchModel autoModel, klantModel, reparatieModel, monteurModel,
			roosterModel;
	private KlantDetailModel klantDetail;
	private String[] autoHeader, klantHeader, reparatieHeader, monteurHeader,
			roosterHeader;

	public MainModel(){
		activePage = "home";

		setHeaders();
		setModels();
	}

	public void setHeaders() {
		autoHeader = new String[] { "AutoID", "Kenteken", "BouwJaar",
				"PersoonID", "MerkID", "Model" };
		klantHeader = new String[] { "PersoonID", "Voornaam", "Achternaam",
				"Adres", "Woonplaats", "Postcode" };
		reparatieHeader = new String[] { "ReparatieID", "AutoID",
				"Opmerkingen", "Klaar", "Factuur Verzonden", "Factuur Betaald" };
		monteurHeader = new String[] { "PersoonIID", "Voornaam",
				 "Achternaam","Adres", "Woonplaats", "Postcode", "Uurloon" };
		roosterHeader = new String[] { "AutoID", "PersoonID", "Merknaam",
			 "Kenteken", "Bouwjaar" };
	}
	
	public void setModels() {
		Object[][] data = new Object[][] { { "", "", "", "", "", "" },
				{ "", "", "", "", "", "" }, { "", "", "", "", "", "" } };

		autoModel = new SearchModel(data, autoHeader);
		klantModel = new SearchModel(data, klantHeader);
		reparatieModel = new SearchModel(data, reparatieHeader);
		monteurModel = new SearchModel(data, monteurHeader);
		roosterModel = new SearchModel(data, roosterHeader);

		klantDetail = new KlantDetailModel(data, data);
	}

	public void setPage(String page) {
		activePage = page;
		setChanged();
		notifyObservers(page);
	}

	public String getActivePage() {
		return activePage;
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
}

package model;

import java.util.Observable;

public class MainModel extends Observable{
	private String activePage;
	private Model autoModel, klantModel, reparatieModel, monteurModel,
			roosterModel;
	private String[] autoHeader, klantHeader, reparatieHeader, monteurHeader,
			roosterHeader;

	public MainModel(){
		activePage = "home";

		setHeaders();
		setModels();
	}

	public void setHeaders() {
		autoHeader = new String[] { "AutoID", "PersoonID", "Merknaam",
				"Kenteken", "Bouwjaar" };
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

		autoModel = new Model(data, autoHeader);
		klantModel = new Model(data, klantHeader);
		reparatieModel = new Model(data, reparatieHeader);
		monteurModel = new Model(data, monteurHeader);
		roosterModel = new Model(data, roosterHeader);
	}

	public void setPage(String page) {
		activePage = page;
		setChanged();
		notifyObservers(page);
	}

	public String getActivePage() {
		return activePage;
	}

	public Model getAutoModel() {
		return autoModel;
	}

	public Model getKlantModel() {
		return klantModel;
	}

	public Model getReparatieModel() {
		return reparatieModel;
	}

	public Model getMonteurModel() {
		return monteurModel;
	}

	public Model getRoosterModel() {
		return roosterModel;
	}
}

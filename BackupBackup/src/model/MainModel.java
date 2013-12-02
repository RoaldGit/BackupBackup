package model;

import java.util.Observable;

import model.detailModel.AutoDetailModel;
import model.detailModel.KlantDetailModel;
import model.detailModel.MonteurDetailModel;
import model.detailModel.ReparatieDetailModel;
import control.DOAs;

/**
 * De class waar alle andere modellen zijn opgeslagen en ook andere belangrijke data inzit, het extend een Observable.
 * @author Stef en Roald
 * @since 30-10-2013
 * @version 2.0
 */
public class MainModel extends Observable{
	private String activePage;
	private SearchModel autoModel, klantModel, reparatieModel, monteurModel,
			roosterModel;
	private KlantDetailModel klantDetail;
	private ReparatieDetailModel reparatieDetail;
	private AutoDetailModel autoDetail;
	private MonteurDetailModel monteurDetail;
	private String[] autoHeader, klantHeader, reparatieHeader, monteurHeader,
			roosterHeader;
	private DOAs doa;

	/**
	 * De constructor voor MainModel.
	 */
	public MainModel(){
		activePage = "home";

		doa = new DOAs(this);

		setHeaders();
		setModels();
	}

	/**
	 * De methode om headers te setten voor de tables.
	 */
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
	
	/**
	 * De methode om models te setten voor het programma.
	 */
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
		monteurDetail = new MonteurDetailModel(data);
	}

	/**
	 * De methode om aan te geven op welke page het programma zit.
	 * @param page Page is de naam van de pagina.
	 */
	public void setPage(String page) {
		activePage = page;
		setChanged();
		notifyObservers(page);
	}

	/**
	 * De methode die de huidige pagina returned.
	 * @return Returned een String met daarin de huidige pagina.
	 */
	public String getActivePage() {
		return activePage;
	}

	/**
	 * De methode die alle doas ophaalt.
	 * @return Een object van het DOA klasse.
	 */
	public DOAs getDoa() {
		return doa;
	}

	/**
	 * De methode SearchModel autoModel op te halen.
	 * @return Returned SearchModel van het automodel.
	 */
	public SearchModel getAutoModel() {
		return autoModel;
	}

	/**
	 * De methode SearchModel KlantModel op te halen.
	 * @return Returned SearchModel van het KlantModel.
	 */
	public SearchModel getKlantModel() {
		return klantModel;
	}

	/**
	 * De methode SearchModel ReparatieModel op te halen.
	 * @return Returned SearchModel van het ReparatieModel.
	 */
	public SearchModel getReparatieModel() {
		return reparatieModel;
	}

	/**
	 * De methode SearchModel MonteurModel op te halen.
	 * @return Returned SearchModel van het MonteurModel.
	 */
	public SearchModel getMonteurModel() {
		return monteurModel;
	}

	/**
	 * De methode SearchModel RoosterModel op te halen.
	 * @return Returned SearchModel van het RoosterModel.
	 */
	public SearchModel getRoosterModel() {
		return roosterModel;
	}

	/**
	 * De methode om het KlantDetailModel op te halen.
	 * @return Returned het KlantDetailModel.
	 */
	public KlantDetailModel getKlantDetail() {
		return klantDetail;
	}
	
	/**
	 * De methode om het ReparatieDetailModel op te halen.
	 * @return Returned het ReparatieDetailModel.
	 */
	public ReparatieDetailModel getReparatieDetail() {
		return reparatieDetail;
	}
	
	/**
	 * De methode om het AutoDetailModel op te halen.
	 * @return Returned het AutoDetailModel.
	 */	
	public AutoDetailModel getAutoDetail() {
		return autoDetail;
	}

	/**
	 * De methode om het AutoDetailModel te setten.
	 * @param autoDetail De AutoDetailModel om te setten.
	 */
	public void setAutoDetail(AutoDetailModel autoDetail) {
		this.autoDetail = autoDetail;
	}
	
	/**
	 * De methode om het MonteurDetailModel te setten.
	 * @param monteurDetail De MonteurDetailModel om te setten.
	 */
	public void setMonteurDetial(MonteurDetailModel monteurDetail){
		this.monteurDetail = monteurDetail;
	}
	
	/**
	 * De methode om het MonteurDetailModel op te halen.
	 * @return Returned het MonteurDetailModel.
	 */
	public MonteurDetailModel getMonteurDetail(){
		return monteurDetail;
	}
}

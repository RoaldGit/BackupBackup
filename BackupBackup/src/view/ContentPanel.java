package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.MainModel;
import view.detail.AutoDetail;
import view.detail.KlantDetail;
import view.detail.ReparatieDetail;
import view.search.AutoSearch;
import view.search.KlantSearch;
import view.search.MonteurSearch;
import view.search.ReparatieSearch;
import view.search.RoosterSearch;
import control.DOAs;



public class ContentPanel extends JPanel implements Observer{
	private MainModel mainModel;
	private JPanel home, autoSearch, klantSearch, reparatieSearch,
			monteurSearch, roosterSearch, klantDetail, autoDetail,
			reparatieDetail;

	public ContentPanel(MainModel model){
		mainModel = model;

		mainModel.addObserver(this);

		home = new JPanel();
		
		DOAs doa = new DOAs(mainModel);
		
		autoSearch = new AutoSearch(mainModel);
		klantSearch = new KlantSearch(mainModel);
		reparatieSearch = new ReparatieSearch(mainModel);
		monteurSearch = new MonteurSearch(mainModel);
		roosterSearch = new RoosterSearch(mainModel);

		klantDetail = new KlantDetail(mainModel);
		autoDetail = new AutoDetail(mainModel);
		reparatieDetail = new ReparatieDetail(mainModel);

		add(home);
		add(autoSearch);
		add(klantSearch);
		add(reparatieSearch);
		add(monteurSearch);
		add(roosterSearch);

		add(klantDetail);
		add(autoDetail);
		add(reparatieDetail);

		allInvisible();
	}

	public void update(Observable obs, Object obj) {
		allInvisible();

		switch ((String) obj) {
		case ("home"):
			home.setVisible(false);
			reparatieDetail.setVisible(true);
			break;
		case("auto"):
			autoSearch.setVisible(true);
			break;
		case ("autoDetail"):
			autoDetail.setVisible(true);
			break;
		case ("klant"):
			klantSearch.setVisible(true);
			break;
		case ("klantDetail"):
			klantDetail.setVisible(true);
			break;
		case ("reparatie"):
			reparatieSearch.setVisible(true);
			break;
		case ("reparatieDetail"):
			reparatieDetail.setVisible(true);
			break;
		case ("monteur"):
			monteurSearch.setVisible(true);
			break;
		case ("rooster"):
			roosterSearch.setVisible(true);
			break;
		}
	}

	public void allInvisible() {
		home.setVisible(false);
		autoSearch.setVisible(false);
		klantSearch.setVisible(false);
		reparatieSearch.setVisible(false);
		monteurSearch.setVisible(false);
		roosterSearch.setVisible(false);

		klantDetail.setVisible(false);
		autoDetail.setVisible(false);
		reparatieDetail.setVisible(false);
	}
}

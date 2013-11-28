package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.MainModel;
import view.search.AutoSearch;
import view.search.KlantSearch;
import view.search.MonteurSearch;
import view.search.ReparatieSearch;
import view.search.RoosterSearch;
import control.DOAs;



public class ContentPanel extends JPanel implements Observer{
	private MainModel mainModel;
	private DetailPanel autoPanel, reparatiePanel, klantPanel, monteurPanel, roosterPanel;
	private JPanel home, autoSearch, klantSearch, reparatieSearch,
			monteurSearch, roosterSearch;

	public ContentPanel(MainModel model){
		mainModel = model;

		mainModel.addObserver(this);

		home = new JPanel();
		

		DOAs doa = new DOAs(mainModel);
		
		autoSearch = new AutoSearch(mainModel, doa);
		klantSearch = new KlantSearch(mainModel, doa);
		reparatieSearch = new ReparatieSearch(mainModel, doa);
		monteurSearch = new MonteurSearch(mainModel, doa);
		roosterSearch = new RoosterSearch(mainModel, doa);

		add(home);
		add(autoSearch);
		add(klantSearch);
		add(reparatieSearch);
		add(monteurSearch);
		add(roosterSearch);

		allInvisible();
	}

	public void update(Observable obs, Object obj) {
		allInvisible();

		switch ((String) obj) {
		case ("home"):
			home.setVisible(true);
			break;
		case("auto"):
			autoSearch.setVisible(true);
			break;
		case ("klant"):
			klantSearch.setVisible(true);
			break;
		case ("reparatie"):
			reparatieSearch.setVisible(true);
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
	}
}

package view.search;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.MainModel;
import model.SearchModel;
import view.Tabel;
import control.DOAs;
import control.InvulVeld;

public class KlantSearch extends JPanel implements Observer {
	private InvulVeld klantVeld;
	private Tabel klantTable;
	private JScrollPane klantScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	public KlantSearch(MainModel model, DOAs doa) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getKlantModel();

		klantVeld = new InvulVeld(40, "klant", mainModel, doa);

		klantTable = new Tabel(dataModel);
		klantScroll = new JScrollPane(klantTable);
		klantScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(klantVeld);
		add(klantScroll);
	}

	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				klantTable.changeData();
			}
		}
	}
}
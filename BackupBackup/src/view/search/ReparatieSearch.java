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

public class ReparatieSearch extends JPanel implements Observer {
	private InvulVeld reparatieVeld;
	private Tabel reparatieTable;
	private JScrollPane reparatieScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	public ReparatieSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getReparatieModel();
		DOAs doa = mainModel.getDoa();

		reparatieVeld = new InvulVeld(40, "reparatie", mainModel, doa);

		reparatieTable = new Tabel(dataModel);
		reparatieScroll = new JScrollPane(reparatieTable);
		reparatieScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(reparatieVeld);
		add(reparatieScroll);
	}

	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				reparatieTable.changeData();
			}
		}
	}
}

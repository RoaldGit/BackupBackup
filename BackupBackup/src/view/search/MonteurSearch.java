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
import control.TableEvent;

public class MonteurSearch extends JPanel implements Observer {
	private InvulVeld monteurVeld;
	private Tabel monteurTable;
	private JScrollPane monteurScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	public MonteurSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getMonteurModel();
		DOAs doa = mainModel.getDoa();

		monteurVeld = new InvulVeld(40, "monteur", mainModel, doa);

		monteurTable = new Tabel(dataModel);
		monteurTable.setName("monteurTable");
		monteurTable.addMouseListener(new TableEvent(mainModel, doa));

		monteurScroll = new JScrollPane(monteurTable);
		monteurScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(monteurVeld);
		add(monteurScroll);
	}

	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				monteurTable.changeData();
			}
		}
	}
}
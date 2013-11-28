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

public class AutoSearch extends JPanel implements Observer {
	private InvulVeld autoVeld;
	private Tabel autoTable;
	private JScrollPane autoScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	public AutoSearch(MainModel model, DOAs doa) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getAutoModel();

		autoVeld = new InvulVeld(40, "auto", mainModel, doa);

		autoTable = new Tabel(dataModel);
		autoScroll = new JScrollPane(autoTable);
		autoScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(autoVeld);
		add(autoScroll);
	}

	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				autoTable.changeData();
			}
		}
	}
}

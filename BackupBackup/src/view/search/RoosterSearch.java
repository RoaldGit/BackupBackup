package view.search;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.MainModel;
import model.Model;
import view.Tabel;
import control.DOAs;
import control.InvulVeld;

public class RoosterSearch extends JPanel implements Observer {
	private InvulVeld roosterVeld;
	private Tabel roosterTable;
	private JScrollPane roosterScroll;
	private MainModel mainModel;
	private Model dataModel;

	public RoosterSearch(MainModel model, DOAs doa) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getRoosterModel();

		roosterVeld = new InvulVeld(40, "auto", mainModel, doa);

		roosterTable = new Tabel(dataModel);
		roosterScroll = new JScrollPane(roosterTable);
		roosterScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(roosterVeld);
		add(roosterScroll);
	}

	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				roosterTable.changeData();
			}
		}
	}
}
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
import control.InvulVeld;
import control.TableEvent;

/**
 * De class die gebruikt wordt voor de roostersearch weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class RoosterSearch extends JPanel implements Observer {
	private InvulVeld roosterVeld;
	private Tabel roosterTable;
	private JScrollPane roosterScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public RoosterSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getRoosterModel();

		roosterVeld = new InvulVeld(40, "rooster", mainModel);

		roosterTable = new Tabel(dataModel);
		roosterTable.setName("roosterTable");
		roosterTable.addMouseListener(new TableEvent(mainModel));

		roosterScroll = new JScrollPane(roosterTable);
		roosterScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(roosterVeld);
		add(roosterScroll);
	}

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				roosterTable.changeData();
			}
		}
	}
}
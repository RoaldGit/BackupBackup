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
 * De class die gebruikt wordt voor de reparatiesearch weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class ReparatieSearch extends JPanel implements Observer {
	private InvulVeld reparatieVeld;
	private Tabel reparatieTable;
	private JScrollPane reparatieScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public ReparatieSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getReparatieModel();

		reparatieVeld = new InvulVeld(40, "reparatie", mainModel);

		reparatieTable = new Tabel(dataModel);
		reparatieTable.setName("reparatieTable");
		reparatieTable.addMouseListener(new TableEvent(mainModel));

		reparatieScroll = new JScrollPane(reparatieTable);
		reparatieScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(reparatieVeld);
		add(reparatieScroll);
	}

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				reparatieTable.changeData();
			}
		}
	}
}

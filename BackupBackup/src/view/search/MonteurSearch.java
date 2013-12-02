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
 * De class die gebruikt wordt voor de monteursearch weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class MonteurSearch extends JPanel implements Observer {
	private InvulVeld monteurVeld;
	private Tabel monteurTable;
	private JScrollPane monteurScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public MonteurSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getMonteurModel();

		monteurVeld = new InvulVeld(40, "monteur", mainModel);

		monteurTable = new Tabel(dataModel);
		monteurTable.setName("monteurTable");
		monteurTable.addMouseListener(new TableEvent(mainModel));

		monteurScroll = new JScrollPane(monteurTable);
		monteurScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(monteurVeld);
		add(monteurScroll);
	}

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				monteurTable.changeData();
				monteurTable.setupRenderer(6);
			}
		}
	}
}
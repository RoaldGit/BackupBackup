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
 * De class die gebruikt wordt voor de autosearch weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class AutoSearch extends JPanel implements Observer {
	private InvulVeld autoVeld;
	private Tabel autoTable;
	private JScrollPane autoScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public AutoSearch(MainModel model) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		mainModel = model;
		dataModel = mainModel.getAutoModel();

		autoVeld = new InvulVeld(40, "auto", mainModel);

		autoTable = new Tabel(dataModel);
		autoTable.setName("autoTable");
		autoTable.addMouseListener(new TableEvent(model));

		autoScroll = new JScrollPane(autoTable);
		autoScroll.setPreferredSize(new Dimension(1250, 610));

		dataModel.addObserver(this);

		add(autoVeld);
		add(autoScroll);
	}

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				autoTable.changeData();
			}
		}
	}
}

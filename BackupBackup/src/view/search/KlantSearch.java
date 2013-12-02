package view.search;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.MainModel;
import model.SearchModel;
import view.Tabel;
import control.Button;
import control.InvulVeld;
import control.TableEvent;

/**
 * De class die gebruikt wordt voor de klantsearch weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 28-11-2013
 * @version 2.0
 */
public class KlantSearch extends JPanel implements Observer {
	private InvulVeld klantVeld;
	private Tabel klantTable;
	private Button nieuweKlant;
	private JScrollPane klantScroll;
	private MainModel mainModel;
	private SearchModel dataModel;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public KlantSearch(MainModel model) {
		setLayout(null);

		mainModel = model;
		dataModel = mainModel.getKlantModel();

		klantVeld = new InvulVeld(40, "klant", mainModel);
		klantVeld.setBounds(400, 0, 400, 20);

		klantTable = new Tabel(dataModel);
		klantTable.setName("klantTable");
		klantTable.addMouseListener(new TableEvent(model));

		klantScroll = new JScrollPane(klantTable);
		klantScroll.setBounds(0, 20, 1250, 590);
		
		nieuweKlant = new Button("Voeg klant toe", mainModel);
		nieuweKlant.setName("nieuweKlant");
		nieuweKlant.setBounds(850, 0, 200, 20);

		dataModel.addObserver(this);

		add(nieuweKlant);
		add(klantVeld);
		add(klantScroll);

		setPreferredSize(new Dimension(1250, 610));
	}

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
	public void update(Observable obs, Object obj) {
		if (obs == dataModel) {
			if (obj.equals("search")) {
				klantTable.changeData();
			}
		}
	}
}

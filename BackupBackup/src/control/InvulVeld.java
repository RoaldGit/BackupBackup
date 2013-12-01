package control;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.MainModel;


public class InvulVeld extends JTextField{
	String page;
	private MainModel mainModel;
	private DOAs doa;

	public InvulVeld(int x, String p, MainModel model) {
		super(x);
		page = p;
		mainModel = model;
		doa = mainModel.getDoa();

		getDocument().addDocumentListener(new Search());

		mainModel.getAutoModel().setData(doa.alleAutos());
		mainModel.getReparatieModel().setData(doa.alleReparaties());
		mainModel.getKlantModel().setData(doa.alleKlanten());
		mainModel.getMonteurModel().setData(doa.alleMonteurs());
		mainModel.getRoosterModel().setData(doa.alleRoosters());
	}

	class Search implements DocumentListener {
		public void changedUpdate(DocumentEvent e) {
			search(e);
		}
		public void removeUpdate(DocumentEvent e) {
			search(e);
	 	}
		public void insertUpdate(DocumentEvent e) {
			search(e);
		}

		public void search(DocumentEvent e) {
			String param = getText();
			if (param.equals("") || param == null) {
				switch (page) {
				case ("auto"):
					mainModel.getAutoModel().setData(doa.alleAutos());
					break;
				case ("reparatie"):
					mainModel.getReparatieModel().setData(doa.alleReparaties());
					break;
				case ("klant"):
					mainModel.getKlantModel().setData(doa.alleKlanten());
					break;
				case ("monteur"):
					mainModel.getMonteurModel().setData(doa.alleMonteurs());
					break;
				case ("rooster"):
					mainModel.getRoosterModel().setData(doa.alleRoosters());
					break;
				}
			}
			if (param.length() > 0) {
				switch (page) {
				case ("auto"):
					mainModel.getAutoModel().setData(doa.autoSearch(param));
					break;
				case ("reparatie"):
					mainModel.getReparatieModel().setData(
							doa.reparatieSearch(param));
					break;
				case ("klant"):
					mainModel.getKlantModel().setData(doa.klantSearch(param));
					break;
				case ("monteur"):
					mainModel.getMonteurModel().setData(
							doa.monteurSearch(param));
					break;
				case ("rooster"):
					mainModel.getRoosterModel().setData(
							doa.roosterSearch(param));
					break;
				}
			}
			requestFocus();
		}
	}
}

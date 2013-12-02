package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainModel;
import model.detailModel.AutoDetailModel;
import model.detailModel.Factuur;
import model.detailModel.KlantDetailModel;
import model.detailModel.MonteurDetailModel;
import model.detailModel.ReparatieDetailModel;

/**
 * Deze class extends JButton zodat er aparte constructoren gemaakt konden worden.
 * @author Stef en Roald
 * @since 30-10-2013
 * @version 2.0
 */
public class Button extends JButton{
	private MainModel mainModel;
	private DOAs doa;

	/**
	 * De eerste constructor om posities en model mee te geven aan de button.
	 * @param title De naam van de button.
	 * @param model Het mainmodel die over het gehele project gebruikt wordt.
	 * @param x De x positie van de button.
	 * @param y De y positie van de button.
	 */
	public Button(String title, MainModel model, int x, int y) {
		super(title);
		mainModel = model;
		doa = mainModel.getDoa();
		setBounds(x,y,100,30);
		addActionListener(new Action());
	}

	/**
	 * De tweede constructor waar alleen een titel en model aan meegegeven worden.
	 * @param title De naam van de button.
	 * @param model Het mainmodel die over het gehele project gebruikt wordt.
	 */
	public Button(String title, MainModel model) {
		super(title);
		mainModel = model;
		doa = mainModel.getDoa();
		addActionListener(new Action());
	}

	/**
	 * De ActionListener, die aangeroepen wordt als er op de button geklikt wordt, haalt een naam op en handelt het klikken af.
	 * @author Stef en Roald
	 * @since 30-10-2013
	 * @version 2.0
	 */
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton) e.getSource();
			String name = button.getName();
			switch (name) {
			case "home":
				mainModel.setPage("home");
				break;
			case "auto":
				mainModel.setPage("auto");
				mainModel.getAutoModel().setData(doa.alleAutos());
				break;
			case "reparatie":
				mainModel.setPage("reparatie");
				mainModel.getReparatieModel().setData(doa.alleReparaties());
				break;
			case "klant":
				mainModel.setPage("klant");
				mainModel.getKlantModel().setData(doa.alleKlanten());
				break;
			case "wijzigKlant":
				changeKlantData();
				break;
			case "wijzigMonteur":
				changeMonteurData();
				break;
			case "voegAutoToe":
				doa.voegAutoToe();
				doa.retreiveKlantData();
				break;
			case "nieuweKlant":
				doa.nieuweKlant();
				break;
			case "voegOnderdeelToe":
				doa.voegOnderdeelToe();
				doa.retreiveReparatieData();
			case "wijzigAuto":
				changeAutoData();
				break;
			case "wijzigReparatie":
				changeReparatieData();
				break;
			case "nieuweReparatie":
				doa.nieuweReparatie();
				break;
			case "printFactuur":
				Factuur factuur = new Factuur(mainModel.getReparatieDetail());
				break;
			case "monteur":
				mainModel.setPage("monteur");
				mainModel.getMonteurModel().setData(doa.alleMonteurs());
				break;
			case "rooster":
				mainModel.setPage("rooster");
				mainModel.getRoosterModel().setData(doa.alleRoosters());
				break;
			}
		}
	}

	/**
	 * Deze methode wordt gebruikt om aan te geven dat er iets in de klantdata gewijzigd is.
	 */
	public void changeKlantData() {
		KlantDetailModel detailModel = mainModel.getKlantDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeKlantData();
		} else
			detailModel.wijzigInfo();
	}

	/**
	 * Deze methode wordt gebruikt om aan te geven dat er iets in de autodata gewijzigd is.
	 */
	public void changeAutoData() {
		AutoDetailModel detailModel = mainModel.getAutoDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeAutoData();
		} else
			detailModel.wijzigInfo();
	}

	/**
	 * Deze methode wordt gebruikt om aan te geven dat er iets in de reparatiedata gewijzigd is.
	 */
	public void changeReparatieData() {
		ReparatieDetailModel detailModel = mainModel.getReparatieDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeReparatieData();
		} else
			detailModel.wijzigInfo();
	}

	/**
	 * Deze methode wordt gebruikt om aan te geven dat er iets in de monteurdata gewijzigd is.
	 */
	public void changeMonteurData() {
		MonteurDetailModel detailModel = mainModel.getMonteurDetail();
		if (detailModel.isWijzigInfo()) {
			doa.changeMonteurData();
			detailModel.wijzigInfo();
		} else
			detailModel.wijzigInfo();
	}
}

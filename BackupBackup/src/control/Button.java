package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainModel;
import model.detailModel.AutoDetailModel;
import model.detailModel.Factuur;
import model.detailModel.KlantDetailModel;
import model.detailModel.ReparatieDetailModel;

public class Button extends JButton{
	private MainModel mainModel;
	private DOAs doa;

	public Button(String title, MainModel model, int x, int y) {
		super(title);
		mainModel = model;
		doa = mainModel.getDoa();
		setBounds(x,y,100,30);
		addActionListener(new Action());
	}

	public Button(String title, MainModel model) {
		super(title);
		mainModel = model;
		doa = mainModel.getDoa();
		addActionListener(new Action());
	}

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
			case "voegAutoToe":
				doa.voegAutoToe();
				doa.retreiveKlantData();
				break;
			case "voegOnderdeelToe":
				doa.voegOnderdeelToe();
				doa.retreiveReparatieData();
			case "wijzigAuto":
				changeAutoData();
				break;
			case "wijzigReparatie":
				changeReparatie();
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

	public void changeKlantData() {
		KlantDetailModel detailModel = mainModel.getKlantDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeKlantData();
		} else
			detailModel.wijzigInfo();
	}

	public void changeAutoData() {
		AutoDetailModel detailModel = mainModel.getAutoDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeAutoData();
		} else
			detailModel.wijzigInfo();
	}

	public void changeReparatie() {
		ReparatieDetailModel detailModel = mainModel.getReparatieDetail();
		if (detailModel.isWijzigInfo()) {
			detailModel.wijzigInfo();
			doa.changeReparatieData();
		} else
			detailModel.wijzigInfo();
	}
}

package view.detail;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.MainModel;
import model.detailModel.KlantDetailModel;
import model.detailModel.MonteurDetailModel;
import view.Tabel;
import control.Button;
import control.DOAs;
import control.TableEvent;

public class MonteurDetail extends JPanel implements Observer {
	private MonteurDetailModel detailModel;
	private MainModel mainModel;
	private JLabel monteurNummerL, monteurVoorNaamL, monteurAchterNaamL, monteurAdresL,
			monteurWoonplaatsL, monteurpostcodeL, uurLoonL,
			geplandeAfsprakenL, autosL; // afspraken en autos aanpassen
	private JTextField monteurNummerT, monteurVoorNaamT, monteurAchterNaamT,
			monteurAdresT, monteurWoonplaatsT, monteurPostcodeT, uurLoonT;
	private Tabel afspraken, auto; // Same here
	private JScrollPane afsprakenScroll, autoScroll; // En dit
	private Button wijzigGegevens, voegAutoToe; // En dit ook
	private DOAs doa;

	public MonteurDetail(MainModel model) {
		setLayout(null);

		mainModel = model;
		doa = mainModel.getDoa();

		detailModel = model.getMonteurDetail();

		detailModel.addObserver(this);
		
		setPreferredSize(new Dimension(1250, 610));

		setupLabels();
		setupTextFields();
		setupTables();
		setupButtons();

		updateGegevens();
		// TODO Afsprakentabel, add auto en wijzig gegevens action events
	}

	public void setupLabels() {
		monteurNummerL = new JLabel("Monteurnummer:");
		monteurVoorNaamL = new JLabel("Voornaam:");
		monteurAchterNaamL = new JLabel("Achternaam:");
		monteurAdresL = new JLabel("Adres:");
		monteurWoonplaatsL = new JLabel("Woonplaats:");
		monteurpostcodeL = new JLabel("Postcode:");
		uurLoonL = new JLabel("Uurloon:");
		geplandeAfsprakenL = new JLabel("Geplande afspraken:"); // TODO
		autosL = new JLabel("Auto's:"); // TODO

		monteurNummerL.setBounds(5, 0, 100, 20);
		monteurVoorNaamL.setBounds(5, 25, 100, 20);
		monteurAchterNaamL.setBounds(5, 50, 100, 20);
		monteurAdresL.setBounds(5, 75, 100, 20);
		monteurWoonplaatsL.setBounds(5, 100, 100, 20);
		monteurpostcodeL.setBounds(5, 125, 100, 20);
		uurLoonL.setBounds(5, 150, 100, 20);
		geplandeAfsprakenL.setBounds(400, 0, 200, 20);
		autosL.setBounds(400, 300, 100, 20);

		add(monteurNummerL);
		add(monteurVoorNaamL);
		add(monteurAchterNaamL);
		add(monteurAdresL);
		add(monteurWoonplaatsL);
		add(monteurpostcodeL);
		add(uurLoonL);
		add(geplandeAfsprakenL);
		add(autosL);
	}

	public void setupTextFields() {
		monteurNummerT = new JTextField();
		monteurVoorNaamT = new JTextField();
		monteurAchterNaamT = new JTextField();
		monteurAdresT = new JTextField();
		monteurWoonplaatsT = new JTextField();
		monteurPostcodeT = new JTextField();
		uurLoonT = new JTextField();

		monteurNummerT.setBounds(120, 0, 200, 20);
		monteurVoorNaamT.setBounds(120, 25, 200, 20);
		monteurAchterNaamT.setBounds(120, 50, 200, 20);
		monteurAdresT.setBounds(120, 75, 200, 20);
		monteurWoonplaatsT.setBounds(120, 100, 200, 20);
		monteurPostcodeT.setBounds(120, 125, 200, 20);
		uurLoonT.setBounds(120, 150, 200, 20);

		monteurNummerT.setEditable(false);
		monteurVoorNaamT.setEditable(false);
		monteurAchterNaamT.setEditable(false);
		monteurAdresT.setEditable(false);
		monteurWoonplaatsT.setEditable(false);
		monteurPostcodeT.setEditable(false);
		uurLoonT.setEditable(false);

		add(monteurNummerT);
		add(monteurVoorNaamT);
		add(monteurAchterNaamT);
		add(monteurAdresT);
		add(monteurWoonplaatsT);
		add(monteurPostcodeT);
		add(uurLoonT);

		detailModel.setKlantNummerT(monteurNummerT);
		detailModel.setKlantVoorNaamT(monteurVoorNaamT);
		detailModel.setKlantAchterNaamT(monteurAchterNaamT);
		detailModel.setKlantAdresT(monteurAdresT);
		detailModel.setKlantWoonplaatsT(monteurWoonplaatsT);
		detailModel.setKlantPostcodeT(monteurPostcodeT);
		detailModel.setKlantAantalAutosT(uurLoonT);
	}

	public void setupTables() {
		afspraken = new Tabel(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		afsprakenScroll = new JScrollPane(afspraken);
		afsprakenScroll.setBounds(400, 20, 700, 200);

		auto = new Tabel(detailModel.getAutos(), detailModel.getAutoHeader());
		auto.setName("klantDetailAuto");
		auto.addMouseListener(new TableEvent(mainModel, doa));

		autoScroll = new JScrollPane(auto);
		autoScroll.setBounds(400, 320, 700, 200);

		add(afsprakenScroll);
		add(autoScroll);
	}

	public void setupButtons() {
		wijzigGegevens = new Button("Wijzig gegevens", mainModel);
		wijzigGegevens.setBounds(120, 180, 200, 20);
		wijzigGegevens.setName("wijzigKlant");

		voegAutoToe = new Button("Voeg auto toe", mainModel);
		voegAutoToe.setBounds(500, 300, 200, 20);
		voegAutoToe.setName("voegAutoToe");

		add(wijzigGegevens);
		add(voegAutoToe);
	}

	public void updateGegevens() {
		monteurNummerT.setText("" + detailModel.getPersoonID());
		monteurVoorNaamT.setText(detailModel.getVoorNaam());
		monteurAchterNaamT.setText(detailModel.getAchterNaam());
		monteurAdresT.setText(detailModel.getAdres());
		monteurWoonplaatsT.setText(detailModel.getWoonplaats());
		monteurPostcodeT.setText(detailModel.getPostcode());
		uurLoonT.setText("" + detailModel.getUurLoon());

		afspraken.changeData(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		auto.changeData(detailModel.getAutos(), detailModel.getAutoHeader());
	}

	public void update(Observable obs, Object obj) {
		if (obs == detailModel) {
			if (obj.equals("wijzigData")) {
				if (detailModel.isWijzigInfo()) {
					enableTextFields(true);
					wijzigGegevens.setText("Sla wijzigingen op");
				} else {
					enableTextFields(false);
					wijzigGegevens.setText("Wijzig gegevens");
				}
			} else
				updateGegevens();
		}
	}

	public void enableTextFields(boolean state) {
		monteurVoorNaamT.setEditable(state);
		monteurAchterNaamT.setEditable(state);
		monteurAdresT.setEditable(state);
		monteurWoonplaatsT.setEditable(state);
		monteurPostcodeT.setEditable(state);
	}
}

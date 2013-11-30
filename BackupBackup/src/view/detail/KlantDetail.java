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
import view.Tabel;
import control.Button;

public class KlantDetail extends JPanel implements Observer {
	private KlantDetailModel detailModel;
	private MainModel mainModel;
	private JLabel klantNummerL, klantVoorNaamL, klantAchterNaamL, klantAdresL,
			klantWoonplaatsL, klantPostcodeL, klantAantalAutosL,
			geplandeAfsprakenL, autosL;
	private JTextField klantNummerT, klantVoorNaamT, klantAchterNaamT,
			klantAdresT, klantWoonplaatsT, klantPostcodeT, klantAantalAutosT;
	private Tabel afspraken, auto;
	private JScrollPane afsprakenScroll, autoScroll;
	private Button wijzigGegevens, voegAutoToe;

	public KlantDetail(MainModel model) {
		setLayout(null);

		mainModel = model;
		detailModel = model.getKlantDetail();

		detailModel.addObserver(this);
		
		setPreferredSize(new Dimension(1250, 610));

		setupLabels();
		setupTextFields();
		setupTables();
		setupButtons();

		updateGegevens();
		// TODO Afsprakentabel, add auto en wijzig gegevens
		// knoppen.
	}

	public void setupLabels() {
		klantNummerL = new JLabel("Klant nummer:");
		klantVoorNaamL = new JLabel("Voornaam:");
		klantAchterNaamL = new JLabel("Achternaam:");
		klantAdresL = new JLabel("Adres:");
		klantWoonplaatsL = new JLabel("Woonplaats:");
		klantPostcodeL = new JLabel("Postcode:");
		klantAantalAutosL = new JLabel("Aantal auto's:");
		geplandeAfsprakenL = new JLabel("Geplande afspraken:");
		autosL = new JLabel("Auto's:");

		klantNummerL.setBounds(5, 0, 100, 20);
		klantVoorNaamL.setBounds(5, 25, 100, 20);
		klantAchterNaamL.setBounds(5, 50, 100, 20);
		klantAdresL.setBounds(5, 75, 100, 20);
		klantWoonplaatsL.setBounds(5, 100, 100, 20);
		klantPostcodeL.setBounds(5, 125, 100, 20);
		klantAantalAutosL.setBounds(5, 150, 100, 20);
		geplandeAfsprakenL.setBounds(400, 0, 200, 20);
		autosL.setBounds(400, 300, 100, 20);

		add(klantNummerL);
		add(klantVoorNaamL);
		add(klantAchterNaamL);
		add(klantAdresL);
		add(klantWoonplaatsL);
		add(klantPostcodeL);
		add(klantAantalAutosL);
		add(geplandeAfsprakenL);
		add(autosL);
	}

	public void setupTextFields() {
		klantNummerT = new JTextField();
		klantVoorNaamT = new JTextField();
		klantAchterNaamT = new JTextField();
		klantAdresT = new JTextField();
		klantWoonplaatsT = new JTextField();
		klantPostcodeT = new JTextField();
		klantAantalAutosT = new JTextField();

		klantNummerT.setBounds(120, 0, 200, 20);
		klantVoorNaamT.setBounds(120, 25, 200, 20);
		klantAchterNaamT.setBounds(120, 50, 200, 20);
		klantAdresT.setBounds(120, 75, 200, 20);
		klantWoonplaatsT.setBounds(120, 100, 200, 20);
		klantPostcodeT.setBounds(120, 125, 200, 20);
		klantAantalAutosT.setBounds(120, 150, 200, 20);

		klantNummerT.setEditable(false);
		klantVoorNaamT.setEditable(false);
		klantAchterNaamT.setEditable(false);
		klantAdresT.setEditable(false);
		klantWoonplaatsT.setEditable(false);
		klantPostcodeT.setEditable(false);
		klantAantalAutosT.setEditable(false);

		add(klantNummerT);
		add(klantVoorNaamT);
		add(klantAchterNaamT);
		add(klantAdresT);
		add(klantWoonplaatsT);
		add(klantPostcodeT);
		add(klantAantalAutosT);
	}

	public void setupTables() {
		afspraken = new Tabel(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		afsprakenScroll = new JScrollPane(afspraken);
		afsprakenScroll.setBounds(400, 20, 500, 200);

		auto = new Tabel(detailModel.getAutos(), detailModel.getAutoHeader());
		autoScroll = new JScrollPane(auto);
		autoScroll.setBounds(400, 320, 500, 200);

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
		klantNummerT.setText("" + detailModel.getPersoonID());
		klantVoorNaamT.setText(detailModel.getVoorNaam());
		klantAchterNaamT.setText(detailModel.getAchterNaam());
		klantAdresT.setText(detailModel.getAdres());
		klantWoonplaatsT.setText(detailModel.getWoonplaats());
		klantPostcodeT.setText(detailModel.getPostcode());
		klantAantalAutosT.setText("" + detailModel.getAantalAutos());

		afspraken.changeData(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		auto.changeData(detailModel.getAutos(), detailModel.getAutoHeader());
	}

	public void update(Observable obs, Object obj) {
		if (obs == detailModel) {
			updateGegevens();
		}
	}
}

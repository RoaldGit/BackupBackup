package view.detail;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MainModel;
import model.detailModel.KlantDetailModel;

public class KlantDetail extends JPanel implements Observer {
	private KlantDetailModel detailModel;
	private MainModel mainModel;

	private JLabel klantNummerL, klantVoorNaamL, klantAchterNaamL, klantAdresL,
			klantWoonplaatsL, klantPostcodeL, klantAantalAutosL;
	private JTextField klantNummerT, klantVoorNaamT, klantAchterNaamT,
			klantAdresT, klantWoonplaatsT, klantPostcodeT, klantAantalAutosT;

	public KlantDetail(MainModel model) {
		setLayout(null);

		mainModel = model;
		detailModel = model.getKlantDetail();

		detailModel.addObserver(this);
		
		setPreferredSize(new Dimension(1250, 610));

		setupLabels();
		setupTextFields();

		updateGegevens();
		// TODO Afspraken en autos tabellen, add auto en wijzig gegevens
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

		klantNummerL.setBounds(5, 0, 100, 20);
		klantVoorNaamL.setBounds(5, 25, 100, 20);
		klantAchterNaamL.setBounds(5, 50, 100, 20);
		klantAdresL.setBounds(5, 75, 100, 20);
		klantWoonplaatsL.setBounds(5, 100, 100, 20);
		klantPostcodeL.setBounds(5, 125, 100, 20);
		klantAantalAutosL.setBounds(5, 150, 100, 20);

		add(klantNummerL);
		add(klantVoorNaamL);
		add(klantAchterNaamL);
		add(klantAdresL);
		add(klantWoonplaatsL);
		add(klantPostcodeL);
		add(klantAantalAutosL);
	}

	public void setupTextFields() {
		klantNummerT = new JTextField();
		klantVoorNaamT = new JTextField();
		klantAchterNaamT = new JTextField();
		klantAdresT = new JTextField();
		klantWoonplaatsT = new JTextField();
		klantPostcodeT = new JTextField();
		klantAantalAutosT = new JTextField();

		klantNummerT.setBounds(120, 0, 100, 20);
		klantVoorNaamT.setBounds(120, 25, 100, 20);
		klantAchterNaamT.setBounds(120, 50, 100, 20);
		klantAdresT.setBounds(120, 75, 100, 20);
		klantWoonplaatsT.setBounds(120, 100, 100, 20);
		klantPostcodeT.setBounds(120, 125, 100, 20);
		klantAantalAutosT.setBounds(120, 150, 100, 20);

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

	public void updateGegevens() {
		klantNummerT.setText("" + detailModel.getPersoonID());
		klantVoorNaamT.setText(detailModel.getVoorNaam());
		klantAchterNaamT.setText(detailModel.getAchterNaam());
		klantAdresT.setText(detailModel.getAdres());
		klantWoonplaatsT.setText(detailModel.getWoonplaats());
		klantPostcodeT.setText(detailModel.getPostcode());
		klantAantalAutosT.setText("" + detailModel.getAantalAutos());
	}

	public void update(Observable obs, Object obj) {
		if (obs == detailModel) {
			updateGegevens();
		}
	}
}

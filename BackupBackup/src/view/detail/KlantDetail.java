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
import control.TableEvent;

/**
 * De class die gebruikt wordt voor de klantdetail weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 30-11-2013
 * @version 2.0
 */
public class KlantDetail extends JPanel implements Observer {
	private KlantDetailModel detailModel;
	private MainModel mainModel;
	private JLabel klantNummerL, klantVoorNaamL, klantAchterNaamL, klantAdresL,
			klantWoonplaatsL, klantPostcodeL, klantAantalAutosL,
			geplandeAfsprakenL, autosL, nieuweAutoL, nieuweAutoKentekenL,
			nieuweAutoBouwjaarL, nieuweAutoMerkL, nieuweAutoModelL;
	private JTextField klantNummerT, klantVoorNaamT, klantAchterNaamT,
			klantAdresT, klantWoonplaatsT, klantPostcodeT, klantAantalAutosT,
			nieuweAutoKentekenT, nieuweAutoBouwjaarT, nieuweAutoMerkT,
			nieuweAutoModelT;
	private Tabel afspraken, auto;
	private JScrollPane afsprakenScroll, autoScroll;
	private Button wijzigGegevens, voegAutoToe;

	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
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
	}

	/**
	 * De methode om labels op te zetten.
	 */
	public void setupLabels() {
		klantNummerL = new JLabel("Klantnummer:");
		klantVoorNaamL = new JLabel("Voornaam:");
		klantAchterNaamL = new JLabel("Achternaam:");
		klantAdresL = new JLabel("Adres:");
		klantWoonplaatsL = new JLabel("Woonplaats:");
		klantPostcodeL = new JLabel("Postcode:");
		klantAantalAutosL = new JLabel("Aantal auto's:");
		geplandeAfsprakenL = new JLabel("Geplande afspraken:");
		autosL = new JLabel("Auto's:");

		nieuweAutoL = new JLabel("Vul de gegevens van de auto in:");
		nieuweAutoKentekenL = new JLabel("Kenteken:");
		nieuweAutoBouwjaarL = new JLabel("Bouwjaar:");
		nieuweAutoMerkL = new JLabel("Merk:");
		nieuweAutoModelL = new JLabel("Model:");

		klantNummerL.setBounds(5, 0, 100, 20);
		klantVoorNaamL.setBounds(5, 25, 100, 20);
		klantAchterNaamL.setBounds(5, 50, 100, 20);
		klantAdresL.setBounds(5, 75, 100, 20);
		klantWoonplaatsL.setBounds(5, 100, 100, 20);
		klantPostcodeL.setBounds(5, 125, 100, 20);
		klantAantalAutosL.setBounds(5, 150, 100, 20);
		geplandeAfsprakenL.setBounds(400, 0, 200, 20);
		autosL.setBounds(400, 300, 100, 20);

		nieuweAutoL.setBounds(5, 300, 300, 20);
		nieuweAutoKentekenL.setBounds(5, 325, 100, 20);
		nieuweAutoBouwjaarL.setBounds(5, 350, 100, 20);
		nieuweAutoMerkL.setBounds(5, 375, 100, 20);
		nieuweAutoModelL.setBounds(5, 400, 100, 20);

		add(klantNummerL);
		add(klantVoorNaamL);
		add(klantAchterNaamL);
		add(klantAdresL);
		add(klantWoonplaatsL);
		add(klantPostcodeL);
		add(klantAantalAutosL);
		add(geplandeAfsprakenL);
		add(autosL);

		add(nieuweAutoL);
		add(nieuweAutoKentekenL);
		add(nieuweAutoBouwjaarL);
		add(nieuweAutoMerkL);
		add(nieuweAutoModelL);
	}

	/**
	 * De methode om TextFields op te zetten.
	 */
	public void setupTextFields() {
		klantNummerT = new JTextField();
		klantVoorNaamT = new JTextField();
		klantAchterNaamT = new JTextField();
		klantAdresT = new JTextField();
		klantWoonplaatsT = new JTextField();
		klantPostcodeT = new JTextField();
		klantAantalAutosT = new JTextField();

		nieuweAutoKentekenT = new JTextField();
		nieuweAutoBouwjaarT = new JTextField();
		nieuweAutoMerkT = new JTextField();
		nieuweAutoModelT = new JTextField();
		
		klantNummerT.setBounds(120, 0, 200, 20);
		klantVoorNaamT.setBounds(120, 25, 200, 20);
		klantAchterNaamT.setBounds(120, 50, 200, 20);
		klantAdresT.setBounds(120, 75, 200, 20);
		klantWoonplaatsT.setBounds(120, 100, 200, 20);
		klantPostcodeT.setBounds(120, 125, 200, 20);
		klantAantalAutosT.setBounds(120, 150, 200, 20);

		nieuweAutoKentekenT.setBounds(120, 325, 200, 20);
		nieuweAutoBouwjaarT.setBounds(120, 350, 200, 20);
		nieuweAutoMerkT.setBounds(120, 375, 200, 20);
		nieuweAutoModelT.setBounds(120, 400, 200, 20);

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

		add(nieuweAutoKentekenT);
		add(nieuweAutoBouwjaarT);
		add(nieuweAutoMerkT);
		add(nieuweAutoModelT);

		detailModel.setKlantNummerT(klantNummerT);
		detailModel.setKlantVoorNaamT(klantVoorNaamT);
		detailModel.setKlantAchterNaamT(klantAchterNaamT);
		detailModel.setKlantAdresT(klantAdresT);
		detailModel.setKlantWoonplaatsT(klantWoonplaatsT);
		detailModel.setKlantPostcodeT(klantPostcodeT);
		detailModel.setKlantAantalAutosT(klantAantalAutosT);

		detailModel.setNieuweAutoKentekenT(nieuweAutoKentekenT);
		detailModel.setNieuweAutoBouwjaarT(nieuweAutoBouwjaarT);
		detailModel.setNieuweAutoMerkT(nieuweAutoMerkT);
		detailModel.setNieuweAutoModelT(nieuweAutoModelT);
	}

	/**
	 * De methode om tables op te zetten.
	 */
	public void setupTables() {
		afspraken = new Tabel(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		afsprakenScroll = new JScrollPane(afspraken);
		afsprakenScroll.setBounds(400, 20, 700, 200);

		auto = new Tabel(detailModel.getAutos(), detailModel.getAutoHeader());
		auto.setName("klantDetailAuto");
		auto.addMouseListener(new TableEvent(mainModel));

		autoScroll = new JScrollPane(auto);
		autoScroll.setBounds(400, 320, 700, 200);

		add(afsprakenScroll);
		add(autoScroll);
	}

	/**
	 * De methode om buttons op te zetten.
	 */
	public void setupButtons() {
		wijzigGegevens = new Button("Wijzig gegevens", mainModel);
		wijzigGegevens.setBounds(120, 180, 200, 20);
		wijzigGegevens.setName("wijzigKlant");

		voegAutoToe = new Button("Voeg auto toe", mainModel);
		voegAutoToe.setBounds(120, 425, 200, 20);
		voegAutoToe.setName("voegAutoToe");

		add(wijzigGegevens);
		add(voegAutoToe);
	}

	/**
	 * De methode om gegevens te updaten.
	 */
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

	/**
	 * De methode die aangeroepen wordt als de observable iets verandert.
	 */
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

	/**
	 * De methode om de textfields editable te maken
	 * @param state True of false.
	 */
	public void enableTextFields(boolean state) {
		klantVoorNaamT.setEditable(state);
		klantAchterNaamT.setEditable(state);
		klantAdresT.setEditable(state);
		klantWoonplaatsT.setEditable(state);
		klantPostcodeT.setEditable(state);
	}
}

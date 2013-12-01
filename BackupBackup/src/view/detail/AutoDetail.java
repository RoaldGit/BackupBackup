package view.detail;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.MainModel;
import model.detailModel.AutoDetailModel;
import view.Tabel;
import control.Button;
import control.DOAs;
import control.TableEvent;

public class AutoDetail extends JPanel implements Observer {
	private AutoDetailModel detailModel;
	private MainModel mainModel;
	private JLabel autoNummerL, autoKentekenL, autoBouwjaarL, autoMerkNaamL,
			autoModelL, eigenaarL, klantNummerL, klantAchternaamL,
			geplandeAfsprakenL,
			reparatiesL;
	private JTextField autoNummerT, autoKentekenT, autoBouwjaarT,
			autoMerkNaamT, autoModelT, klantNummerT, klantAchternaamT;
	private Tabel afspraken, reparaties;
	private JScrollPane afsprakenScroll, reparatiesScroll;
	private Button wijzigGegevens, nieuweReparatie;
	private DOAs doa;

	public AutoDetail(MainModel model) {
		setLayout(null);

		mainModel = model;
		doa = mainModel.getDoa();

		detailModel = model.getAutoDetail();

		detailModel.addObserver(this);

		setPreferredSize(new Dimension(1250, 610));

		setupLabels();
		setupTextFields();
		setupTables();
		setupButtons();

		updateGegevens();
	}

	private void setupLabels() {
		autoNummerL = new JLabel("Auto nummer:");
		autoKentekenL = new JLabel("Kenteken:");
		autoBouwjaarL = new JLabel("Bouwjaar:");
		autoMerkNaamL = new JLabel("Merk:");
		autoModelL = new JLabel("Model:");
		eigenaarL = new JLabel("Eigenaar:");
		klantNummerL = new JLabel("Klant nummer:");
		klantAchternaamL = new JLabel("Achternaam:");
		geplandeAfsprakenL = new JLabel("Geplande afspraken:");
		reparatiesL = new JLabel("Reparatie historie:");

		autoNummerL.setBounds(5, 0, 100, 20);
		autoKentekenL.setBounds(5, 25, 100, 20);
		autoBouwjaarL.setBounds(5, 50, 100, 20);
		autoMerkNaamL.setBounds(5, 75, 100, 20);
		autoModelL.setBounds(5, 100, 100, 20);
		eigenaarL.setBounds(5, 150, 100, 20);
		klantNummerL.setBounds(5, 175, 100, 20);
		klantAchternaamL.setBounds(5, 200, 100, 20);
		geplandeAfsprakenL.setBounds(400, 0, 200, 20);
		reparatiesL.setBounds(400, 300, 200, 20);

		add(autoNummerL);
		add(autoKentekenL);
		add(autoBouwjaarL);
		add(autoMerkNaamL);
		add(autoModelL);
		add(eigenaarL);
		add(klantNummerL);
		add(klantAchternaamL);
		add(geplandeAfsprakenL);
		add(reparatiesL);
	}

	private void setupTextFields() {
		autoNummerT = new JTextField();
		autoKentekenT = new JTextField();
		autoBouwjaarT = new JTextField();
		autoMerkNaamT = new JTextField();
		autoModelT = new JTextField();
		klantNummerT = new JTextField();
		klantAchternaamT = new JTextField();
		
		autoNummerT.setBounds(120, 0, 200, 20);
		autoKentekenT.setBounds(120, 25, 200, 20);
		autoBouwjaarT.setBounds(120, 50, 200, 20);
		autoMerkNaamT.setBounds(120, 75, 200, 20);
		autoModelT.setBounds(120, 100, 200, 20);
		klantNummerT.setBounds(120, 175, 200, 20);
		klantAchternaamT.setBounds(120, 200, 200, 20);

		autoNummerT.setEditable(false);
		autoKentekenT.setEditable(false);
		autoBouwjaarT.setEditable(false);
		autoMerkNaamT.setEditable(false);
		autoModelT.setEditable(false);
		klantNummerT.setEditable(false);
		klantAchternaamT.setEditable(false);

		detailModel.setAutoKentekenT(autoKentekenT);
		detailModel.setAutoBouwjaarT(autoBouwjaarT);
		detailModel.setAutoMerkNaamT(autoMerkNaamT);
		detailModel.setAutoModelT(autoModelT);
		detailModel.setKlantNummerT(klantNummerT);
		detailModel.setKlantAchternaamT(klantAchternaamT);

		add(autoNummerT);
		add(autoKentekenT);
		add(autoBouwjaarT);
		add(autoMerkNaamT);
		add(autoModelT);
		add(klantNummerT);
		add(klantAchternaamT);
	}

	private void setupTables() {
		afspraken = new Tabel(detailModel.getAfspraakData(),
				detailModel.getAfspraakHeader());
		afsprakenScroll = new JScrollPane(afspraken);
		afsprakenScroll.setBounds(400, 20, 700, 200);

		reparaties = new Tabel(detailModel.getReparatieData(),
				detailModel.getReparatieHeader());
		reparaties.setName("autoDetailReparaties");
		reparaties.addMouseListener(new TableEvent(mainModel));

		reparatiesScroll = new JScrollPane(reparaties);
		reparatiesScroll.setBounds(400, 320, 700, 200);

		add(afsprakenScroll);
		add(reparatiesScroll);
	}

	private void setupButtons() {
		wijzigGegevens = new Button("Wijzig gegevens", mainModel);
		wijzigGegevens.setBounds(120, 230, 200, 20);
		wijzigGegevens.setName("wijzigAuto");

		nieuweReparatie = new Button("Nieuwe reparatie", mainModel);
		nieuweReparatie.setBounds(550, 300, 200, 20);
		nieuweReparatie.setName("nieuweReparatie");

		add(wijzigGegevens);
		add(nieuweReparatie);
	}

	private void updateGegevens() {
		autoNummerT.setText("" + detailModel.getAutoNummer());
		autoKentekenT.setText(detailModel.getKenteken());
		autoBouwjaarT.setText("" + detailModel.getBouwjaar());
		autoMerkNaamT.setText(detailModel.getMerk());
		autoModelT.setText(detailModel.getModel());
		klantNummerT.setText("" + detailModel.getKlantNummer());
		klantAchternaamT.setText(detailModel.getKlantnaam());

		afspraken.changeData(detailModel.getAfspraakData(),
				detailModel.getAfspraakHeader());
		reparaties.changeData(detailModel.getReparatieData(),
				detailModel.getReparatieHeader());
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

	private void enableTextFields(boolean state) {
		autoKentekenT.setEditable(state);
		autoBouwjaarT.setEditable(state);
		autoMerkNaamT.setEditable(state);
		autoModelT.setEditable(state);
	}

}

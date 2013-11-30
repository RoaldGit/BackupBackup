package view.detail;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.MainModel;
import model.detailModel.ReparatieDetailModel;
import view.Tabel;
import control.Button;
import control.DOAs;

public class ReparatieDetail extends JPanel implements Observer {
	private ReparatieDetailModel detailModel;
	private MainModel mainModel;
	private JLabel reparatieNummerL, klantNummerL, autoNummerL, autoKentekenL, statusL, opmerkingenL, planningL, onderdeelL;
	private JTextField reparatieNummerT, klantNummerT, autoNummerT, autoKentekenT, statusT, opmerkingenT;
	private Tabel planning, onderdelen;
	private JScrollPane planningScroll, onderdelenScroll;
	private Button wijzig, printFactuur, planReparatie, voegOnderdeelToe;
	private DOAs doa;
	
	public ReparatieDetail(MainModel model) {
		setLayout(null);
		
		mainModel = model;
		doa = mainModel.getDoa();

		detailModel = model.getReparatieDetail();
		
		detailModel.addObserver(this);
		
		setPreferredSize(new Dimension(1250, 610));

		setupLabels();
		setupTextFields();
		setupTables();
		setupButtons();

		updateGegevens();
	}
	
	private void setupLabels() {
		reparatieNummerL = new JLabel("Reparatienummer:");
		klantNummerL = new JLabel("Klantnummer:");
		autoNummerL = new JLabel("Autonummer:");
		autoKentekenL = new JLabel("Kenteken");
		statusL = new JLabel("Status");
		opmerkingenL  = new JLabel("Opmerkingen: ");
		planningL = new JLabel("Ingeplande reparaties: ");
		onderdeelL = new JLabel("Gebruikte onderdelen: ");
		
		reparatieNummerL.setBounds(5, 0, 100, 20);
		klantNummerL.setBounds(5, 25, 100, 20);
		autoNummerL.setBounds(5, 50, 100, 20);
		autoKentekenL.setBounds(5, 75, 100, 20);
		statusL.setBounds(5, 100, 100, 20);
		opmerkingenL.setBounds(5, 125, 100, 20);
		planningL.setBounds(400, 0, 200, 20);
		onderdeelL.setBounds(400, 300, 200, 20);
		
		add(reparatieNummerL);
		add(klantNummerL);
		add(autoNummerL);
		add(autoKentekenL);
		add(statusL);
		add(opmerkingenL);
		add(planningL);
		add(onderdeelL);
		
	}

	private void setupTextFields() {
		reparatieNummerT = new JTextField();
		klantNummerT = new JTextField();
		autoNummerT = new JTextField();
		autoKentekenT = new JTextField();
		statusT = new JTextField();
		opmerkingenT = new JTextField();

		reparatieNummerT.setBounds(120, 0, 200, 20);
		klantNummerT.setBounds(120, 25, 200, 20);
		autoNummerT.setBounds(120, 50, 200, 20);
		autoKentekenT.setBounds(120, 75, 200, 20);
		statusT.setBounds(120, 100, 200, 20);
		opmerkingenT.setBounds(120, 125, 200, 20);

		reparatieNummerT.setEditable(false);
		klantNummerT.setEditable(false);
		autoNummerT.setEditable(false);
		autoKentekenT.setEditable(false);
		statusT.setEditable(false);
		opmerkingenT.setEditable(false);

		add(reparatieNummerT);
		add(klantNummerT);
		add(autoNummerT);
		add(autoKentekenT);
		add(statusT);
		add(opmerkingenT);
		
	}
	
	private void setupButtons() {
		wijzig = new Button("Wijzig gegevens", mainModel);
		wijzig.setBounds(120, 150, 200, 20);
		wijzig.setName("wijzigKlant");
		
		printFactuur = new Button("Print Factuur", mainModel);
		printFactuur.setBounds(120, 180, 200, 20);
		printFactuur.setName("printFactuur");
		
		planReparatie = new Button("Plan reparatie", mainModel);
		planReparatie.setBounds(550, 0, 200, 20);
		planReparatie.setName("planReparatie");
		
		voegOnderdeelToe = new Button("Voeg onderdeel toe", mainModel);
		voegOnderdeelToe.setBounds(550, 300, 200, 20);
		voegOnderdeelToe.setName("voegOnderdeelToe");

		add(wijzig);
		add(printFactuur);
		add(planReparatie);
		add(voegOnderdeelToe);
		
	}
	
	private void setupTables() {
		planning = new Tabel(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		planningScroll = new JScrollPane(planning);
		planningScroll.setBounds(400, 20, 500, 200);

		onderdelen = new Tabel(detailModel.getGebruikteOnderdelen(), detailModel.getOnderdelenHeader());
		onderdelenScroll = new JScrollPane(onderdelen);
		onderdelenScroll.setBounds(400, 320, 500, 200);

		add(planningScroll);
		add(onderdelenScroll);
		
	}

	private void updateGegevens() {
		reparatieNummerT.setText("" + detailModel.getReparatieID());
		klantNummerT.setText("" + detailModel.getPersoonID());
		autoNummerT.setText("" + detailModel.getAutoID());
		autoKentekenT.setText(detailModel.getKenteken());
		statusT.setText(detailModel.getStatus());
		opmerkingenT.setText(detailModel.getOpmerkingen());

		planning.changeData(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		onderdelen.changeData(detailModel.getGebruikteOnderdelen(), detailModel.getOnderdelenHeader());
		
	}

	@Override
	public void update(Observable obs, Object obj) {
		if (obs == detailModel) {
			updateGegevens();
		}
		
	}
}

package view.detail;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.MainModel;
import model.detailModel.ReparatieDetailModel;
import view.Tabel;
import control.Button;

/**
 * De class die gebruikt wordt voor de reparatiedetail weergave. Het extends een JPanel en implement een observer.
 * @author Stef en Roald
 * @since 30-11-2013
 * @version 2.0
 */
public class ReparatieDetail extends JPanel implements Observer {
	private ReparatieDetailModel detailModel;
	private MainModel mainModel;
	private JLabel reparatieNummerL, klantNummerL, autoNummerL, autoKentekenL,
			statusL, opmerkingenL, planningL, onderdeelL, nieuwOnderdeelL,
			nieuwOnderdeelNaamL, nieuwOnderdeelAantalL;
	private JTextField reparatieNummerT, klantNummerT, autoNummerT,
			autoKentekenT, nieuwOnderdeelAantalT;
	private JComboBox<Object> statusC, onderdelenC;
	private JTextArea opmerkingenA;
	private Tabel planning, onderdelen;
	private JScrollPane planningScroll, onderdelenScroll;
	private Button wijzigGegevens, printFactuur, planReparatie, voegOnderdeelToe;
	
	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public ReparatieDetail(MainModel model) {
		setLayout(null);
		
		mainModel = model;
		detailModel = model.getReparatieDetail();
		
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
	private void setupLabels() {
		reparatieNummerL = new JLabel("Reparatie nr.:");
		klantNummerL = new JLabel("Klantnummer:");
		autoNummerL = new JLabel("Autonummer:");
		autoKentekenL = new JLabel("Kenteken");
		statusL = new JLabel("Status");
		opmerkingenL  = new JLabel("Opmerkingen: ");
		planningL = new JLabel("Ingeplande reparaties: ");
		onderdeelL = new JLabel("Gebruikte onderdelen: ");
		
		nieuwOnderdeelL = new JLabel("Voeg een nieuw onderdeel toe:");
		nieuwOnderdeelNaamL = new JLabel("Onderdeelnaam:");
		nieuwOnderdeelAantalL = new JLabel("Aantal:");

		reparatieNummerL.setBounds(5, 0, 100, 20);
		klantNummerL.setBounds(5, 25, 100, 20);
		autoNummerL.setBounds(5, 50, 100, 20);
		autoKentekenL.setBounds(5, 75, 100, 20);
		statusL.setBounds(5, 100, 100, 20);
		opmerkingenL.setBounds(5, 125, 100, 20);
		planningL.setBounds(400, 0, 200, 20);
		onderdeelL.setBounds(400, 300, 200, 20);
		
		nieuwOnderdeelL.setBounds(5, 400, 200, 20);
		nieuwOnderdeelNaamL.setBounds(5, 425, 100, 20);
		nieuwOnderdeelAantalL.setBounds(5, 450, 100, 20);

		add(reparatieNummerL);
		add(klantNummerL);
		add(autoNummerL);
		add(autoKentekenL);
		add(statusL);
		add(opmerkingenL);
		add(planningL);
		add(onderdeelL);
		
		add(nieuwOnderdeelL);
		add(nieuwOnderdeelNaamL);
		add(nieuwOnderdeelAantalL);

	}

	/**
	 * De methode om TextFields op te zetten.
	 */
	private void setupTextFields() {
		reparatieNummerT = new JTextField();
		klantNummerT = new JTextField();
		autoNummerT = new JTextField();
		autoKentekenT = new JTextField();
		nieuwOnderdeelAantalT = new JTextField();
		
		Object[] status = new Object[] { "In behandeling", "Klaar",
				"Factuur Verzonden", "Factuur Betaald" };

		statusC = new JComboBox<Object>(status);
		onderdelenC = new JComboBox<Object>(detailModel.getOnderdelen());

		opmerkingenA = new JTextArea();

		reparatieNummerT.setBounds(120, 0, 200, 20);
		klantNummerT.setBounds(120, 25, 200, 20);
		autoNummerT.setBounds(120, 50, 200, 20);
		autoKentekenT.setBounds(120, 75, 200, 20);
		nieuwOnderdeelAantalT.setBounds(120, 450, 200, 20);

		statusC.setBounds(120, 100, 200, 20);
		onderdelenC.setBounds(120, 425, 200, 20);
		opmerkingenA.setBounds(120, 125, 200, 200);

		reparatieNummerT.setEditable(false);
		klantNummerT.setEditable(false);
		autoNummerT.setEditable(false);
		autoKentekenT.setEditable(false);

		statusC.setEnabled(false);
		opmerkingenA.setEditable(false);

		opmerkingenA.setLineWrap(true);
		opmerkingenA.setWrapStyleWord(true);

		detailModel.setStatusC(statusC);
		detailModel.setOnderdelenC(onderdelenC);
		detailModel.setNieuwOnderdeelAantalT(nieuwOnderdeelAantalT);
		detailModel.setOpmerkingenA(opmerkingenA);

		add(reparatieNummerT);
		add(klantNummerT);
		add(autoNummerT);
		add(autoKentekenT);
		add(nieuwOnderdeelAantalT);

		add(statusC);
		add(onderdelenC);
		add(opmerkingenA);
	}
	
	/**
	 * De methode om buttons op te zetten.
	 */
	private void setupButtons() {
		wijzigGegevens = new Button("Wijzig gegevens", mainModel);
		wijzigGegevens.setBounds(120, 330, 200, 20);
		wijzigGegevens.setName("wijzigReparatie");
		
		printFactuur = new Button("Print Factuur", mainModel);
		printFactuur.setBounds(120, 355, 200, 20);
		printFactuur.setName("printFactuur");
		
		planReparatie = new Button("Plan reparatie", mainModel);
		planReparatie.setBounds(550, 0, 200, 20);
		planReparatie.setName("planReparatie");
		
		voegOnderdeelToe = new Button("Voeg onderdeel toe", mainModel);
		voegOnderdeelToe.setBounds(120, 470, 200, 20);
		voegOnderdeelToe.setName("voegOnderdeelToe");

		add(wijzigGegevens);
		add(printFactuur);
		add(planReparatie);
		add(voegOnderdeelToe);
	}
	
	/**
	 * De methode om tables op te zetten.
	 */
	private void setupTables() {
		planning = new Tabel(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		planningScroll = new JScrollPane(planning);
		planningScroll.setBounds(400, 20, 700, 200);

		onderdelen = new Tabel(detailModel.getGebruikteOnderdelen(), detailModel.getOnderdelenHeader());
		onderdelenScroll = new JScrollPane(onderdelen);
		onderdelenScroll.setBounds(400, 320, 700, 200);

		add(planningScroll);
		add(onderdelenScroll);
	}

	/**
	 * De methode om gegevens te updaten.
	 */
	private void updateGegevens() {
		reparatieNummerT.setText("" + detailModel.getReparatieID());
		klantNummerT.setText("" + detailModel.getPersoonID());
		autoNummerT.setText("" + detailModel.getAutoID());
		autoKentekenT.setText(detailModel.getKenteken());
		statusC.setSelectedIndex(detailModel.getStatus());
		opmerkingenA.setText(detailModel.getOpmerkingen());

		planning.changeData(detailModel.getGeplandeAfspraken(),
				detailModel.getAfsprakenHeader());
		onderdelen.changeData(detailModel.getGebruikteOnderdelen(), detailModel.getOnderdelenHeader());
		
		onderdelen.setupRenderer(3);
		onderdelen.setupRenderer(5);

		onderdelenC.setModel(new JComboBox<Object>(detailModel.getOnderdelen())
				.getModel());
		onderdelenC.setSelectedIndex(0);
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
		statusC.setEnabled(state);
		opmerkingenA.setEditable(state);
	}
}

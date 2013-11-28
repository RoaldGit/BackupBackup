package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import control.Button;

import model.MainModel;

public class ButtonPanel extends JPanel {
	private Button homeButton, autoButton, reparatieButton, monteurButton,
			klantButton, roosterButton;
	private MainModel mainModel;

	public ButtonPanel(MainModel model) {
		setLayout(null);
		setBounds(305, 0, 670, 40);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

		mainModel = model;

		homeButton = new Button("Home", mainModel, 10, 5);
		autoButton = new Button("Auto", mainModel, 120, 5);
		reparatieButton = new Button("Reparatie", mainModel, 230, 5);
		klantButton = new Button("Klant", mainModel, 340, 5);
		monteurButton = new Button("Monteur", mainModel, 450, 5);
		roosterButton = new Button("Rooster", mainModel, 560, 5);

		add(homeButton);
		add(autoButton);
		add(reparatieButton);
		add(klantButton);
		add(monteurButton);
		add(roosterButton);
	}
}

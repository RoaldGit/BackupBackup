package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import model.MainModel;
import control.Button;

/**
 * De class die gebruikt wordt om buttons toe te voegen. Het extends een JPanel.
 * @author Stef en Roald
 * @since 30-10-2013
 * @version 2.0
 */
public class ButtonPanel extends JPanel {
	private Button homeButton, autoButton, reparatieButton, monteurButton,
			klantButton, roosterButton;
	private MainModel mainModel;

	/**
	 * De constructor.
	 * @param model Het mainmodel dat gebruikt wordt over het gehele programma.
	 */
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

		homeButton.setName("home");
		autoButton.setName("auto");
		reparatieButton.setName("reparatie");
		klantButton.setName("klant");
		monteurButton.setName("monteur");
		roosterButton.setName("rooster");

		add(homeButton);
		add(autoButton);
		add(reparatieButton);
		add(klantButton);
		add(monteurButton);
		add(roosterButton);
	}
}

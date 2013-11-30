package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainModel;

public class Button extends JButton{
	private MainModel mainModel;

	public Button(String title, MainModel model, int x, int y) {
		super(title);
		mainModel = model;
		setBounds(x,y,100,30);
		addActionListener(new Action());
	}

	public Button(String title, MainModel model) {
		super(title);
		mainModel = model;
		addActionListener(new Action());
	}

	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton) e.getSource();
			String name = button.getName();
			switch (name) {
			case ("home"):
				mainModel.setPage("home");
				break;
			case ("auto"):
				mainModel.setPage("auto");
				break;
			case ("reparatie"):
				mainModel.setPage("reparatie");
				break;
			case ("klant"):
				mainModel.setPage("klant");
				break;
			case ("wijzigKlant"):
				// TODO enable klantVelden, misschien toggle (Wijzig/Save
				// changes)
				break;
			case ("voegAutoToe"):
				// TODO open formulier of sorts
				break;
			case ("monteur"):
				mainModel.setPage("monteur");
				break;
			case ("rooster"):
				mainModel.setPage("rooster");
				break;
			}
		}
	}
}

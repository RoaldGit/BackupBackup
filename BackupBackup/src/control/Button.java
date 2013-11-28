package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainModel;

public class Button extends JButton{
	MainModel mainModel;

	public Button(String title, MainModel model, int x, int y) {
		super(title);
		mainModel = model;
		setBounds(x,y,100,30);
		addActionListener(new Action());
	}

	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton button = (JButton) e.getSource();
			String name = button.getText();
			switch (name) {
			case ("Home"):
				mainModel.setPage("home");
				break;
			case ("Auto"):
				mainModel.setPage("auto");
				break;
			case ("Reparatie"):
				mainModel.setPage("reparatie");
				break;
			case ("Klant"):
				mainModel.setPage("klant");
				break;
			case ("Monteur"):
				mainModel.setPage("monteur");
				break;
			case ("Rooster"):
				mainModel.setPage("rooster");
				break;
			}
		}
	}
}

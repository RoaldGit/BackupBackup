package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MainModel;

public class DetailPanel extends JPanel
{
	private MainModel model;
	public DetailPanel(MainModel _model) {
		model = _model;
		
		add(new JLabel("test"));
		System.out.println("test");
	}

}

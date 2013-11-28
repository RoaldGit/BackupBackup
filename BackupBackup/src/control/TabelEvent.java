package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Model;

public class TabelEvent extends MouseAdapter {
	private Model dataModel;
	
	public TabelEvent(Model model) {
		dataModel = model;
	}

	public void mouseClicked(MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			// JOptionPane.showMessageDialog(null, "Nog niet geïmplementeerd");

			int detailID = 1;
			// dataModel.setDetail(detailID, true); // detailpagina
		}
	}
}


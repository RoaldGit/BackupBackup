package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.SearchModel;

public class TabelEvent extends MouseAdapter {
	private SearchModel dataModel;
	
	public TabelEvent(SearchModel model) {
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


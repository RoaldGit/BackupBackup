package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.MainModel;
import view.Tabel;

public class TableEvent extends MouseAdapter {
	private MainModel mainModel;
	private DOAs doa;

	public TableEvent(MainModel model, DOAs doa) {
		mainModel = model;
		this.doa = doa;
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Tabel source = (Tabel) e.getSource();
			String sourceName = source.getName();
			int selectedID = (int) source
					.getValueAt(source.getSelectedRow(), 0);

			switch(sourceName) {
			case "klantTable":
				doa.retreiveKlantData(selectedID);
				break;
			default:
				System.out.println("No name");
				break;
			}
//			System.out.println(selectedID);
		}
	}
}
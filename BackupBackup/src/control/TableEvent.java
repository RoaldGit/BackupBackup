package control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.MainModel;
import view.Tabel;

/**
 * De class die ervoor zorgt dat je op de juiste detailpagina komt als je dubbelklikt op de table. 
 * @author Stef en Roald
 * @since 1-11-2013
 * @version 2.0
 */
public class TableEvent extends MouseAdapter {
	private MainModel mainModel;
	private DOAs doa;

	/**
	 * De constructor voor TableEvent.
	 * @param model Het mainmodel dat gebruikt wordt over het gehele programma.
	 */
	public TableEvent(MainModel model) {
		mainModel = model;
		doa = mainModel.getDoa();
	}
	/**
	 * Mouseclick event.
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Tabel source = (Tabel) e.getSource();
			String sourceName = source.getName();
			int selectedID = 0;

			if(!sourceName.equals("roosterTable"))
				selectedID = (int) source
					.getValueAt(source.getSelectedRow(), 0);
			else
				selectedID = (int) source
						.getValueAt(source.getSelectedRow(), 3);

			switch(sourceName) {
			case "klantTable":
				doa.retreiveKlantData(selectedID);
				break;
			case "klantDetailAuto":
			case "autoTable":
				doa.retreiveAutoData(selectedID);
				break;
			case "monteurTable":
				doa.retreiveMonteurData(selectedID);
				break;
			case "roosterTable":
				doa.retreiveReparatieData(selectedID);
				break;
			case "autoDetailReparaties":
			case "reparatieTable":
				doa.retreiveReparatieData(selectedID);
				break;
			default:
				System.out.println("No name");
				break;
			}
		}
	}
}

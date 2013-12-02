package model.detailModel;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Deze class genereert een factuur en opent dit in een nieuwe JFrame.
 * @author Stef en Roald
 * @since 1-12-2013
 * @version 2.0 
 */
public class Factuur extends JFrame{
	private ReparatieDetailModel detailModel;
	private JTextArea gegevensA;
	private JScrollPane gegevensSP;
	private Object[][] onderdelen;
	
	/**
	 * De constructor van de factuur.
	 * @param detailModel Het reparatiedetailmodel waar alle gegevens uit moeten worden opgehaald.
	 */
	public Factuur(ReparatieDetailModel detailModel){
		super("Factuur");
		setBounds(280, 0, 1000, 720);
		this.detailModel = detailModel;
		onderdelen = detailModel.getGebruikteOnderdelen();
		
		gegevensA = new JTextArea("Garage\nVan Galenstraat 19\n7511 JL Enschede\n053-123456\n\n" + 
				"ditiseenemailadres@geenemail.com\nIBAN: NL00GASF0112233445\nBIC: GASFNL4W\nKvK Overijssel 75341286\nBTW NL777881145A99\n\n");
		gegevensA.setEditable(false);
		
		add(gegevensA);

		regelsToevoegen();
		onderdelenToevoegen();

		setVisible(true);
	}
	
	/**
	 * Deze methode moet wat extra regels toevoegen.
	 */
	public void regelsToevoegen(){
		gegevensA.append("Factuurnummer: \n");
		gegevensA.append("Factuurdatum: \n");
		gegevensA.append("Reparatienummer: " + detailModel.getReparatieID() + "\n");
		gegevensA.append("Klantnummer: " + detailModel.getPersoonID() + "\n");
		gegevensA.append("Autonummer: " + detailModel.getAutoID()+ "\n\n");
	}

	/**
	 * Deze methode moet onderdelen toevoegen.
	 */
	public void onderdelenToevoegen(){
		//TODO Uitlijning.
		String header = String.format("%-30s%-30s%-30s%-30s%-30s%-30s\n",
				"Onderdeelnummer", "Onderdeelnaam", "Leverancier", "Prijs",
				"Aantal", "Totaalprijs");
			gegevensA.append(header);

			for(int i=0; i < onderdelen.length; i++){
			String formatted = String.format(
					"%-50s%-35s%-25s€%-24.2f%-34d€%-30.2f\n", onderdelen[i][0],
					onderdelen[i][1], onderdelen[i][2], onderdelen[i][3],
					onderdelen[i][4], onderdelen[i][5]);
				gegevensA.append(formatted);
		}
	}
}

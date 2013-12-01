package model.detailModel;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Factuur extends JFrame{
	private ReparatieDetailModel detailModel;
	private JTextArea gegevensA;
	private JScrollPane gegevensSP;
	private Object[][] onderdelen;
	
	public Factuur(ReparatieDetailModel detailModel){
		super("Factuur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 0, 1000, 720);
		this.detailModel = detailModel;
		onderdelen = detailModel.getGebruikteOnderdelen();
		
		gegevensA = new JTextArea("Garage\nVan Galenstraat 19\n7511 JL Enschede\n053-123456\n\n" + 
				"ditiseenemailadres@geenemail.com\nIBAN: NL00GASF0112233445\nBIC: GASFNL4W\nKvK Overijssel 75341286\nBTW NL777881145A99\n\n");
		gegevensA.setEditable(false);
		
		regelsToevoegen();
		onderdelenToevoegen();
	}
	
	public void regelsToevoegen(){
		gegevensA.append("Factuurnummer: \n");
		gegevensA.append("Factuurdatum: \n");
		gegevensA.append("Reparatienummer: " + detailModel.getReparatieID() + "\n");
		gegevensA.append("Klantnummer: " + detailModel.getPersoonID() + "\n");
		gegevensA.append("Autonummer: " + detailModel.getAutoID()+ "\n\n");
	}

	public void onderdelenToevoegen(){
		gegevensA.append(" Onderdeelnummer	Onderdeelnaam	Leverancier	 Prijs	Aantal	Totaalprijs\n\n");
		for(int i=0; i < onderdelen.length; i++){
			for(int j=0; j < onderdelen[i].length; j++){
				gegevensA.append("" + onderdelen[i][j] + "	");
				if(j == (onderdelen[i].length-1)){
					gegevensA.append("\n");
				}
			}
		}
	}
}

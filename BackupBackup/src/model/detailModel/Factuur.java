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
		
		gegevensA = new JTextArea("Garage\n Van Galenstraat 19\n 7511 JL Enschede\n 053-123456\n\n" + 
				"ditiseenemailadres@geenemail.com\n IBAN: NL00GASF0112233445\n BIC: GASFNL4W\n KvK Overijssel 75341286\n BTW NL777881145A99\n\n");
		gegevensA.setEditable(false);
		
	}

}

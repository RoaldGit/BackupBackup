package view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.MainModel;

/**
 * De class die gebruikt wordt als MainFrame. Het extends een JFrame.
 * @author Stef en Roald
 * @since 30-10-2013
 * @version 2.0
 */
public class MainFrame extends JFrame{
	private MainModel mainModel;
	private Border raisedetched, loweredetched;
	
	/**
	 * De constructor
	 * @param model Het mainmodel dat over het gehele programma gebruikt wordt.
	 */
	public MainFrame(MainModel model){
		super("Garage Administratie Systeem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		mainModel = model;

		ButtonPanel buttonPanel = new ButtonPanel(mainModel);

        raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
		ContentPanel cPanel = new ContentPanel(mainModel);
        cPanel.setBounds(5,41,1255,640);
        cPanel.setBorder(loweredetched);

		mainModel.addObserver(cPanel);

		add(buttonPanel);
		add(cPanel);

		setVisible(true);
	}
}

package view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.Model;

public class Tabel extends JTable {
	private Model dataModel;
	private TableColumnModel tcm;

	/**
	 * De default constructor voor de class Tabel.
	 */
	public Tabel() {
		super();
	}

	/**
	 * De constructor voor de class Tabel
	 * 
	 * @param row
	 * @param col
	 */
	public Tabel(Model model) {
		super(model.getData(), model.getHeader());
		dataModel = model;
		// TODO voeg TableEvent to aan tabel.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JTable#isCellEditable(int, int)
	 */
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	/**
	 * Met deze methode wordt de data in de tabel aangepast door het TableModel
	 * te wijzigen.
	 * 
	 * @param data
	 */
	public void changeData() {
		DefaultTableModel dtm = new DefaultTableModel(dataModel.getData(),
				dataModel.getHeader());
		setModel(dtm);
	}
}

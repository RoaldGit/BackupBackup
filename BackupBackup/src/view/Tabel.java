package view;

import java.text.NumberFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import model.SearchModel;

public class Tabel extends JTable {
	private SearchModel dataModel;
	private TableColumnModel tcm;

	/**
	 * Constructor voor de class table
	 * 
	 * @param data
	 *            Data voor de tabel
	 * @param header
	 *            Headers voor de tabel
	 */
	public Tabel(Object[][] data, String[] header) {
		super(data, header);
	}

	/**
	 * De constructor voor de class Tabel
	 * 
	 * @param model
	 *            Model met de data en header voor de table
	 */
	public Tabel(SearchModel model) {
		super(model.getData(), model.getHeader());
		dataModel = model;
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
	 * te wijzigen. *
	 */
	public void changeData() {
		DefaultTableModel dtm = new DefaultTableModel(dataModel.getData(),
				dataModel.getHeader());
		setModel(dtm);
	}

	/**
	 * Met deze methode wordt de data in de tabel aangepast door het TableModel
	 * te wijzigen.
	 * 
	 * @param data
	 *            Data voor de tabel
	 * @param header
	 *            header van de tabel
	 */
	public void changeData(Object[][] data, String[] header) {
		DefaultTableModel dtm = new DefaultTableModel(data, header);
		setModel(dtm);
	}

	public void setupRenderer(int column) {
		tcm = this.getColumnModel();

		tcm.getColumn(column).setCellRenderer(new NumberRenderer());
	}

	class NumberRenderer extends DefaultTableCellRenderer {
		NumberFormat formatter;

		public NumberRenderer() {
			super();
		}

		public void setValue(Object value) {
			Double number = 0.0;
			if (value != null)
				number = Double.parseDouble(value.toString());
			setText((value == null) ? "" : String.format("€ %,.2f", number));
		}
	}
}

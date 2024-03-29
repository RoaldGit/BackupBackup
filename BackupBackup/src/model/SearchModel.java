package model;

import java.util.Observable;

public class SearchModel extends Observable {
	protected Object[][] tableData;
	protected String[] tableHeader;

	public SearchModel(Object[][] data, String[] header) {
		tableData = data;
		tableHeader = header;
	}

	public Object[][] getData() {
		return tableData;
	}

	public String[] getHeader() {
		return tableHeader;
	}

	public void setData(Object[][] data) {
		tableData = data;
		setChanged();
		notifyObservers("search");
	}

	public void setHeader(String[] header) {
		tableHeader = header;
	}
}

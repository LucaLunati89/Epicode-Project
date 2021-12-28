package it.mypizza.model.impl.table;

public class Table {

	private int idTable;
	private int maxPlaceSettings;
	private boolean state;
	
	int getIdTable() {
		return idTable;
	}
	public Table setIdTable(int idTable) {
		this.idTable = idTable;
		return this;
	}
	int getMaxPlaceSettings() {
		return maxPlaceSettings;
	}
	public Table setMaxPlaceSettings(int maxPlaceSettings) {
		this.maxPlaceSettings = maxPlaceSettings;
		return this;
	}
	boolean isState() {
		return state;
	}
	public Table setState(boolean state) {
		this.state = state;
		return this;
	}
	@Override
	public String toString() {
		return "Table [idTable=" + idTable + ", maxPlaceSettings=" + maxPlaceSettings + ", state=" + state + "]";
	}
	
	
}

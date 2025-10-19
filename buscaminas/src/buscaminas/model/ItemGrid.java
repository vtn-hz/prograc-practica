package buscaminas.model;

public abstract class ItemGrid {
	
	public static final String FLAGED = "flaged";
	
	public static final String SHOWED = "showed";
	
	public static final String HIDDEN = "hidden";
	
	private String status;
	
	public ItemGrid() {
		super();
		this.status = ItemGrid.HIDDEN;
	}

	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public abstract boolean isMina(); 
}

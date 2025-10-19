package buscaminas.model;

public class Grid {
	private ItemGrid[][] gridFields;
	 
	private int mineAmount;

	private int foundedMinesAmount = 0;
	
	private GridAlgorithm algorithm; 
	
	public Grid(int x, int y, int mineAmount) {
		super();
		this.gridFields = new ItemGrid[x][y]; 
		this.mineAmount = mineAmount;
	}

	public ItemGrid[][] getGridFields() {
		return gridFields;
	}

	public int getMineAmount() {
		return mineAmount;
	}

	public int getFoundedMinesAmount() {
		return foundedMinesAmount;
	}
	
	public void populateGrid() {
		this.algorithm.populateGrid(gridFields, mineAmount);
	}
	
	public int getMinasCercanas(int i, int j)
	{
		return this.algorithm.getMinasCercanas(gridFields, i, j);
	}
	
	public boolean isMina(int i, int j)
	{
		return this.gridFields[i][j].isMina();
	}
	
	public void showField(int i, int j) throws Exception 
	{
		if (this.isMina(i, j))
			throw new Exception("Perdiste!");
		
		this.gridFields[i][j].setStatus(ItemGrid.SHOWED);
	}
	
	public void flagField(int i, int j)
	{
		if (this.isMina(i, j))
			this.foundedMinesAmount++;
		
		this.gridFields[i][j].setStatus(ItemGrid.FLAGED);
	}
	
	public void unflagField(int i, int j)
	{
		if (this.isMina(i, j))
			this.foundedMinesAmount--;
		
		this.gridFields[i][j].setStatus(ItemGrid.HIDDEN);
	}
	
	public boolean isWin() 
	{
		return this.foundedMinesAmount == this.mineAmount;
	}

	public void setAlgorithm(GridAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

}
	

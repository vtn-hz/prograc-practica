package buscaminas.model;

public class GridBuilder {
	public Grid build (int dimx, int dimy, int minAmount) {
		Grid grid = new Grid(dimx, dimy, minAmount);
        
		grid.setAlgorithm(new GridAlgorithm());
        grid.populateGrid();

		return grid;
	}
}

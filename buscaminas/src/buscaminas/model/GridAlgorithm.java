package buscaminas.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import buscaminas.model.itemgrid.Ground;
import buscaminas.model.itemgrid.Mine;

public class GridAlgorithm {
	
	private Random rdm;
	
	public GridAlgorithm() {
		super();
		this.rdm = new Random();
	}

	public void populateGrid(ItemGrid[][] gridFields, int mineAmount) 
	{
		int dimx = gridFields[0].length;
		int dimy = gridFields.length;
		
		while (mineAmount > 0) {
			int j = rdm.nextInt(dimx);
			int i = rdm.nextInt(dimy);
			
			if (gridFields[i][j] == null) {
				mineAmount--;
				gridFields[i][j] = new Mine();
			}
		}
		
		for (int i = 0 ; i < dimy ; i++) {
			for(int j=0 ; j < dimx ; j++) {
				if (gridFields[i][j] == null)
					gridFields[i][j] = new Ground();
			}
		}
	} 
	
	public int getMinasCercanas(ItemGrid[][] gridFields, int i, int j) {
		int dimx = gridFields[0].length;
		int dimy = gridFields.length;
		
		int amount = 0;
		
		int posibilities[][] = {
			{-1,-1}, {-1,0}, {-1, 1}, 
			{0, 1}, {1, 1}, { 1, 0}, 
			{1,-1}, {0,-1}
		};
		
		for (int k = 0 ; k < 8 ; k++) {
			int[] current = posibilities[k];
			
			int posy = i + current[0];
			int posx = j + current[1];
			
			
			if ( 0 <= posx && posx < dimx )
			    if ( 0 <= posy && posy < dimy )	
					amount += gridFields[posy][posx].isMina() ? 1 : 0;
		}
		
		return amount;
	}
	
	public void showGridNeighbors(ItemGrid[][] gridFields, int i, int j) {
	
	    int posibilities[][] = {
	        {-1, -1}, {-1, 0}, {-1, 1},
	        {0, 1},   {1, 1},  {1, 0},
	        {1, -1},  {0, -1}
	    };

	    int rows = gridFields.length;
	    int cols = gridFields[0].length; 
	    
	    Queue<int[]> queue = new LinkedList<>();

	    gridFields[i][j].setStatus(ItemGrid.SHOWED);
	    int minas = getMinasCercanas(gridFields, i, j); 

	    if (minas > 0) {
	        return;
	    }

	    queue.add(new int[]{i, j});
	    while (!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int r = current[0];
	        int c = current[1]; 

	        for (int[] p : posibilities) {
	            int nr = r + p[0];
	            int nc = c + p[1]; 

	            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
	                continue; 
	            }

	            ItemGrid neighbor = gridFields[nr][nc];
	            if (neighbor.getStatus() == ItemGrid.SHOWED) {
	                continue;
	            }

	            neighbor.setStatus(ItemGrid.SHOWED);
	            if (getMinasCercanas(gridFields, nr, nc) == 0) {
	                queue.add(new int[]{nr, nc});
	            }
	        }
	    }
	}
}

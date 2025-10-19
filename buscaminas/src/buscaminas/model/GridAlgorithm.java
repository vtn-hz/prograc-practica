package buscaminas.model;

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
			{-1,0}, {-1, 1}, {0, 1},
			{1, 1}, { 1, 0}, {1,-1},
			{0,-1}, {-1,-1} 
		};
		
		for (int k = 0 ; k < 8 ; k++) {
			int[] current = posibilities[k];
			
			int posx = j + current[0];
			int posy = i + current[1];
			
			if ( 0 <= posx && posx < dimx )
			    if ( 0 <= posy && posy < dimy )	
					amount += gridFields[posy][posx].isMina() ? 1 : 0;
		}
		
		return amount;
	}
}

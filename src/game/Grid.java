package game;

public class Grid {

	Cell[][] cells;
	
	public Grid(){
		cells = new Cell[Game.NumberOfCells][Game.NumberOfCells];
		
		for (int i = 0; i < cells.length; i++)
			for (int j = 0; j < cells.length; j++) {
				boolean alive = Math.random() < 0.5;
				cells[i][j] = new Cell(alive, i, j);
			}
	}
	
	public void updateGeneration(){
		//System.out.println("updating");
		
		for (int i = 0; i < cells.length; i++) 
			for (int j = 0; j < cells.length; j++) {
				Cell cell = cells[i][j];
				int livingNeighbors = cell.livingNeighbors(this);
				
				//The four rules of the game
				//http://en.wikipedia.org/wiki/Conway's_Game_of_Life#Rules
				if(livingNeighbors < 2 && cell.isAlive())
					cell.die();
				if(livingNeighbors > 3 && cell.isAlive())
					cell.die();
				if(livingNeighbors == 3 && !cell.isAlive())
					cell.beBorn();
				// The fourth rule(third in the wikipedia) keeps the state of the cell and is implicitly implemented 
			}
		
		for (int i = 0; i < cells.length; i++) 
			for (int j = 0; j < cells.length; j++)
				cells[i][j].updateState();
	}
	
	public Cell getCellAt(int i, int j) {
		return cells[i][j];
	}

}

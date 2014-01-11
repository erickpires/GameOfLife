package game;

public class Cell {
	private boolean alive;
	private boolean willLive;
	private int x;
	private int y;
	
	public Cell(boolean alive, int x, int y){
		this.alive = alive;
		this.willLive = alive;
		this.x = x;
		this.y = y;
	}
	
	public void die(){
		willLive = false;
	}
	
	public void beBorn(){
		willLive = true;
	}
	
	public void updateState(){
		alive = willLive;
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public int livingNeighbors(Grid grid){
		int result = 0;
		
		for(int i = -1; i <= 1; i++){
			if(x + i < 0) continue; // the cell belongs to the first row			
			if(x + i >= Game.NumberOfCells) break; // the cell belongs to the last row 
			
			for(int j = -1; j <= 1; j++){
				if(j == 0 && i == 0) continue; // there's no need to test itself
				if(y + j < 0) continue; // the cell belongs to the first column
				if(y + j >= Game.NumberOfCells) break; // the cell belongs to the last column
				
				Cell neighbor = grid.getCellAt(x + i, y + j);
				
				if(neighbor.isAlive())
					result++;
			}
		}
		
		return result;
	}
}

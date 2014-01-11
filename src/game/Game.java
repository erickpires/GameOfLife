package game;



import desenho.Tela;

public class Game {
	
	public static final int NumberOfCells = 130;
	public static final int cellSize = 7;
	
	private Tela tela;
	private boolean paused = true;
	private Grid grid;

	public Game(Tela t) {
		this.tela = t;
		grid = new Grid();
	}

	public void run() {
		long t0 = System.currentTimeMillis();
		long t1;
		while (true) {
			
			if (!paused) {
				t0 = System.currentTimeMillis();

				tick();
				
				tela.desenha(grid);
			}
			
			do {
				t1 = System.currentTimeMillis();
			} while (t1 - t0 < 100);

		}
	}

	private void tick() {
		grid.updateGeneration();
	}

	synchronized public void changePauseState() {
		// TODO
		paused = !paused;

		System.out.println("Game paused = " + paused);

	}

	public void reset() {
		// TODO Auto-generated method stub
		grid = new Grid();
		System.out.println("The game was reseted");
	}
}

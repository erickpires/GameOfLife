package desenho;

import game.Cell;
import game.Game;
import game.Grid;

import java.awt.Canvas;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Tela extends Canvas {

	private static final long serialVersionUID = 8711731406589100246L;

	// private Janela janela;
	private BufferStrategy buffer;
	private Graphics graphic;
	// private Sort algoritmo;
	private Game game;

	private Tela t;

	public Tela(Janela janela) {
		// this.janela = janela;
		t = this;
		// start();
		janela.add(this);

		createBufferStrategy(2);
		buffer = getBufferStrategy();

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();

				switch (c) {
				case ' ':
					game.changePauseState();
					break;
				case 'r':
				case 'R':
					game.reset();
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});

		requestFocus();

		start();
	}

	private void start() {
		Runnable r = new Runnable() {

			@Override
			public void run() {

				/*
				 * new BubbleSort(t, new
				 * File("/home/erick/ordem_inversa")).start();
				 */
				// new HeapSort(t).start();
				// algoritmo = new HeapSort(t);
				// algoritmo.start();

				game = new Game(t);

				game.run();
			}

		};

		// try {
		// EventQueue.invokeAndWait(r);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		//
		// } catch (InvocationTargetException e) {
		// e.getCause().printStackTrace();
		// }
		Thread thread = new Thread(r);
		thread.run();

	}

	public void desenha(Retangulo[] retangulos) {

		graphic = buffer.getDrawGraphics();

		graphic.fillRect(0, 0, Janela.LARGURA, Janela.ALTURA);

		// for(int i = 0; i < retangulos.length; i++)
		// retangulos[i].draw(graphic, (double)i * Janela.LARGURA/algoritmo.N);

		buffer.show();
		graphic.dispose();
	}

	public void desenha(Grid grid) {
		graphic = buffer.getDrawGraphics();

		graphic.setColor(Color.white);
		graphic.fillRect(0, 0, Janela.LARGURA, Janela.ALTURA);

		graphic.setColor(Color.black);
		
		for(int i = 0; i < Game.NumberOfCells; i++){
			graphic.drawLine(i * Game.cellSize, 0, i * Game.cellSize, Janela.ALTURA);
			
			graphic.drawLine(0, i * Game.cellSize, Janela.LARGURA, i * Game.cellSize);
		}
		
		graphic.setColor(new Color(70,70,70));
		
		for(int i = 0; i < Game.NumberOfCells; i++)
			for(int j = 0; j < Game.NumberOfCells; j++){
				Cell cell = grid.getCellAt(i, j);
				
				if(cell.isAlive())
					graphic.fillRect(i * Game.cellSize, j * Game.cellSize, Game.cellSize, Game.cellSize);
			}
				
		
		buffer.show();
		graphic.dispose();
	}
}

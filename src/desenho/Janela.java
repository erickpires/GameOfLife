package desenho;

import game.Game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Janela extends JFrame {

	private static final long serialVersionUID = -6325664318323523503L;

	public static final int LARGURA = Game.NumberOfCells * Game.cellSize;
	public static final int ALTURA = LARGURA + 30;

	public Janela() {
		super();
		setBounds(50, 70, LARGURA, ALTURA);
		setTitle("Conway's Game of Life");
		setName("Conway's Game of Life");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setIgnoreRepaint(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {
		new Tela(new Janela());

	}
}

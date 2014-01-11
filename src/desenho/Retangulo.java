package desenho;
import java.awt.Color;
import java.awt.Graphics;


public class Retangulo {
	
	private Color color;
	private double width;
	private double height;

	public Retangulo(double width, double height) {
		this.width = width;
		this.height = height;
		color = Color.blue;
	}

	public void draw(Graphics g, double point){
		g.setColor(color);
		g.fillRect((int)point, Janela.ALTURA - (int)this.height, (int)this.width, (int)this.height);
	}
	
	public void setCor(Color color){
		this.color = color;
	}
}

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class DrawStuff extends JComponent {

	//Sets the size of the sprite (height and width are the same).
	public int size;
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//Add coins.
	private int coin = 0;
	private ArrayList<int[]> coins = new ArrayList<int[]>();
	
	public void addCoins(int amount) {
		int i = 0;
		while (i < amount) {
			Random rand = new Random();
			int x = rand.nextInt(120);
			x = x * 10;
			int y = rand.nextInt(80);
			y = y * 10;
			if (Landscape.isBarrier(x, y) != true) {
				coin = coin + 1;
				int[] coin = new int[2];
				coin[0] = x;
				coin[1] = y;
				coins.add(coin);
				i = i + 1;
			}
		}
	}
	
	//Detects sprite collision with coins.
	public boolean coinCollision(float x, float y) {
		boolean collision = false;
		for (int i = 0; i < coin; i++) {
			int[] current_coin = coins.get(i);
			if (x == current_coin [0] && y == current_coin[1]) {
				collision = true;
				coin = coin - 1;
				coins.remove(i);
			}
		}
		return collision;
	}

	//Displays the background and sprite to JFrame.
	public void paint(Graphics g) {
		
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draws background.
		g.drawImage(Landscape.imageLandscape, 0, 0, this);
		
		//Draws sprite (circle). Subtracts x,y location by half the objects size to line up the 
		//actual x,y location with the center of the circle instead of the corner.
		Shape drawEllipse = new Ellipse2D.Float(Location.x - (size / 2), Location.y - (size / 2), size, size);
		graph2.draw(drawEllipse);
		graph2.setPaint(Color.GRAY);
		graph2.fill(drawEllipse);
		
		int i = 0;
		
		while (i <= coin - 1) {
			int[] coin = coins.get(i);
			Shape newEllipse = new Ellipse2D.Float(coin[0] - 9, coin[1] - 9, 18, 18);
			graph2.draw(newEllipse);
			graph2.setPaint(Color.ORANGE);
			graph2.fill(newEllipse);
			i = i + 1;
		}
		
	}
}

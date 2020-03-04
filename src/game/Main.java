package game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("Simple Maze Game");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 800);
		frame.setFocusable(true);
		
		Landscape.addImagelandscape("maze.png");
		
		Location.x = 600;
		Location.y = 400;
		
		DrawStuff canvas = new DrawStuff();
		canvas.setSize(20);
		canvas.addCoins(10);
		frame.add(canvas, BorderLayout.CENTER);
		
		frame.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if (Landscape.isBarrier(Location.x, Location.y - 10)) {
						Location.y = Location.y;
					}
					else {
						Location.y = Location.y - 10;
					}
					if (canvas.coinCollision(Location.x, Location.y) == true) {
						System.out.println("COLLISION AT: " + Location.x + ", " + Location.y);
					}
					System.out.println("Location: " + Location.x + ", " + Location.y);
					canvas.repaint();
					break;
				case KeyEvent.VK_DOWN:
					if (Landscape.isBarrier(Location.x, Location.y + 10)) {
						Location.y = Location.y;
					}
					else {
						Location.y = Location.y + 10;
					}
					if (canvas.coinCollision(Location.x, Location.y) == true) {
						System.out.println("COLLISION AT: " + Location.x + ", " + Location.y);
					}
					System.out.println("Location: " + Location.x + ", " + Location.y);
					canvas.repaint();
					break;
				case KeyEvent.VK_RIGHT:
					if (Landscape.isBarrier(Location.x + 10, Location.y)) {
						Location.x = Location.x;
					}
					else {
						Location.x = Location.x + 10;
					}
					if (canvas.coinCollision(Location.x, Location.y) == true) {
						System.out.println("COLLISION AT: " + Location.x + ", " + Location.y);
					}
					System.out.println("Location: " + Location.x + ", " + Location.y);
					canvas.repaint();
					break;
				case KeyEvent.VK_LEFT:
					if (Landscape.isBarrier(Location.x - 10, Location.y)) {
						Location.x = Location.x;
					}
					else {
						Location.x = Location.x - 10;
					}
					if (canvas.coinCollision(Location.x, Location.y) == true) {
						System.out.println("COLLISION AT: " + Location.x + ", " + Location.y);
					}
					System.out.println("Location: " + Location.x + ", " + Location.y);
					canvas.repaint();
					break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
package game;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Landscape {
	
	//Checks if the sprite is touching a barrier. If true, prevent sprite from entering.
	public static boolean isBarrier(float x, float y) {
		int rgb = imageLandscape.getRGB((int) x, (int) y);
		Color c = new Color(rgb);
		
		//If the pixel that the sprite is attempting to move to is black (barrier), the move is rejected.
		if (c.getRed() <= 10 && c.getGreen() <= 10 && c.getBlue() <= 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//The landscape image, determines where the sprite is prevented from going. Black areas are a barrier.
	public static BufferedImage imageLandscape;
			
	public static void addImagelandscape(String fileName) throws IOException {
		File newFile = new File(fileName);
		imageLandscape = ImageIO.read(newFile);
	}

}

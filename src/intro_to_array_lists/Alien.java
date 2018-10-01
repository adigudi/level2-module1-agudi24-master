package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	void update() {
		super.update();
		Random r = new Random();
		int rand = r.nextInt(20);
		y = y + rand;
	}
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		
	}
}

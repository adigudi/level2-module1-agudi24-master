package intro_to_array_lists;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed;
	
public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 20;
		// TODO Auto-generated constructor stub
	}
void update(){
	super.update();
	if(x < 0) {
		x = 0;
	}
	if(x > 448) {
		x = 448;
	}
	if(y < 0) {
		y = 0;
	}
	if(y > 752) {
		y = 752;
	}
}
public void draw(Graphics g) {
	g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
}
}

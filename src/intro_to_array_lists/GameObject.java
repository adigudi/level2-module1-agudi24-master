package intro_to_array_lists;

import java.awt.Graphics;

public class GameObject {
	
int x;
int y;
int width;
int height;

public GameObject(int x, int y, int width, int height){
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}
void update() {
	x=x+1;
			
}
public void draw(Graphics g) {
	g.fillRect(x, y, 100, 100);
}
}

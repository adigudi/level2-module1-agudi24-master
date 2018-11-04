package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import intro_to_array_lists.GamePanel;

public class Player {
	static int x;
	static int y;
	static int width;
	static int height;

	private Rectangle cBox = new Rectangle();

	public boolean left = false;
	public boolean right = false;

	private int xVelocity = 5;

	private int gravity = 1;
	private int yVelocity = 0;
	private int jumpPower = 20;

	private int yLimit = 500;

	boolean canJump = false;

	public Player(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		cBox.setBounds(x, y, width, height);
	}

	public void jump() {
		if (canJump) {
			yVelocity -= jumpPower;
			canJump = false;
		}
	}

	public void update() {
		if (left) {
			x -= xVelocity;
		}
		if (right) {
			x += xVelocity;
		}

		yVelocity += gravity;
		y += yVelocity;

		if (y >= yLimit + 1) {
			y = yLimit + 1;
			yVelocity = 0;
			canJump = true;
		}

		x = x + 10;

		cBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		g.drawImage(FinalGamePanel.faceImg, x, y, width, height, null);
		
	}

	public Rectangle getCBox() {
		return cBox;
	}

	public void setYLimit(int l) {
		yLimit = l;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getYVelocity() {
		return yVelocity;
	}
}

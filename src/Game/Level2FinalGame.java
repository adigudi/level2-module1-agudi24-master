package Game;
//HERE ARE SOME CHANGES!!!

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Level2FinalGame extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 600;
	JFrame window;
	Timer timer;
	static int x = 50;

	Player p1 = new Player(x, 50, 100, 100);

	ArrayList<Platform> platforms = new ArrayList<Platform>();

	public static void main(String[] args) {
		new Level2FinalGame().run();
	}

	public void run() {
		window = new JFrame("Square Runner");
		window.addKeyListener(this);
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, this);
		Random r = new Random();
		int rand = r.nextInt(450);
		int rand2 = r.nextInt(450);
		int rand3 = r.nextInt(450);
		int rand4 = r.nextInt(450);

		platforms.add(new Platform(700, rand, 200, 50));
		platforms.add(new Platform(500, rand2, 200, 50));
		platforms.add(new Platform(300, rand3, 200, 50));
		platforms.add(new Platform(100, rand4, 200, 50));

		timer.start();

	}

	public void paintComponent(Graphics g) {
		p1.draw(g);
		g.setColor(Color.BLUE);

		for (Platform p : platforms) {
			p.draw(g);
		}
	}

	public void actionPerformed(ActionEvent e) {
		checkCollision();

		p1.update();

		for (Platform p : platforms) {
			p.update();
		}

		repaint();

	}

	private boolean checkCollision() {
		for (Platform p : platforms) {
			if (p1.getCBox().intersects(p.getCBox())) {
				handleCollision(p);
				return true;
			}
		}

		p1.setYLimit(500);
		return false;
	}

	private void handleCollision(Platform p) {
		if (p1.getYVelocity() >= 0 && p1.getY() + p1.getHeight() < p.getY() + 25) {
			p1.setYLimit(p.getY() - p1.getHeight());
		} else {
			p1.setYLimit(500);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p1.left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p1.right = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			p1.jump();
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			timer.stop();
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			p1.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			p1.right = false;
		}
	}
}

/*
 * class Platform{ private int x; private int y; private int width; private int
 * height;
 * 
 * private Rectangle cBox = new Rectangle();
 * 
 * public Platform(int x, int y, int w, int h){ this.x = x; this.y = y;
 * this.width = w; this.height = h;
 * 
 * 
 * 
 * cBox.setBounds(x, y, width, height); }
 * 
 * public void update(){ cBox.setBounds(x, y, width, height); }
 * 
 * public void draw(Graphics g){ g.setColor(Color.GREEN); g.fillRect(x, y,
 * width, height); }
 * 
 * public Rectangle getCBox(){ return cBox; }
 * 
 * public int getX(){ return x; }
 * 
 * public int getY(){ return y; } }
 * 
 * class Player{ private int x; private int y; private int width; private int
 * height;
 * 
 * private Rectangle cBox = new Rectangle();
 * 
 * 
 * public boolean left = false; public boolean right = false;
 * 
 * private int xVelocity = 5;
 * 
 * private int gravity = 1; private int yVelocity = 0; private int jumpPower =
 * 20;
 * 
 * private int yLimit = 500;
 * 
 * boolean canJump = false;
 * 
 * public Player(int x, int y, int w, int h){ this.x = x; this.y = y; this.width
 * = w; this.height = h; System.out.println(x); cBox.setBounds(x, y, width,
 * height); }
 * 
 * public void jump(){ if(canJump){ yVelocity -= jumpPower; canJump = false; } }
 * 
 * public void update(){ if(left){ x -= xVelocity; } if(right){ x += xVelocity;
 * }
 * 
 * yVelocity += gravity; y += yVelocity;
 * 
 * if(y >= yLimit + 1){ y = yLimit + 1; yVelocity = 0; canJump = true; } x = x +
 * 10; cBox.setBounds(x, y, width, height); }
 * 
 * public void draw(Graphics g){ g.setColor(Color.BLUE); g.fillRect(x, y, width,
 * height); }
 * 
 * public Rectangle getCBox(){ return cBox; }
 * 
 * public void setYLimit(int l){ yLimit = l; }
 * 
 * public int getX(){ return x; }
 * 
 * public int getY(){ return y; }
 * 
 * public int getWidth(){ return width; }
 * 
 * public int getHeight(){ return height; }
 * 
 * public int getYVelocity(){ return yVelocity; } }
 */
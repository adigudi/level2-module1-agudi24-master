package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont;
	Font startFont;
	Font instructionsFont;
	Rocketship rocket = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(rocket);
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 24);
		instructionsFont = new Font("Arial", Font.PLAIN, 24);
	}

	void StartGame() {
		timer.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 150);
		g.setFont(startFont);
		g.drawString("Press ENTER to start", 20, 300);
		g.setFont(instructionsFont);
		g.drawString("Press SPACE for instructions", 20, 450);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		manager.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER!", 20, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	@Override
	public void paintComponent(Graphics g) {
		repaint();
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HiT");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HiP");
		//System.out.println(e.getKeyCode());
		if(KeyEvent.VK_ENTER == e.getKeyCode()){
			currentState = GAME_STATE;
		}
		if(KeyEvent.VK_SPACE == e.getKeyCode()) {
			manager.addProjectile(new Projectile(rocket.x + 20, rocket.y, 10, 10));
			System.out.println("Space");
		}
		if (currentState > END_STATE) {

			currentState = MENU_STATE;

		}
		if(KeyEvent.VK_UP == e.getKeyCode()) {
			System.out.println("up");
			rocket.y=rocket.y-rocket.speed;
		}
		if(KeyEvent.VK_DOWN == e.getKeyCode()) {
			System.out.println("down");
			rocket.y=rocket.y+rocket.speed;
		}
		if(KeyEvent.VK_LEFT == e.getKeyCode()) {
			System.out.println("left");
			rocket.x=rocket.x-rocket.speed;
		}
		if(KeyEvent.VK_RIGHT == e.getKeyCode()) {
			System.out.println("right");
			rocket.x=rocket.x+rocket.speed;
		}
		System.out.println(rocket.x + "," + rocket.y);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HiR");
		rocket.update();
	}
}

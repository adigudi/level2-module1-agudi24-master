package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FinalGamePanel{
	Font titleFont;
	public static BufferedImage faceImg;
	int maxX = 1050;
	int startX = 50;
	final static int MENU_STATE = 0;
	static int currentState = MENU_STATE;
	

	FinalGamePanel() {
		titleFont = new Font("Helvetica Neue", Font.PLAIN, 48);
	}
	{
	try {

        faceImg = ImageIO.read(this.getClass().getResourceAsStream("smile.png"));

      

} catch (IOException e) {

        // TODO Auto-generated catch block

        e.printStackTrace();

}
	}

	

	void updateMenuState() {

	}

	void updateGameState() {
		
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.drawString("Square Runner", 80, 150);
	}

	void drawGameState(Graphics g) {
		Camera cam = new Camera(0, 0, 1000, 600);
		g.drawRect(Level2FinalGame.x - cam.x, 50, Level2FinalGame.WIDTH, Level2FinalGame.HEIGHT);
		System.out.println(cam.x);
	}

	void drawEndState(Graphics g) {

	}
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		}
	}


}

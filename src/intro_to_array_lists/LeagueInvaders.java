package intro_to_array_lists;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame = new JFrame("League Invaders");
	int width = 500;
	int height = 800;
	GamePanel GP;
	LeagueInvaders() {
		GP = new GamePanel();
		GP.StartGame();
	}

void setup() {
	frame.add(GP);
	frame.setVisible(true);
	frame.setSize(width, height);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setPreferredSize(new Dimension(width, height));
	frame.pack();
	frame.addKeyListener(GP);
}

	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
		LI.setup();
		
	}

}

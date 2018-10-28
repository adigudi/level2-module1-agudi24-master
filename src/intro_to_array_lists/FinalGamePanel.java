package intro_to_array_lists;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class FinalGamePanel {
	Font titleFont;
  

	FinalGamePanel() {
		titleFont = new Font("Helvetica Neue", Font.PLAIN, 48);
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
		

	}

	void drawEndState(Graphics g) {

	}


}

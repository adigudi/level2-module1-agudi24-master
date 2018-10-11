package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	static int score = 0;

	public int getScore() {
		return score;
	}

	void addAlien(Alien a) {
		aliens.add(a);
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	ObjectManager(Rocketship r) {
		this.r = r;
	}

	void update() {
		r.update();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile j = projectiles.get(i);
			j.update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			Alien b = aliens.get(i);
			b.update();
		}
		purgeAlien();
		purgeProjectile();
		

	}

	void draw(Graphics g) {
		//

		for (int i = 0; i < projectiles.size(); i++) {
			Projectile k = projectiles.get(i);
			k.draw(g);
		}
		r.draw(g);

		for (int i = 0; i < aliens.size(); i++) {
			Alien b = aliens.get(i);
			b.draw(g);

		}

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(500), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}

	}

	void purgeAlien() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien c = aliens.get(i);
			if (c.isAlive == false) {
				aliens.remove(c);
			}
		}
	}

	void purgeProjectile() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile d = projectiles.get(i);
			if (d.isAlive == false) {
				projectiles.remove(d);
			}
		}
	}

	void checkCollision() {
		for (Alien a : aliens) {
			if (r.collisionBox.intersects(a.collisionBox)) {
				r.isAlive = false;
				System.out.println("You Die!");
				GamePanel.changeCurrentState();
				break;
			}

			for (Projectile p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
					System.out.println("Hit!");
					score++;
					getScore();

				}
			}
		}

	}

}

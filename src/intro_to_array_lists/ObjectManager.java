package intro_to_array_lists;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship r;
	ArrayList<Projectile> projectile = new ArrayList<Projectile>();
	ArrayList<Alien> alien = new ArrayList<Alien>();
	
	void addAlien(Alien a) {
		alien.add(a);
	}

	void addProjectile(Projectile p) {
		projectile.add(p);
	}

	ObjectManager(Rocketship r) {
		this.r = r;
	}

	void update() {
		r.update();
		for (int i = 0; i < projectile.size(); i++) {
			Projectile j = projectile.get(i);
			j.update();
		}
		for (int i = 0; i < alien.size(); i++) {
			Alien b = alien.get(i);
			b.update();
		}
		
	}

	void draw(Graphics g) {
		//

		for (int i = 0; i < projectile.size(); i++) {
			Projectile k = projectile.get(i);
			k.draw(g);
		}
		r.draw(g);
		Alien ali = new Alien(250, 400, 100, 100);
		System.out.println(ali.x);
		alien.add(ali);
		for (int i = 0; i < alien.size(); i++) {
			Alien b = alien.get(i);
			b.draw(g);
			
		}
		}
	}


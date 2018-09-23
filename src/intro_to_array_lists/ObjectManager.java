package intro_to_array_lists;

import java.awt.Graphics;

public class ObjectManager {
	Rocketship r;
	
	ObjectManager(Rocketship r){
		this.r = r;
	}
	void update(){
		r.update();
	}
    void draw(Graphics g){
	//	
	}
}

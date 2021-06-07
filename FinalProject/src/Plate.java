import java.awt.Graphics;
import java.util.ArrayList;

public class Plate extends Item {
	private ArrayList<Food> foods = new ArrayList<Food>();
	public Plate(int x, int y, Player p) {
		super(x,y,p);
		imgName = "plate.png";
		canHoldFood=true;
	}
	public void paint(Graphics g) {
		super.paint(g);
		for(Food f:foods) {
			f.paint(g);
		}
	}
	public void setBeingHeld(boolean beingHeld) {
		this.beingHeld=beingHeld;
		for(Food f:foods) {
			f.beingHeld=beingHeld;
		}
	}
	public boolean empty() {
		return(foods.size()==0);
	}
	public void add(Food f) {
		foods.add(f);
		f.setBeingHeld(true);
	}
	public Food remove() {
		return foods.remove(0);
	}
}

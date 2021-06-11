import java.awt.Graphics;
import java.util.ArrayList;

public class Plate extends Item {
	private ArrayList<Food> foods = new ArrayList<Food>();
	private int origX, origY;
	public Plate(int x, int y, Player p) {
		super(x,y,p);
		imgName = "plate.png";
		canHoldFood=true;
		origX=x;
		origY=y;
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
	public void reset() {
		for(Food f:foods){
			f.setDelivered(true);
		}
		foods.removeAll(foods);
		//put plate back to its original spot
		x=origX;
		y=origY;
	}
	public boolean empty() {
		return(foods.size()==0);
	}
	public ArrayList<Food> getFoods() {
		return foods;
	}
	public void add(Food f) {
		foods.add(f);
		f.setBeingHeld(true);
	}
	public Food remove() {
		return foods.remove(0);
	}
}

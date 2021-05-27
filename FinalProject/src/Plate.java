import java.util.ArrayList;

public class Plate extends Tile {
	private ArrayList<Food> foods = new ArrayList<Food>();
	public Plate(int x, int y, Player p) {
		super(x, y,p);
		imgName = "plate.png";
		collide = false;
	}
	public void add(Food f) {
		foods.add(0,f);
	}
	public Food remove() {
		return foods.remove(0);
	}
}

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Stove extends Tile {
	private boolean timer=false;

	public Stove(int x, int y, Player p) {
		super(x, y, p);
		imgName = "stovetop.png";
		collide = true;
	}
	public void setCookingLimit() {
	}

}

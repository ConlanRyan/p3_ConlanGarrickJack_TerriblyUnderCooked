import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

public class Stove extends Tile {
	private int count=0;
	public Stove(int x, int y) {
		super(x, y);
		imgName = "stovetop.png";
		collide = true;
	}
	
	
	
}

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

public class Stove extends Tile {

	private int count=0;
	

	private boolean timer=false;

	public Stove(int x, int y, Player p) {
		super(x, y, p);

		imgName = "stovetop.png";
		collide = true;
	}

	
	
}



import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

public class DeliverySpace extends Tile {

	private int count=0;
	

	private boolean timer=false;
	private int cookingLimit=0;
	private boolean cooking = false;
	public DeliverySpace(int x, int y, Player p) {
		super(x, y, p);

		imgName = "Delivery Space.png";
		collide = true;
	}
	

}
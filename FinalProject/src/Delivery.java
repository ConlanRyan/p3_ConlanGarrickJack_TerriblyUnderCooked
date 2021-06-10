
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Delivery extends Tile{
	public Delivery(int x, int y, Player p) {
		super(x, y, p);
		imgName = "deliveryStation.png";
		collide = true;
	}	

}
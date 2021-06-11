import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Item {
	protected int x,y;
	protected boolean beingHeld;
	protected Player p;
	protected String imgName;
	private int width,height;
	protected boolean canHoldFood;
	protected boolean delivered;
	protected AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	public Item(int x, int y, Player p) {
		this.x=x;
		this.y=y;
		this.p=p;
		height=50;
		width=50;
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		
		
		//if an item is being held
		//set it's x and y to the players
		if(beingHeld) {
			int yMod = 0;
			int xMod = 0;
			if(p.direction()==0) {
				yMod=-50;
			}
			else if(p.direction()==1) {
				xMod=50;
			}
			else if(p.direction()==2) {
				yMod=50;
			}
			else if(p.direction()==3) {
				xMod=-50;
			}
			x=p.getX()+xMod;
			y=p.getY()+yMod;
		}
		else {
			
		}
		tx.setToTranslation(x, y);
		g2.drawImage(getImage(imgName), tx, null);
		
		
	}
	public void setBeingHeld(boolean held) {
		beingHeld = held;
	}
	public int getX() {
		return x;
	}
	public void setDelivered(boolean del) {
		delivered=del;
	}
	public boolean getDevlivered() {
		return delivered;
	}
	public int getY() {
		return y;
	}
	
	// converts image to make it drawable in paint
	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Game.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	/* Helper function for collision detection later */
	public Rectangle getRect() {
		Rectangle temp = new Rectangle(x,y,width,height);
		return temp;
	}
}

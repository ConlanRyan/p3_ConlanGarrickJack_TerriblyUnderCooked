import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Tile {
	protected int x;
	protected int y;
	private int width;
	private int height;
	protected boolean collide;
	protected String imgName;
	protected boolean canGrab;
	protected boolean beingHeld;
	protected int seconds=0;
	protected Player p;
	public Tile(int x, int y, Player p) {
		collide=false;
		imgName = "Tile.png";
		this.x = x*50;
		this.y = y*50;
		width = 50;
		height = 50;
		this.p=p;
	}
	public void update(int timer) {
		seconds=timer;
	}
	
	protected AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		tx.setToTranslation(x, y);
		
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
		
		g2.drawImage(getImage(imgName), tx, null);
		
		
	}
	public boolean canGrab() {
		return canGrab;
	}
	
	public boolean canCollide() {
		return collide;
	}
	public void setBeingHeld(boolean held) {
		beingHeld = held;
	}
	public int getX() {
		return x;
		
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

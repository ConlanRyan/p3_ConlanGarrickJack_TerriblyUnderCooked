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
	protected int seconds=0;
	protected Player p;
	protected boolean canGrabIngredientFrom;
	private Game game;
	private int num=0;
	
	public Tile(int x, int y, Player p) {
		collide=false;
		imgName = "Tile.png";
		this.x = x*50;
		this.y = y*50;
		width = 50;
		height = 50;
		this.p=p;
		canGrabIngredientFrom=false;
	}
	public void update(int timer) {
		seconds=timer;
	}
	
	protected AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		tx.setToTranslation(x, y);
		g2.drawImage(getImage(imgName), tx, null);
		
		
	}
	
	public boolean canCollide() {
		return collide;
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

	
	public int getX() {
		return x;
	}

	public int getY(){
		return y;
	}
}

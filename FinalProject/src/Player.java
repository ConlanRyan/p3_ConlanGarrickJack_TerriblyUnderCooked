import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player {
	private int x,y,width,height,xVel,yVel;
	private boolean display;
	private int speed=10;
	
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		xVel=0;
		yVel=0;
		width = 50;
		height = 50;
	}
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	
	
	public void paint(Graphics g) {
		x+=xVel;
		y+=yVel;
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(getImage("player.png"), tx, null);
		
		tx.setToTranslation(x, y);
		
	}
	
	// converts image to make it drawable in paint
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Game.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void right() {
		xVel=speed;
	}
	public void left() {
		xVel=-speed;
	}
    public void up() {
    	yVel=-speed;
	}
	public void down() {
		yVel=speed;
	}
	public void stopX() {
		xVel = 0;
	}
	public void stopY() {
		yVel = 0;
		
	}
	/* Helper function for collision detection later */
	public Rectangle getRect() {
		Rectangle temp = new Rectangle(x,y,width,height);
		return temp;
	}
}

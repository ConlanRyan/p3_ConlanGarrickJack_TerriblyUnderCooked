import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.ArrayList;

public class Player {
	private int x,y,width,height,xVel,yVel;
	private boolean display;
	private int speed=10;
	private boolean collide=false;
	private boolean isHolding;
	private int direction;
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		xVel=0;
		yVel=0;
		width = 50;
		height = 50;
		isHolding = false;
		direction = 0;
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
	public int direction(){
		return direction;
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
	
	public void pickUp(ArrayList<Item> items) {
		//looking up and something above?
		System.out.println("Method activated");
		System.out.println(direction);
		
		//if we are not holding something already
		if(!isHolding) {
			//for every item in our arraylist
			for(Item i:items) {
				//if we are intersecting with an item
				if(i.getRect().intersects(getRect())) {
					if(direction==0&&(i.getY()<y)){
						isHolding = true;
						i.setBeingHeld(true);
						System.out.println("Picked up");
					}
					//looking right?
					else if(direction==1&&(i.getX()>x)){
						isHolding = true;
						i.setBeingHeld(true);
						System.out.println("Picked right");
					}
					//looking down?
					else if(direction==2&&(i.getY()>y)){
						isHolding = true;
						i.setBeingHeld(true);
						System.out.println("Picked down");
					}		
					//looking left?
					else if(direction==3&&(i.getX()<x)){
						isHolding = true;
						i.setBeingHeld(true);
						System.out.println("Picked left");
					}
					
				}
			}
		
		}
		else {
			//if we are holding something
			isHolding = false;
			for(Item i:items) {
				//find the one we are holding
				if(i.beingHeld) {
					i.setBeingHeld(false);
				}
			}
		}
	}
	
	public void right() {
		xVel=speed;
		direction = 1;
	}
	public void left() {
		xVel=-speed;
		direction = 3;
	}
    public void up() {
    	yVel=-speed;
    	direction = 0;
	}
	public void down() {
		yVel=speed;
		direction = 2;
	}
	
	public void stopRight() {
			xVel=0;
	}
	
	public boolean getCollide() {
		return collide;
	}
	public void setCollide(boolean c) {
		collide=c;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setTx(AffineTransform tx) {
		this.tx = tx;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getxVel() {
		return xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public boolean isDisplay() {
		return display;
	}

	public int getSpeed() {
		return speed;
	}

	public AffineTransform getTx() {
		return tx;
	}

	public void stopX() {
		xVel = 0;
	}
	public void stopY() {
		yVel = 0;
		
	}
	/* Helper function for collision detection later */
	public Rectangle getRect() {
		Rectangle temp = new Rectangle(x-1,y-1,width+2,height+2);
		return temp;
	}
}

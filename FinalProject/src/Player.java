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
	private boolean plate;
	private Item itemBeingHeld;
	private String imgName;
	private int score;
	public Player(int x, int y) {
		this.x=x;
		this.y=y;
		xVel=0;
		yVel=0;
		width = 50;
		height = 50;
		isHolding = false;
		direction = 0;
		plate = false;
		itemBeingHeld = new Item(0, 0, null);
		imgName = "Chef Up.png";
		score = 0;
	}
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	
	
	public void paint(Graphics g) {
		x+=xVel;
		y+=yVel;
		Graphics2D g2 = (Graphics2D) g;
		if(direction==0) {
			imgName="Chef Up.png";
		}
		if(direction==1) {
			imgName="Chef Right.png";
		}
		if(direction==2) {
			imgName="Chef Down.png";
		}
		if(direction==3) {
			imgName="Chef Left.png";
		}
		g2.drawImage(getImage(imgName), tx, null);


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
	
	public void pickUp(ArrayList<Item> items, Tile[][] room) {
		
		
		//if we are not holding something already
		if(!isHolding) {
			boolean priority=true;
			//ingredient grab 
			if(priority) {
				//for every item in our arraylist
				for(Item i:items) {
					//if we are intersecting with an item
					if(i.getRect().intersects(getRect())) {
						//if it is a plated food, don't worry about it
						if(i.getClass().getName().equals("Food")&&((Food)(i)).plated) {}
						else {
							itemBeingHeld=i;
							if(direction==0&&(i.getY()<y)){
								isHolding = true;
								i.setBeingHeld(true);	}
							//looking right?
							else if(direction==1&&(i.getX()>x)){
								isHolding = true;
								i.setBeingHeld(true);}
							//looking down?
							else if(direction==2&&(i.getY()>y)){
								isHolding = true;
								i.setBeingHeld(true);}		
							//looking left?
							else if(direction==3&&(i.getX()<x)){
								isHolding = true;
								i.setBeingHeld(true);}
							if(i.getClass().getName().equals("Plate")) {
								plate = true;}
							else {plate=false;}
							priority=false;
						}
						
					}
				}
				
			}
			if(priority) {
				for(int i=0;i<room.length;i++) {
					for(int j=0;j<room[0].length;j++) {
						if(room[i][j].getClass().getName().equals("IngredientStation")
							&& room[i][j].getRect().intersects(getRect())) {
							
							//add that item immedietly to the arraylist, so it will paint itself
							items.add(0,((IngredientStation)(room[i][j])).grabFromBox());
							//immedietly tell that we are picking it up
							items.get(0).setBeingHeld(true);
							//set our personal variable to the picked up item
							itemBeingHeld=items.get(0);
							isHolding = true;
							priority=false;
						}
					}
				}
			}
			
			
			
			
		
		}
		
		//if we are holding something
		else {

			//if we are holding a plate, and we are touching a food, stack that food
			//in the plate's arraylist
			boolean priority=true;
			//find the item we are touching
			for(Item i:items) {
				if(itemBeingHeld.getRect().intersects(i.getRect())) {
					//if the item we are touching is one that we are
					//already holding, then we don't bother it
					if(!i.beingHeld) {
						//if we are holding a plate, and the one we are
						//touching is a food then put that food on the plate!
						if(itemBeingHeld.getClass().getName().equals("Plate")
							&&i.getClass().getName().equals("Food")){
							
							((Plate)(itemBeingHeld)).add((Food)(i));
							priority=false;
							isHolding=true;
						}
					}
				}
			}
						
		
			if(priority) {
				for(int i=0;i<room.length;i++) {
					for(int j=0;j<room[0].length;j++) {
						if(room[i][j].getRect().intersects(getRect())&&room[i][j].getClass().getName().equals("Stove")) {
							//dont allow plates that are empty to be in oven
							if(itemBeingHeld.getClass().getName().equals("Plate")&& !(plate&&((Plate)(itemBeingHeld)).empty())) {
								//put just the food in the oven
								
								Food f = ((Plate)(itemBeingHeld)).remove();
								f.setBeingHeld(false);
								((Stove)(room[i][j])).startCooking(f);
								priority=false;
								isHolding=true;
								
							}
						}
					
					}	
				}
			}
			//Delivering food out!
			if(priority) {
				for(int i=0;i<room.length;i++) {
					for(int j=0;j<room[0].length;j++) {
						if(itemBeingHeld.getClass().getName().equals("Plate")&&room[i][j].getRect().intersects(getRect())&&room[i][j].getClass().getName().equals("DeliverySpace")) {
							//drop our item
							itemBeingHeld.setBeingHeld(false);
							isHolding=false;
							calculateScore((Plate)(itemBeingHeld));
							itemBeingHeld.delete();
							
						}
					}
				}	
			}
			
			if(priority) {
				if(itemBeingHeld.beingHeld) {
					itemBeingHeld.setBeingHeld(false);
					isHolding=false;
				}
			}
		}
	}
	
	public void right() {
		xVel=speed;
		direction = 1;
	}
	public void calculateScore(Plate p) {
		ArrayList<Food> foods = p.getFoods();
		//if all the food is cooked, you get points
		for(Food f:foods) {
			String name = f.getImageName();
			if(f.cooked) {
				score++;
			}
			if(name.equals("Spagetti.png")){
				score++;
			}
			if(name.equals("Raw Spagetti.png")) {
				score++;
			}
			if(name.equals("Sauce.png")){
				score++;
			}
			if(name.equals("Tomato.png")) {
				score++;
			}
		}
		
	}
	public int getScore() {
		return score;
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
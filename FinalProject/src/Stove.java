import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.Timer;

public class Stove extends Tile {

	private int count=0, seconds=0,num=0;
	private boolean cooking;
	private boolean timer=false;
	public Stove(int x, int y, Player p) {
		super(x, y, p);
		imgName = "stovetop.png";
		collide = true;
		cooking = false;
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		if(cooking) {
			System.out.println(cooking);
			count+=20;
			if(seconds<5) {
				if(count%(1000)==0) {
					seconds++;
				}
				if(seconds%4==0) {
					g.drawImage(getImage("UpTimer.png"),x,y+50,50,50,null);
					System.out.println("Cooking1!");
				}else if(seconds%4==1) {
					
					g.drawImage(getImage("RightTimer.png"),x,y+50,50,50,null);
					System.out.println("Cooking2!");
				}else if(seconds%4==2) {
					
					g.drawImage(getImage("DownTimer.png"),x,y+50,50,50,null);
					System.out.println("Cooking3!");
				}else{
					
					g.drawImage(getImage("LeftTimer.png"),x,y+50,50,50,null);
					System.out.println("Cooking4!");
				}
			}
			else {
				//the food inside should turn cooked
			}
			
			
		}
	}
	
	public boolean getCooking() {
		return cooking;
	}
	
	public void setCooking(boolean t) {
		cooking=t;
	}
	
}


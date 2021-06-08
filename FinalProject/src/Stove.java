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
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(cooking) {
			count+=20/num;
			if(seconds<5) {
			if(count%(1000)==0) {
				seconds++;
			}
				
				
			if(seconds%4==0) {
				
				g.drawImage(getImage("UpTimer.png"),x,y,50,50,null);
			}else if(seconds%4==1) {
				
				g.drawImage(getImage("RightTimer.png"),x,y,50,50,null);
			}else if(seconds%4==2) {
				
				g.drawImage(getImage("DownTimer.png"),x,y,50,50,null);
			}else{
				
				g.drawImage(getImage("LeftTimer.png"),x,y,50,50,null);
			}
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


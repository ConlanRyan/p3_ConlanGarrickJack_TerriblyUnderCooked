import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class Stove extends Tile {

	private int count=0, seconds=0,num=0;
	private boolean timer=false;
	private Food f = new Food(0,0,null,null);
	private int cookingLimit=0;
	private boolean cooking = false;

	public Stove(int x, int y, Player p) {
		super(x, y, p);
		imgName = "stovetop.png";
		collide = true;
		cooking = false;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if(cooking) {
			count+=20;
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
			else {
				f.setCooked(true);
			}
		}
		
		
		
	}
	
	public boolean getCooking() {
		return cooking;
	}
	
	public void startCooking(Food f) {
		System.out.println("Started cooking");
		cooking=true;
		count=0;
		this.f = f;
		
	}
	
}


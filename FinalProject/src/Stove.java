import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Stove extends Tile {
	private boolean timer=false;
	private int cookingLimit=0;
	private boolean cooking = false;
	public Stove(int x, int y, Player p) {
		super(x, y, p);
		imgName = "stovetop.png";
		collide = true;
	}
	public void setCookingLimit() {
		cookingLimit = seconds+10;
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		if( seconds!=cookingLimit ) {
			
		}
		else{
			cooking=false;
		}
	}

	/*public void cookingTimer(){
		timer=true;
		
		long startTime=System.currentTimeMillis();
		System.out.println("Timer:");
		while(timer) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long timePassed=System.currentTimeMillis()-startTime;
			long secondsPassed=timePassed/1000;
			if(secondsPassed%4==0) {
				System.out.print("up");
				imgName="UpTimer.png";
			}else if(secondsPassed%4==1) {
				System.out.print("right");
				imgName="RightTimer.png";
			}else if(secondsPassed%4==2) {
				System.out.print("down");
				imgName="DownTimer.png";
			}else{
				System.out.print("left");
				imgName="LeftTimer.png";
			}
			
			System.out.println(secondsPassed);
			
		}
		
	}*/
}
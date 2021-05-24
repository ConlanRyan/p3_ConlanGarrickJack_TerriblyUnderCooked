import java.awt.Rectangle;
import java.util.concurrent.TimeUnit;

public class Stove extends Tile {
	private boolean timer=false;
	public Stove(int x, int y) {
		super(x, y);
		imgName = "stovetop.png";
		collide = true;
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

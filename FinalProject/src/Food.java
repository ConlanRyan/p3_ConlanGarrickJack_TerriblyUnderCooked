import java.awt.Graphics;

public class Food extends Item{
	boolean canCook;
	boolean cooked;
	boolean canBoil;
	boolean boiled;
	boolean canToast;
	boolean toasted;
	boolean canChop;
	boolean chopped;
	boolean plated; 

	public Food(int x, int y, String imgName, Player p) {
		super(x,y,p);
		this.imgName=imgName;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
	}
	public String getImageName() {
		return imgName;
	}
	
}

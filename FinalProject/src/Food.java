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
		canHoldFood=false;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(cooked) {
			if(imgName=="Raw Spagetti.png") {
				imgName="Spagetti.png";
			}
			if(imgName=="Whole Tomato.png") {
				imgName="Sauce.png";
			}
		}
		
	}
	public String getImageName() {
		return imgName;
	}
	public void setBeingPlated(boolean plated) {
		this.plated=plated;
	}
	public void setCooked(boolean cooked) {
		this.cooked=cooked;
	}
}

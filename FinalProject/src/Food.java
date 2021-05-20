
public class Food extends Tile{
	boolean canCook;
	boolean cooked;
	boolean canBoil;
	boolean boiled;
	boolean canToast;
	boolean toasted;
	public Food(int x, int y, String imgName) {
		super(x, y);
		collide = false;
		canGrab = true;
		this.imgName=imgName;
	}

}

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class IngredientStation extends Tile{
	private Food f;
	public IngredientStation(int x,int y, Food f, Player p, String imgName) {
		super(x,y,p);
		collide = true;
		this.imgName = imgName;
		this.f=f;
		
	}
	protected AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	// draw the affine transform
	
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		tx.setToTranslation(x, y);
		
		g2.drawImage(getImage(imgName), tx, null);
		
		
	}
	public Food grabFromBox() {
		return f;
		
	}
	protected Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Game.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
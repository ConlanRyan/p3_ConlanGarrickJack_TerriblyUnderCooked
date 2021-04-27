
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class Game extends JPanel implements ActionListener, KeyListener {
	//800x600
	//16x12 50 pixel tiles
	private Player p = new Player(0,0);
    private Tile[][] room = new Tile[12][16];
    private boolean title = true;
	public void paint(Graphics g) {
		super.paintComponent(g); // do not remove
		if (title) {
			
			g.drawImage(getImage("terriblyundercooked.png"),0,0,800,600,null);
			g.setFont(new Font("courier",30,30));
			g.setColor(new Color(255,255,255));
			g.drawString("Press T to begin",33,400);
		}
		else {
			p.paint(g);
			line(2,10,4,g);
			for(int i=0;i<room.length;i++) {
				for(int j=0;j<room[0].length;j++) {
					room[i][j].paint(g);
				}
			}
			for(int i =0;i<800;i+=50) {
				g.drawLine(i, 0, i, 600);
			}
			for(int i =0;i<600;i+=50) {
				g.drawLine(0, i, 800, i);
			}
			
			int mouseY = ((int)MouseInfo.getPointerInfo().getLocation().getY())-35;
			int mouseX = ((int)MouseInfo.getPointerInfo().getLocation().getX())-10;
			
		}
		

	}

	public void line(int x, int x2, int y, Graphics g) {
		for(int i =x;i<x2;i++) {
			room[i][y] = new Stove(i,y);
		}
	}
	
	
	// do not touch
	public Game() {
		JFrame frame = new JFrame("Food Frenzy");
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer t = new Timer(16, this);
		
		//LEVEL CREATION
		for(int i =0;i<room.length;i++) {
			for(int j=0;j<room[0].length;j++) {
				room[i][j]=new Tile(j,i);
				
			}
		}
		
		t.start();
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
	} // end of MainFrame




	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		//w
		if (e.getKeyCode()==87) {
			p.up();
		}
		
		//a
		if (e.getKeyCode()==65) {
			p.left();
		}
		
		//s
		if (e.getKeyCode()==83) {
			p.down();
		}
		
		//d
		if (e.getKeyCode()==68) {
			p.right();
		}
		
		//space
		if (e.getKeyCode()==32) {
			
		}
		
		//e
		if(e.getKeyCode()==69) {
			
		}
		if(e.getKeyCode()==84) {
			title=false;
		}
	}




	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==87||e.getKeyCode()==83) {
			p.stopY();
			
		}
		if(e.getKeyCode()==65||e.getKeyCode()==68) {
			p.stopX();
		}
	}




	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();


		
	}
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


} // end of class curly - do not delete

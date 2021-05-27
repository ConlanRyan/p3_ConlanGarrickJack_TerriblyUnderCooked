
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
	private Player p = new Player(300,400);
    private Tile[][] room = new Tile[12][16];
    private boolean title = true;
    private int level = 0;
    private boolean colR,colL,colU,colD;
    private int count=0, seconds=0;
    
	public void paint(Graphics g) {
		level=1;
		super.paintComponent(g); // do not remove
		if (title) {	
			g.drawImage(getImage("title.png"),0,0,800,600,null);
			g.setFont(new Font("courier",30,30));
			g.setColor(new Color(255,255,255));
		}

		else {
			//room paint

			for(int i=0;i<room.length;i++) {
				for(int j=0;j<room[0].length;j++) {
					room[i][j].paint(g);
				}
			}
			//level selector
			if(level==0) {
				
			}
			//breakfast
			else if (level==1) {
				//counters
				horizLine(2,4,2,"counter");
				horizLine(6,8,2,"counter");
				vertLine(2,4,13,"counter");
				vertLine(7,10,13,"counter");
				room[9][11] = new Counter(11,9,p);
				room[9][9] = new Counter(9,9,p);
				room[9][7] = new Counter(7,9,p);
				room[9][5] = new Counter(5,9,p);
				horizLine(2,4,9,"counter");
				vertLine(6,9,2,"counter");
				room[4][2] = new Counter(2,4,p);
				
				//stoves
				room[2][9] = new Stove(9,2,p);
				room[2][11] = new Stove(11,2,p);
				room[9][8] = new Stove(8,9,p);
				
				room[2][4] = new Sink(4,2,p);
				
				room[4][4] = new Plate(4,4,p);
				
			}
			else if (level==2) {
				
			}
			


			grid(g);
			p.paint(g);
			int mouseY = ((int)MouseInfo.getPointerInfo().getLocation().getY())-35;
			int mouseX = ((int)MouseInfo.getPointerInfo().getLocation().getX())-10;
			
		}
		//Border collision
		if(p.getX()+p.getWidth()>795) {
			p.stopX();
			colR=true;
			//p.setSpeed(0);
		}else {
			colR=false;
		}
		if(p.getX()<10) {
			p.stopX();
			colL=true;
		}else {
			colL=false;
		}
		if(p.getY()+p.getHeight()>590) {
			p.stopY();
			colD=true;
		}else {
			colD=false;
		}
		if(p.getY()<10) {
			p.stopY();
			colU=true;
		}else {
			colU=false;
		}
		
	}

	public void horizLine(int x, int x2, int y, String type) {
		for(int i =x;i<x2;i++) {
			if(type.toLowerCase().equals("stove")) {
				room[y][i] = new Stove(i,y,p);
			}
			else if(type.toLowerCase().equals("counter")) {
				room[y][i] = new Counter(i,y,p);
			}
			else if(type.toLowerCase().equals("tile")) {
				room[y][i] = new Tile(i,y,p);
			}
			
			
		}
	}
	
	public void vertLine(int y, int y2, int x, String type) {
		for(int i =y;i<y2;i++) {
			
			if(type.toLowerCase().equals("stove")) {
				room[i][x] = new Stove(x,i,p);
			}
			else if(type.toLowerCase().equals("counter")) {
				room[i][x] = new Counter(x,i,p);
			}
			else if(type.toLowerCase().equals("tile")) {
				room[i][x] = new Tile(x,i,p);
			}
			
		}
	}
	public void grid(Graphics g) {
		for(int i =0;i<800;i+=50) {
			g.drawLine(i, 0, i, 600);
		}
		for(int i =0;i<600;i+=50) {
			g.drawLine(0, i, 800, i);
		}
	}
	// do not touch
	public Game() {
		JFrame frame = new JFrame("Terribly Under Cooked");
		frame.setSize(815, 637);
		frame.setResizable(false);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.add(this);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer t = new Timer(16, this);
		
		//LEVEL CREATION
		for(int i =0;i<room.length;i++) {
			for(int j=0;j<room[0].length;j++) {
				room[i][j]=new Tile(j,i,p);
				
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
		
		//if statement to check if collision
		if(!colU) {
		if (e.getKeyCode()==87) {
			p.up();
		}
		}
		
		if(!colL) {
		//a
		if (e.getKeyCode()==65) {
			p.left();
		}
		}
		
		if(!colD) {
		//s
		if (e.getKeyCode()==83) {
			p.down();
		}
		}
		
		if(!colR) {
		//d
		if (e.getKeyCode()==68) {
			p.right();
		}
		}
		
		//space
		if (e.getKeyCode()==32) {
			
		}
		
		//e
		if(e.getKeyCode()==69) {
			p.pickUp(room);
			System.out.println("E is pressed");
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

		for(int i=0;i<room.length;i++) {
			for(int j=0;j<room[0].length;j++) {
				room[i][j].update(seconds);
			}
		}

		
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
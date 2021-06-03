
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
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener, KeyListener {
	//800x600
	//16x12 50 pixel tiles
	private Player p = new Player(200,300);
    private Tile[][] room = new Tile[12][16];
    private ArrayList<Item> items = new ArrayList<Item>();
    private boolean title = true;
    private int level = 0;
    private boolean colR,colL,colU,colD;
<<<<<<< HEAD
    private int count=0, seconds=0;
    /*private playMusic musicPlayer;
    public void Music() {
    	musicPlayer = new playMusic("title");
		playMusic.main(null);
    }*/
=======
    private int count=0, seconds=0,num=0;
  
    
>>>>>>> refs/remotes/origin/Conlan
	public void paint(Graphics g) {
		level=1;
		super.paintComponent(g); // do not remove
<<<<<<< HEAD
		if (title) {	
=======
		for(int i =0;i<items.size();i++) {
			System.out.println(": "+items.get(i).beingHeld);
		}
		if (title) {
			//test
>>>>>>> refs/remotes/origin/Conlan
			g.drawImage(getImage("title.png"),0,0,800,600,null);
			g.setFont(new Font("courier",30,30));
			g.setColor(new Color(255,255,255));
			g.drawString("Press T to begin",33,400);
			
		} 
		else {
			//room paint
			for(int i=0;i<room.length;i++) {
				for(int j=0;j<room[0].length;j++) {
					room[i][j].paint(g);
				}
			}
			//item paint
			for(Item i:items) {
				i.paint(g);
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
				room[9][12] = new Counter(12,9,p);
				
				//plates in their starting locations
				room[2][8] = new Counter(8,2,p);
				room[2][10] = new Counter(10,2,p);
				room[2][12] = new Counter(12,2,p);

				
				//stoves
				room[2][9] = new Stove(9,2,p);
				room[2][11] = new Stove(11,2,p);
				room[9][8] = new Stove(8,9,p);
				room[9][10]= new Stove(10,9,p);
				
				//sink for washing dishes
				room[2][4] = new Sink(4,2,p);
	
				
				//cutting Board
				room[9][4] = new CuttingBoard(4,9,p);
				room[9][6] = new CuttingBoard(6,9,p);
				
				//ingredients
				room[3][2] = new IngredientStation(2,3,new Food(0,0,"Spagetti Box.png",p),p,"Spagetti Box.png");
				room[5][2] = new IngredientStation(2,5,new Food(0,0,"Whole Tomato.png",p),p,"Tomatoes in Crate.png");
				
				//delivery space
				room[4][13] = new DeliverySpace(13,4,p);
				room[5][13] = new DeliverySpace(13,5,p);
				
				//plate spaces
				room[6][13] = new PlateSpace(13,6,p);
				room[2][5] = new PlateSpace(5,2,p);

				room[2][5] = new PlateSpace(5,2,p);

				
			}
			else if (level==2) {
				
			}
			
<<<<<<< HEAD


			grid(g);
			p.paint(g);
=======
			
			//grid(g);
			p.paint(g);
>>>>>>> refs/remotes/origin/Conlan
			int mouseY = ((int)MouseInfo.getPointerInfo().getLocation().getY())-35;
<<<<<<< HEAD
			int mouseX = ((int)MouseInfo.getPointerInfo().getLocation().getX())-10;
		
		}	
=======
			int mouseX = ((int)MouseInfo.getPointerInfo().getLocation().getX())-10;
		}
		
		
		//testing timer
	//testing timer

		
		//for each timer you add you must update the global num variable!!! 
		
		//format: cookingTimer(g,*x location,*y location,number of timers,number of seconds)
		
			//num=1;
			//cookingTimer(g,room[9][10].getX(),room[9][10].getY(),num,5);
			//cookingTimer(g,room[9][8].getX(),room[9][8].getY(),num,10);
			//cookingTimer(g,room[2][11].getX(),room[2][11].getY());
			//cookingTimer(g,room[10][9].getX()-50,room[10][9].getY()-50);

		
>>>>>>> refs/remotes/origin/Conlan
		//Border collision
		if(p.getX()+p.getWidth()>640) {
			p.stopX();
			colR=true;
			//p.setSpeed(0);
		}else {
			colR=false;
		}
		if(p.getX()<160) {
			p.stopX();
			colL=true;
		}else {
		 colL=false;
		}
		if(p.getY()+p.getHeight()>440) {
			p.stopY();
			colD=true;
		}else {
			colD=false;
		}
		if(p.getY()<160) {
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
<<<<<<< HEAD
=======
		items.add(new Plate(600,100,p));
		items.add(new Plate(400,100,p));
		items.add(new Plate(500,100,p));
		
>>>>>>> refs/remotes/origin/Conlan
		t.start();
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
	} // end of MainFrame



	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println();
		System.out.println(e.getKeyCode());
		//w
		
		//if statement to check if collision
		if (e.getKeyCode()==87) {
			if(!colU) {
				p.up();
			}
			
			
			
		}
		
		
		
		//a
		if (e.getKeyCode()==65) {
			if(!colL) {
				p.left();
			}
		}
		
		
		//s
		if (e.getKeyCode()==83) {
			if(!colD) {
				p.down();
			}
		}
		
		//d
		if (e.getKeyCode()==68) {
			if(!colR) {
				p.right();
			}
		}
		
		//space
		if (e.getKeyCode()==32) {
			
		}
		
		//e
		if(e.getKeyCode()==69) {
			p.pickUp(items,room);
			
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

		
	
	public void cookingTimer(Graphics g,int x , int y, int num, int time) {
		count+=20/num;
		if(seconds<time) {
		if(count%(1000)==0) {
			seconds++;
			System.out.println(seconds);
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
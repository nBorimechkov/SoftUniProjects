import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;





import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainWindow extends JFrame {
	
	Image backgroung;
	Image redcar;
	BlueCar bluecar = new BlueCar();
	BlueCarSec bluecarsec = new BlueCarSec();
	Backgroung backg = new Backgroung();
	
	
	int x,y;
	int score=0;
	private Image dbImage;
	private Graphics dbg;
	
	Font font = new Font("Arial",Font.BOLD,30);
	
	public class Al extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			//System.out.println(keyCode);
			if (keyCode == e.VK_LEFT) {
				
				if (x<=125) 
					x=125;
				else 
					x-=100;		
				score++;
			}
			if (keyCode == e.VK_RIGHT) {
				if(x>=325)
					x=325;
				else
					x+=100;		
				score++;
			}
			if (keyCode == e.VK_SPACE) {
				/*repaint();	
				score=0;*/
			}
			
		}
	}
	
	public MainWindow(){	
		ImageIcon i = new ImageIcon("src/red-car.png");
		redcar = i.getImage();
		//use key left and right
		addKeyListener(new Al());
		setTitle("CarGame");
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//set position of red_car
		x=225;
		y=395;
			    	
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void paint(Graphics g) {
		dbImage =createImage(getWidth(),getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this );
		
	}
	public void paintComponent(Graphics g) {
		g.setFont(font);
		//background drawing
		backg.drawBackg(g);
		//red_car drawing
		g.drawImage(redcar,x,y,this);
		//blue_car drawing
		bluecar.drawBlueCar(g);
		bluecarsec.drawBlueCar(g);

		if((bluecar.getY() + 100 == y && bluecar.getX() == x || bluecar.getX() == x && bluecar.getY() == y || bluecar.getX() == x && bluecar.getY() - 100 == y)||
			(bluecarsec.getY()+ 100 == y && bluecarsec.getX() == x || bluecarsec.getY() == y && bluecarsec.getX() == x || bluecarsec.getY() - 100 == y   && bluecarsec.getX() == x)){
			g.drawString("game over", 170, 150);
			g.setColor(Color.BLUE);
			g.drawString("score:"+score, 180, 180);
		}
		else
		repaint();
		
	}
	
	
	
	
	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		
		Thread t1 = new Thread(mw.bluecar);
		t1.start();
		Thread t2 = new Thread(mw.bluecarsec);
		t2.start();
		Thread t0 = new Thread(mw.backg);
		t0.start();
		
		
	}
	
	
	
	
	
	
}

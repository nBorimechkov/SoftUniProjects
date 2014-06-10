import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Backgroung extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int x,xDirection,y ,yDirection;
	Image backg;
	
	
	public void move(){
		if(y>-1){
			y = -500;
		}
		y +=1-yDirection;
		
	}
	
	public void setYDir(int ydir){
		yDirection = ydir;
	}
	
	public void run(){
		try{
			while(true){
				move();
				
				Thread.sleep(2);
			}
		}catch(Exception e){
			System.out.println("ERORR " +e);
		}
	}
	
	public Backgroung(){
		ImageIcon i = new ImageIcon("src/Trace.png");
		backg = i.getImage();
		y=500;
		}
	
	public void drawBackg(Graphics g) {
		g.drawImage(backg,x,y,this);
	}

}

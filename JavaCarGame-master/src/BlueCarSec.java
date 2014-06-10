import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class BlueCarSec extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	BlueCar blueCar = new BlueCar();
	private static final long serialVersionUID = 1L;
	private static int x, xDirection,y ,yDirection;
	Image bluecarsec;
	int [] arr= {125,225,325};
	
	public void move(){
		int idx = new Random().nextInt(arr.length);
		if(y>600){
			y =blueCar.getY();
			if(this.x==blueCar.getX()) {
				x=x+100;
				if(x>325) {
					x=125;
				}
			}else
			x = arr[idx];
		}else if(y==0){
			if(this.x==blueCar.getX()) {
				x=x+100;
				if(x>=325) {
					x=125;
				}
			}else
			x = arr[idx];}
		y +=1+yDirection;
	}
	
	public void setXDir(int xdir){
		xDirection = xdir;
	}
	public void setYDir(int ydir){
		yDirection = ydir;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
	
	public BlueCarSec(){
		//create blue_car
		ImageIcon i = new ImageIcon("src/blue-car.png");
		bluecarsec = i.getImage();
	}
	
	public void drawBlueCar(Graphics g) {
		//draw blue_car
		g.drawImage(bluecarsec,x,y,this);
	}

}

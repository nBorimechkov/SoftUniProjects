import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class BlueCar extends JFrame implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int x,xDirection,y ,yDirection;
	Image bluecar;
	int [] arr= {125,225,325};
	
	public void move(){
		int idx = new Random().nextInt(arr.length);
		if(y>600){
			y =0;
			x =arr[idx];
		} else if(y==0){
			x = arr[idx];}
		y +=1+yDirection;
	}
	
	public void setXDir(int xadir){
		xDirection = xadir;
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
	
	public BlueCar(){
		//create blue_car
		ImageIcon i = new ImageIcon("src/blue-car.png");
		bluecar = i.getImage();
	}
	
	public void drawBlueCar(Graphics g) {
		//draw blue_car
		g.drawImage(bluecar,x,y,this);
	}


	

}

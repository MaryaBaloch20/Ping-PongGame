import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.*;
public class Player2 extends JFrame {
	public int width=1000;   // width of frame
	public int height=500;   // height of frame
	Player2()
	{
		initialize();
	}
	public static void main(String[] args) {
	
		Player2 ten=new Player2();
			 
	}
	public void initialize()
	{
		JFrame obj=new JFrame("Big Bash Pong");
		
		Player2play p =new Player2play();		
		obj.setBounds(400, 100, width, height);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setResizable(true);
		obj.add(p);
		//
		
	}
	
}
 
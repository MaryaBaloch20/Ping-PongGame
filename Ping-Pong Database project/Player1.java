import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class Player1 extends JFrame {
	public int width=1000;   // width of frame
	public int height=500;   // height of frame
	public JFrame obj;
	static boolean score;
	Player1()
	{
		initialize();
	
	}
	

	
	
	
	public static void main(String[] args) {
	
		Player1 ten=new Player1();
			 
	}
	public void initialize()
	{
		 obj=new JFrame("Big Bash Pong");
		
		Player1play p =new Player1play();		
		obj.setBounds(400, 100, width, height);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setResizable(true);
		obj.add(p);
		
		
		
	}
	
	
	
}
 
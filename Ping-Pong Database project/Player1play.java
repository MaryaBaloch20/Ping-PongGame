import java.awt.BorderLayout;
import java.awt.Color;   
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.*;


public class Player1play extends JPanel implements KeyListener, ActionListener
{                              // start of class
		

	ImageIcon i=new ImageIcon("E:\\pictures\\logo.jpeg");   //logo for game
    ImageIcon table=new ImageIcon("E:\\pictures\\table.jpeg"); // background for gameplay
    ImageIcon in=new ImageIcon("E:\\pictures\\instruct.jpeg"); // background for instruction
	ImageIcon sc=new ImageIcon("E:\\pictures\\score.jpeg");
	
	public Timer t;
	JLabel Logo = new JLabel("New label");
	

		
	public int width=980;// width of BG filling
	public int height=460;// height of BG filling
	public int ydir=50; // y direction for paddle1
	public int ydir2=50;//  y direction for paddle2
	public int y=120*(int)Math.random();//    y direction for ball
	public int xdir=10; // x direction for paddle1
	public int x=60; // x direction for ball
	public int speed=0; // for increasing speed
	public  int score=0; // score for player 1
	
	public int s=2;    // for score increment
	public int xdir2=956;// x direction for paddle2
	public int xvel=2;  // for the direction of ball in x axis
	public int yvel=2; //  for the direction of ball in y axis
	public boolean player1=false,player2=false,database=false; // for conditions
	FileWriter fw;JFrame frame;
	File read=new File("E:\\pictures\\name.txt");
	String winner="";
	public void winner() throws FileNotFoundException
	{
		Scanner input=new Scanner(read);
		while(input.hasNextLine())
		{
			winner=input.nextLine();
		}
	}
	
	public Player1play()        // constructor
	{

			addKeyListener(this);       
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		t=new Timer(5,this);
		t.start();
		
		try {
			fw=new FileWriter("E:\\pictures\\score.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
int num;
	public void paintComponent(Graphics g)   // method that draw component.
	
	{		
			try {
				winner();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// paint table image at background
			table.paintIcon(this, g, 0, 0);
		//player 1 paddle
		g.setColor(Color.black);
		g.fillRect(xdir, ydir, 20, 90);
		//ball
		g.setColor(new Color(255,255,102));		
		g.fillOval(x,y, 20, 20);
			// auto paddle + player 2 paddle
		g.setColor(Color.black);
		g.fillRect(xdir2, ydir2, 20, 90);
		
		g.setColor(Color.white);
		g.setFont(new Font("Engravers MT",Font.PLAIN,25));
		g.drawString(winner+": "+score, 770, 30);
		
		
		
		
		
		
			if(x<0)  // game over section for player 1
			{
				player1=false;
				database=true;
				sc.paintIcon(this, g, 0, 0);
				g.setColor(Color.white);
				g.setFont(new Font("Engravers MT",Font.PLAIN, 25)); 
				g.drawString("Player :"+ score, 380,310);
	
				
				try {
					fw.write(String.valueOf(score));
					fw.close();
					
					DBS db=new DBS();
					
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
				
				Statement s=c.createStatement();
				//String query="select max(player1_score) from player1";
				ResultSet rs=s.executeQuery("select max(player1_score) from player1 ");
				rs.next();
			num=rs.getInt("max(player1_score)");
			String nums=String.valueOf(num);
				// System.out.println(num);
				g.setColor(Color.orange);
				g.setFont(new Font("Engravers MT",Font.BOLD,30));
				g.drawString( "Highest Score: " +num, 260,350);
			
				
				} catch (ClassNotFoundException  | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t.removeActionListener(this);

			
			}
			
       }
	
	
 		
			
	
	public void getup() // method for upward movement for player 1
	{
		
		ydir-=10;
	
	}
	
	public void getdown()      // method for downward movement for player 1
	{
		
		ydir+=10;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		     // start 
			ydir2=y;
			
			if(ydir2<0)
				{         //start
				ydir2=0;
				}        // end of if
			
			if(ydir2>=370)    //start
				
			{
				ydir2=370;
			}   // end
			
			// detecting collision between paddle and ball
if(new Rectangle(x,y, 20, 20).intersects(new Rectangle(xdir, ydir, 20, 90)) || new Rectangle(x,y,20,20).intersects(new Rectangle(xdir2,ydir2,20,90)))  
{    
	// start
			
	 xvel=-xvel;
					
  }  //end
          // detection for score and speed increment
if(new Rectangle(x,y, 20, 20).intersects(new Rectangle(xdir, ydir, 20, 90)))
{   //start
       speed++;
       score+=s;
       if(speed>=25)
        {      // start
	        	xvel++;
        }    // end
      } // end
				       	
			x+=xvel;   // ball direction x
			y+=yvel;  // ball direction y
			
		if(y<0)      
			{
				yvel=-yvel;
				
			}
		
			if(y==460)
			{
				
				yvel=-yvel;
			}
		
		repaint();
	}  // end of action listener
	
	
	
	public void keyTyped(KeyEvent e) {}
	// Key Events
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_UP)   // to move paddle up
		{
			if(ydir<=0)
			{
				ydir=0;
			}
			else
			{
			getup();
			}
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)  // to move paddle down
		{
			if(ydir>=370)
			{
				ydir=370;
			}
			else
				{
				getdown();
				}
		}
			
		
		
	/*if(e.getKeyCode()==KeyEvent.VK_1)   // to play in single player
			{

			player1=true;
			xdir=10;
			x=50;
			ydir=50;
			y=120;
			xvel=2;
			speed=0;
			score=0;
			yvel=2;
				t.addActionListener(this);
			
			repaint();

			}
	*/
		
	}

		
	//} // end of key events
	public void keyReleased(KeyEvent e) {	}
	

}  // end of class

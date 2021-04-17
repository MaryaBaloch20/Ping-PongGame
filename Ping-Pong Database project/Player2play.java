import java.awt.BorderLayout;
import java.awt.Color;   
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;


public class Player2play extends JPanel implements KeyListener, ActionListener
{                              // start of class
	public Player2play()           // constructor
	{
		
			addKeyListener(this);       
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
			 t=new Timer(5 ,this);
		t.start();  
		try {
			player1fw=new FileWriter("E:\\pictures\\score.txt");
			player2fw=new FileWriter("E:\\pictures\\score2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	ImageIcon i=new ImageIcon("E:\\pictures\\logo.jpeg");   //logo for game
    ImageIcon table=new ImageIcon("E:\\pictures\\table.jpeg"); // background for gameplay
    ImageIcon in=new ImageIcon("E:\\pictures\\instruct.jpeg"); // background for instruction
	ImageIcon sc=new ImageIcon("E:\\pictures\\score.jpeg");
	
	public Timer t;

		
	private int width=980;// width of BG filling
	private int height=460;// height of BG filling
	private int ydir=50; // y direction for paddle1
	private int ydir2=50;//  y direction for paddle2
	private int y=(int)Math.random();//    y direction for ball
	private int xdir=10; // x direction for paddle1
	private int x=60*(int)Math.random(); // x direction for ball
	private int speed=0; // for increasing speed
	private int score=0; // score for player 1
	private int score1=0; // score for player 2
	private int s=2;    // for score increment
	private int xdir2=956;// x direction for paddle2
	private int xvel=2;  // for the direction of ball in x axis
	private int yvel=2; //  for the direction of ball in y axis
	public boolean player1=false,player2=false; // for conditions
	FileWriter player1fw,player2fw;
	File read=new File("E:\\pictures\\name1.txt");
	
	String winner1="",winner2="";
	public void winner1() throws FileNotFoundException
	{
		Scanner input=new Scanner(read);
		while(input.hasNextLine())
		{
			winner2=input.next();
		}
	}
	public void winner2() throws FileNotFoundException
	{
		File read1=new File("E:\\pictures\\name.txt");
		Scanner input=new Scanner(read1);
		while(input.hasNextLine())
		{
			winner1=input.next();
		}
	}
		
		
	public void paintComponent(Graphics g)   // method that draw component.
	
	{		
		
			table.paintIcon(this, g, 0, 0);
		//player 1 paddle
		g.setColor(Color.black);
		g.fillRect(xdir, ydir, 20, 90);
		//paddle for player 2
		g.setColor(Color.black);
		g.fillRect(xdir2, ydir2, 20, 90);
		//ball
		g.setColor(new Color(255,255,108));		
		g.fillOval(x,y, 20, 20);
		
		
		g.setColor(Color.white);
		g.setFont(new Font("Engravers MT",Font.PLAIN,25));
		try
		{
		winner1();
		winner2();
		}catch(FileNotFoundException t)
		{
			t.printStackTrace();
		}
		
	
		g.drawString(winner2+": "+score1, 770, 30);
		g.drawString(winner1+": "+score, 50, 30);
			
         if(x>=980 || x<0)    // game over section for player 2
         {
        	 player2=false;
        	 sc.paintIcon(this, g, 0, 0);	
		 g.setColor(Color.white);
      g.setFont(new Font("Engravers MT",Font.PLAIN, 25));  
          g.drawString(winner1+": " +score, 150,320);
      g.drawString(winner2+": " +score1, 610,320);
      if(score<score1)
      {
    	  try {
			winner1();
		} catch (FileNotFoundException w) {
			// TODO Auto-generated catch block
			w.printStackTrace();
		}
    	  g.setColor(Color.orange);
          g.setFont(new Font("Engravers MT",Font.PLAIN, 25));  
              g.drawString("Winner:" +winner2, 350,400);
              
          
      }
      else
      {
    	  try {
  			winner2();
  		} catch (FileNotFoundException w) {
  			// TODO Auto-generated catch block
  			w.printStackTrace();
  		}
      	  g.setColor(Color.orange);
            g.setFont(new Font("Engravers MT",Font.PLAIN, 25));  
                g.drawString("Winner:" +winner1, 370,400);
          
      }
    	  
    
       
  	try {
		player1fw.write(String.valueOf(score));
		player1fw.close();
		player2fw.write(String.valueOf(score1));

		player2fw.close();
		
		DBS2 db=new DBS2();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
	
	//g.drawString("Press 1:Restart ", 190,350);
  		t.removeActionListener(this);

      
      }  
              }
 		
			
	
	public void getup() // method for upward movement for player 1
	{
		
		ydir-=10;
	
	}
	public void getup1()        //method for upward movement for player 2
	{
		
		ydir2-=10;
	}
	public void getdown()      // method for downward movement for player 1
	{
		
		ydir+=10;
	}
	public void getdown1()     // method for downward movement for player 2
	{
		ydir2+=10;
		
	}
	public void actionPerformed(ActionEvent e) {	
	

	if(new Rectangle(x,y, 20, 20).intersects(new Rectangle(xdir, ydir, 20, 90))  || new Rectangle(x,y,20,20).intersects(new Rectangle(xdir2, ydir2, 20, 90)))
			{
	
		        xvel=-xvel;
		      }
	// detection for score and speed increment for paddle 1
		        if(new Rectangle(x,y, 20, 20).intersects(new Rectangle(xdir, ydir, 20, 90)))
		        {
		        speed++;
		        score+=s;
		        if(speed>=25)
		        {
		        	xvel++;
		        }
		        }
		        
		        // detection for score and speed increment for player 2
		        if(new Rectangle(x,y, 20, 20).intersects(new Rectangle(xdir2, ydir2, 20, 90)))
		        {
			        speed++;
			        score1+=s;
		        	
		        }

		        
		        x+=xvel;
				y+=yvel;
				
			if(y<0)
				{
					yvel=-yvel;
					
				}
			
				if(y==460)
				{
					
					yvel=-yvel;
				}
			
			repaint();
			
	
			
		//}// end of p2 if
	}  // end of action listener
	
	public void keyTyped(KeyEvent e) {}
	// Key Events
	public void keyPressed(KeyEvent e) {
		
			if(e.getKeyCode()==KeyEvent.VK_UP)   // to move paddle upward
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
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN)     // to move paddle down
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
			if(e.getKeyCode()==KeyEvent.VK_A)       // to move paddle 2 up
			{
				if(ydir2<=0)
				{
					ydir2=0;
				}
				else
				{
					getup1();
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_D)    // to move paddle 2 down
			{
				if(ydir2>=370)
				{
					ydir2=370;
				}
				else 
				{
					getdown1();
				}
				
			}
			
		
			
		//} // end of 2 players
		
		
		
		
	}
		
	
	public void keyReleased(KeyEvent e) {	}
	
	
}  // end of class

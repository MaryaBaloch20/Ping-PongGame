import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class playgame  implements ActionListener{

	 public JFrame frame;  
	JLabel Logo = new JLabel("New label");
	JButton playbtn = new JButton("PLAY");
	JButton player1=new JButton("PLAYER 1");
	JButton player2=new JButton("PLAYER 2");
	JLabel input_name,player2_label;
	JTextField name_field=new JTextField();
	JTextField name_field1=new JTextField();
	JButton start=new JButton("START");
	JButton instruction=new JButton("INSTRUCTIONS");
	JButton back=new JButton("BACK");
	boolean play1=false,play2=false;
	  boolean instruct=false;
	  FileWriter player1fw,player2fw;
	  

	  
	  public static void main(String[] args) {
					playgame window = new playgame();
					window.frame.setVisible(true);
					
					try {
						window.player1fw=new FileWriter("E:\\pictures\\name.txt");
						window.player2fw=new FileWriter("E:\\pictures\\name1.txt");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	public void playersframe()
	{
		frame.getContentPane().add(player1);
		player1.setBounds(329, 290, 337	, 53);
		player1.setFont(new Font("Engravers MT",Font.BOLD,30));
		player1.setBackground(new Color(221,127,25));
		player1.setForeground(SystemColor.text);
		player1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		player1.setFocusable(false);
		
		frame.getContentPane().add(player2);
		player2.setBounds(329, 360, 337	, 53);
		player2.setFont(new Font("Engravers MT",Font.BOLD,30));
		player2.setBackground(new Color(221,127,25));
		player2.setForeground(SystemColor.text);
		player2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		player2.setFocusable(false);

		
		Logo.setIcon(new ImageIcon("E:\\pictures\\logo.jpeg"));
		Logo.setBounds(0, 0, 994, 560);
		frame.getContentPane().add(Logo);
		

	}
	public void player1frame()
	{
		input_name=new JLabel("Enter Your Name:");
		frame.getContentPane().add(input_name);
		input_name.setBounds(400, 100, 300, 40);
		input_name.setForeground(Color.white);
		input_name.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.getContentPane().add(name_field);
		
		name_field.setBounds(680, 100, 240, 40);
		name_field.setFont(new Font("Engravers MT",Font.ITALIC,20));
		name_field.requestFocus();
		
		
		frame.getContentPane().add(start);
		start.setBounds(500, 200, 337, 52);
		start.setFont(new Font("Engravers MT",Font.BOLD,30));
		start.setBackground(new Color(221,127,25));
		start.setForeground(SystemColor.text);
		start.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		start.setFocusable(false);

		frame.getContentPane().add(instruction);
		instruction.setBounds(500,280,337,52);
		instruction.setFont(new Font("Engravers MT",Font.BOLD,30));
		instruction.setBackground(new Color(221,127,25));
		instruction.setForeground(SystemColor.text);
		instruction.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		instruction.setFocusable(false);
		
		frame.getContentPane().add(back);
		back.setBounds(500,360,337,52);
		back.setFont(new Font("Engravers MT",Font.BOLD,30));
		back.setBackground(new Color(221,127,25));
		back.setForeground(SystemColor.text);
		back.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		back.setFocusable(false);
		
		Logo.setIcon(new ImageIcon("E:\\pictures\\instruct.jpeg"));
		Logo.setBounds(0, 0, 994, 600);
		frame.getContentPane().add(Logo);
		

	}
	public void player2frame()
	{
		input_name=new JLabel("Player 1: ");
		frame.getContentPane().add(input_name);
		input_name.setBounds(500, 80, 300, 40);
		input_name.setForeground(Color.white);
		input_name.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.getContentPane().add(name_field);
		name_field.setBounds(680, 80, 240, 40);
		name_field.setFont(new Font("Engravers MT",Font.ITALIC,20));
		name_field.requestFocus();
		
		player2_label=new JLabel("PLAYER 2: ");
		frame.getContentPane().add(player2_label);
		player2_label.setBounds(500, 160, 300, 40);
		player2_label.setForeground(Color.white);
		player2_label.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.getContentPane().add(name_field1);
		name_field1.setBounds(680, 160, 240, 40);
		name_field1.setFont(new Font("Engravers MT",Font.ITALIC,20));
		name_field1.requestFocus();
		
		frame.getContentPane().add(start);
		start.setBounds(550, 230, 337, 52);
		start.setFont(new Font("Engravers MT",Font.BOLD,30));
		start.setBackground(new Color(221,127,25));
		start.setForeground(SystemColor.text);
		start.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		start.setFocusable(false);

		frame.getContentPane().add(instruction);
		instruction.setBounds(550,300,337,52);
		instruction.setFont(new Font("Engravers MT",Font.BOLD,30));
		instruction.setBackground(new Color(221,127,25));
		instruction.setForeground(SystemColor.text);
		instruction.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		instruction.setFocusable(false);
		
		frame.getContentPane().add(back);
		back.setBounds(550,370,337,52);
		back.setFont(new Font("Engravers MT",Font.BOLD,30));
		back.setBackground(new Color(221,127,25));
		back.setForeground(SystemColor.text);
		back.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		back.setFocusable(false);

		Logo.setIcon(new ImageIcon("E:\\pictures\\instruct.jpeg"));
		Logo.setBounds(0, 0, 994, 600);
		frame.getContentPane().add(Logo);
	}
	public void player1_instruction()
	{
		JLabel label=new JLabel("UP= UP arrow key");
		JLabel label1=new JLabel("DOWN= DOWN arrow key");
		input_name=new JLabel("Player 1:");
		
		frame.add(input_name);
		input_name.setBounds(500, 100, 150, 20);
		input_name.setForeground(Color.white);
		input_name.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label);
		label.setBounds(500, 130, 320, 20);
		label.setForeground(Color.white);
		label.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label1);
		label1.setBounds(500, 160, 400, 20);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		
		frame.getContentPane().add(back);
		back.setBounds(550, 290, 337, 52);
		back.setFont(new Font("Engravers MT",Font.BOLD,30));
		back.setBackground(new Color(221,127,25));
		back.setForeground(SystemColor.text);
		back.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		back.setFocusable(false);
		
				Logo.setIcon(new ImageIcon("E:\\pictures\\instruct.jpeg"));
				Logo.setBounds(0, 0, 994, 600);
				frame.getContentPane().add(Logo);
	
	}
	public void player2_instruction()
	{
		JLabel label=new JLabel("UP= UP arrow key");
		JLabel label1=new JLabel("DOWN= DOWN arrow key");
		JLabel label2=new JLabel("UP= A");
			JLabel label3=new JLabel("DOWN=D");
		input_name=new JLabel("Player 1:");
				player2_label=new JLabel("Player 2:");
		
		frame.add(input_name);
		input_name.setBounds(500, 100, 150, 20);
		input_name.setForeground(Color.white);
		input_name.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label);
		label.setBounds(500, 130, 320, 20);
		label.setForeground(Color.white);
		label.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label1);
		label1.setBounds(500, 160, 400, 20);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(player2_label);
		player2_label.setBounds(500, 190, 320, 20);
		player2_label.setForeground(Color.white);
		player2_label.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label2);
		label2.setBounds(500, 220, 400, 20);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.add(label3);
		label3.setBounds(500, 250, 400, 20);
		label3.setForeground(Color.white);
		label3.setFont(new Font("Engravers MT",Font.BOLD,20));
		
		frame.getContentPane().add(back);
		back.setBounds(550, 290, 337, 52);
		back.setFont(new Font("Engravers MT",Font.BOLD,30));
		back.setBackground(new Color(221,127,25));
		back.setForeground(SystemColor.text);
		back.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		back.setFocusable(false);

				Logo.setIcon(new ImageIcon("E:\\pictures\\instruct.jpeg"));
				Logo.setBounds(0, 0, 994, 600);
				frame.getContentPane().add(Logo);
						

	}
	
	
	public playgame() {
		
	
		playbtn.addActionListener(this);
		player1.addActionListener(this);
		player2.addActionListener(this);
		instruction.addActionListener(this);
		start.addActionListener(this);
		back.addActionListener(this);
		
		frame = new JFrame("BIG BASH PONG");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\pictures\\ping-pong.png"));
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		

		playbtn.setForeground(SystemColor.text);
		playbtn.setBounds(329, 330, 337, 53);
		playbtn.setFont(new Font("Engravers MT", Font.BOLD, 30));
		playbtn.setBackground(new Color(221,127,25));
		//playbtn.setBackground(Color.black);
		//playbtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED	, new Color(76,73,73),Color.white ));
		//playbtn.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.gray));
		playbtn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedSoftBevelBorder()));
		
		playbtn.setFocusable(false);
		frame.getContentPane().add(playbtn);
		Logo.setIcon(new ImageIcon("E:\\pictures\\logo.jpeg"));
		Logo.setBounds(0, 0, 994, 560);
		frame.getContentPane().add(Logo);
		
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		if(playbtn==e.getSource())
		{

			frame.getContentPane().removeAll();
			
			frame.repaint();
			playersframe();
						
		}
		if(player1==e.getSource())
		{
			
			play1=true;
			frame.getContentPane().removeAll();
			
			frame.repaint();
			player1frame();
			
		}

		if(player2==e.getSource())
		{
			play2=true;
				frame.getContentPane().removeAll();
			
			frame.repaint();
			player2frame();
					}
		
		if(instruction==e.getSource() && play2==true)
		{
				frame.getContentPane().removeAll();

			frame.repaint();
			instruct=true;
			player2_instruction();
			
			
		}
		
		if(instruction==e.getSource() && play1==true)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			instruct=true;
			player1_instruction();
							
		}
			if(start==e.getSource() && play1==true )
		{
			
				String name=name_field.getText();
				
				try {
					player1fw.write(name);
					player1fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
					Player1 pong=new Player1();
				
				
				
				
		}
		
		if(start==e.getSource() && play2==true)
		{
			
			String name1=name_field.getText();
			String name2=name_field1.getText();
			
			try {
				player1fw.write(name1);
				player2fw.write(name2);
				player1fw.close();
				player2fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.setVisible(false);
			Player2 pong=new Player2();
		}
		
		if((back==e.getSource() && play1==true) ||  (back==e.getSource() && play2==true))
		{
			
			frame.getContentPane().removeAll();
			
			frame.repaint();
			playersframe();
			
		}
		if(back==e.getSource() && instruct==true && play1==true)
		{
			frame.getContentPane().removeAll();
			
			frame.repaint();
			player1frame();
			
		}
		if(back==e.getSource() && instruct==true && play2==true)
		{
			frame.getContentPane().removeAll();
			frame.repaint();
			player2frame();
		}
	}
	
	
}


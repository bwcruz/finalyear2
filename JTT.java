/*
	@author Benji Cruz
	My AI works by first checking if it can execute a winning move, and does so if possible.
	It then checks if it needs to block a User Win, and does so if needed.
	If not either it performs a "basic move" which basically means it prioritizes a move towards a possible win, taking into account their win path is not already blocked
	If none of these are possible, it prioritizes 2 and 8, which I believe to be major priority spots, and then 1 - 9 to conduct a legal move that normally is only done in early game
	(Example: First Move)
	Also I am not sure if this error will happen for you, but my bottom randomly moves a copy of it to the top that is not usable. I cannot figure out how to delete it but it does not affect the game.

*/
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
class JTT extends JFrame implements ActionListener
{
	class Closer extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.out.println("Good Game!");
			System.exit(0);
		}
	}
			boolean change1 = false;
			boolean change2 = false;
			boolean change3 = false;
			boolean change4 = false;
			boolean change5 = false;
			boolean change6 = false;
			boolean change7 = false;
			boolean change8 = false;
			boolean change9 = false;
			boolean aichange1 = false;
			boolean aichange2 = false;
			boolean aichange3 = false;
			boolean aichange4 = false;
			boolean aichange5 = false;
			boolean aichange6 = false;
			boolean aichange7 = false;
			boolean aichange8 = false;
			boolean aichange9 = false;
			
	class Circles extends JPanel
	{
		public Circles()
		{
			setSize(1000,600);
		}
		public void draw(Graphics g)
		{
			
			g.setColor(Color.BLUE);
			if(change1)
			{
				g.setColor(Color.GREEN);
				g.fillOval(90,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("1",100,100);
			}
			else if(aichange1)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(90,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("1",100,100);
			}
			else
			{
				g.fillOval(90,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("1",100,100);			
			}
			g.setColor(Color.BLUE);
			if(change2)
			{
				g.setColor(Color.GREEN);
				g.fillOval(290,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("2",300,100);
			}
			else if(aichange2)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(290,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("2",300,100);
			}
			else
			{
				g.fillOval(290,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("2",300,100);
			}
			g.setColor(Color.BLUE);
			if(change3)
			{
				g.setColor(Color.GREEN);
				g.fillOval(490,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("3",500,100);
			}
			else if(aichange3)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(490,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("3",500,100);
			}
			else
			{
				g.fillOval(490,90,30,30);
				g.setColor(Color.WHITE);
				g.drawString("3",500,100);
			}
			g.setColor(Color.BLUE);
			if(change4)
			{
				g.setColor(Color.GREEN);
				g.fillOval(190,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("4",200,300);
			}
			else if(aichange4)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(190,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("4",200,300);
			}
			else
			{	
				g.fillOval(190,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("4",200,300);			
			}
			g.setColor(Color.BLUE);
			if(change5)
			{
				g.setColor(Color.GREEN);
				g.fillOval(290,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("5",300,300);
			}
			else if(aichange5)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(290,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("5",300,300);
			}
			else
			{
				g.fillOval(290,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("5",300,300);
			}
			g.setColor(Color.BLUE);
			if(change6)
			{
				g.setColor(Color.GREEN);
				g.fillOval(390,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("6",400,300);
			}
			else if(aichange6)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(390,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("6",400,300);
			}
			else
			{
				g.fillOval(390,290,30,30);
				g.setColor(Color.WHITE);
				g.drawString("6",400,300);
			}
			g.setColor(Color.BLUE);
			if(change7)
			{
				g.setColor(Color.GREEN);
				g.fillOval(85,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("7",100,500);
			}
			else if(aichange7)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(85,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("7",100,500);
			}
			else
			{
				g.fillOval(85,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("7",100,500);
			}
			g.setColor(Color.BLUE);
			if(change8)
			{
				g.setColor(Color.GREEN);
				
				g.fillOval(285,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("8",300,500);
			}
			else if(aichange8)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(285,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("8",300,500);
			}
			else
			{
				g.fillOval(285,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("8",300,500);
			}
			g.setColor(Color.BLUE);
			if(change9)
			{
				g.setColor(Color.GREEN);
				g.fillOval(485,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("9",500,500);
			}
			else if(aichange9)
			{
				g.setColor(Color.ORANGE);
				g.fillOval(485,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("9",500,500);
			}
			else
			{
				g.fillOval(485,485,30,30);
				g.setColor(Color.WHITE);
				g.drawString("9",500,500);
			}
			
			
			
			
			
			
			
			
		}
		
	}
	class Board extends JPanel
	{
		Circles c = new Circles();
		public Board()
		{
			setSize(1000,600);
				
		}
		public void paintComponent(Graphics g)
		{
			//lines
			g.drawLine(100,100,500,100);
			g.drawLine(300,100,100,500);
			g.drawLine(300,100,500,500);
			g.drawLine(500,100,100,500);
			g.drawLine(100,500,500,500);
			g.drawLine(100,100,300,500);
			g.drawLine(500,100,300,500);
			g.drawLine(100,100,500,500);
			g.drawLine(200,300,400,300);
			c.draw(g);
		}
		
	}
	
		JTextField input;
		Board b;
		Circles c;
		JButton enter;
		int count = 0;
	public void actionPerformed(ActionEvent e)
	{
		count++;
		if(e.getSource()==enter)
		{
		  String x=input.getText();
		  int i=Integer.parseInt(x);
		  if(i == 1)
		  {
			  change1=true;
		  }
		  else if(i == 2)
		  {
			  change2=true;
		  }
		  else if(i == 3)
		  {
			  change3=true;
		  }
		  else if(i == 4)
		  {
			  change4=true;
		  }
		  else if(i == 5)
		  {
			  change5=true;
		  }
		  else if(i == 6)
		  {
			  change6=true;
		  }
		  else if(i == 7)
		  {
			  change7=true;
		  }
		  else if(i == 8)
		  {
			  change8=true;
		  }
		  else if(i == 9)
		  {
			  change9=true;
		  }
		  else
		  {
			System.out.println("Sorry that move is invalid!"); 
		  }
		  makeMove();
		  b.repaint();
		}
		// forces a redraw of the picasso art object
	}
	public JTT()
	{


    setTitle("JERRY TAC TOE!");
    setSize(1100,700);
    addWindowListener(new Closer());
	
	
    input=new JTextField("Enter your move here!");
    b=new Board();
	c = new Circles();
	enter = new JButton("Enter");
    enter.addActionListener(this);
   
    

    // put stuff in the window
    Container glass=getContentPane();
    glass.setLayout( new BorderLayout() ); // layout manager

    JPanel bottom=new JPanel();
    bottom.setLayout(new BorderLayout());
	bottom.add(input,"Center");
	bottom.add(enter,"East");
	
    glass.add(b,"Center");
    glass.add(bottom,"South");

    setVisible(true);
  }
	public void makeMove()
	{
		boolean Aiwins = false;
		boolean userWins = false;
		//check all ways we might win
		if(aichange1 && aichange2 && !change3)
		{
			Aiwins = true;
		}
		else if(aichange1 && aichange3 && !change2)
		{
			Aiwins = true;
		}
		else if(aichange2 && aichange3 && !change1)
		{
			Aiwins = true;
		}
		else if(aichange1 && aichange5 && !change9)
		{
			Aiwins = true;
		}
		else if(aichange1 & aichange9 && !change5)
		{
			Aiwins = true;
		}
		else if(aichange5 && aichange9 && !change1)
		{
			Aiwins = true;
		}
		else if(aichange1 && aichange4 && !change8)
		{
			Aiwins = true;
		}
		else if(aichange1 && aichange8 && !change4)
		{
			Aiwins = true;
		}
		else if(aichange4 && aichange8 && !change1)
		{
			Aiwins = true;
		}
		else if(aichange2 && aichange7 && !change4)
		{
			Aiwins = true;
		}
		else if(aichange2 && aichange4 && !change7)
		{
			Aiwins = true;
		}
		else if(aichange4 && aichange7 && !change2)
		{
			Aiwins = true;
		}
		else if(aichange2 && aichange6 && !change9)
		{
			Aiwins = true;
		}
		else if(aichange2 && aichange9 && !change6)
		{
			Aiwins = true;
		}
		else if(aichange6 && aichange9 && !change2)
		{
			Aiwins = true;
		}
		else if(aichange3 && aichange5 && !change7)
		{
			Aiwins = true;
		}
		else if(aichange3 && aichange7 && !change5)
		{
			Aiwins = true;
		}
		else if(aichange5 && aichange7 && !change3)
		{
			Aiwins = true;
		}
		else if(aichange3 && aichange6 && !change8)
		{
			Aiwins = true;
		}
		else if(aichange3 && aichange8 && !change6)
		{
			Aiwins = true;
		}
		else if(aichange6 && aichange8 && !change3)
		{
			Aiwins = true;
		}
		else if(aichange4 && aichange5 && !change6)
		{
			Aiwins = true;
		}
		else if(aichange4 && aichange6 && !change5)
		{
			Aiwins = true;
		}
		else if(aichange5 && aichange6 && !change4)
		{
			Aiwins = true;
		}
		else if(aichange8 && aichange7 && !change9)
		{
			Aiwins = true;
		}
		else if(aichange9 && aichange7 && !change8)
		{
			Aiwins = true;
		}
		else if(aichange8 && aichange9 && !change7)
		{
			Aiwins = true;
		}
		//check if user is about to win
		
		if(change1 && change2 && !aichange3)
		{
			userWins = true;
		}
		else if(change1 && change3 && !aichange2)
		{
			userWins = true;
		}
		else if(change2 && change3 && !aichange1)
		{
			userWins = true;
		}
		else if(change1 && change5 && !aichange9)
		{
			userWins = true;
		}
		else if(change1 & change9 && !aichange5)
		{
			userWins = true;
		}
		else if(change5 && change9 && !aichange1)
		{
			userWins = true;
		}
		else if(change1 && change4 && !aichange8)
		{
			userWins = true;
		}
		else if(change1 && change8 && !aichange4)
		{
			userWins = true;
		}
		else if(change4 && change8 && !aichange1)
		{
			userWins = true;
		}
		else if(change2 && change7 && !aichange4)
		{
			userWins = true;
		}
		else if(change2 && change4 && !aichange7)
		{
			userWins = true;
		}
		else if(change4 && change7 && !aichange2)
		{
			userWins = true;
		}
		else if(change2 && change6 && !aichange9)
		{
			userWins = true;
		}
		else if(change2 && change9 && !aichange6)
		{
			userWins = true;
		}
		else if(change6 && change9 && !aichange2)
		{
			userWins = true;
		}
		else if(change3 && change5 && !aichange7)
		{
			userWins = true;
		}
		else if(change3 && change7 && !aichange5)
		{
			userWins = true;
		}
		else if(change5 && change7 && !aichange3)
		{
			userWins = true;
		}
		else if(change3 && change6 && !aichange8)
		{
			userWins = true;
		}
		else if(change3 && change8 && !aichange6)
		{
			userWins = true;
		}
		else if(change6 && change8 && !aichange3)
		{
			userWins = true;
		}
		else if(change4 && change5 && !aichange6)
		{
			userWins = true;
		}
		else if(change4 && change6 && !aichange5)
		{
			userWins = true;
		}
		else if(change5 && change6 && !aichange4)
		{
			userWins = true;
		}
		else if(change8 && change7 && !aichange9)
		{
			userWins = true;
		}
		else if(change9 && change7 && !aichange8)
		{
			userWins = true;
		}
		else if(change8 && change9 && !aichange7)
		{
			userWins = true;
		}
		
		
		
		if(Aiwins)
		{
			execwinCondition();
		}
		else if(userWins)
		{
			blockUser();
		}
		else
		{
			basicMove();
		}
		b.repaint();
		count++;
		if(count >= 4)
		{
			checkWin();
			checkDraw();
		}
	}
	public void execwinCondition()
	{
		if(aichange1 && aichange2 && !change3)
		{
			aichange3 = true;
		}
		else if(aichange1 && aichange3 && !change2)
		{
			aichange2 = true;
		}
		else if(aichange2 && aichange3 && !change1)
		{
			aichange1 = true;
		}
		else if(aichange1 && aichange5 && !change9)
		{
			aichange9 = true;
		}
		else if(aichange1 & aichange9 && !change5)
		{
			aichange5 = true;
		}
		else if(aichange5 && aichange9 && !change1)
		{
			aichange1 = true;
		}
		else if(aichange1 && aichange4 && !change8)
		{
			aichange8 = true;
		}
		else if(aichange1 && aichange8 && !change4)
		{
			aichange4 = true;
		}
		else if(aichange4 && aichange8 && !change1)
		{
			aichange1 = true;
		}
		else if(aichange2 && aichange7 && !change4)
		{
			aichange4 = true;
		}
		else if(aichange2 && aichange4 && !change7)
		{
			aichange7 = true;
		}
		else if(aichange4 && aichange7 && !change2)
		{
			aichange2 = true;
		}
		else if(aichange2 && aichange6 && !change9)
		{
			aichange9 = true;
		}
		else if(aichange2 && aichange9 && !change6)
		{
			aichange6 = true;
		}
		else if(aichange6 && aichange9 && !change2)
		{
			aichange2 = true;
		}
		else if(aichange3 && aichange5 && !change7)
		{
			aichange7 = true;
		}
		else if(aichange3 && aichange7 && !change5)
		{
			aichange5 = true;
		}
		else if(aichange5 && aichange7 && !change3)
		{
			aichange3 = true;
		}
		else if(aichange3 && aichange6 && !change8)
		{
			aichange8 = true;
		}
		else if(aichange3 && aichange8 && !change6)
		{
			aichange6 = true;
		}
		else if(aichange6 && aichange8 && !change3)
		{
			aichange3 = true;
		}
		else if(aichange4 && aichange5 && !change6)
		{
			aichange6 = true;
		}
		else if(aichange4 && aichange6 && !change5)
		{
			aichange5 = true;
		}
		else if(aichange5 && aichange6 && !change4)
		{
			aichange4 = true;
		}
		else if(aichange8 && aichange7 && !change9)
		{
			aichange9 = true;
		}
		else if(aichange9 && aichange7 && !change8)
		{
			aichange8 = true;
		}
		else if(aichange8 && aichange9 && !change7)
		{
			aichange7 = true;
		}
		
	}
	public void blockUser()
	{
		if(change1 && change2 && !aichange3)
		{
			aichange3 = true;
		}
		else if(change1 && change3 && !aichange2)
		{
			aichange2 = true;
		}
		else if(change2 && change3 && !aichange1)
		{
			aichange1 = true;
		}
		else if(change1 && change5 && !aichange9)
		{
			aichange9 = true;
		}
		else if(change1 & change9 && !aichange5)
		{
			aichange5 = true;
		}
		else if(change5 && change9 && !aichange1)
		{
			aichange1 = true;
		}
		else if(change1 && change4 && !aichange8)
		{
			aichange8 = true;
		}
		else if(change1 && change8 && !aichange4)
		{
			aichange4 = true;
		}
		else if(change4 && change8 && !aichange1)
		{
			aichange1 = true;
		}
		else if(change2 && change7 && !aichange4)
		{
			aichange4 = true;
		}
		else if(change2 && change4 && !aichange7)
		{
			aichange7 = true;
		}
		else if(change4 && change7 && !aichange2)
		{
			aichange2 = true;
		}
		else if(change2 && change6 && !aichange9)
		{
			aichange9 = true;
		}
		else if(change2 && change9 && !aichange6)
		{
			aichange6 = true;
		}
		else if(change6 && change9 && !aichange2)
		{
			aichange2 = true;
		}
		else if(change3 && change5 && !aichange7)
		{
			aichange7 = true;
		}
		else if(change3 && change7 && !aichange5)
		{
			aichange5 = true;
		}
		else if(change5 && change7 && !aichange3)
		{
			aichange3 = true;
		}
		else if(change3 && change6 && !aichange8)
		{
			aichange8 = true;
		}
		else if(change3 && change8 && !aichange6)
		{
			aichange6 = true;
		}
		else if(change6 && change8 && !aichange3)
		{
			aichange3 = true;
		}
		else if(change4 && change5 && !aichange6)
		{
			aichange6 = true;
		}
		else if(change4 && change6 && !aichange5)
		{
			aichange5 = true;
		}
		else if(change5 && change6 && !aichange4)
		{
			aichange4 = true;
		}
		else if(change8 && change7 && !aichange9)
		{
			aichange9 = true;
		}
		else if(change9 && change7 && !aichange8)
		{
			aichange8 = true;
		}
		else if(change8 && change9 && !aichange7)
		{
			aichange7 = true;
		}
	}
	public void basicMove()
	{
		if(aichange1 && !change2 && !change3)
		{
			aichange2 = true;
		}
		else if(aichange1 && !change5 && !change9)
		{
			aichange5 = true;
		}
		else if(aichange1 && !change4 && !change8)
		{
			aichange4 = true;
		}
		else if(aichange2 && !change2 &&!change3)
		{
			aichange1 = true;
		}
		else if(aichange2 && !change4 && !change7)
		{
			aichange4 = true;
		}
		else if(aichange2 && !change6 &&!change9)
		{
			aichange9 =true;
		}
		else if(aichange3 && !change1 && !change2)
		{
			aichange2 = true;
		}
		else if(aichange3 && !change5 && !change7)
		{
			aichange5 = true;
		}
		else if(aichange3 && !change6 && !change8)
		{
			aichange6 = true;
		}
		else if(aichange4 && !change1 && !change8)
		{
			aichange8 =true;
		}
		else if(aichange4 && !change2 && !change7)
		{
			aichange2 =true;
		}
		else if(aichange4 && !change5 && !change6)
		{
			aichange5 = true;
		}
		else if(aichange5 && !change1 && !change9)
		{
			aichange1 = true;
		}
		else if(aichange5 && !change3 && !change7)
		{
			aichange3 = true;
		}
		else if(aichange5 && !change6 && !change4)
		{
			aichange4 = true;
		}
		else if(aichange6 && !change2 && !change9)
		{
			aichange2 = true;
		}
		else if(aichange6 && !change3 && !change8)
		{
			aichange8 =true;
		}
		else if(aichange6 && !change4 && !change5)
		{
			aichange5 = true;
		}
		else if(aichange7 && !change2 && !change4)
		{
			aichange2 = true;
		}
		else if(aichange7 && !change3 && !change5)
		{
			aichange5 =true;
		}
		else if(aichange7 && !change8 && !change9)
		{
			aichange8 =true;
		}
		else if(aichange8 && !change1 && !change4)
		{
			aichange4 =true;
		}
		else if(aichange8 && !change3 && !change6)
		{
			aichange6 =true;
		}
		else if(aichange8 && !change7 && !change9)
		{
			aichange7 =true;
		}
		else if(aichange9 && !change1 && !change5)
		{
			aichange5 = true;
		}
		else if(aichange9 && !change2 && !change6)
		{
			aichange2 = true;
		}
		else if(aichange9 && !change7 && !change8)
		{
			aichange8 = true;
		}
		else if (!aichange2 && !change2)
		{
			aichange2 =true;
		}
		else if(!aichange8 && change8)
		{
			aichange8 = true;
		}
		else if (!aichange1 && !change1)
		{
			aichange1 = true;
		}
		else if (!aichange3 && !change3)
		{
			aichange2 = true;
		}
		else if (!aichange4 && !change4)
		{
			aichange4 = true;
		}
		else if (!aichange5 && !change5)
		{
			aichange5 = true;
		}
		else if (!aichange6 && !change6)
		{
			aichange6 = true;
		}
		else if (!aichange7 && !change7)
		{
			aichange7 = true;
		}
		else if (!aichange9 && !change9)
		{
			aichange9 =true;
		}
		else
		{
			checkDraw();
			System.out.println("I can't seem to figure out a move...");
		}
		
	}
	public void playFirst()
	{
		while(count % 2 ==1)
		{
			makeMove();
		}
	}
	public void playSecond()
	{
		while(count % 2 == 0)
		{
			makeMove();
		}
	}
	public void startGame()
	{
		System.out.println("Would you like to play first or second? [F] or [S]");
		Scanner s = new Scanner(System.in);
		char fors = s.next().charAt(0);
		if(fors == 'F')
		{
			System.out.println("OK! You'll play first!");
			playFirst();
		}
		else if(fors == 'S')
		{
			System.out.println("OK! You'll play second!");
			playSecond();
		}
		else 
		{
			System.out.println("Your code is broken!");
			playFirst();
		}
		
	}
	public void playGame()
	{
		startGame();
	}
	char playAgain;
	public void checkWin()
	{
		boolean userWon = false;
		boolean aiWon = false;
		//check if User Won
		if(change1 && change2 && change3)
		{
			userWon = true;
		}
		else if(change1 && change5 && change9)
		{
			userWon = true;
		}
		else if(change1 && change4 && change8)
		{
			userWon = true;
		}
		else if(change2 && change7 && change4)
		{
			userWon = true;
		}
		else if(change2 && change6 && change9)
		{
			userWon = true;
		}
		else if(change3 && change5 && change7)
		{
			userWon = true;
		}
		else if(change3 && change6 && change8)
		{
			userWon = true;
		}
		else if(change4 && change5 && change6)
		{
			userWon = true;
		}
		else if(change8 && change7 && change9)
		{
			userWon = true;
		}
		// check if AI Won
		
		if(aichange1 && aichange2 && aichange3)
		{
			aiWon = true;
		}
		else if(aichange1 && aichange5 && aichange9)
		{
			aiWon = true;
		}
		else if(aichange1 && aichange4 && aichange8)
		{
			aiWon = true;
		}
		else if(aichange2 && aichange7 && aichange4)
		{
			aiWon = true;
		}
		else if(aichange2 && aichange6 && aichange9)
		{
			aiWon = true;
		}
		else if(aichange3 && aichange5 && aichange7)
		{
			aiWon = true;
		}
		else if(aichange3 && aichange6 && aichange8)
		{
			aiWon = true;
		}
		else if(aichange4 && aichange5 && aichange6)
		{
			aiWon = true;
		}
		else if(aichange8 && aichange7 && aichange9)
		{
			aiWon = true;
		}
		
		if(userWon)
		{
			System.out.println("Wow! YOU WIN!");
			System.out.println("Would you like to play again? (Y) or (N)");
			Scanner s = new Scanner(System.in);
			playAgain = s.next().charAt(0);
			if (playAgain == 'Y'|| playAgain== 'y')
			{
				resetBoard();
				b.repaint();
				startGame();
			}
			else
			{
				System.exit(0);
			}
		}
		else if(aiWon)
		{
			System.out.println("Bummer! You Lose!");
			System.out.println("Would you like to play again? (Y) or (N)");
			Scanner s = new Scanner(System.in);
			playAgain = s.next().charAt(0);
			if (playAgain == 'Y'|| playAgain== 'y')
			{
				resetBoard();
				b.repaint();
				startGame();
			}
			else
			{
				System.exit(0);
			}
		}
	}
	public void checkDraw()
	{
		
		boolean weDraw =false;
		if(count == 9)
		{
			weDraw = true;
		}
		if(weDraw)
		{
			System.out.println("Oops, we drew...");
			System.out.println("Would you like to play again? (Y) or (N)");
			Scanner s = new Scanner(System.in);
			playAgain = s.next().charAt(0);
			if(playAgain == 'Y'|| playAgain== 'y')
			{
				resetBoard();
				b.repaint();
				startGame();
			}
			else
			{
				System.exit(0);
			}
		}
	}
	public void resetBoard()
	{
		change1 = false;
		change2 = false;
		change3 = false;
		change4 = false;
		change5 = false;
		change6 = false;
		change7 = false;
		change8 = false;
		change9 = false;
		aichange1 = false;
		aichange2 = false;
		aichange3 = false;
		aichange4 = false;
		aichange5 = false;
		aichange6 = false;
		aichange7 = false;
		aichange8 = false;
		aichange9 = false;
		count = 0;
		b.repaint();
	}
	public static void main(String [] args) throws IOException
  {
    JTT board=new JTT();
	System.out.println("Welcome to Jerry Tac Toe!");
	System.out.println("You will be using the green and the bot will use orange!");
	board.playGame();
	
  }
}
package mypack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		//b3=new JButton("Next");
		b2=new JButton("Marked for Review");
		b1.addActionListener(this);
		//b3.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		//b3.setBounds(300,240,100,30);
		b2.setBounds(270,240,200,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(750,150);
		setVisible(true);
		setSize(600,450);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Marked for Review"))
		{
			JButton bk=new JButton("Marked for Review"+x);
			bk.setBounds(380,20+30*x,200,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Marked for Review"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Who is Father of Nation?");
			jb[0].setText("Pandit Nehru");jb[1].setText("MK Gandhi");jb[2].setText("Bhagat Singh");jb[3].setText("Charles Babbage");	
		}
		if(current==1)
		{
			l.setText("Que2: Who is known as the Iron Man of India?");
			jb[0].setText("Jawaharlal Nehru");jb[1].setText("Vallabhbhai Patel");jb[2].setText("Subhas Chandra Bose");jb[3].setText("Bhagat Singh");
		}
		if(current==2)
		{
			l.setText("Que3: Which is the longest river on the earth?");
			jb[0].setText("Huang Ho");jb[1].setText("Brahmaputra");jb[2].setText("Amazon");jb[3].setText("Nile");
		}
		if(current==3)
		{
			l.setText("Que4: Which is the largest coffee-producing state of India?");
			jb[0].setText("Karnataka");jb[1].setText("Kerala");jb[2].setText("Tamil Nadu");jb[3].setText("Arunachal Pradesh");
		}
		if(current==4)
		{
			l.setText("Que5: Who was the first scientist to discover Electrons?");
			jb[0].setText("Albert Einstein");jb[1].setText("James Chadwick");jb[2].setText("J.J. Thomson");jb[3].setText("Ernest Rutherford");
		}
		if(current==5)
		{
			l.setText("Que6: The super computer ‘PARAM’ was developed by?");
			jb[0].setText("TATA");jb[1].setText("IIT-Kharagpur");jb[2].setText("C-DAC");jb[3].setText("IIT-Kanpur");
		}
		if(current==6)
		{
			l.setText("Que7: Which of the following is not an Output device? ");
			jb[0].setText("Moniter");jb[1].setText("Scanner");jb[2].setText("Printer");jb[3].setText("Speakers");
		}
		if(current==7)
		{
			l.setText("Que8: Which Indian state has the least literacy rate?");
			jb[0].setText("Rajasthan");jb[1].setText("Arunachal Pradesh");jb[2].setText("Kerala");jb[3].setText("Bihar");		
		}
		if(current==8)
		{
			l.setText("Que9: Which element is used to get highlighted text in HTML5?");
			jb[0].setText("<highlight>");jb[1].setText("<mark>");jb[2].setText("<u>");jb[3].setText(" <pre>");
		}
		if(current==9)
		{
			l.setText("Que10: Which HTML tag is used to declare internal CSS?");
			jb[0].setText("<script>");jb[1].setText("<link>");jb[2].setText("<style>");jb[3].setText("None of the above");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[2].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Exam");
	}


}


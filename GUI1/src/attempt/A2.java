package attempt;

import javax.swing.*;

import java.awt.*;
public class A2 extends JFrame
{

	MyPanel3 mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A2 a2=new A2();
	}

	public A2()
	{
		mp=new MyPanel3();
		
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

class MyPanel3 extends JPanel
{
	Tortoise tortoise=null;
	
	public MyPanel3()
	{
		tortoise=new Tortoise(10,10);
	}
	
	//重新Paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//目的是使面板变成黑色的
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(getX(), getY(), g, 0, 1);
		this.drawTank(getX()+10, getY()+10, g, 0, 0);
	}
	//画出乌龟的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		switch(direct)
		{
		case 0:
			g.fillOval(x, y, 20, 40);
		}
	}
}

class Tortoise
{
	int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	int y;
	public Tortoise(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}


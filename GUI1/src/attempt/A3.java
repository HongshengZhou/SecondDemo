package attempt;
/*
 * 功能：坦克游戏的1.0版
 * 1.画出坦克.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class A3 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		A3 a3=new A3();
	}
	//构造函数
	public A3()
	{
		mp=new MyPanel();
		
		this.addKeyListener(mp);
		
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener 
{
	//定义一个我的坦克
	Hero hero=null;
	
	//构造函数
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//目的是使面板变成黑色的
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g,0, 1);
	}
	//画出坦克的函数
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
			//画出我的坦克（到时再封装成一个函数）
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5.画出直线
			g.drawLine(x+10, y+15,x+10, y);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int x=hero.getX();
		int y=hero.getY();
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//加速
			y+=10;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_UP)
		{
			y--;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x--;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x++;
		}
		//调用repaint()函数，来重绘界面
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
//坦克类
class Tank
{
	//表示坦克的横坐标，改变时则坦克可移动
	int x=0;
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
	//表示坦克的纵坐标
	int y=0;
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
//我的坦克
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
}
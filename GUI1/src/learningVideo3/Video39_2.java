package learningVideo3;
/*
 * 功能：坦克游戏的3.0版
 * 1.画出坦克.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
public class Video39_2 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video39_2 video34_1=new Video39_2();
	}
	//构造函数
	public Video39_2()
	{
		mp=new MyPanel();
		
		//启动线程
		Thread t=new Thread(mp);
		t.start();
		
		this.addKeyListener(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero=null;
	
	//定义敌人的坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	int enSize=3;

	//构造函数
	public MyPanel()
	{
		hero=new Hero(50,200);
		
		//初始化敌人的坦克
		for(int i=0;i<enSize;i++)
		{
			//创建一辆敌人的坦克对象
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setColor(2);
			//加入
			ets.add(et);
		}
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//目的是使面板变成黑色的
		g.fillRect(0, 0, 400, 300);
		
		//画出自己的坦克
		this.drawTank(hero.getX(), hero.getY(), g,this.hero.direct, 1);
		
		//画出子弹,加hero.s.isLive==true这句话是为了
		//不会浪费绘图的资源
		if(hero.s!=null&&hero.s.isLive==true)
		{
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		
		//画出敌人的坦克（不用具体的值的原因是敌人
		//的坦克数量总是在变化,所以用ets.size()）
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(),0);
		}
	}
	//画出坦克的函数（扩展）
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
			//炮筒向上
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
			break;
		case 1:
			//炮筒向右
			//1.画出左边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2.画出右边的矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//5.画出直线
			g.drawLine(x+15, y+10,x+30, y+10);
		    break;
		case 2:
			//炮筒向下
			//1.画出左边的矩形
			g.fill3DRect(x, y, 5, 30,false);
			//2.画出右边的矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.画出圆形
			g.fillOval(x+5, y+10, 10, 10);
			//5.画出直线
			g.drawLine(x+10, y+15,x+10, y+30);
			break;
		case 3:
			//炮筒向左
			//1.画出左边的矩形
			g.fill3DRect(x, y, 30, 5,false);
			//2.画出右边的矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.画出中间的矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.画出圆形
			g.fillOval(x+10, y+5, 10, 10);
			//5.画出直线
			g.drawLine(x+15, y+10,x, y+10);
		    break;
		}
		
	}

	@Override
	//键按下处理  a表示向左 ,s表示向下,d表示向右,w表示向上
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_W)
		{
			//设置我的坦克的方向
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_D)
		{
			//向右
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_S)
		{
			//向下
			this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_A)
		{
			//向左
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			//判断玩家是否按下j
			
			//开火
			this.hero.shotEnemy();
		}
		//必须重新绘制Panel
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//每隔100毫秒去重绘
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//重绘
			this.repaint();
		}
	}
}

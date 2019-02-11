package learningVideo5;
/*
 * 功能：坦克游戏的4.0版
 * 1.画出坦克.
 * 2.我的坦克可以上下左右移动
 * 3.可以发射子弹，子弹连发（最多5颗）
 * 4.当我的坦克击中敌人的坦克时，敌人就消失（爆炸效果）
 * 5.让敌人坦克也可以自由随机地上下左右移动（在规定范围内，并且可以发射子弹）
 *    当敌人的坦克击中我的坦克时，我的坦克爆炸
 * 6.防止敌人的坦克重叠运动
 *    6.1决定把判断是否碰撞的函数写到EnemyTank类
 * 7.可以分关
 *    7.1做一个开始的Panel,它是一个空的
 *    7.2闪烁效果
 * 8.可以在玩游戏的时候暂停和继续
 *    8.1当用户点击暂停时，子弹的速度和坦克的速度设为0，
 *       并让坦克的方向不再变化
 * 9.可以记录玩家的成绩
 *    9.1用文件流
 *    9.2单写一个记录类，完成对玩家记录
 *    9.3先完成保存共击毁了多少辆敌人坦克的功能
 *    9.4存盘退出游戏，可以记录当时的敌人坦克坐标，并可恢复
 * 10.java如何操作声音文件
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Video47_1 extends JFrame implements ActionListener
{
	MyPanel mp=null;
	
	//定义一个开始面板
	MyStartPanel msp=null;
	
	//作出我需要的菜单
	JMenuBar jmb=null;
	//开始游戏
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//退出系统
	JMenuItem jmi2=null;
	//存盘退出
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video47_1 video34_1=new Video47_1();
	}
	//构造函数
	public Video47_1()
	{
//		mp=new MyPanel();
//		
//		//启动线程
//		Thread t=new Thread(mp);
//		t.start();
//		this.add(mp);
//		//注册监听
//		this.addKeyListener(mp);
		
		//创建菜单及菜单选项
		jmb=new JMenuBar();
		jm1=new JMenu("游戏(G)");
		//设置快捷方式
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("开始新游戏(N)");
		jmi1.setMnemonic('N');
		jmi2=new JMenuItem("退出游戏(E)");
		jmi2.setMnemonic('E');
		jmi3=new JMenuItem("存盘退出游戏(C)");
		jmi4=new JMenuItem("继续上局游戏(S)");
		
		jmi4.addActionListener(this);
		jmi4.setActionCommand("conGame");
		//注册监听
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jmi2.setMnemonic('E');
		
		//对jmi1响应
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jmb.add(jm1);
		
		msp=new MyStartPanel();
		Thread t=new Thread(msp);
		t.start();
		
		this.setJMenuBar(jmb);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(msp);
		this.setSize(600, 500);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//对用户不同的点击作出不同的处理
		if(arg0.getActionCommand().equals("newgame"))
		{
			//创建战场面板
			mp=new MyPanel("newgame");
			
			//启动线程
			Thread t=new Thread(mp);
			t.start();
			//先删除旧的开始面板
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示，刷新JFrame
			this.setVisible(true);
		}
		else if(arg0.getActionCommand().equals("exit"))
		{
			//用户点击了退出系统的菜单
			//保存击毁敌人数量
			Recorder.keepRecording();
			
			System.exit(0);
		}
		//对存盘退出做处理
		else if(arg0.getActionCommand().equals("saveExit"))
		{
			//工作
			Recorder.setEts(mp.ets);
			//保存击毁敌人的数量和敌人的坐标
			Recorder.keepRecAndEnemyTank();
			
			//退出
			System.exit(0);
		}
		else if(arg0.getActionCommand().equals("conGame"))
		{
			//创建战场面板
			mp=new MyPanel("con");
			//mp.flag="con";
			
			//启动线程
			Thread t=new Thread(mp);
			t.start();
			//先删除旧的开始面板
			this.remove(msp);
			this.add(mp);
			//注册监听
			this.addKeyListener(mp);
			//显示，刷新JFrame
			this.setVisible(true);
		}
	}
}

//就是一个提示作用
class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//提示信息
		
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			//开关信息的字体
			Font myFont=new Font("华文新魏",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("stage: 1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//休眠
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			//重画
			this.repaint();
		}
	}
}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//定义一个我的坦克
	Hero hero=null;
	
	//判断是续上局，还是新游戏
	String flag="newGame";
	
	//定义敌人的坦克组
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	Vector<Node> nodes=new Vector<Node>();
	
	//定义炸弹集合
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	int enSize=5;
	
	//定义三张图片,三张图片才能组成一颗炸弹
	Image image1=null;
	Image image2=null;
	Image image3=null;

	//构造函数
	public MyPanel(String flag)
	{
		//恢复记录
		Recorder.getRecording();
		
		hero=new Hero(50,200);
		
		if(flag.equals("newGame"))
		{
			//初始化敌人的坦克
			for(int i=0;i<enSize;i++)
			{
				//创建一辆敌人的坦克对象
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setColor(0);
				et.setColor(2);
				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);
				
				//启动敌人的坦克
				Thread t=new Thread(et);
				t.start();
				//给敌人坦克添加一颗子弹
				Shot s=new Shot(et.x+10,et.y+30,2);
				//加入给敌人坦克
				et.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				
				
				//加入
				ets.add(et);
			}
		}
		else
		{
			nodes=new Recorder().getNodesAndEnNums();
			//初始化敌人的坦克
			for(int i=0;i<nodes.size();i++)
			{
				Node node=nodes.get(i);
				//创建一辆敌人的坦克对象
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setColor(0);
				et.setColor(node.direct);
				//将MyPanel的敌人坦克向量交给该敌人坦克
				et.setEts(ets);
				
				//启动敌人的坦克
				Thread t=new Thread(et);
				t.start();
				//给敌人坦克添加一颗子弹
				Shot s=new Shot(et.x+10,et.y+30,2);
				//加入给敌人坦克
				et.ss.add(s);
				Thread t2=new Thread(s);
				t2.start();
				
				
				//加入
				ets.add(et);
			}
			
		}
		
//		try {
//			image1=ImageIO.read(new File("bomb_1.PNG"));
//			image2=ImageIO.read(new File("bomb_2.PNG"));
//			image3=ImageIO.read(new File("bomb_3.PNG"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//初始化图片
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.PNG"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.PNG"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.PNG"));
		
	}
	
	//画出提示信息
	public void showInfo(Graphics g)
	{
		//画出提示信息坦克（该坦克不参与战斗）
		this.drawTank(80, 330, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"",110 , 350);
		this.drawTank(130, 330, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMyLife()+"",165 , 350);
		
		//画出玩家的总成绩
		g.setColor(Color.black);
		Font f=new Font("宋体",Font.BOLD,20);
		g.setFont(f);
		g.drawString("您的总成绩", 420, 20);
		
		this.drawTank(420, 60, g, 0, 0);
		
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"", 460, 80);
	}
	
	//重新paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//目的是使面板变成黑色的
		g.fillRect(0, 0, 400, 300);
		
		//画出提示信息
		this.showInfo(g);
		
		//画出自己的坦克
		if(hero.isLive)
		{
			this.drawTank(hero.getX(), hero.getY(), g,this.hero.direct, 1);
		}
		
		//从ss 中取出每颗子弹，并画出
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot=hero.ss.get(i);
			//画出子弹,加hero.s.isLive==true这句话是为了
			//不会浪费绘图的资源
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false)
			{
				//从ss 中删除掉该子弹（注意：此处myShot 不能用i）
				hero.ss.remove(myShot);
			}
		}
		
		//画出炸弹
		for(int i=0;i<bombs.size();i++)
		{
			//取出炸弹
			Bomb b=bombs.get(i);
			
			if(b.life>6)
			{
				g.drawImage(image1, b.x, b.y, 30, 30, this);
			}
			else if(b.life>3)
			{
				g.drawImage(image2, b.x, b.y, 30, 30, this);
			}
			else
			{
				g.drawImage(image3, b.x, b.y, 30, 30, this);
			}
			
			//让b 的生命值减小
			b.lifeDown();
			//如果炸弹生命值为0，就把该炸弹从bombs向量去掉
			if(b.life==0)
			{
				bombs.remove(b);
			}
		}
		
		//画出敌人的坦克（不用具体的值的原因是敌人
		//的坦克数量总是在变化,所以用ets.size()）
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(),0);
				//再画出敌人的子弹
				for(int j=0;j<et.ss.size();j++)
				{
					//取出子弹
					Shot enemyShot=et.ss.get(j);
					if(enemyShot.isLive)
					{
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}
					else 
					{
						//如果敌人的坦克死亡就把子弹从Vector去掉
						et.ss.remove(enemyShot);
					}
				}
			}
			
		}
	}
	
	//判断敌人的子弹是否击中我的坦克
	public void hitMe()
	{
		//取出每一个敌人的坦克
		for(int i=0;i<this.ets.size();i++)
		{
			//取出坦克
			EnemyTank et=ets.get(i);
			
			//取出每一颗子弹
			for(int j=0;j<et.ss.size();j++)
			{
				//取出子弹
				Shot enemyShot=et.ss.get(j);
				if(hero.isLive)
				{
					if(this.hitTank(enemyShot, hero))
					{
						
					}
				}
			}
		}
	}
	
	//判断我的子弹是否击中敌人的坦克
	public void hitEnemyTank()
	{
		//判断是否击中敌人坦克
		//自己的注释：遍历，调用hitTank函数实现
		//            判断是否击中敌人的坦克。
		for(int i=0;i<hero.ss.size();i++)
		{
			//取出子弹
			Shot myShot=hero.ss.get(i);
			//判断子弹是否有效
			if(myShot.isLive)
			{
				//取出每个坦克，与它判断
				for(int j=0;j<ets.size();j++)
				{
					//取出坦克
					EnemyTank et=ets.get(j);
					
					if(et.isLive)
					{
						if(this.hitTank(myShot, et))
						{
							//减少敌人数量
							Recorder.reduceEnNum();
							//增加我的记录
							Recorder.addEnNumRec();
						}
					}
				}
			}
		}
	}
	
	//写一个函数专门判断子弹是否击中敌人坦克
	//自己的注释：子弹什么情况下击中敌人坦克，及其反应
	public boolean hitTank(Shot s,Tank et)
	{
		boolean b2=false;
		
		//判断该坦克的方向
		switch(et.direct)
		{
		//如果敌人坦克的方向是上或者下
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				//击中
				//子弹死亡
				s.isLive=false;
				//敌人坦克死亡
				et.isLive=false;
				b2=true;
//				//减少敌人数量
//				Recorder.reduceEnNum();
//				//增加我的记录
//				Recorder.addEnNumRec();
				//创建一颗炸弹，放入Vector
				Bomb b=new Bomb(et.x,et.y);
				//放入Vector
				bombs.add(b);
			}
			break;
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				//击中
				//子弹死亡
				s.isLive=false;
				//敌人坦克死亡
				et.isLive=false;
				b2=true;
//				//减少敌人数量
//				Recorder.reduceEnNum();
//				//增加我的记录
//				Recorder.addEnNumRec();
				//创建一颗炸弹，放入Vector
				Bomb b=new Bomb(et.x,et.y);
				//放入Vector
				bombs.add(b);
			}
		}
		return b2;
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
			System.out.println("this.hero.ss.size()="+this.hero.ss.size());
			if(this.hero.ss.size()<=4)
			{
				this.hero.shotEnemy();
			}
			
		}
		//必须重新绘制Panel
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
				
				this.hitEnemyTank();
				//函数，判断敌人的坦克是否击中我
				this.hitMe();
				
	//			//判断是否击中敌人坦克
	//			//自己的注释：遍历，调用hitTank函数实现
	//			//            判断是否击中敌人的坦克。
	//			for(int i=0;i<hero.ss.size();i++)
	//			{
	//				//取出子弹
	//				Shot myShot=hero.ss.get(i);
	//				//判断子弹是否有效
	//				if(myShot.isLive)
	//				{
	//					//取出每个坦克，与它判断
	//					for(int j=0;j<ets.size();j++)
	//					{
	//						//取出坦克
	//						EnemyTank et=ets.get(j);
	//						
	//						if(et.isLive)
	//						{
	//							this.hitTank(myShot, et);
	//						}
	//					}
	//				}
	//			}
				//重绘
				this.repaint();
			}
		}
}
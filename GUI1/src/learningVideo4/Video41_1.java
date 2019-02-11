package learningVideo4;
/*
 * ���ܣ�̹����Ϸ��3.0��
 * 1.����̹��.
 * 2.�ҵ�̹�˿������������ƶ�
 * 3.���Է����ӵ����ӵ����������5�ţ�
 * 4.���ҵ�̹�˻��е��˵�̹��ʱ�����˾���ʧ����ըЧ����
 * 5.�õ���̹��Ҳ����������������������ƶ����ڹ涨��Χ�ڣ����ҿ��Է����ӵ���
 * 6.�����˵�̹�˻����ҵ�̹��ʱ���ҵ�̹�˱�ը
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Video41_1 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video41_1 video34_1=new Video41_1();
	}
	//���캯��
	public Video41_1()
	{
		mp=new MyPanel();
		
		//�����߳�
		Thread t=new Thread(mp);
		t.start();
		
		this.addKeyListener(mp);
		
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//����һ���ҵ�̹��
	Hero hero=null;
	
	//������˵�̹����
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	//����ը������
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	int enSize=3;
	
	//��������ͼƬ,����ͼƬ�������һ��ը��
	Image image1=null;
	Image image2=null;
	Image image3=null;

	//���캯��
	public MyPanel()
	{
		hero=new Hero(50,200);
		
		//��ʼ�����˵�̹��
		for(int i=0;i<enSize;i++)
		{
			//����һ�����˵�̹�˶���
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setColor(2);
			//�������˵�̹��
			Thread t=new Thread(et);
			t.start();
			//������̹�����һ���ӵ�
			Shot s=new Shot(et.x+10,et.y+30,2);
			//���������̹��
			et.ss.add(s);
			Thread t2=new Thread(s);
			t2.start();
			
			
			//����
			ets.add(et);
		}
		
		try {
			image1=ImageIO.read(new File("bomb_1.PNG"));
			image2=ImageIO.read(new File("bomb_2.PNG"));
			image3=ImageIO.read(new File("bomb_3.PNG"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		//��ʼ��ͼƬ
//		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.PNG"));
//		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.PNG"));
//		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.PNG"));
//		
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//Ŀ����ʹ����ɺ�ɫ��
		g.fillRect(0, 0, 400, 300);
		
		//�����Լ���̹��
		if(hero.isLive)
		{
			this.drawTank(hero.getX(), hero.getY(), g,this.hero.direct, 1);
		}
		
		//��ss ��ȡ��ÿ���ӵ���������
		for(int i=0;i<hero.ss.size();i++)
		{
			Shot myShot=hero.ss.get(i);
			//�����ӵ�,��hero.s.isLive==true��仰��Ϊ��
			//�����˷ѻ�ͼ����Դ
			if(myShot!=null&&myShot.isLive==true)
			{
				g.draw3DRect(myShot.x, myShot.y, 1, 1, false);
			}
			if(myShot.isLive==false)
			{
				//��ss ��ɾ�������ӵ���ע�⣺�˴�myShot ������i��
				hero.ss.remove(myShot);
			}
		}
		
		//����ը��
		for(int i=0;i<bombs.size();i++)
		{
			//ȡ��ը��
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
			
			//��b ������ֵ��С
			b.lifeDown();
			//���ը������ֵΪ0���ͰѸ�ը����bombs����ȥ��
			if(b.life==0)
			{
				bombs.remove(b);
			}
		}
		
		//�������˵�̹�ˣ����þ����ֵ��ԭ���ǵ���
		//��̹�����������ڱ仯,������ets.size()��
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			
			if(et.isLive)
			{
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(),0);
				//�ٻ������˵��ӵ�
				for(int j=0;j<et.ss.size();j++)
				{
					//ȡ���ӵ�
					Shot enemyShot=et.ss.get(j);
					if(enemyShot.isLive)
					{
						g.draw3DRect(enemyShot.x, enemyShot.y, 1, 1, false);
					}
					else 
					{
						//������˵�̹�������Ͱ��ӵ���Vectorȥ��
						et.ss.remove(enemyShot);
					}
				}
			}
			
		}
	}
	
	//�жϵ��˵��ӵ��Ƿ�����ҵ�̹��
	public void hitMe()
	{
		//ȡ��ÿһ�����˵�̹��
		for(int i=0;i<this.ets.size();i++)
		{
			//ȡ��̹��
			EnemyTank et=ets.get(i);
			
			//ȡ��ÿһ���ӵ�
			for(int j=0;j<et.ss.size();j++)
			{
				//ȡ���ӵ�
				Shot enemyShot=et.ss.get(j);
				
				this.hitTank(enemyShot, hero);
			}
		}
	}
	
	//�ж��ҵ��ӵ��Ƿ���е��˵�̹��
	public void hitEnemyTank()
	{
		//�ж��Ƿ���е���̹��
		//�Լ���ע�ͣ�����������hitTank����ʵ��
		//            �ж��Ƿ���е��˵�̹�ˡ�
		for(int i=0;i<hero.ss.size();i++)
		{
			//ȡ���ӵ�
			Shot myShot=hero.ss.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myShot.isLive)
			{
				//ȡ��ÿ��̹�ˣ������ж�
				for(int j=0;j<ets.size();j++)
				{
					//ȡ��̹��
					EnemyTank et=ets.get(j);
					
					if(et.isLive)
					{
						this.hitTank(myShot, et);
					}
				}
			}
		}
	}
	
	//дһ������ר���ж��ӵ��Ƿ���е���̹��
	//�Լ���ע�ͣ��ӵ�ʲô����»��е���̹�ˣ����䷴Ӧ
	public void hitTank(Shot s,Tank et)
	{
		//�жϸ�̹�˵ķ���
		switch(et.direct)
		{
		//�������̹�˵ķ������ϻ�����
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				//����
				//�ӵ�����
				s.isLive=false;
				//����̹������
				et.isLive=false;
				//����һ��ը��������Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
			}
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				//����
				//�ӵ�����
				s.isLive=false;
				//����̹������
				et.isLive=false;
				//����һ��ը��������Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
			}
		}
	}
	
	//����̹�˵ĺ�������չ��
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
			//�����ҵ�̹�ˣ���ʱ�ٷ�װ��һ��������
			//��Ͳ����
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5.����ֱ��
			g.drawLine(x+10, y+15,x+10, y);
			break;
		case 1:
			//��Ͳ����
			//1.������ߵľ���
			g.fill3DRect(x, y, 30, 5,false);
			//2.�����ұߵľ���
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.����Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//5.����ֱ��
			g.drawLine(x+15, y+10,x+30, y+10);
		    break;
		case 2:
			//��Ͳ����
			//1.������ߵľ���
			g.fill3DRect(x, y, 5, 30,false);
			//2.�����ұߵľ���
			g.fill3DRect(x+15, y, 5, 30,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//4.����Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//5.����ֱ��
			g.drawLine(x+10, y+15,x+10, y+30);
			break;
		case 3:
			//��Ͳ����
			//1.������ߵľ���
			g.fill3DRect(x, y, 30, 5,false);
			//2.�����ұߵľ���
			g.fill3DRect(x, y+15, 30, 5,false);
			//3.�����м�ľ���
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//4.����Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//5.����ֱ��
			g.drawLine(x+15, y+10,x, y+10);
		    break;
		}
		
	}

	@Override
	//�����´���  a��ʾ���� ,s��ʾ����,d��ʾ����,w��ʾ����
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_W)
		{
			//�����ҵ�̹�˵ķ���
			this.hero.setDirect(0);
			this.hero.moveUp();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_D)
		{
			//����
			this.hero.setDirect(1);
			this.hero.moveRight();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_S)
		{
			//����
			this.hero.setDirect(2);
			this.hero.moveDown();
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_A)
		{
			//����
			this.hero.setDirect(3);
			this.hero.moveLeft();
		}
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			//�ж�����Ƿ���j
			
			//����
			System.out.println("this.hero.ss.size()="+this.hero.ss.size());
			if(this.hero.ss.size()<=4)
			{
				this.hero.shotEnemy();
			}
			
		}
		//�������»���Panel
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
			//ÿ��100����ȥ�ػ�
			while(true)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				this.hitEnemyTank();
				//�������жϵ��˵�̹���Ƿ������
				this.hitMe();
				
	//			//�ж��Ƿ���е���̹��
	//			//�Լ���ע�ͣ�����������hitTank����ʵ��
	//			//            �ж��Ƿ���е��˵�̹�ˡ�
	//			for(int i=0;i<hero.ss.size();i++)
	//			{
	//				//ȡ���ӵ�
	//				Shot myShot=hero.ss.get(i);
	//				//�ж��ӵ��Ƿ���Ч
	//				if(myShot.isLive)
	//				{
	//					//ȡ��ÿ��̹�ˣ������ж�
	//					for(int j=0;j<ets.size();j++)
	//					{
	//						//ȡ��̹��
	//						EnemyTank et=ets.get(j);
	//						
	//						if(et.isLive)
	//						{
	//							this.hitTank(myShot, et);
	//						}
	//					}
	//				}
	//			}
				//�ػ�
				this.repaint();
			}
		}
}
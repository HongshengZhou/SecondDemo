package learningVideo3;
/*
 * ���ܣ�̹����Ϸ��3.0��
 * 1.����̹��.
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
	//���캯��
	public Video39_2()
	{
		mp=new MyPanel();
		
		//�����߳�
		Thread t=new Thread(mp);
		t.start();
		
		this.addKeyListener(mp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	int enSize=3;

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
			//����
			ets.add(et);
		}
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//Ŀ����ʹ����ɺ�ɫ��
		g.fillRect(0, 0, 400, 300);
		
		//�����Լ���̹��
		this.drawTank(hero.getX(), hero.getY(), g,this.hero.direct, 1);
		
		//�����ӵ�,��hero.s.isLive==true��仰��Ϊ��
		//�����˷ѻ�ͼ����Դ
		if(hero.s!=null&&hero.s.isLive==true)
		{
			g.draw3DRect(hero.s.x, hero.s.y, 1, 1, false);
		}
		
		//�������˵�̹�ˣ����þ����ֵ��ԭ���ǵ���
		//��̹�����������ڱ仯,������ets.size()��
		for(int i=0;i<ets.size();i++)
		{
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getDirect(),0);
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
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
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
			this.hero.shotEnemy();
		}
		//�������»���Panel
		this.repaint();
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
			//�ػ�
			this.repaint();
		}
	}
}

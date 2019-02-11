package learningVideo5;
/*
 * ���ܣ�̹����Ϸ��4.0��
 * 1.����̹��.
 * 2.�ҵ�̹�˿������������ƶ�
 * 3.���Է����ӵ����ӵ����������5�ţ�
 * 4.���ҵ�̹�˻��е��˵�̹��ʱ�����˾���ʧ����ըЧ����
 * 5.�õ���̹��Ҳ����������������������ƶ����ڹ涨��Χ�ڣ����ҿ��Է����ӵ���
 *    �����˵�̹�˻����ҵ�̹��ʱ���ҵ�̹�˱�ը
 * 6.��ֹ���˵�̹���ص��˶�
 *    6.1�������ж��Ƿ���ײ�ĺ���д��EnemyTank��
 * 7.���Էֹ�
 *    7.1��һ����ʼ��Panel,����һ���յ�
 *    7.2��˸Ч��
 * 8.����������Ϸ��ʱ����ͣ�ͼ���
 *    8.1���û������ͣʱ���ӵ����ٶȺ�̹�˵��ٶ���Ϊ0��
 *       ����̹�˵ķ����ٱ仯
 * 9.���Լ�¼��ҵĳɼ�
 *    9.1���ļ���
 *    9.2��дһ����¼�࣬��ɶ���Ҽ�¼
 *    9.3����ɱ��湲�����˶���������̹�˵Ĺ���
 *    9.4�����˳���Ϸ�����Լ�¼��ʱ�ĵ���̹�����꣬���ɻָ�
 * 10.java��β��������ļ�
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
	
	//����һ����ʼ���
	MyStartPanel msp=null;
	
	//��������Ҫ�Ĳ˵�
	JMenuBar jmb=null;
	//��ʼ��Ϸ
	JMenu jm1=null;
	JMenuItem jmi1=null;
	//�˳�ϵͳ
	JMenuItem jmi2=null;
	//�����˳�
	JMenuItem jmi3=null;
	JMenuItem jmi4=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video47_1 video34_1=new Video47_1();
	}
	//���캯��
	public Video47_1()
	{
//		mp=new MyPanel();
//		
//		//�����߳�
//		Thread t=new Thread(mp);
//		t.start();
//		this.add(mp);
//		//ע�����
//		this.addKeyListener(mp);
		
		//�����˵����˵�ѡ��
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ(G)");
		//���ÿ�ݷ�ʽ
		jm1.setMnemonic('G');
		jmi1=new JMenuItem("��ʼ����Ϸ(N)");
		jmi1.setMnemonic('N');
		jmi2=new JMenuItem("�˳���Ϸ(E)");
		jmi2.setMnemonic('E');
		jmi3=new JMenuItem("�����˳���Ϸ(C)");
		jmi4=new JMenuItem("�����Ͼ���Ϸ(S)");
		
		jmi4.addActionListener(this);
		jmi4.setActionCommand("conGame");
		//ע�����
		jmi3.addActionListener(this);
		jmi3.setActionCommand("saveExit");
		
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jmi2.setMnemonic('E');
		
		//��jmi1��Ӧ
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
		//���û���ͬ�ĵ��������ͬ�Ĵ���
		if(arg0.getActionCommand().equals("newgame"))
		{
			//����ս�����
			mp=new MyPanel("newgame");
			
			//�����߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ���ɵĿ�ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ��ˢ��JFrame
			this.setVisible(true);
		}
		else if(arg0.getActionCommand().equals("exit"))
		{
			//�û�������˳�ϵͳ�Ĳ˵�
			//������ٵ�������
			Recorder.keepRecording();
			
			System.exit(0);
		}
		//�Դ����˳�������
		else if(arg0.getActionCommand().equals("saveExit"))
		{
			//����
			Recorder.setEts(mp.ets);
			//������ٵ��˵������͵��˵�����
			Recorder.keepRecAndEnemyTank();
			
			//�˳�
			System.exit(0);
		}
		else if(arg0.getActionCommand().equals("conGame"))
		{
			//����ս�����
			mp=new MyPanel("con");
			//mp.flag="con";
			
			//�����߳�
			Thread t=new Thread(mp);
			t.start();
			//��ɾ���ɵĿ�ʼ���
			this.remove(msp);
			this.add(mp);
			//ע�����
			this.addKeyListener(mp);
			//��ʾ��ˢ��JFrame
			this.setVisible(true);
		}
	}
}

//����һ����ʾ����
class MyStartPanel extends JPanel implements Runnable
{
	int times=0;
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 300);
		//��ʾ��Ϣ
		
		if(times%2==0)
		{
			g.setColor(Color.yellow);
			//������Ϣ������
			Font myFont=new Font("������κ",Font.BOLD,30);
			g.setFont(myFont);
			g.drawString("stage: 1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//����
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			//�ػ�
			this.repaint();
		}
	}
}

//�ҵ����
class MyPanel extends JPanel implements KeyListener,Runnable
{
	//����һ���ҵ�̹��
	Hero hero=null;
	
	//�ж������Ͼ֣���������Ϸ
	String flag="newGame";
	
	//������˵�̹����
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	Vector<Node> nodes=new Vector<Node>();
	
	//����ը������
	Vector<Bomb> bombs=new Vector<Bomb>();
	
	int enSize=5;
	
	//��������ͼƬ,����ͼƬ�������һ��ը��
	Image image1=null;
	Image image2=null;
	Image image3=null;

	//���캯��
	public MyPanel(String flag)
	{
		//�ָ���¼
		Recorder.getRecording();
		
		hero=new Hero(50,200);
		
		if(flag.equals("newGame"))
		{
			//��ʼ�����˵�̹��
			for(int i=0;i<enSize;i++)
			{
				//����һ�����˵�̹�˶���
				EnemyTank et=new EnemyTank((i+1)*50,0);
				et.setColor(0);
				et.setColor(2);
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);
				
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
		}
		else
		{
			nodes=new Recorder().getNodesAndEnNums();
			//��ʼ�����˵�̹��
			for(int i=0;i<nodes.size();i++)
			{
				Node node=nodes.get(i);
				//����һ�����˵�̹�˶���
				EnemyTank et=new EnemyTank(node.x,node.y);
				et.setColor(0);
				et.setColor(node.direct);
				//��MyPanel�ĵ���̹�����������õ���̹��
				et.setEts(ets);
				
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
			
		}
		
//		try {
//			image1=ImageIO.read(new File("bomb_1.PNG"));
//			image2=ImageIO.read(new File("bomb_2.PNG"));
//			image3=ImageIO.read(new File("bomb_3.PNG"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//��ʼ��ͼƬ
		image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.PNG"));
		image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.PNG"));
		image3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.PNG"));
		
	}
	
	//������ʾ��Ϣ
	public void showInfo(Graphics g)
	{
		//������ʾ��Ϣ̹�ˣ���̹�˲�����ս����
		this.drawTank(80, 330, g, 0, 0);
		g.setColor(Color.black);
		g.drawString(Recorder.getEnNum()+"",110 , 350);
		this.drawTank(130, 330, g, 0, 1);
		g.setColor(Color.black);
		g.drawString(Recorder.getMyLife()+"",165 , 350);
		
		//������ҵ��ܳɼ�
		g.setColor(Color.black);
		Font f=new Font("����",Font.BOLD,20);
		g.setFont(f);
		g.drawString("�����ܳɼ�", 420, 20);
		
		this.drawTank(420, 60, g, 0, 0);
		
		g.setColor(Color.black);
		g.drawString(Recorder.getAllEnNum()+"", 460, 80);
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//Ŀ����ʹ����ɺ�ɫ��
		g.fillRect(0, 0, 400, 300);
		
		//������ʾ��Ϣ
		this.showInfo(g);
		
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
				if(hero.isLive)
				{
					if(this.hitTank(enemyShot, hero))
					{
						
					}
				}
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
						if(this.hitTank(myShot, et))
						{
							//���ٵ�������
							Recorder.reduceEnNum();
							//�����ҵļ�¼
							Recorder.addEnNumRec();
						}
					}
				}
			}
		}
	}
	
	//дһ������ר���ж��ӵ��Ƿ���е���̹��
	//�Լ���ע�ͣ��ӵ�ʲô����»��е���̹�ˣ����䷴Ӧ
	public boolean hitTank(Shot s,Tank et)
	{
		boolean b2=false;
		
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
				b2=true;
//				//���ٵ�������
//				Recorder.reduceEnNum();
//				//�����ҵļ�¼
//				Recorder.addEnNumRec();
				//����һ��ը��������Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
			}
			break;
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				//����
				//�ӵ�����
				s.isLive=false;
				//����̹������
				et.isLive=false;
				b2=true;
//				//���ٵ�������
//				Recorder.reduceEnNum();
//				//�����ҵļ�¼
//				Recorder.addEnNumRec();
				//����һ��ը��������Vector
				Bomb b=new Bomb(et.x,et.y);
				//����Vector
				bombs.add(b);
			}
		}
		return b2;
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
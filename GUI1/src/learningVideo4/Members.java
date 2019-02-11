package learningVideo4;
import java.util.*;

//ը����
class Bomb
{
	//����ը������
	int x,y;
	//ը��������
	int life=9;
	boolean isLive=true;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	//��������ֵ
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive=false;
		}
	}
	
}

//�ӵ���
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed=1;
	//�Ƿ񻹻���
	boolean isLive=true;
	public Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	@Override
	public void run() 
	{
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0:
				//��
				y-=speed;
				break;
			case 1:
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			
			//System.out.println("�ӵ�����x="+x+" y="+y);
			//�ӵ���ʱ��������
			
			//�жϸ��ӵ��Ƿ�������Ե
			if(x<0||x>400||y<0||y>300)
			{
				this.isLive=false;
				break;
			}
		}
		
	}
}

//̹����
class Tank
{
	//��ʾ̹�˵ĺ����꣬�ı�ʱ��̹�˿��ƶ�
	int x=0;
	//��ʾ̹�˵�������
	int y=0;
	//̹�˷���
	//0��ʾ��  ��1��ʾ��  ��2��ʾ�£� 3��ʾ��
	int direct=0;
	int color;
	
	boolean isLive=true;
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	//̹�˵��ٶ�
	int speed=2;
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
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
	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}

//���˵�̹��
class EnemyTank extends Tank implements Runnable
{
	
	int times=0;
	//����һ�����������Դ�ŵ��˵��ӵ�
	Vector<Shot> ss=new Vector<Shot>();
	//��������ӵ���Ӧ���ڸոմ���̹�˺͵���̹��������
	
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(true)
		{
			
			switch(this.direct)
			{
			case 0:
				//˵��̹����������
				for(int i=0;i<30;i++)
				{
					if(y>0)
					{
						y-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 1:
				//����
				for(int i=0;i<30;i++)
				{
					//��֤̹�˲����߽�
					if(x<400)
					{
						x+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2:
				//����
				for(int i=0;i<30;i++)
				{
					if(y<300)
					{
						y+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 3:
				//����
				for(int i=0;i<30;i++)
				{
					if(x>0)
					{
						x-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			
			this.times++;
			
			if(times%2==0)
			{
				if(isLive)
				{
					if(ss.size()<5)
					{
						//System.out.println("et.ss.size()"+et.ss.size());
						Shot s=null;
						//û���ӵ�
						//���
						switch(direct)
						{
						case 0:
							//����һ���ӵ�
							s=new Shot(x+10,y,0);
							//���ӵ����뵽����
							ss.add(s);
							break;
						case 1:
							s=new Shot(x+30,y+10,1);
							ss.add(s);
							break;
						case 2:
							s=new Shot(x+10,y+30,2);
							ss.add(s);
							break;
						case 3:
							s=new Shot(x,y+10,3);
							ss.add(s);
							break;
						}
						//�����ӵ�
						Thread t=new Thread(s);
						t.start();
					}
				}
			}
			//��̹���������һ���µķ���
			this.direct=(int)(Math.random()*4);
			
			//�жϵ���̹���Ƿ�����
			if(this.isLive==false)
			{
				//��̹���������˳��߳�
				break;
			}
		}
	}
}
//�ҵ�̹��
class Hero extends Tank
{
	//�ӵ�
	//Shot s=null;
	Vector<Shot> ss=new Vector<Shot>();
	Shot s=null;
	
	public Hero(int x,int y)
	{
		super(x,y);
	}
	
	//����
	public void shotEnemy()
	{
		switch(this.direct)
		{
		case 0:
			//����һ���ӵ�
			s=new Shot(x+10,y,0);
			//���ӵ����뵽����
			ss.add(s);
			break;
		case 1:
			s=new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			s=new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s=new Shot(x,y+10,3);
			ss.add(s);
			break;
		}
		//�����ӵ��߳�
		Thread t=new Thread(s);
		t.start();
	}
	
	//̹�������ƶ�
	public void moveUp()
	{
		y-=speed;
	}
	//̹�������ƶ�
	public void moveRight()
	{
		x+=speed;
	}
	//̹�������ƶ�
	public void moveDown()
	{
		y+=speed;
	}
	//̹�������ƶ�
	public void moveLeft()
	{
		x-=speed;
	}
}

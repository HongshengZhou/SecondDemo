package learningVideo5;
import java.util.*;
import java.io.*;

class Node
{
	int x;
	int y;
	int direct;
	public Node(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}

//��¼�࣬ͬʱҲ���Ա�����ҵ�����
class Recorder
{
	//��¼ÿ���ж�����
	private static int enNum=20;
	//�������ж��ٿ����õ���
	private static int myLife=3;
	//��¼�ܹ������˶��ٵ���
	public static int allEnNum=0;
	//���ļ��лָ���¼��
	static Vector<Node> nodes=new Vector<Node>();
	
	private static FileWriter fw=null;
	private static BufferedWriter bw=null;
	private static FileReader fr=null;
	private static BufferedReader br=null;
	
	private static Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	//��ɶ�ȡ����
	public Vector<Node> getNodesAndEnNums()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			String n="";
			//�ȶ�ȡ��һ��
			n=br.readLine();
			allEnNum=Integer.parseInt(n);
			while((n=br.readLine())!=null)
			{
				String []xyz=n.split(" ");
				for(int i=0;i<xyz.length;i++)
				{
					Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
					nodes.add(node);
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nodes;
	}
	
	
	public static Vector<EnemyTank> getEts() {
		return ets;
	}


	public static void setEts(Vector<EnemyTank> ets) {
		Recorder.ets = ets;
	}


	//������ٵ��˵������͵���̹�����꣬����
	public static void keepRecAndEnemyTank()
	{
		try {
			//����
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
			
			//���浱ǰ��ĵ���̹�˵�����ͷ���
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				
				if(et.isLive)
				{
					//��ľͱ���
					String recode=et.x+" "+et.y+" "+et.direct;
					
					//д��
					bw.write(recode+"\r\n");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//�ر���
			try {
				//ע�⣺�󿪵�Ӧ�ȹر�
				bw.close();
				fw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//���ļ��ж�ȡ����¼
	public static void getRecording()
	{
		try {
			fr=new FileReader("d:\\myRecording.txt");
			br=new BufferedReader(fr);
			String n=br.readLine();
			//���ַ���ת��Ϊ����
			allEnNum=Integer.parseInt(n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//����һ��ٵ���̹���������浽�ļ���
	public static void keepRecording()
	{
		try {
			//����
			fw=new FileWriter("d:\\myRecording.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(allEnNum+"\r\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//�ر���
			try {
				//ע�⣺�󿪵�Ӧ�ȹر�
				bw.close();
				fw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static int getAllEnNum() {
		return allEnNum;
	}
	public static void setAllEnNum(int allEnNum) {
		Recorder.allEnNum = allEnNum;
	}
	public static int getEnNum() {
		return enNum;
	}
	public static void setEnNum(int enNum) {
		Recorder.enNum = enNum;
	}
	public static int getMyLife() {
		return myLife;
	}
	public static void setMyLife(int myLife) {
		Recorder.myLife = myLife;
	}
	
	//���ٵ�����
	public static void reduceEnNum()
	{
		enNum--;
	}
	//�������
	public static void addEnNumRec()
	{
		allEnNum++;
	}
}

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
	
	//����һ�����������Է��ʵ�MyPanel�����е��˵�̹��
	Vector<EnemyTank> ets=new Vector<EnemyTank>();
	
	//����һ�����������Դ�ŵ��˵��ӵ�
	Vector<Shot> ss=new Vector<Shot>();
	//��������ӵ���Ӧ���ڸոմ���̹�˺͵���̹��������
	
	public EnemyTank(int x,int y)
	{
		super(x,y);
	}
	
	//�õ�MyPanel�ĵ���̹������
	public void setEts(Vector<EnemyTank> vv)
	{
		this.ets=vv;
	}
	
	//�ж��Ƿ������˱�ĵ���̹��
	public boolean isTouchOtherEnemy()
	{
		boolean b=false;
		
		switch(this.direct)
		{
		case 0:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						//���
						if(this.x>et.x&&this.x<et.x+20&&this.y>et.y&&this.y<et.y+30)
						{
							return true;
						}
						//�ҵ�
						if(this.x+20>et.x&&this.x+20<et.x+20&&this.y>et.y&&this.y<et.y+30)
						{
							return true;
						}
					}
					if(et.direct==1||et.direct==3)
					{
						if(this.x>et.x&&this.x<et.x+30&&this.y>et.y&&this.y<et.y+20)
						{
							return true;
						}
						if(this.x+20>et.x&&this.x+20<et.x+30&&this.y>et.y&&this.y<et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 1:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						if(this.x+30>et.x&&this.x+30<et.x+20&&this.y>et.y&&this.y<et.y+30)
						{
							return true;
						}
						if(this.x+30>et.x&&this.x+30<et.x+20&&this.y+20>et.y&&this.y+20<et.y+30)
						{
							return true;
						}
					}
					if(et.direct==1||et.direct==3)
					{
						if(this.x+30>et.x&&this.x+30<et.x+30&&this.y>et.y&&this.y<et.y+20)
						{
							return true;
						}
						if(this.x+30>et.x&&this.x+30<et.x+30&&this.y+20>et.y&&this.y+20<et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 2:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						//���
						if(this.x>et.x&&this.x<et.x+20&&this.y+30>et.y&&this.y+30<et.y+30)
						{
							return true;
						}
						//�ҵ�
						if(this.x+20>et.x&&this.x+20<et.x+20&&this.y+30>et.y&&this.y+30<et.y+30)
						{
							return true;
						}
					}
					if(et.direct==1||et.direct==3)
					{
						if(this.x>et.x&&this.x<et.x+30&&this.y+30>et.y&&this.y+30<et.y+20)
						{
							return true;
						}
						if(this.x+20>et.x&&this.x+20<et.x+30&&this.y+30>et.y&&this.y+30<et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		case 3:
			//�ҵ�̹������
			//ȡ�����еĵ���̹��
			for(int i=0;i<ets.size();i++)
			{
				//ȡ����һ��̹��
				EnemyTank et=ets.get(i);
				//��������Լ�
				if(et!=this)
				{
					if(et.direct==0||et.direct==2)
					{
						if(this.x>et.x&&this.x<et.x+20&&this.y>et.y&&this.y<et.y+30)
						{
							return true;
						}
						if(this.x>et.x&&this.x<et.x+20&&this.y+20>et.y&&this.y+20<et.y+30)
						{
							return true;
						}
					}
					if(et.direct==1||et.direct==3)
					{
						if(this.x>et.x&&this.x<et.x+30&&this.y>et.y&&this.y<et.y+20)
						{
							return true;
						}
						if(this.x>et.x&&this.x<et.x+30&&this.y+20>et.y&&this.y+20<et.y+20)
						{
							return true;
						}
					}
				}
			}
			break;
		}
		
		return b;
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
					if(y>0&&!this.isTouchOtherEnemy())
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
					if(x<400&&!this.isTouchOtherEnemy())
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
					if(y<300&&!this.isTouchOtherEnemy())
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
					if(x>0&&!this.isTouchOtherEnemy())
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

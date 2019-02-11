package learningVideo;
/*
 * ���ܣ�̹����Ϸ��1.0��
 * 1.����̹��.
 */
import java.awt.*;
import javax.swing.*;
public class Video34_1 extends JFrame
{
	MyPanel mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video34_1 video34_1=new Video34_1();
	}
	//���캯��
	public Video34_1()
	{
		mp=new MyPanel();
		
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
	}
}

//�ҵ����
class MyPanel extends JPanel
{
	//����һ���ҵ�̹��
	Hero hero=null;
	
	//���캯��
	public MyPanel()
	{
		hero=new Hero(10,10);
	}
	
	//����paint
	public void paint(Graphics g)
	{
		super.paint(g);
		//Ŀ����ʹ����ɺ�ɫ��
		g.fillRect(0, 0, 400, 300);
		
		this.drawTank(hero.getX(), hero.getY(), g,0, 1);
	}
	//����̹�˵ĺ���
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
		}
	}
}
//̹����
class Tank
{
	//��ʾ̹�˵ĺ����꣬�ı�ʱ��̹�˿��ƶ�
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
	//��ʾ̹�˵�������
	int y=0;
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
//�ҵ�̹��
class Hero extends Tank
{
	public Hero(int x,int y)
	{
		super(x,y);
	}
}
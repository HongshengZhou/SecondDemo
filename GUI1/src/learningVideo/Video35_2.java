package learningVideo;
/*
 * ���ܣ�������¼�������Ƶ����
 * 1.ͨ���������Ҽ���������һ��С���λ��
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Video35_2 extends JFrame
{
	MyPanel5 mp =null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video35_2 video35_2=new Video35_2();
	}

	public Video35_2()
	{
		mp=new MyPanel5();
		
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//�����Լ������
class MyPanel5 extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	//��������
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("��������"+(char)arg0.getKeyCode());
		
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//����
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
		//����repaint()���������ػ����
		this.repaint();
	}

	@Override
	//�����ͷ�
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//����һ��ֵ�����
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
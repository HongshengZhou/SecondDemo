package learningVideo;
/*
 * �¼��������
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Video35_1 extends JFrame implements ActionListener
{
	//����һ��panel
	JPanel mp=null;
	JButton jb1=null;
	JButton jb2=null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Video35_1 video35_1=new Video35_1();
	}
	public Video35_1()
	{
		mp=new JPanel();
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat cat1=new Cat();
		
		//ע�����
		//cat��this( video35_1)���Ǽ�����
		jb1.addActionListener(this);
		//��jb1.addActionListener(cat1);��仰���Ƴ�����
		//��Դ������jb1,�¼�����������cat1
		//jb1.addActionListener(cat1);
		
		//ָ��action����
		jb1.setActionCommand("aa");
		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	//���¼��Ĵ�����
	//�����ť������ActionEvent�¼�,��arg0�����¼��Ķ���
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//�ж����ĸ���ť�����
		if(arg0.getActionCommand().equals("aa"))
		{
			System.out.println("������ɫ��ť��");
			mp.setBackground(Color.BLACK);
		}
		else if(arg0.getActionCommand().equals("bb"))
		{
			System.out.println("������ɫ��ť��");
			mp.setBackground(Color.RED);
		}
		else
		{
			System.out.println("��֪�����ʲô��ť");
		}
	}
}

class Cat implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("aa"))
		{
			System.out.println("èè֪��������ɫ��ť��");
		}
		else if(arg0.getActionCommand().equals("bb"))
		{
			System.out.println("èè֪��������ɫ��ť��");
		}
	}
	
}

//class MyPanel4 extends JPanel
//{
//	public void paint(Graphics g)
//	{
//		
//	}
//}
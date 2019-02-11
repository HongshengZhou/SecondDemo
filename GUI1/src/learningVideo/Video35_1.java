package learningVideo;
/*
 * 事件处理机制
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Video35_1 extends JFrame implements ActionListener
{
	//定义一个panel
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
		jb1=new JButton("黑色");
		jb2=new JButton("红色");
		
		this.add(jb1,BorderLayout.NORTH);
		mp.setBackground(Color.black);
		this.add(mp);
		this.add(jb2,BorderLayout.SOUTH);
		
		Cat cat1=new Cat();
		
		//注册监听
		//cat和this( video35_1)均是监听者
		jb1.addActionListener(this);
		//从jb1.addActionListener(cat1);这句话可推出，事
		//件源对象是jb1,事件监听对象是cat1
		//jb1.addActionListener(cat1);
		
		//指定action命令
		jb1.setActionCommand("aa");
		jb2.addActionListener(this);
		jb2.setActionCommand("bb");
		
		this.setSize(200,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	//对事件的处理方法
	//点击按钮将发生ActionEvent事件,而arg0是这事件的对象
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被点击
		if(arg0.getActionCommand().equals("aa"))
		{
			System.out.println("你点击黑色按钮了");
			mp.setBackground(Color.BLACK);
		}
		else if(arg0.getActionCommand().equals("bb"))
		{
			System.out.println("你点击红色按钮了");
			mp.setBackground(Color.RED);
		}
		else
		{
			System.out.println("不知道点击什么按钮");
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
			System.out.println("猫猫知道你点击黑色按钮了");
		}
		else if(arg0.getActionCommand().equals("bb"))
		{
			System.out.println("猫猫知道你点击红色按钮了");
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
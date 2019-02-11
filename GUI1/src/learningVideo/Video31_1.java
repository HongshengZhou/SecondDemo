package learningVideo;
/*
 * 练习使用swing组件，复选框组件、单选框组件
 */
import java.awt.*;

import javax.swing.*;
public class Video31_1 extends JFrame
{
	JPanel jp1,jp2,jp3;
	JLabel jlb1,jlb2;
	JButton jb1,jb2;
	JCheckBox jcb1,jcb2,jcb3;
	JRadioButton jrb1,jrb2;
	ButtonGroup bg;
	public static void main(String[] args)
	{
		Video31_1 video31_1=new Video31_1();
	}
	public Video31_1()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("你最喜欢的运动");
		jlb2=new JLabel("你的性别");
		jb1=new JButton("注册用户");
		jb2=new JButton("取消注册");
		
		jcb1=new JCheckBox("足球");
		jcb2=new JCheckBox("篮球");
		jcb3=new JCheckBox("网球");
		
		jrb1=new JRadioButton("男");
		jrb2=new JRadioButton("女");
		//一定要把jrb1，jrb2,放入到一个ButtonGroup中
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//设置布局管理器
		this.setLayout(new GridLayout(3,1));
		//添加组件
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//加入到JFrame中
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

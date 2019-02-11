package eeeee;

/*
 * 功能：编写一个通信录软件。要求设计Person类，包含name、gender、homePhone、officePhone、
 * remark、group等属性、构造方法和对这些属性进行操作的方法，如属性值的获取和修改。
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Total extends JFrame  
{
	JPanel jp1,jp2;
	//jb1,jb2,jb3,jb4,jb5分别为“添加职工”，“删除职工”，“查找职工”“所有职工”“退出程序”
	JButton jb1,jb2,jb3,jb4,jb5;
	JLabel jlb;
	JTextArea area;
	JScrollPane scrollPane;
	
	
//	String a1="姓名：习近平\n性别：男\n手机号码：111111\n分组：国家领导人\n简介：当今中国主席";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Total total=new Total();
	}
	public Total()
	{
		jp1=new JPanel();
		jp2=new JPanel();
//		jp3=new JPanel();
		
		jlb=new JLabel(new ImageIcon("images/welcome.jpg"));
		
		jb1=new JButton("添加职工");
		jb2=new JButton("删除职工");
		jb3=new JButton("查找职工");
		jb4=new JButton("所有职工");
		jb5=new JButton("退出程序");
		
		area=new JTextArea(15,20);
		scrollPane=new JScrollPane(area);
		scrollPane.setHorizontalScrollBarPolicy(       
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(   
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		//设置布局管理器
		this.setLayout(new BorderLayout()); 
//		this.setLayout(new GridLayout(2,1));
		//设置面板为流式布局居中显示，组件横、纵间距为5个像素

      
		//添加组件
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		
		jp2.add(jlb);
		
//		this.add(jp1,BorderLayout.WEST);
//		this.add(jp2,BorderLayout.CENTER);
//		this.add(jp3,BorderLayout.EAST);
		
		//加入到JFrame中
		this.add(jp1,BorderLayout.NORTH);
		this.add(area,BorderLayout.CENTER);
		
		this.setSize(650, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		 
	}
	


}

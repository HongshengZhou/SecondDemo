package total;

/*
 * 功能：编写一个通信录软件。要求设计Person类，包含name、gender、homePhone、officePhone、
 * remark、group等属性、构造方法和对这些属性进行操作的方法，如属性值的获取和修改。
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Total extends JFrame  implements ActionListener
{
	JPanel jp1,jp2,jp3;
	//jb1,jb2,jb3分别为“查找联系人”，“新增联系人”，“修改联系人”
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JTextArea jta=null;
	JScrollPane jsp=null;
	
	String a1="姓名：习近平\n性别：男\n手机号码：111111\n分组：国家领导人\n简介：当今中国主席";
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Total total=new Total();
	}
	public Total()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("查找联系人");
		jb2=new JButton("新增联系人");
		jb3=new JButton("修改联系人");
		
		jb4=new JButton("习近平");
		jb5=new JButton("马云");
		jb6=new JButton("本拉登");
		jb7=new JButton("小云");
		
		jta=new JTextArea(a1);
		//将滚动窗格组件 加入到多行文本框组件
		jsp=new JScrollPane(jta);
		
		//设置布局管理器
		this.setLayout(new GridLayout(1,3));
		
		//添加组件
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		jp2.add(jb7);
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		
//		this.add(jp1,BorderLayout.WEST);
//		this.add(jp2,BorderLayout.CENTER);
//		this.add(jp3,BorderLayout.EAST);
		
		//加入到JFrame中
		this.add(jp1);
		this.add(jp2);
		this.add(jsp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//注册监听
		//cat和this( video35_1)均是监听者
		jb1.addActionListener(this);
		//指定action命令
		jb1.setActionCommand("习近平");
		jb2.addActionListener(this);
		jb2.setActionCommand("马云");
		jb3.addActionListener(this);
		jb3.setActionCommand("本拉登");
		jb4.addActionListener(this);
		jb4.setActionCommand("小云");
		 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被点击
		if(arg0.getActionCommand().equals("习近平"))
		{
			System.out.println("你点击黑色按钮了");
		}
		if(arg0.getActionCommand().equals("马云"))
		{
			String a2="  d d d ";
			jta=new JTextArea(a2);
			//将滚动窗格组件 加入到多行文本框组件
			jsp=new JScrollPane(jta);
		}
	}

}

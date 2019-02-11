package learningVideo;
/*
 * JTextArea 的演示
 */
import java.awt.*;

import javax.swing.*;
public class Video32_4 extends JFrame
{
	JTextArea jta=null;
	JScrollPane jsp=null;
	JPanel jp=null;
	JComboBox jcb=null;
	JTextField jtf=null;
	JButton jb=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video32_4 video32_4=new Video32_4();
	}
	
	public Video32_4()
	{
		jta=new JTextArea();
		//将滚动窗格组件 加入到多行文本框组件
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		String []friends={"白白","黑黑","红红","蓝蓝"};
		jcb=new JComboBox(friends);
		jtf=new JTextField();
		jb=new JButton("发送");
		
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		
		this.setIconImage((new ImageIcon("images//IMG0150A.jpg")).getImage());
		this.setTitle("小鸡");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 100);
		this.setLocation(200, 200);
		this.setVisible(true);
		
	}
}

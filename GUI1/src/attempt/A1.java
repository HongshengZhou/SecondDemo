package attempt;
/*
 * 小界面
 */
import java.awt.*;
import javax.swing.*;
public class A1 extends JFrame
{
	//定义需要的组件
	JLabel jlb1,jlb2;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	public static void main(String[] args)
	{
		A1 a1=new A1();
	}
	//构造函数
	public A1()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("账号");
		jlb2=new JLabel("密码");
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		
		jtf1=new JTextField(10);
		jpf1=new JPasswordField(10);
		
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jpf1);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//加入到JFrame中
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("Hello");
		this.setSize(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

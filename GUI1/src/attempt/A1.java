package attempt;
/*
 * С����
 */
import java.awt.*;
import javax.swing.*;
public class A1 extends JFrame
{
	//������Ҫ�����
	JLabel jlb1,jlb2;
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	public static void main(String[] args)
	{
		A1 a1=new A1();
	}
	//���캯��
	public A1()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jlb1=new JLabel("�˺�");
		jlb2=new JLabel("����");
		jb1=new JButton("��¼");
		jb2=new JButton("ȡ��");
		
		jtf1=new JTextField(10);
		jpf1=new JPasswordField(10);
		
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jlb1);
		jp1.add(jtf1);
		jp2.add(jlb2);
		jp2.add(jpf1);
		jp3.add(jb1);
		jp3.add(jb2);
		
		//���뵽JFrame��
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setTitle("Hello");
		this.setSize(250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

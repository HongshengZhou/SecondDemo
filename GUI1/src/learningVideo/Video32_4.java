package learningVideo;
/*
 * JTextArea ����ʾ
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
		//������������� ���뵽�����ı������
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		String []friends={"�װ�","�ں�","���","����"};
		jcb=new JComboBox(friends);
		jtf=new JTextField();
		jb=new JButton("����");
		
		jp.add(jcb);
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jsp);
		this.add(jp,BorderLayout.SOUTH);
		
		this.setIconImage((new ImageIcon("images//IMG0150A.jpg")).getImage());
		this.setTitle("С��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 100);
		this.setLocation(200, 200);
		this.setVisible(true);
		
	}
}

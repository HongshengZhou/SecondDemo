package total;

/*
 * ���ܣ���дһ��ͨ��¼�����Ҫ�����Person�࣬����name��gender��homePhone��officePhone��
 * remark��group�����ԡ����췽���Ͷ���Щ���Խ��в����ķ�����������ֵ�Ļ�ȡ���޸ġ�
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Total extends JFrame  implements ActionListener
{
	JPanel jp1,jp2,jp3;
	//jb1,jb2,jb3�ֱ�Ϊ��������ϵ�ˡ�����������ϵ�ˡ������޸���ϵ�ˡ�
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	JTextArea jta=null;
	JScrollPane jsp=null;
	
	String a1="������ϰ��ƽ\n�Ա���\n�ֻ����룺111111\n���飺�����쵼��\n��飺�����й���ϯ";
	
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
		
		jb1=new JButton("������ϵ��");
		jb2=new JButton("������ϵ��");
		jb3=new JButton("�޸���ϵ��");
		
		jb4=new JButton("ϰ��ƽ");
		jb5=new JButton("����");
		jb6=new JButton("������");
		jb7=new JButton("С��");
		
		jta=new JTextArea(a1);
		//������������� ���뵽�����ı������
		jsp=new JScrollPane(jta);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(1,3));
		
		//������
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
		
		//���뵽JFrame��
		this.add(jp1);
		this.add(jp2);
		this.add(jsp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//ע�����
		//cat��this( video35_1)���Ǽ�����
		jb1.addActionListener(this);
		//ָ��action����
		jb1.setActionCommand("ϰ��ƽ");
		jb2.addActionListener(this);
		jb2.setActionCommand("����");
		jb3.addActionListener(this);
		jb3.setActionCommand("������");
		jb4.addActionListener(this);
		jb4.setActionCommand("С��");
		 
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//�ж����ĸ���ť�����
		if(arg0.getActionCommand().equals("ϰ��ƽ"))
		{
			System.out.println("������ɫ��ť��");
		}
		if(arg0.getActionCommand().equals("����"))
		{
			String a2="  d d d ";
			jta=new JTextArea(a2);
			//������������� ���뵽�����ı������
			jsp=new JScrollPane(jta);
		}
	}

}

package eeeee;

/*
 * ���ܣ���дһ��ͨ��¼�����Ҫ�����Person�࣬����name��gender��homePhone��officePhone��
 * remark��group�����ԡ����췽���Ͷ���Щ���Խ��в����ķ�����������ֵ�Ļ�ȡ���޸ġ�
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Total extends JFrame  
{
	JPanel jp1,jp2;
	//jb1,jb2,jb3,jb4,jb5�ֱ�Ϊ�����ְ��������ɾ��ְ������������ְ����������ְ�������˳�����
	JButton jb1,jb2,jb3,jb4,jb5;
	JLabel jlb;
	JTextArea area;
	JScrollPane scrollPane;
	
	
//	String a1="������ϰ��ƽ\n�Ա���\n�ֻ����룺111111\n���飺�����쵼��\n��飺�����й���ϯ";
	
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
		
		jb1=new JButton("���ְ��");
		jb2=new JButton("ɾ��ְ��");
		jb3=new JButton("����ְ��");
		jb4=new JButton("����ְ��");
		jb5=new JButton("�˳�����");
		
		area=new JTextArea(15,20);
		scrollPane=new JScrollPane(area);
		scrollPane.setHorizontalScrollBarPolicy(       
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(   
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		//���ò��ֹ�����
		this.setLayout(new BorderLayout()); 
//		this.setLayout(new GridLayout(2,1));
		//�������Ϊ��ʽ���־�����ʾ������ᡢ�ݼ��Ϊ5������

      
		//������
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp1.add(jb4);
		jp1.add(jb5);
		
		jp2.add(jlb);
		
//		this.add(jp1,BorderLayout.WEST);
//		this.add(jp2,BorderLayout.CENTER);
//		this.add(jp3,BorderLayout.EAST);
		
		//���뵽JFrame��
		this.add(jp1,BorderLayout.NORTH);
		this.add(area,BorderLayout.CENTER);
		
		this.setSize(650, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		 
	}
	


}

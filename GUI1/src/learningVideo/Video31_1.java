package learningVideo;
/*
 * ��ϰʹ��swing�������ѡ���������ѡ�����
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
		
		jlb1=new JLabel("����ϲ�����˶�");
		jlb2=new JLabel("����Ա�");
		jb1=new JButton("ע���û�");
		jb2=new JButton("ȡ��ע��");
		
		jcb1=new JCheckBox("����");
		jcb2=new JCheckBox("����");
		jcb3=new JCheckBox("����");
		
		jrb1=new JRadioButton("��");
		jrb2=new JRadioButton("Ů");
		//һ��Ҫ��jrb1��jrb2,���뵽һ��ButtonGroup��
		bg=new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(3,1));
		//������
		jp1.add(jlb1);
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		jp2.add(jlb2);
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		//���뵽JFrame��
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}

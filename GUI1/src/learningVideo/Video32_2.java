package learningVideo;
import java.awt.GridLayout;
/*
 * JComboBox,JList,JScrollPane���
 */
import javax.swing.*;
public class Video32_2 extends JFrame
{
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args)
	{
		Video32_2 video32_2=new Video32_2();
	}
	public Video32_2()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		
		jlb1=new JLabel("���ļ�����");
		jlb2=new JLabel("��ϲ��ȥ���εĵ���");
		
		String []jg={"����","���","����","����","�㶫"};
		jcb=new JComboBox(jg);
		
		String []dd={"��ͷ","����","��β","����","����","տ��","����"};
		jlist=new JList(dd);
		//������ϣ����ʾ������
		jlist.setVisibleRowCount(3);
		jsp=new JScrollPane(jlist);
		
		//���ò��ֹ�����
		this.setLayout(new GridLayout(2,1));
		
		jp1.add(jlb1);
		jp1.add(jcb);
		
		jp2.add(jlb2);
		jp2.add(jsp);
		
		//���뵽JFrame��
		this.add(jp1);
		this.add(jp2);
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

package learningVideo;
/*
 * swing �������ִ���JSplitPane �������������
 */
import java.awt.*;
import javax.swing.*;
public class Video32_3 extends JFrame
{
	JSplitPane jsp;
	JList jlist;
	JLabel jl1;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video32_3 video32_3=new Video32_3();
	}

	public Video32_3()
	{
		String []words={"boy","girl","man","woman"};
		jlist=new JList(words);
		
		//���ʰ����ͼƬ������һ��"\"��������"/"����
		jl1=new JLabel(new ImageIcon("images//java ��ҵ1.PNG"));
		//��ִ���
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl1);
		//���Ա仯��������
		jsp.setOneTouchExpandable(true);
		
		//������
		this.add(jsp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
}

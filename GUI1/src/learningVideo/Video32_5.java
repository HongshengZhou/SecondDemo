package learningVideo;
import java.awt.*;
import javax.swing.*;
/*
 * JTabbedPane ѡ�����ҳǩ�����
 */
public class Video32_5 extends JFrame
{
	//��������
	JLabel jl1;
	
	//�ϲ�����
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//�в�����
	JTabbedPane jtp;  // ѡ�����
	JPanel jp2,jp3,jp4;
	
	JLabel jl2,jl3,jl4,jl5;
	JTextField jtf;
	JPasswordField jpf;
	JButton jb4;
	JCheckBox jcb1,jcb2;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video32_5 video32_5=new Video32_5();
	}

	public Video32_5()
	{
		//�������
		jl2=new JLabel("QQ����",JLabel.CENTER);
		jl3=new JLabel("QQ����",JLabel.CENTER);
		jl4=new JLabel("��������",JLabel.CENTER);
		
		//����������ʽ
		jl4.setFont(new Font("����",Font.PLAIN,16));
		//����������ɫ����
		jl4.setForeground(Color.BLUE);
		jl5=new JLabel("�������뱣��",JLabel.CENTER);
		//ʹ����ƶ����˴����һ������
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jtf=new JTextField();
		jpf=new JPasswordField();
		//button �з�ͼƬ
		jb4=new JButton(new ImageIcon("images//�ṷ.PNG"));
		jcb1=new JCheckBox("�����¼");
		jcb2=new JCheckBox("��ס����");
		
		//��������
		jl1=new JLabel(new ImageIcon("images//ͼƬ.PNG"));
		
		//�ϲ�����
		jp1=new JPanel();
		jb1=new JButton("��¼");
		jb2=new JButton("ȡ��");
		jb3=new JButton("��");
		
		//�в�����
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.RED);
		jp4=new JPanel();
		jp4.setBackground(new Color(0,0,255));
		
		//�������ӵ�ѡ�������
		//��һ����������ѡ����ƣ��ڶ������������������
		jtp.add("QQ����",jp2);
		jtp.add("�ֻ�����",jp3);
		jtp.add("��������",jp4);
		
		//���ò���
		jp2.setLayout(new GridLayout(3,3));
		
		//������
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		jp2.add(jl2);
		jp2.add(jtf);
		jp2.add(jb4);
		jp2.add(jl3);
		jp2.add(jpf);
		jp2.add(jl4);
		jp2.add(jcb1);
		jp2.add(jcb2);
		jp2.add(jl5);
		
		jtp.add(jp2);
		jtp.add(jp3);
		jtp.add(jp4);
		
		this.add(jl1,BorderLayout.NORTH);
		this.add(jtp);
		this.add(jp1,BorderLayout.SOUTH);
		
		this.setIconImage((new ImageIcon("images//IMG0150A.jpg")).getImage());
		this.setTitle("QQ��¼����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
}

package learningVideo;
import java.awt.*;
import javax.swing.*;
public class Video33_1 extends JFrame
{
	MyPanel2 mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video33_1 video33_1=new Video33_1();
	}

	public Video33_1()
	{
		mp=new MyPanel2();
		
		this.add(mp);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
//����һ��MyPanel�����Լ�����壬�����ڻ�ͼ��ʵ�ֻ�ͼ������
class MyPanel2 extends JPanel
{
	//����JPnel��paint����
	//Graphics �ǻ�ͼ����Ҫ�࣬����԰�������һֻ����
	public void paint(Graphics g)
	{
		//1.���ø��ຯ����ɳ�ʼ��
		//��仰��������
		super.paint(g);
		//�Ȼ�һ��Բ
		//g.drawOval(10, 10, 30, 30);
		//��һ�������β�������ɫ
		//g.setColor(Color.cyan);
		//g.fillRect(10, 10, 40, 60);
		
//		������ϻ�ͼƬ,ͼƬӦ����src ����
//		Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/�ṷ.PNG"));
//		��ʾ,�ֱ����ͼƬ�����Ͻ����꣬ͼƬ�Ŀ�͸�
//	    g.drawImage(im, 90, 90, 114, 40, this);
	    
	    //������ϻ���
	    g.setColor(Color.red);
	    g.setFont(new Font("���Ĳ���",Font.BOLD,30));
	    g.drawString("�������", 100,100);
	}
}

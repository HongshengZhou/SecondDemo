package learningVideo;
/*
 * ����˳����Ժ���swing �������ʱ���ȼ̳�JFrame���ٰ���Ҫ��swing ���
 * ���嵽main ����ǰ�����ڹ��캯������1.�ȴ������     /2.������     /3.������
 * һϵ�еĲ���
 */
import java.awt.*;
import javax.swing.*;
public class Video29_3 extends JFrame
{
	//����Ҫ��swing �������������
    JButton jb1=null;
	public static void main(String[] args)
	{
		Video29_3 video29_3=new Video29_3();
	}
	//���캯��
	public Video29_3()
	{
		        //1.�ȴ������
		        jb1=new JButton("���ǰ�ť");
		        
		        //2.������
		        this.add(jb1);
		        
		        //3.������һϵ�еĲ���
				//��Ϊ�̳���JFrame,���Կ�����this
				this.setTitle("Hello");
				//���ô�С��������
				//��Ϊ100����Ϊ200
				this.setSize(100, 200);
				//�ɸı������ʾ�ĵط�
				this.setLocation(100, 200);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
				//��ֹ�û��ı䴰�ڴ�С
				this.setResizable(false);
	}
}

package learningVideo;
/*
 * ���ܣ�
 * 1.ʵ������Ƴ������������з�Ӧ
 * 2.������ʱ��Ҫ֪������������
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Video36_1 extends JFrame
{
	MyPanel6 mp=null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video36_1 video36_1=new Video36_1();
	}
	public Video36_1()
	{
		mp=new MyPanel6();
		
		this.add(mp);
		
		this.addMouseListener(mp);
		this.addKeyListener(mp);
		this.addMouseMotionListener(mp);
		this.addWindowListener(mp);
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

//1.��MyPanel ֪����갴�µ���Ϣ������֪�������λ��(x,y)
//2.��MyPanel ֪���ĸ�������
//3.��MyPanel ֪������ƶ�����ק
//4.��MyPanel ֪�����ڵı仯���رգ���󻯣���С����

class MyPanel6 extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

	@Override
	//1.�����
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("�������x="+arg0.getX()+" y="+arg0.getY());
	}

	@Override
	//2.����ƶ���MyPanel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�������");
	}

	@Override
	//3.����뿪MyPanel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("�������");
	}

	@Override
	//4.��갴��
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//5.����ɿ�
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//������
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub 
		//��arg0.getKeyKode()����� ��ֵ��
		System.out.println(arg0.getKeyChar()+"��������");
	}

	@Override
	//���ɿ�
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//������        ����F1���޷����������
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//�����ק
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//����ƶ�
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("��굱ǰ���� x"+arg0.getX());
	}

	@Override
	//���ڼ�����
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");
	}

	@Override
	//���ڹر�
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//�������ڹر�
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
	}

	@Override
	//������С��
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//���ڴ�
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}
}
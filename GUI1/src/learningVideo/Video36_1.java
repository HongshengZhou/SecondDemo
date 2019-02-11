package learningVideo;
/*
 * 功能：
 * 1.实现鼠标移出及移入面板的有反应
 * 2.点击面板时需要知道这个点的坐标
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

//1.让MyPanel 知道鼠标按下的消息，并且知道点击的位置(x,y)
//2.让MyPanel 知道哪个键按下
//3.让MyPanel 知道鼠标移动，拖拽
//4.让MyPanel 知道窗口的变化（关闭，最大化，最小化）

class MyPanel6 extends JPanel implements MouseListener,KeyListener,MouseMotionListener,WindowListener
{
	public void paint(Graphics g)
	{
		super.paint(g);
	}

	@Override
	//1.鼠标点击
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("鼠标点击了x="+arg0.getX()+" y="+arg0.getY());
	}

	@Override
	//2.鼠标移动到MyPanel
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标来了");
	}

	@Override
	//3.鼠标离开MyPanel
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标走了");
	}

	@Override
	//4.鼠标按下
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//5.鼠标松开
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//键按下
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub 
		//而arg0.getKeyKode()是针对 码值的
		System.out.println(arg0.getKeyChar()+"键被按下");
	}

	@Override
	//键松开
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//键输入        （但F1等无法触发这个）
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//鼠标拖拽
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//鼠标移动
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("鼠标当前坐标 x"+arg0.getX());
	}

	@Override
	//窗口激活了
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated");
	}

	@Override
	//窗口关闭
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//窗口正在关闭
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowClosing");
	}

	@Override
	//窗口最小化
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
	//窗口打开
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("windowOpened");
	}
}
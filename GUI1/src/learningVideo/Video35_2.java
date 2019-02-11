package learningVideo;
/*
 * 功能：加深对事件处理机制的理解
 * 1.通过上下左右键，来控制一个小球的位置
 */
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Video35_2 extends JFrame
{
	MyPanel5 mp =null;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Video35_2 video35_2=new Video35_2();
	}

	public Video35_2()
	{
		mp=new MyPanel5();
		
		this.add(mp);
		
		this.addKeyListener(mp);
		
		this.setSize(400, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//定义自己的面板
class MyPanel5 extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	//键被按下
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("键被按下"+(char)arg0.getKeyCode());
		
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN)
		{
			//加速
			y+=10;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_UP)
		{
			y--;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_LEFT)
		{
			x--;
		}
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			x++;
		}
		//调用repaint()函数，来重绘界面
		this.repaint();
	}

	@Override
	//键被释放
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//键的一个值被输出
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
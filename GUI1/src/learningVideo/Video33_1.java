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
//定义一个MyPanel（我自己的面板，是用于绘图和实现绘图的区域）
class MyPanel2 extends JPanel
{
	//覆盖JPnel的paint方法
	//Graphics 是绘图的重要类，你可以把它理解成一只画笔
	public void paint(Graphics g)
	{
		//1.调用父类函数完成初始化
		//这句话，不能少
		super.paint(g);
		//先画一个圆
		//g.drawOval(10, 10, 30, 30);
		//画一个填充矩形并设置颜色
		//g.setColor(Color.cyan);
		//g.fillRect(10, 10, 40, 60);
		
//		在面板上画图片,图片应放在src 下面
//		Image im=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/酷狗.PNG"));
//		显示,分别代表图片，左上角坐标，图片的宽和高
//	    g.drawImage(im, 90, 90, 114, 40, this);
	    
	    //在面板上画字
	    g.setColor(Color.red);
	    g.setFont(new Font("华文彩云",Font.BOLD,30));
	    g.drawString("祖国万岁", 100,100);
	}
}

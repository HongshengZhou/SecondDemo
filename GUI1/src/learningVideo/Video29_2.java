package learningVideo;
/*
 * 调整顺序前
 */
import java.awt.*;
import javax.swing.*;
public class Video29_2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		JFrame jf=new JFrame();
		JButton jb1=new JButton("我是按钮");
		
		jf.setTitle("Hello");
		//设置大小，以像素
		jf.setSize(200, 200);
		jf.add(jb1);
		jf.setLocation(100, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

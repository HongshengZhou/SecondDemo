package learningVideo;
/*
 * swing 组件：拆分窗格：JSplitPane 属于容器类组件
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
		
		//访问包里的图片，可用一个"\"或者两个"/"访问
		jl1=new JLabel(new ImageIcon("images//java 作业1.PNG"));
		//拆分窗格
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jlist,jl1);
		//可以变化（伸缩）
		jsp.setOneTouchExpandable(true);
		
		//添加组件
		this.add(jsp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
}

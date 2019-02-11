package learningVideo;
/*
 * 调整顺序后，以后有swing 组件开发时，先继承JFrame，再把需要的swing 组件
 * 定义到main 函数前，再在构造函数处，1.先创建组件     /2.添加组件     /3.再设置
 * 一系列的参数
 */
import java.awt.*;
import javax.swing.*;
public class Video29_3 extends JFrame
{
	//把需要的swing 组件定义在这里
    JButton jb1=null;
	public static void main(String[] args)
	{
		Video29_3 video29_3=new Video29_3();
	}
	//构造函数
	public Video29_3()
	{
		        //1.先创建组件
		        jb1=new JButton("我是按钮");
		        
		        //2.添加组件
		        this.add(jb1);
		        
		        //3.再设置一系列的参数
				//因为继承了JFrame,所以可以用this
				this.setTitle("Hello");
				//设置大小，以像素
				//宽为100，长为200
				this.setSize(100, 200);
				//可改变界面显示的地方
				this.setLocation(100, 200);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
				//禁止用户改变窗口大小
				this.setResizable(false);
	}
}

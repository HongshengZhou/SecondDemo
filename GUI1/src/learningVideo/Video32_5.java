package learningVideo;
import java.awt.*;
import javax.swing.*;
/*
 * JTabbedPane 选项卡窗格（页签组件）
 */
public class Video32_5 extends JFrame
{
	//北部区域
	JLabel jl1;
	
	//南部区域
	JButton jb1,jb2,jb3;
	JPanel jp1;
	
	//中部区域
	JTabbedPane jtp;  // 选项卡窗格
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
		//创建组件
		jl2=new JLabel("QQ号码",JLabel.CENTER);
		jl3=new JLabel("QQ密码",JLabel.CENTER);
		jl4=new JLabel("忘记密码",JLabel.CENTER);
		
		//设置字体样式
		jl4.setFont(new Font("宋体",Font.PLAIN,16));
		//设置字体颜色方法
		jl4.setForeground(Color.BLUE);
		jl5=new JLabel("申请密码保护",JLabel.CENTER);
		//使鼠标移动到此处变成一个手型
		jl5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jtf=new JTextField();
		jpf=new JPasswordField();
		//button 中放图片
		jb4=new JButton(new ImageIcon("images//酷狗.PNG"));
		jcb1=new JCheckBox("隐身登录");
		jcb2=new JCheckBox("记住密码");
		
		//北部区域
		jl1=new JLabel(new ImageIcon("images//图片.PNG"));
		
		//南部区域
		jp1=new JPanel();
		jb1=new JButton("登录");
		jb2=new JButton("取消");
		jb3=new JButton("向导");
		
		//中部区域
		jtp=new JTabbedPane();
		jp2=new JPanel();
		jp3=new JPanel();
		jp3.setBackground(Color.RED);
		jp4=new JPanel();
		jp4.setBackground(new Color(0,0,255));
		
		//将面板添加到选项卡窗格上
		//第一个参数代表选项卡名称，第二个参数代表面板名称
		jtp.add("QQ号码",jp2);
		jtp.add("手机号码",jp3);
		jtp.add("电子邮箱",jp4);
		
		//设置布局
		jp2.setLayout(new GridLayout(3,3));
		
		//添加组件
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
		this.setTitle("QQ登录界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setLocation(200, 200);
		this.setVisible(true);
	}
}

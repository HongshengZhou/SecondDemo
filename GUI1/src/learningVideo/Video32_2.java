package learningVideo;
import java.awt.GridLayout;
/*
 * JComboBox,JList,JScrollPane组件
 */
import javax.swing.*;
public class Video32_2 extends JFrame
{
	JPanel jp1,jp2;
	JLabel jlb1,jlb2;
	JComboBox jcb;
	JList jlist;
	JScrollPane jsp;
	public static void main(String[] args)
	{
		Video32_2 video32_2=new Video32_2();
	}
	public Video32_2()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		
		jlb1=new JLabel("您的籍贯是");
		jlb2=new JLabel("您喜欢去旅游的地区");
		
		String []jg={"北京","天津","湖南","湖北","广东"};
		jcb=new JComboBox(jg);
		
		String []dd={"汕头","潮州","汕尾","阳江","揭阳","湛江","广州"};
		jlist=new JList(dd);
		//设置你希望显示多少行
		jlist.setVisibleRowCount(3);
		jsp=new JScrollPane(jlist);
		
		//设置布局管理器
		this.setLayout(new GridLayout(2,1));
		
		jp1.add(jlb1);
		jp1.add(jcb);
		
		jp2.add(jlb2);
		jp2.add(jsp);
		
		//加入到JFrame中
		this.add(jp1);
		this.add(jp2);
		
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

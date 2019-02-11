package learningVideo4;
/*
 * 功能：我的记事本（界面+功能）
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Video46_1 extends JFrame implements ActionListener
{
	//定义需要的组件
	JTextArea jta=null;
	//菜单条
	JMenuBar jmb=null;
	//第一JMenu
	JMenu jm1=null;
	//定义JMenuItem
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args)
	{
		Video46_1 video46_1=new Video46_1();
	}
	
	//构造函数
	public Video46_1()
	{
		//创建jta
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("文件");
		//设置助记符
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("打开",new ImageIcon("酷狗.PNG"));
		
		//注册监听
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2=new JMenuItem("保存");
		
		//对保存菜单处理
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//加入
		this.setJMenuBar(jmb);
		//把jm1放入jmb
		jmb.add(jm1);
		//把item放入Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//放入到JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//判断是哪个菜单被选中
		if(arg0.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//JFileChooser 文件选择组件
			JFileChooser jfc1=new JFileChooser();
			//设置名字
			jfc1.setDialogTitle("请选择文件....");
			//默认方式
			jfc1.showOpenDialog(null);
			//显示
			jfc1.setVisible(true);
			
			//得到用户选择的文件全路径
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//从文件中读取信息并显示到jta
				String s="";
				String allCon="";
				while((s=br.readLine())!=null)
				{
					allCon+=s+"\r\n";
				}
				//放置大jta即可
				jta.setText(allCon);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fr.close();
					br.close();
				} catch (Exception e) {
					// TODO Auto-generatede.
				}
			}
		}
		else if(arg0.getActionCommand().equals("save"))
		{
			//出现保存对话框
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("另存为....");
			//按默认的方式显示
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			//得到用户希望把文件保存到何处，文件全路径
			String file=jfc.getSelectedFile().getAbsolutePath();
			
			//准备写入到指定文件
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				//自己优化，文件较大时缓存进去
				bw.write(this.jta.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try {
					fw.close();
					bw.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

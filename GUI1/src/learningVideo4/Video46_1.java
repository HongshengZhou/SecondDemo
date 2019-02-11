package learningVideo4;
/*
 * ���ܣ��ҵļ��±�������+���ܣ�
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Video46_1 extends JFrame implements ActionListener
{
	//������Ҫ�����
	JTextArea jta=null;
	//�˵���
	JMenuBar jmb=null;
	//��һJMenu
	JMenu jm1=null;
	//����JMenuItem
	JMenuItem jmi1=null;
	JMenuItem jmi2=null;
	
	public static void main(String[] args)
	{
		Video46_1 video46_1=new Video46_1();
	}
	
	//���캯��
	public Video46_1()
	{
		//����jta
		jta=new JTextArea();
		jmb=new JMenuBar();
		jm1=new JMenu("�ļ�");
		//�������Ƿ�
		jm1.setMnemonic('F');
		jmi1=new JMenuItem("��",new ImageIcon("�ṷ.PNG"));
		
		//ע�����
		jmi1.addActionListener(this);
		jmi1.setActionCommand("open");
		jmi2=new JMenuItem("����");
		
		//�Ա���˵�����
		jmi2.addActionListener(this);
		jmi2.setActionCommand("save");
		
		//����
		this.setJMenuBar(jmb);
		//��jm1����jmb
		jmb.add(jm1);
		//��item����Menu
		jm1.add(jmi1);
		jm1.add(jmi2);
		
		//���뵽JFrame
		this.add(jta);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//�ж����ĸ��˵���ѡ��
		if(arg0.getActionCommand().equals("open"))
		{
			//System.out.println("open");
			
			//JFileChooser �ļ�ѡ�����
			JFileChooser jfc1=new JFileChooser();
			//��������
			jfc1.setDialogTitle("��ѡ���ļ�....");
			//Ĭ�Ϸ�ʽ
			jfc1.showOpenDialog(null);
			//��ʾ
			jfc1.setVisible(true);
			
			//�õ��û�ѡ����ļ�ȫ·��
			String filename=jfc1.getSelectedFile().getAbsolutePath();
			//System.out.println(filename);
			
			FileReader fr=null;
			BufferedReader br=null;
			try {
				fr=new FileReader(filename);
				br=new BufferedReader(fr);
				
				//���ļ��ж�ȡ��Ϣ����ʾ��jta
				String s="";
				String allCon="";
				while((s=br.readLine())!=null)
				{
					allCon+=s+"\r\n";
				}
				//���ô�jta����
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
			//���ֱ���Ի���
			JFileChooser jfc=new JFileChooser();
			jfc.setDialogTitle("���Ϊ....");
			//��Ĭ�ϵķ�ʽ��ʾ
			jfc.showSaveDialog(null);
			jfc.setVisible(true);
			
			//�õ��û�ϣ�����ļ����浽�δ����ļ�ȫ·��
			String file=jfc.getSelectedFile().getAbsolutePath();
			
			//׼��д�뵽ָ���ļ�
			FileWriter fw=null;
			BufferedWriter bw=null;
			try {
				fw=new FileWriter(file);
				bw=new BufferedWriter(fw);
				//�Լ��Ż����ļ��ϴ�ʱ�����ȥ
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

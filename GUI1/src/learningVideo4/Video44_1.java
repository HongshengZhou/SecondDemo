package learningVideo4;
/*
 * ���ܣ�File��Ļ����÷�
 */
import java.io.*;
public class Video44_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		//����һ���ļ�����
//		File f=new File("c:\\bootmgr");
//		//�õ��ļ���·��
//		System.out.println("�ļ�·��"+f.getAbsolutePath());
//		//�õ��ļ��Ĵ�ѧ���ֽ���
//		System.out.println("�ļ���С"+f.length());
//		System.out.println("�ɶ�"+f.canRead());
		
//		//�����ļ��ʹ����ļ���
//		File f=new File("d:\\ff\\asp.txt");
//		if(!f.exists())
//		{
//			//���Դ���
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		else 
//		{
//			System.out.println("���ļ������ܴ���");
//		}
		
//		File f=new File("d:\\ff");
//		
//		if(f.isDirectory())
//		{
//			System.out.println("�ļ��д���");
//		}
//		else
//		{
//			f.mkdir();
//		}
		
		//�г�һ���ļ����������е��ļ�
		File f=new File("d:\\ff");
		if(f.isDirectory())
		{
			File lists[]=f.listFiles();
			for(int i=0;i<lists.length;i++)
			{
				System.out.println("�ļ�����"+lists[i].getName());
			}
		}
	}

}

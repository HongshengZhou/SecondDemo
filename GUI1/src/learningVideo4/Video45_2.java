package learningVideo4;
/*
 * ���ܣ���ʾ�ļ��ַ����İ���
 */
import java.io.*;
public class Video45_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�ļ�ȡ���ַ���������������
		FileReader fr=null;
		//д�뵽�ļ����������
		FileWriter fw=null;
		
		try {
			//����fr����
			fr=new FileReader("d:\\ss.txt");
			//�����������
			fw=new FileWriter("d:\\new.txt");
			int n=0;//��¼ʵ�ʶ�ȡ���ַ���
			//���뵽�ڴ�
			char c[]=new char[1024];
			while((n=fr.read(c))!=-1)
			{
//				String s=new String(c,0,n);
//				System.out.println(s);
				//����Ҳ����fw.write(c,0,n);
				fw.write(c);
			}
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			try {
				fr.close();
				fw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package learningVideo4;
/*
 * ���ܣ�ͼƬ����
 * ע�⣺�޷����������ڴ������c�̣�ֻ�ܴ�c �����뵽�ڴ�
 */
import java.io.*;
public class Video45_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//˼·���Ȱ�ͼƬ���뵽�ڴ�->д�뵽ĳ���ļ�
		//��Ϊ�Ƕ������ļ������ֻ�����ֽ������
		
		//������
		FileInputStream fis=null;
		//�����
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("d:\\export.jpg");
			fos=new FileOutputStream("g:\\export.jpg");
			
			byte buf[]=new byte[512];
			int n=0;//��¼ʵ�ʶ�ȡ�����ֽ���
			//ѭ����ȡ
			while((n=fis.read(buf))!=-1)
			{
				//�����ָ���ļ�
				fos.write(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			//�رմ򿪵��ļ���
			try {
				fis.close();
				fos.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

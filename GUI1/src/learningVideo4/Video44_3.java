package learningVideo4;
/*
 * ���ܣ���ʾFileOutputStream��ʹ��
 */
import java.io.*;
public class Video44_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f=new File("d:\\ss.txt");
		
		//�ֽ������
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(f);
			//ע��ü�\r(�س�)
			String s="�Ǻ���hello,world\r\n";
			String s1="�й��ã�";
			//�����ֽ�����
			//byte []bytes=new byte[1024];
			//��ΰ�String->bytes����
			
			fos.write(s.getBytes());
			fos.write(s1.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

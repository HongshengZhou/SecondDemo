package learningVideo4;
/*
 * ��ʾFileInputStream���ʹ��
 */
import java.io.*;
public class Video44_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�õ�һ���ļ�����f->c:\\bootmgr
		File f=new File("c:\\bootmgr");
		FileInputStream fis=null;
		
		try {
			//��ΪFileû�ж�д��������������Ҫʹ��InputStream
			fis=new FileInputStream(f);
			
			//����һ���ֽ����飬�൱�ڻ���
			byte []bytes=new byte[1024];
			int n=0;//�õ�ʵ�ʶ�ȡ�����ֽ���
			//ѭ����ȡ
			while((n=fis.read(bytes))!=-1)
			{
				//���ֽ�ת��String
				String s=new String(bytes,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//�ر��ļ��������������
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

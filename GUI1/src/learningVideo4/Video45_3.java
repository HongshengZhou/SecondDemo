package learningVideo4;
/*
 * ���ܣ���ʾ�����ַ�������
 */
import java.io.*;
public class Video45_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//�ȴ���FileReader����
			FileReader fr=new FileReader("d:\\ss.txt");
			br=new BufferedReader(fr);
			//����FileWriter����
			FileWriter fw=new FileWriter("d:\\����");
			bw=new BufferedWriter(fw);
			
			//ѭ����ȡ�ļ�
			String s="";
			while((s=br.readLine())!=null)
			{
//				System.out.println(s);
				//���������
				bw.write(s+"\r\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
				bw.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

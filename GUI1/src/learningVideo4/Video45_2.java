package learningVideo4;
/*
 * 功能：演示文件字符流的案例
 */
import java.io.*;
public class Video45_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//文件取出字符流对象（输入流）
		FileReader fr=null;
		//写入到文件（输出流）
		FileWriter fw=null;
		
		try {
			//创建fr对象
			fr=new FileReader("d:\\ss.txt");
			//创建输出对象
			fw=new FileWriter("d:\\new.txt");
			int n=0;//记录实际读取的字符数
			//读入到内存
			char c[]=new char[1024];
			while((n=fr.read(c))!=-1)
			{
//				String s=new String(c,0,n);
//				System.out.println(s);
				//这里也可以fw.write(c,0,n);
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

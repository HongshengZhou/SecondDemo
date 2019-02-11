package learningVideo4;
/*
 * 功能：演示FileOutputStream的使用
 */
import java.io.*;
public class Video44_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f=new File("d:\\ss.txt");
		
		//字节输出流
		FileOutputStream fos=null;
		
		try {
			fos=new FileOutputStream(f);
			//注意得加\r(回车)
			String s="呵呵哒hello,world\r\n";
			String s1="中国好！";
			//定义字节数组
			//byte []bytes=new byte[1024];
			//如何把String->bytes数组
			
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

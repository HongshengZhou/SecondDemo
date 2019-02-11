package learningVideo4;
/*
 * 功能：图片拷贝
 * 注意：无法将东西从内存输出到c盘，只能从c 盘输入到内存
 */
import java.io.*;
public class Video45_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//思路：先把图片读入到内存->写入到某个文件
		//因为是二进制文件，因此只能用字节流完成
		
		//输入流
		FileInputStream fis=null;
		//输出流
		FileOutputStream fos=null;
		
		try {
			fis=new FileInputStream("d:\\export.jpg");
			fos=new FileOutputStream("g:\\export.jpg");
			
			byte buf[]=new byte[512];
			int n=0;//记录实际读取到的字节数
			//循环读取
			while((n=fis.read(buf))!=-1)
			{
				//输出到指定文件
				fos.write(buf);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally
		{
			//关闭打开的文件流
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

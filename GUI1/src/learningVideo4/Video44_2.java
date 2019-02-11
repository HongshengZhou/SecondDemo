package learningVideo4;
/*
 * 演示FileInputStream类的使用
 */
import java.io.*;
public class Video44_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//得到一个文件对象f->c:\\bootmgr
		File f=new File("c:\\bootmgr");
		FileInputStream fis=null;
		
		try {
			//因为File没有读写的能力，所以需要使用InputStream
			fis=new FileInputStream(f);
			
			//定义一个字节数组，相当于缓存
			byte []bytes=new byte[1024];
			int n=0;//得到实际读取到的字节数
			//循环读取
			while((n=fis.read(bytes))!=-1)
			{
				//把字节转成String
				String s=new String(bytes,0,n);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//关闭文件流必须放在这里
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

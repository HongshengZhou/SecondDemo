package learningVideo4;
/*
 * 功能：演示缓冲字符流案例
 */
import java.io.*;
public class Video45_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br=null;
		BufferedWriter bw=null;
		try {
			//先创建FileReader对象
			FileReader fr=new FileReader("d:\\ss.txt");
			br=new BufferedReader(fr);
			//创建FileWriter对象
			FileWriter fw=new FileWriter("d:\\赵云");
			bw=new BufferedWriter(fw);
			
			//循环读取文件
			String s="";
			while((s=br.readLine())!=null)
			{
//				System.out.println(s);
				//输出到磁盘
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

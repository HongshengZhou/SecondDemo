package learningVideo2;
/*
 * 演示如果通过继承Thread来开发程序
 */
public class Video38_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建一个Cat对象
		Cat cat=new Cat();
		//启动线程，会导致run函数的运行
		cat.start();
	}

}

class Cat extends Thread
{
	//重写run函数
	public void run()
	{
		int times=0;
		while(true)
		{
			//休眠一秒,1000表示1000毫秒
			//sleep就会让该线程进入到Blocked 状态，并释放资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    times++;
			System.out.println("hello,world"+times);
			if(times==10)
			{
				break;
			}
		}
	}
}
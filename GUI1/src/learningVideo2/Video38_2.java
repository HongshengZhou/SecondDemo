package learningVideo2;
/*
 * 演示如果通过实现Runnable接口来开发程序
 */
public class Video38_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//注意启动和Thread 的区别
		Dog dog=new Dog();
		//创建一个Thread 对象
		Thread t=new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable
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
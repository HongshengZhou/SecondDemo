package learningVideo2;
/*
 * 两个线程同时运行的案例
 */
public class Video39_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig=new Pig(10);
		Bird bird=new Bird(10);
		Thread t1=new Thread(pig);
		Thread t2=new Thread(bird);
		t1.start();
		t2.start();
	}

}
//打印
class Pig implements Runnable
{
	int n=0;
	int times=0;
	public Pig(int n)
	{
		this.n=n;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			times++;
			System.out.println("我是一个线程，在输出第 "+times+" 个hello,world");
			if(times==n)
			{
				break;
			}
		}
	}
}


//算数学题
class Bird implements Runnable
{
	int n=0;
	int res=0;
	int times=0;
	public Bird(int n)
	{
		this.n=n;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res+=(++times);
			System.out.println("当前结果是："+res);
			if(times==n)
			{
				System.out.println("最后结果是"+res);
				break;
			}
		}
	}
}
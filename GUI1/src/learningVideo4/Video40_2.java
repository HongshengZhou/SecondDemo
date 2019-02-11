package learningVideo4;
/*
 * synchronized(Object){你要同步的代码}
 * 解决了java线程的同步
 */
public class Video40_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//这里创建一个窗口
		TicketWindow tw1=new TicketWindow();
//		TicketWindow tw2=new TicketWindow();
//		TicketWindow tw3=new TicketWindow();
		
		//使用三个线程同时启动
		Thread t1=new Thread(tw1);
		Thread t2=new Thread(tw1);
		Thread t3=new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}

}

//售票窗口类
class TicketWindow implements Runnable
{
	//一共两千张票,另一种思路就是在int前加上static
	private int nums=2000;
    private Pig myPig=new Pig();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//认为if  else 要保证其原子性[同步代码块]
			//里面的对象也可以是this
			synchronized(myPig)
			{
				//先判断是否还有票
				if(nums>0)
				{
					//显示售票信息
					//Thread.currentThread().getName()表示当前线程的名字
					System.out.println(Thread.currentThread().getName()+"在售出第 "+nums+" 票");
					//出票速度是1秒出一张
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					nums--;
				}
				else
				{
					//售票结束
					break;
				}
			}
		}
	}
	
}

class Pig
{
	
}
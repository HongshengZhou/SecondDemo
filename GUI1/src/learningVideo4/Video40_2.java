package learningVideo4;
/*
 * synchronized(Object){��Ҫͬ���Ĵ���}
 * �����java�̵߳�ͬ��
 */
public class Video40_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ﴴ��һ������
		TicketWindow tw1=new TicketWindow();
//		TicketWindow tw2=new TicketWindow();
//		TicketWindow tw3=new TicketWindow();
		
		//ʹ�������߳�ͬʱ����
		Thread t1=new Thread(tw1);
		Thread t2=new Thread(tw1);
		Thread t3=new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}

}

//��Ʊ������
class TicketWindow implements Runnable
{
	//һ����ǧ��Ʊ,��һ��˼·������intǰ����static
	private int nums=2000;
    private Pig myPig=new Pig();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//��Ϊif  else Ҫ��֤��ԭ����[ͬ�������]
			//����Ķ���Ҳ������this
			synchronized(myPig)
			{
				//���ж��Ƿ���Ʊ
				if(nums>0)
				{
					//��ʾ��Ʊ��Ϣ
					//Thread.currentThread().getName()��ʾ��ǰ�̵߳�����
					System.out.println(Thread.currentThread().getName()+"���۳��� "+nums+" Ʊ");
					//��Ʊ�ٶ���1���һ��
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
					//��Ʊ����
					break;
				}
			}
		}
	}
	
}

class Pig
{
	
}
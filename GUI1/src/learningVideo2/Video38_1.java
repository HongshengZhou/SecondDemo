package learningVideo2;
/*
 * ��ʾ���ͨ���̳�Thread����������
 */
public class Video38_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��Cat����
		Cat cat=new Cat();
		//�����̣߳��ᵼ��run����������
		cat.start();
	}

}

class Cat extends Thread
{
	//��дrun����
	public void run()
	{
		int times=0;
		while(true)
		{
			//����һ��,1000��ʾ1000����
			//sleep�ͻ��ø��߳̽��뵽Blocked ״̬�����ͷ���Դ
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
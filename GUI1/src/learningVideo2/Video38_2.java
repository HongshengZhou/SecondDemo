package learningVideo2;
/*
 * ��ʾ���ͨ��ʵ��Runnable�ӿ�����������
 */
public class Video38_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ע��������Thread ������
		Dog dog=new Dog();
		//����һ��Thread ����
		Thread t=new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable
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
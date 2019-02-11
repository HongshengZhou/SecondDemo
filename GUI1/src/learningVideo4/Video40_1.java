package learningVideo4;
/*
 * 功能：演示使用线程的注意事项
 * 线程对象只能启动一个线程
 */
public class Video40_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Cat cat1=new Cat();
//		cat1.start();
//		cat1.start();
		
		Dog dog1=new Dog();
		Thread t=new Thread(dog1);
		Thread t2=new Thread(dog1);
		t.start();
		t2.start();
	}

}

//猫类
class Cat extends Thread
{
	public void run()
	{
		System.out.println("11");
	}
}
//狗类
class Dog implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("22");
	}
	
}
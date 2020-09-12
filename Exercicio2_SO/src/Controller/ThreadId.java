package Controller;

public class ThreadId extends Thread{
	
	public ThreadId() {
		super();
	}
	
	@Override
	public void run() {
		System.out.println("Id ==> " + getId());
	}
}

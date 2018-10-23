package museum;

public class East extends Thread {
	Control control;
	
	public East(Control control){
		this.control = control;
	}
	
	public void run(){
		while(true){
			System.out.println(Thread.currentThread().getName() + " is from East.");
			try {
				Thread.sleep(200);
				control.arrive();
			}
			catch(InterruptedException e) {};
		}
	}
}

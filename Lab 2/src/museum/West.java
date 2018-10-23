package museum;

public class West extends Thread {
	Control control;
	
	public West(Control control){
		this.control = control;
	}
	
	public void run(){
		while(true){
			System.out.println(Thread.currentThread().getName() + " is from West.");
			try {
				Thread.sleep(200);
				control.leave();
			}
			catch(InterruptedException e) {};
		}
	}
}

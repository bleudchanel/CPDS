package museum;

public class Director extends Thread {
	Control control;
	
	public Director(Control control){
		this.control = control;
	}
	
	public void run(){
		while(true){
			System.out.println("...");
			try{
				Thread.sleep(200);
				control.open();
				control.close();
			}
			catch(InterruptedException e) {};
		}
	}
}

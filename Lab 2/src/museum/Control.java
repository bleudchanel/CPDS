package museum;

public class Control {
	int count = 0;
	boolean opened = false;
	
	public Control(int count) {
	    this.count = count;
	}
	
	public synchronized void arrive() throws InterruptedException {
		while (!opened){
			System.out.println(Thread.currentThread().getName() + " has to wait");
			wait();
		}
		if (count < 5){
			++count;
			System.out.println(Thread.currentThread().getName() + " enters into the museum.");
		}
		if (count == 5) notifyAll();
		print_count();
	}
	
	public synchronized void leave() throws InterruptedException {
		while (count <= 0){
			System.out.println(Thread.currentThread().getName() + " has to wait");
			wait();
		}
		--count;
		System.out.println(Thread.currentThread().getName() + " leaves the museum.");
		print_count();
		
		if (count == 0){	
			notifyAll();
		}
	}
	
	public synchronized void open() throws InterruptedException {
		while (count > 0){
			System.out.println(Thread.currentThread().getName() + " has to wait to open.");
			wait();
		}	
		System.out.println(Thread.currentThread().getName() + " opens the museum.");
		opened = true;
		notifyAll();
	}
	
	public synchronized void close() throws InterruptedException {
		while (count < 5){
			System.out.println(Thread.currentThread().getName() + " has to wait to close.");
			wait();
			//opened = false;
		}
		System.out.println(Thread.currentThread().getName() + " closes the museum.");
		opened = false;
		notifyAll();
	}
	
	public synchronized void print_count() {
		System.out.println("people in the museum: " + count);
	}

}

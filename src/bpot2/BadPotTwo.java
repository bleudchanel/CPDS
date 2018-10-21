package bpot2;

public class BadPotTwo {
	private int servings = 0;
	private int capacity;
	
	public BadPotTwo(int capacity){
		this.capacity = capacity;
	}
	
	public void getserving() throws InterruptedException {
		if (servings == 0)
		{
			System.out.println(Thread.currentThread().getName() + " go walk");
			
		} else {
			Thread.sleep(200);
            --servings;
            System.out.println(Thread.currentThread().getName()+ " is served");
            print_servings();
		}
	}
	
	public  void fillpot() throws InterruptedException {
		if (servings > 0)
		{
			 System.out.println(Thread.currentThread().getName() + " go walk");
			 
		}
		else {
			// The bad behavior is caused by interference. While Thread is taking the Pot 
			// and access the getserving() method, another Thread might be already changing 
			// the servings value, or many threads can be using the same method at the same time,
			// and only the last value updated will be called, which also causes multiple messages
			// with the same value.
			Thread.sleep(200);
			servings = capacity;
	        System.out.println(Thread.currentThread().getName() + " fills the pot");
	        // wake up threads in Waiting Set in order to assure....
	        print_servings();
	        //notifyAll();
		} 
	}
	 
	public synchronized void print_servings() {
		 System.out.println("servings in the pot: " + servings);
	}
	
	
}

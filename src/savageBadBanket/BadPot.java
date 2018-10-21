package savageBadBanket;

public class BadPot {
	private int servings = 0;
	private int capacity;
	
	public BadPot(int capacity){
		this.capacity = capacity;
	}
	
	public synchronized void getserving() throws InterruptedException {
        // Condition synchronization: at least one serving available,
        // otherwise, go to the Waiting Set until the cook fill the pot
		//System.out.println("Servings: " + servings);
		if (servings == 0) {
        	
           System.out.println(Thread.currentThread().getName() + " has to wait");
           wait(); 
        }
		
		//Added the if statement to prevent negative values
		if (servings > 0){
			 --servings;
		     System.out.println(Thread.currentThread().getName() + " is served");
		}
       
        // when necessary, wake up threads  in Waiting Set in order to assure
        // a runnable cook
        if (servings == 0)
        {
        	System.out.println("Servings are low...");	
        	notifyAll();
        }
        print_servings();
    }
    
    public synchronized void fillpot() throws InterruptedException {
        //Condition synchronization: .....
        //....
        if (servings > 0) {
           System.out.println(Thread.currentThread().getName() + " has to wait");
           wait();    
        }
        servings = capacity;
        System.out.println(Thread.currentThread().getName() + " fills the pot");
        // wake up threads in Waiting Set in order to assure....
        print_servings();
        notifyAll();
    }
    
    //only for trace purposes
    public synchronized void print_servings() {
        System.out.println("servings in the pot: " + servings);
    }
}

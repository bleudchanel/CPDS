package badPotTwoRepaired;

public class Cook extends Thread {
	BadPotTwo pot;
	
	public Cook(BadPotTwo pot) {
		this.pot = pot;
	}
	
	public void run(){
		while(true){
			System.out.println("...");
			try{
				Thread.sleep(200);
				pot.fillpot();
			}
			catch(InterruptedException e) {};
		}
	}
}

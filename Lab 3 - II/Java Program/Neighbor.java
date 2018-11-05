package warringPeterson;

public class Neighbor extends Thread {
	private Flag flag;
	private Turn turn;
	public Neighbor(Flag flags, Turn turn) {
		this.flag = flags;
		this.turn = turn;
	}
	public void run() {
		while (true) {
		try {
			String name = Thread.currentThread().getName();
			System.out.println("try again, my name is: " + name);
			flag.set_true(name);
			turn.set(name);

			Thread.sleep((int)(200 * Math.random()));
			
			while ( (flag.query_flag(name) == true) && turn.is_my_turn(name)==false) {
				System.out.println(name + " waits");
				Thread.sleep(200);
			}
			System.out.println(name + " enters");
			Thread.sleep(400);
			System.out.println(name + " exits");
			Thread.sleep((int)(200 * Math.random()));
			flag.set_false(name);
		}
			catch (InterruptedException e) {};
		}
	}
}

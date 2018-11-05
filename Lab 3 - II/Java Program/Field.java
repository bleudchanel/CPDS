package warringPeterson;

public class Field {
	public static void main(String args[]) {
		Flag flag = new Flag();
		Turn turn = new Turn();

		Thread a = new Neighbor(flag, turn);
		Thread b = new Neighbor(flag, turn);

		a.setName("alice");
		b.setName("bob");

		a.start();
		b.start();
	}
}

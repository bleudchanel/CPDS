package museum;

public class Musem {
	public static void main(String args[]) {
		Control control = new Control(0);
		Thread a = new East(control);
		a.setName("Alice");
		Thread b = new East(control);
		b.setName("Bob");
		Thread c = new East(control);
		c.setName("Carl");
		Thread d = new East(control);
		d.setName("Dave");
		Thread e = new East(control);
		e.setName("Eva");
		Thread f = new West(control);
		f.setName("Frank");
		Thread g = new West(control);
		g.setName("Gio");
		Thread h = new West(control);
		h.setName("Hannah");
		Thread i = new West(control);
		i.setName("Ian");
		Thread j = new West(control);
		j.setName("Jean");
		Thread dir = new Director(control);
		dir.setName("Director");
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();
		g.start();
		h.start();
		//i.start();
		//j.start();
		dir.start();
	}
}

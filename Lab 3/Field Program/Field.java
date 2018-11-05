/* Homework: Safety & Progres (I)
 *
 *
 * Name: Carlos
 * Surname: Rojas Morales
 *
 * Name: Wilmer
 * Surname: Uruchi
 * 
 *
 */
package field;

public class Field {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Flags flags = new Flags();
        Thread a = new Neighbor(flags);
        //Thread a = new GreedyNeighbor(flags);
        a.setName("alice");
        Thread b = new Neighbor(flags);
        //Thread b = new GreedyNeighbor(flags);
        b.setName("bob");
        a.start();
        b.start();
    }
    
}

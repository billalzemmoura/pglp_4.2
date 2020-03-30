package pglp.pglp42;

/**
 * @author bill
 */
public class Soustraction implements SpecifiqueCommand {

	/**
	*/
	static private int soustraction;

     /**
	 */
	public final int apply(final int a, final int b) {
		soustraction = a - b;
		return soustraction;
	}

}

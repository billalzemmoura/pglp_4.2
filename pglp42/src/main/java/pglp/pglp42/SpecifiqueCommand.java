package pglp.pglp42;

/**
 * @author bill
 */
public interface SpecifiqueCommand extends CommandInterface {
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public int apply(int a, int b);
}

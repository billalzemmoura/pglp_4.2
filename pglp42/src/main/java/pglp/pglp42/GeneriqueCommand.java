package pglp.pglp42;

import java.util.Stack;

/**
 * @author bill
 */
public interface GeneriqueCommand extends CommandInterface {
//public void apply();

	/**
	 * @param pille
	 * @param a     :operand 1
	 * @param b     :operand 2
	 */
	void apply(Stack<Integer> pille, int a, int b);
}

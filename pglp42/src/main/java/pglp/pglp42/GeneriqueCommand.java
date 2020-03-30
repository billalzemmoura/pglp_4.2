package pglp.pglp42;

import java.util.Stack;

public interface GeneriqueCommand extends CommandInterface {
//public void apply();

	void apply(Stack<Integer> s, int a, int b);
}

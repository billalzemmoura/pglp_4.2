package pglp.pglp42;

import java.util.Stack;

public class Undo implements GeneriqueCommand {

	public void apply(Stack<Integer> s, int a, int b) {
		s.pop();
		s.push(a);
		s.push(b);

	}

}

package pglp.pglp42;

import java.util.Stack;

public class Quit implements GeneriqueCommand {

	@Override
	public void apply(Stack<Integer> s, int a, int b) {
		System.exit(0);

	}

}

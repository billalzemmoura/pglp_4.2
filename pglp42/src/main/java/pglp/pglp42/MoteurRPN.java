package pglp.pglp42;

import java.util.HashMap;
import java.util.Stack;

public class MoteurRPN extends Interpreteur {

	final HashMap<String, SpecifiqueCommand> map = new HashMap<String, SpecifiqueCommand>();

	public void Addcommande(String nomCom, SpecifiqueCommand com) {
		map.put(nomCom, com);

	}

	public void ExcuteCommande(String NomCommande, Stack<Integer> pile) {

		SpecifiqueCommand commande = map.get(NomCommande);
		if (commande == null) {
			throw new IllegalStateException("la commande n'existe pas !" + NomCommande);
		}

		if (NomCommande.equals("/")) {

			if (pile.peek().intValue() != 0) {
				int b = pile.pop();
				int a = pile.pop();
				save(commande.apply(a, b), pile);
				// else
			}

		} else {
			int b = pile.pop();
			int a = pile.pop();
			save(commande.apply(a, b), pile);
		}
	}

	public void save(int operande, Stack<Integer> pile) {

		pile.push(operande);

	}

	public boolean existeCommande(String nomCommande) {

		return map.containsKey(nomCommande);
	}

}

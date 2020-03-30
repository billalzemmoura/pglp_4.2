package pglp.pglp42;

import java.util.HashMap;

import java.util.Stack;

/**
 * @author bill
 */

public class Interpreteur {

	/**
	 */
	final HashMap<String, GeneriqueCommand> map = new HashMap<String, GeneriqueCommand>();

	/**
	 * @param nomCom
	 * @param com
	 */
	public void Addcommande(String nomCom, GeneriqueCommand com) {
		map.put(nomCom, com);

	}

	/**
	 * @param NomCommande
	 * @return
	 */
	public Boolean ExisteCommande(String NomCommande) {

		return map.containsKey(NomCommande);
	}

	/**
	 * @param NomCommande
	 * @param pile
	 * @param ope1
	 * @param ope2
	 */
	public void ExcuteCommande(String NomCommande, Stack<Integer> pile, int ope1, int ope2) {
		GeneriqueCommand commande = map.get(NomCommande);
		if (commande == null) {
			throw new IllegalStateException("la commande n'existe pas !" + NomCommande);
		}
		commande.apply(pile, ope1, ope2);

	}

}

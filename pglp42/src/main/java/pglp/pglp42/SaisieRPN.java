package pglp.pglp42;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author bill
 *
 */
public class SaisieRPN {

    /**
    */
	private boolean undoable = false;
	/**
	 */
	private Stack<Integer> pile = new Stack<Integer>();
     /** 
	 */
	private int ope1 = 0;
	/**
	 */
	private int ope2 = 0;
	/**
	 */
	private Addition addition = new Addition();
	/**
	 */
	private Soustraction soustraction = new Soustraction();
	/**
	 */
	private Multiplication multiplication = new Multiplication();
	/**
	 */
	private Division division = new Division();
	/**
	 */
	private Undo undo = new Undo();
	/** 
	 */
	private Quit quite = new Quit();

	/**
	 */
	private Interpreteur interpreteur = new Interpreteur();

	/**
	 */
	private MoteurRPN moteur = new MoteurRPN();

	/**
	 */
	public SaisieRPN() {
int i=0;
		SpecifiqueCommand add = addition::apply;
		SpecifiqueCommand sous = soustraction::apply;
		SpecifiqueCommand mult = multiplication::apply;
		SpecifiqueCommand div = division::apply;
		
		this.moteur.Addcommande("+", add);
		this.moteur.Addcommande("-", sous);
		this.moteur.Addcommande("*", mult);
		this.moteur.Addcommande("/", div);
		GeneriqueCommand qui = quite::apply;
		GeneriqueCommand und = undo::apply;
		this.interpreteur.Addcommande("undo", und);
		this.interpreteur.Addcommande("quit", qui);
	}

	/**
	 * @param NomCommande
	 */
	public final void excInter(final String NomCommande) {
		if (interpreteur.ExisteCommande(NomCommande)) {

			if (undoable) {
				interpreteur.ExcuteCommande(NomCommande, pile, ope1, ope2);
				// moteur.ExcuteCommande(NomCommande);
				undoable = false;
			}
		}
	}

	/**
	 * @param NomCommande
	 * @return {@link Boolean}
	 */
	public final boolean ExisteCommandeMoteur(String NomCommande) {
		return moteur.existeCommande(NomCommande);
	}

	/**
	 * @param NomCommande
	 * @return boolean
	 */
	public final boolean ExisteCommandeInterpreteur(String NomCommande) {
		return interpreteur.ExisteCommande(NomCommande);
	}

	/**
	 * @param NomCommande
	 */
	public final void excMoteur(String NomCommande) {
		// interpreteur.ExcuteCommande(NomCommande);
		if (pile.size() > 1) {

			if (moteur.existeCommande(NomCommande)) {

				moteur.ExcuteCommande(NomCommande, pile);
				undoable = true;
			}

		}
	}

	/**
	 */
	public final void setOperande() {
		if (pile.size() > 1) {
			this.ope1 = pile.pop();
			this.ope2 = pile.pop();
			pile.push(ope2);
			pile.push(ope1);
		}

	}

	/**
	 * @param operande
	 */
	public final void ItInteger(int operande) {

		moteur.save(operande, this.pile);
		setOperande();
		undoable = false;
	}

	/**
	 * @return {@link String}
	 */
	public final String saisie() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Veuillez saisir un entier dans cette intervale =>[-999999999;999999999] ou undo ou (* / + -) ou quit  :");
		String str = sc.nextLine();
		return str;

	}

	/**
	 * @return Stack<Integer>
	 */
	public final Stack<Integer> getStack() {
		return pile;
	}
}

package pglp.pglp42;

import java.util.Scanner;
import java.util.Stack;

public class SaisieRPN {
	boolean undoable = false;
	Stack<Integer> pile = new Stack<Integer>();
	int ope1 = 0;
	int ope2 = 0;
	Addition addition = new Addition();
	Soustraction soustraction = new Soustraction();
	Multiplication multiplication = new Multiplication();
	Division division = new Division();
	Undo undo = new Undo();
	Quit quite = new Quit();

	Interpreteur interpreteur = new Interpreteur();

	MoteurRPN moteur = new MoteurRPN();

	public SaisieRPN() {

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

	public void excInter(String NomCommande) {
		if (interpreteur.ExisteCommande(NomCommande)) {

			if (undoable) {
				interpreteur.ExcuteCommande(NomCommande, pile, ope1, ope2);
				// moteur.ExcuteCommande(NomCommande);
				undoable = false;
			}
		}
	}

	public boolean ExisteCommandeMoteur(String NomCommande) {
		return moteur.existeCommande(NomCommande);
	}

	public boolean ExisteCommandeInterpreteur(String NomCommande) {
		return interpreteur.ExisteCommande(NomCommande);
	}

	public void excMoteur(String NomCommande) {
		// interpreteur.ExcuteCommande(NomCommande);
		if (pile.size() > 1) {

			if (moteur.existeCommande(NomCommande)) {

				moteur.ExcuteCommande(NomCommande, pile);
				undoable = true;
			}

		}
	}

	public void setOperande() {
		if (pile.size() > 1) {
			this.ope1 = pile.pop();
			this.ope2 = pile.pop();
			pile.push(ope2);
			pile.push(ope1);
		}

	}

	public void ItInteger(int operande) {

		moteur.save(operande, this.pile);
		setOperande();
		undoable = false;
	}

	public String saisie() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Veuillez saisir un entier dans cette intervale =>[-999999999;999999999] ou undo ou (* / + -) ou quit  :");
		String str = sc.nextLine();
		return str;

	}

	public Stack<Integer> getStack() {
		return pile;
	}
}

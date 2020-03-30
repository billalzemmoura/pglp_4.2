package pglp.pglp42;

public class RPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean callOP = false;
		SaisieRPN saisieRPN = new SaisieRPN();
		while (true) {

			String saisie = saisieRPN.saisie();

			try {
				if (saisieRPN.ExisteCommandeMoteur(saisie)) {
					saisieRPN.excMoteur(saisie);
					callOP = true;
				}
			} catch (Exception e2) {

			}

			try {
				if (saisieRPN.ExisteCommandeInterpreteur(saisie)) {
					saisieRPN.excInter(saisie);
					callOP = true;
				}
			} catch (Exception e) {

			}

			try {
				if (!callOP) {
					int integer = Integer.parseInt(saisie.trim());

					System.out.println("push  =>> " + integer);
					saisieRPN.ItInteger(integer);
				}
			} catch (NumberFormatException nfe) {
				System.out.println("NumberFormatException OR COMMANDE INTROUVABLE : " + nfe.getMessage());
			}
			callOP = false;
			System.out.println("---------------------------->");
			System.out.println(saisieRPN.getStack());
			System.out.println("---------------------------->");
		}

	}

}

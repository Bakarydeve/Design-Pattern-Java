package factory;

import velo.Velo;

/**
 * Classe permettant de verifier un velo.
 *
 * @author BAKARY
 *
 */



public class VerifierVelo {

  /**
   * Méthode permettant de verifier que les pneus d'un velo sont identique.

   * @param velo le velo
   * 
   */  
	
	public static enum PneuCheckResult {
	    OK("Aucun problème détecté, les pneus avant et arrière sont identiques"),
	    LARGEUR_DIFFERENTE("Les pneus avant et arrière n'ont pas la même largeur"),
	    TYPE_DIFFERENT("Les pneus avant et arrière ne sont pas du même type"),
	    LARGEUR_INCORRECTE("Les pneus avant et arrière ont une largeur soit inférieure à 19 soit supérieure à 30"),
	    MARQUE_DIFFERENTE("Les pneus avant et arrière ne sont pas de la même marque");

	    private final String message;

	    PneuCheckResult(String message) {
	        this.message = message;
	    }

	    public String getMessage() {
	        return message;
	    }
	}
  
	public static PneuCheckResult check_pneu(Velo velo) {
        if (velo.getPneu_avant().getMarque().getMarque().equals(velo.getPneu_arriere().getMarque().getMarque())) {
            if (velo.getPneu_avant().getLargeur() == velo.getPneu_arriere().getLargeur()) {
                if (velo.getPneu_avant().getEstTubeless() == velo.getPneu_arriere().getEstTubeless()) {
                    int largeur = velo.getPneu_avant().getLargeur();
                    if (largeur >= 19 && largeur <= 30) {
                        return PneuCheckResult.OK;
                    } else {
                        return PneuCheckResult.LARGEUR_INCORRECTE;
                    }
                } else {
                    return PneuCheckResult.TYPE_DIFFERENT;
                }
            } else {
                return PneuCheckResult.LARGEUR_DIFFERENTE;
            }
        }
        return PneuCheckResult.MARQUE_DIFFERENTE;
    }
	
	public static void checkpneu(PneuCheckResult ret, Velo velo) {
        System.out.println(ret.getMessage());
    }


}

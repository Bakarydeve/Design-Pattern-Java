package test;

import factory.UsineVelo;
import factory.VerifierVelo;
import velo.Velo;

public class Programme {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.out.println("***************** Création de l'usine **********************");
	    UsineVelo usine = new UsineVelo("Kalkhoff");
	    System.out.println("Création de quatre vélos dnas l'usine");
	    Velo v = usine.creer_velo("VTC", 220, "EASYBIKE", "MICHELIN PROTEK 700");
	    Velo velo = usine.creer_velo("ENTICE 5 MOVE+", 200, "EASYBIKE", "MICHELIN PROTEK 700");
	    usine.creer_velo("ENTICE 1.B MOVE", 250, "EASYBIKE", "MICHELIN PROTEK 700");
	    usine.creer_velo("ENTICE 5 ADVANCE+", 230, "EASYBIKE", "MICHELIN PROTEK 700");
	    System.out.println("Nb vélos : " + usine.getNbvelos());
	    System.out.println("***************** Affichage des vélos **********************");
	    // affichage des velos

	    System.out.println("***************** Vérification d'un vélo **********************");
	    VerifierVelo.PneuCheckResult result = VerifierVelo.check_pneu(velo);
	    VerifierVelo.checkpneu(result, velo);

	}
	

}

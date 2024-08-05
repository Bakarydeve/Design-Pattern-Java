package vue;

import velo.Batterie;
import velo.Pneu;
import velo.Velo;
import visite.Visitor;

public class VisitorDetailed implements Visitor {
	
	@Override
    public void visit(Velo velo) {
        System.out.println("Velo: " + velo.getNumeroSerie() + ", Modele: " + velo.getModele() + ", Marque: " + velo.getMarque().getMarque());
    }

    @Override
    public void visit(Batterie batterie) {
        System.out.println("Batterie: Marque: " + batterie.getMarque().getMarque() + ", Puissance: " + batterie.getPuissance() + "W");
    }

    @Override
    public void visit(Pneu pneu) {
        System.out.println("Pneu: Marque: " + pneu.getMarque().getMarque() + ", Largeur: " + pneu.getLargeur() + "mm, Tubeless: " + pneu.getEstTubeless());
    }

}

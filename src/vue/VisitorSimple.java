package vue;

import velo.Batterie;
import velo.Pneu;
import velo.Velo;
import visite.Visitor;

public class VisitorSimple implements Visitor {
	
	@Override
    public void visit(Velo velo) {
        System.out.println("Velo: " + velo.getModele());
    }

    @Override
    public void visit(Batterie batterie) {
        System.out.println("Batterie: " + batterie.getPuissance() + "W");
    }

    @Override
    public void visit(Pneu pneu) {
        System.out.println("Pneu: " + pneu.getLargeur() + "mm");
    }

}

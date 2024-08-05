package visite;

import velo.Batterie;
import velo.Pneu;
import velo.Velo;

public interface Visitor {
	
    void visit(Velo velo);
    void visit(Batterie batterie);
    void visit(Pneu pneu);

}

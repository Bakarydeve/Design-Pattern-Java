package factory;

import java.util.ArrayList;

import velo.Batterie;
import velo.Marque;
import velo.Pneu;
import velo.Velo;

/**
 * Classe definissant une usine à vélo.
 *
 * @author BAKARY
 *
 */

public class UsineVelo {

  private Marque marqueVelo;
  private int nbvelos;
  private static final Integer LARGEUR = 30;
  private static final boolean ESTTUBELESS = true;

  /**
   * Construit une usine à vélo.
   * 
   * @param nom bom de l'usine
   * 
   */

  public UsineVelo(String nom) {
    super();
    this.marqueVelo = new Marque(nom);
    nbvelos = 0;
  }

  /**
   * Création d'un nouveau vélo dans l'usine largeur des pneus initialisé à 30 estTubeless des pneus
   * initialisés à true.
   * 
   * @param modele le modele du vélo
   * @param puissance la puissance de la batterie du vélo
   * 
   */

  public Velo creer_velo(String modele, Integer puissance, String marqueBatterie,
      String marquePneu) {
    Marque marquebatterie = new Marque(marqueBatterie);
    Marque marquepneu = new Marque(marquePneu);
    Batterie batterie = new Batterie(puissance, marquebatterie);
    Pneu pneuavant = new Pneu(LARGEUR, ESTTUBELESS, marquepneu);
    Pneu pneuarriere = new Pneu(LARGEUR, ESTTUBELESS, marquepneu);
    Velo velo = new Velo(modele, this.marqueVelo, batterie, pneuavant, pneuarriere);
    this.nbvelos++;

    return velo;
  }

  public int getNbvelos() {
    return nbvelos;
  }

  public void setNbvelos(int nbvelos) {
    this.nbvelos = nbvelos;
  }

  public Marque getMarqueVelo() {
    return marqueVelo;
  }

  public void setMarqueVelo(Marque marqueVelo) {
    this.marqueVelo = marqueVelo;
  }

  public Integer getLargeur() {
    return LARGEUR;
  }

}

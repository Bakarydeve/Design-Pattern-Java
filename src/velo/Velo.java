package velo;

import visite.Visitable;
import visite.Visitor;

/**
 * Classe definissant un velo.
 *
 * @author BAKARY
 *
 */

public class Velo implements Visitable {

  private String modele;
  private int numeroSerie;
  static int id = 1;

  private Pneu pneuavant;
  private Pneu pneuarriere;
  private Batterie batterie;
  private Marque marque;

  /**
   * Construit un nouveau velo. numeroSerie auto incrément

   * @param modele le modele du velo
   * @param marque la marque du velo
   * @param batterie la batterie du pneu
   * @param p1 le pneu avant du velo
   * @param p2 le pneu arriere du velo 
   * 
   */

  public Velo(String modele, Marque marque, Batterie batterie, Pneu p1, Pneu p2) {
    super();
    this.setNumeroSerie(id);
    id++;

    this.marque = marque;
    this.modele = modele;
    this.pneuavant = p1;
    this.pneuarriere = p2;
    this.batterie = batterie;

  }

  public Pneu getPneu_avant() {
    return pneuavant;
  }

  public void setPneu_avant(Pneu pneuavant) {
    this.pneuavant = pneuavant;
  }

  public Pneu getPneu_arriere() {
    return pneuarriere;
  }

  public void setPneu_arriere(Pneu pneuarriere) {
    this.pneuarriere = pneuarriere;
  }

  public String getModele() {
    return modele;
  }

  public void setModele(String modele) {
    this.modele = modele;
  }

  public Batterie getBatterie() {
    return batterie;
  }

  public void setBatterie(Batterie batterie) {
    this.batterie = batterie;
  }

  public Marque getMarque() {
    return marque;
  }

  public void setMarque(Marque marque) {
    this.marque = marque;
  }

  public int getNumeroSerie() {
    return numeroSerie;
  }

  public void setNumeroSerie(int numeroSerie) {
    this.numeroSerie = numeroSerie;
  }
  
  @Override
  public void accept(Visitor visitor) {
      visitor.visit(this);
      if (this.batterie != null) {
          this.batterie.accept(visitor);
      }
      if (this.pneuavant != null) {
          this.pneuavant.accept(visitor);
      }
      if (this.pneuarriere != null) {
          this.pneuarriere.accept(visitor);
      }
  }



}

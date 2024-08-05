package velo;

import visite.Visitable;
import visite.Visitor;

/**
 * Classe definissant un pneu.
 *
 * @author BAKARY
 *
 */

public class Pneu implements Visitable {

  private Integer largeur;
  private Boolean estTubeless;
  private Marque marque;

  /**
   * Construit un nouveau pneu.

   * @param largeur la largeur du pneu
   * @param estTubeless v
   * @param marque la marque du pneu
   * 
   */
  
  public Pneu(Integer largeur, boolean estTubeless, Marque marque) {
    super();
    this.largeur = largeur;
    this.estTubeless = estTubeless;
    this.marque = marque;
  }


  public Integer getLargeur() {
    return largeur;
  }

  public void setLargeur(Integer largeur) {
    this.largeur = largeur;
  }

  public Boolean getEstTubeless() {
    return estTubeless;
  }

  public void setEstTubeless(Boolean estTubeless) {
    this.estTubeless = estTubeless;
  }


  public Marque getMarque() {
    return marque;
  }


  public void setMarque(Marque marque) {
    this.marque = marque;
  }
  
  @Override
  public void accept(Visitor visitor) {
      visitor.visit(this);
  }



}

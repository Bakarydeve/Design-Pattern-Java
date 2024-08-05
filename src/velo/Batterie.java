package velo;

import visite.Visitable;
import visite.Visitor;

/**
 * Classe definissant une batterie.
 *
 * @author BAKARY
 *
 */

public class Batterie implements Visitable  {

  private Integer puissance;
  private Marque marque;

  /**
   * Construit une nouvelle batterie.

   * @param puissance la puissance de la batterie
   * @param marque la marque de la batterie
   * 
   */
  public Batterie(Integer puissance, Marque marque) {
    super();
    this.puissance = puissance;
    this.marque = marque;


  }

  public Integer getPuissance() {
    return puissance;
  }

  public void setPuissance(Integer puissance) {
    this.puissance = puissance;
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

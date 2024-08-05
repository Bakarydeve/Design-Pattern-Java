package facade;

import java.util.ArrayList;
import java.util.List;

import factory.UsineVelo;
import observer.Observer;
import observer.Subject;
import velo.Velo;
import visite.Visitor;


/**
 * Classe permettant la gestion CRUD d'une liste de velo .
 *
 * @author BAKARY
 *
 */

public class GarageVelo implements Subject {

  private ArrayList<Velo> velos;

  private Velo velocourant;

  private UsineVelo usine;

  private List<Integer> numeros;

  private int choix;

  private int identifiant;

  private Integer indicecourant;
  
  private List<Observer> observers;




  /**
   * Construit le garage à velo.
   * 
   * @param nomusine le nom de l'usine qui contient les vélos
   * 
   */

  public GarageVelo(String nomusine) {
    super();
    velos = new ArrayList<Velo>();
    usine = new UsineVelo(nomusine);
    numeros = new ArrayList<Integer>();
    velocourant = null;
    choix = -1;
    identifiant = -1;
    observers = new ArrayList<>();


  }
  
  public UsineVelo getUsine() {
	    return usine;
	  }

	  public void setUsine(UsineVelo usine) {
	    this.usine = usine;
	  }


	  public int getChoix() {
	    return choix;
	  }

	  public void setChoix(int choix) {
	    this.choix = choix;
	  }

	  public int getIdentifiant() {
	    return identifiant;
	  }

	  public void setIdentifiant(int identifiant) {
	    this.identifiant = identifiant;
	  }

	  public List<Integer> getNumeros() {
	    return numeros;
	  }

	  public void setNumeros(List<Integer> numeros) {
	    this.numeros = numeros;
	  }

	  public ArrayList<Velo> getVelos() {
	    return velos;
	  }

	  public void setVelos(ArrayList<Velo> velos) {
	    this.velos = velos;
	  }

	  public Velo getVelocourant() {
	    return velocourant;
	  }

	  public void setVelocourant(int indice) {
	    this.velocourant = this.getVelos().get(indice);
	    this.setIndicecourant(indice);
	  }

	  public Integer getIndicecourant() {
	    return indicecourant;
	  }

	  public void setIndicecourant(Integer indicecourant) {
	    this.indicecourant = indicecourant;
	  }

  /**
   * Fonction permettant de changer l'un des pneus d'un vélo dont ont connait le numéro de série.
   * 
   * @param numeroSerie le numéro de série du vélo
   * @param avant : à true si c'est le pneu avant qu'ont souhaitent changer, false sinon
   * @param largeur : nouvelle largeur du pneu ( doit être compris entre 19 et 30)
   * @param estTubeless : nouvelle largeur du pneu
   * 
   */

  public int changerPneu(int numeroSerie, boolean avant, Integer largeur, boolean estTubeless) {

    if (largeur < 19 || largeur > 30) {
      return -1;
    }

    for (Velo v : this.velos) {
      if (v.getNumeroSerie() == numeroSerie) {
        if (avant) {
          v.getPneu_avant().setLargeur(largeur);
          v.getPneu_avant().setEstTubeless(estTubeless);
          return 1;

        } else {
          v.getPneu_arriere().setLargeur(largeur);
          v.getPneu_arriere().setEstTubeless(estTubeless);
          return 1;
        }
      }
    }
    return 0;
  }

  /**
   * Fonction permettant de changer l'un des pneus du velo courant.
   * 
   * @param avant : à true si c'est le pneu avant qu'ont souhaitent changer, false sinon
   * @param largeur : nouvelle largeur du pneu ( doit être compris entre 19 et 30)
   * @param estTubeless : nouvelle largeur du pneu
   * 
   */

  public int changerPneuVeloCourant(boolean avant, Integer largeur, boolean estTubeless) {
    if (this.velocourant != null) {
      if (largeur < 19 || largeur > 30) {
        return -1;
      }

      if (avant) {
        this.getVelocourant().getPneu_avant().setLargeur(largeur);
        this.getVelocourant().getPneu_avant().setEstTubeless(estTubeless);
        this.choix = 3;
        return 1;

      } else {
        this.getVelocourant().getPneu_arriere().setLargeur(largeur);
        this.getVelocourant().getPneu_arriere().setEstTubeless(estTubeless);
        this.choix = 3;
        return 1;
      }

    }
    return 0;

  }

  /**
   * Fonction permettant d'afficher le velo courant.
   * 
   */

  public void afficherVeloCourant() {

    Velo v = this.getVelocourant();
    if (v != null) {
      System.out.println("Velo ");
      System.out.println("Velo : " + v.getNumeroSerie() + ", Marque : " + v.getMarque().getMarque()
          + ", Modele : " + v.getModele());

      System.out.println("Pneu Velo ");
      System.out.println(
          "avant marque : " + v.getPneu_avant().getMarque().getMarque() + ", avant largeur : "
              + v.getPneu_avant().getLargeur() + ", type : " + v.getPneu_avant().getEstTubeless());
      System.out.println("arriere marque : " + v.getPneu_arriere().getMarque().getMarque()
          + ", arriere largeur : " + v.getPneu_arriere().getLargeur() + ", type : "
          + v.getPneu_arriere().getEstTubeless());
      System.out.println("Batterie Velo ");
      System.out.println("marque : " + v.getBatterie().getMarque().getMarque() + ", puissance : "
          + v.getBatterie().getPuissance());
      System.out.println();
    }

  }

  /**
   * Fonction permettant de changer la batterie d'un vélo dont ont connait le numéro de série.
   * 
   * @param numeroSerie le numéro de série du vélo
   * @param puissance : nouvelle puissance
   * 
   */

  public int changerBatterie(int numeroSerie, Integer puissance) {
    for (Velo v : this.velos) {
      if (v.getNumeroSerie() == numeroSerie) {
        v.getBatterie().setPuissance(puissance);
        return 1;
      }
    }
    return 0;
  }

  /**
   * Fonction permettant de changer la batterie du velo courant.
   * 
   * @param puissance : nouvelle puissance
   * 
   */

  public int changerBatterieVeloCourant(Integer puissance) {
    if (this.velocourant != null) {
      this.velocourant.getBatterie().setPuissance(puissance);
      this.choix = 3;
      return 1;
    }
    return 0;
  }

  /**
   * Fonction permettant trouver un vélo à l'aide de son numéro de série.
   * 
   * @param numeroSerie le numéro de série du vélo que l'on cherche
   * 
   */

  public Velo trouverVelo(int numeroSerie) {
    for (Velo v : this.velos) {
      if (v.getNumeroSerie() == numeroSerie) {
        return v;
      }
    }

    return null;
  }

  /**
   * Fonction permettant d'ajouté un nouveau velo dans l'usine.
   * 
   * @param modele le modele de série du vélo
   * @param puissance la puissance du vélo
   * 
   */
/*
  public void ajouterVelo(String modele, Integer puissance, String marqueBatterie,
      String marquePneu) {
    Velo v = usine.creer_velo(modele, puissance, marqueBatterie, marquePneu);
    this.velos.add(v);
    this.setChoix(1);
    this.setIdentifiant(v.getNumeroSerie());
    //notifyAllObservers();

  }
*/

  /**
   * Fonction permettant dont supprimer un vélo dont ont connaient le numéro de série. Si velo
   * courant, la valeur de velo courant passe à null
   * 
   * @param numeroSerie le numéro de série du vélo que l'on souhaite supprimer
   * 
   */
/*
  public int supprimerVelo(int numeroSerie) {
    for (Velo v : this.velos) {
      if (v.getNumeroSerie() == numeroSerie) {
        if (this.velocourant != null && this.velocourant == v) {
          this.setIdentifiant(v.getNumeroSerie());
          this.velos.remove(v);
          usine.setNbvelos(usine.getNbvelos() - 1);
          this.setChoix(2);
          this.velocourant = null;
          //notifyAllObservers();
          return 1;
        } else {
          this.setIdentifiant(v.getNumeroSerie());
          this.velos.remove(v);
          usine.setNbvelos(usine.getNbvelos() - 1);
          this.setChoix(2);
          //notifyAllObservers();
          return 1;
        }

      }
    }
    return 0;
  }
*/

  /**
   * Fonction permettant de trouver l'indice à la quelle est stocké un vélo.
   * 
   * @param numeroSerie le numéro de série du vélo que l'on souhaite supprimer
   * 
   */

  public int trouverIndice(int numeroSerie) {
    int tmp = 0;
    for (Velo v : this.getVelos()) {
      if (v.getNumeroSerie() == numeroSerie) {
        return tmp;
      }
      tmp++;
    }
    return -1;
  }

  /**
   * Fonction permettant de recuperer une chaine de caractère contenant la liste des velos. Le
   * numero de serie du vélo courant est entre crochet
   * 
   */

  public String afficherNumeros() {
    String s = "";
    for (Integer i : this.getNumeros()) {
      if (this.velocourant != null) {
        if (this.velocourant.getNumeroSerie() == i) {
          s += "[" + i + "]" + " ";
        } else {
          s += i + " ";
        }
      } else {
        s += i + " ";
      }

    }
    return s;
  }

  /**
   * Affiche les caractéristiques du vélo courant avec un visiteur.
   * 
   * @param visitor Le visiteur à utiliser pour afficher les caractéristiques.
   */
  public void afficherVeloCourant(Visitor visitor) {
      if (velocourant != null) {
          velocourant.accept(visitor);
      } else {
          System.out.println("Aucun vélo courant sélectionné.");
      }
  }

  /**
   * Affiche les caractéristiques d'un vélo spécifique avec un visiteur.
   * 
   * @param numeroSerie Le numéro de série du vélo à afficher.
   * @param visitor     Le visiteur à utiliser pour afficher les caractéristiques.
   */
  public void afficherVelo(int numeroSerie, Visitor visitor) {
      Velo velo = trouverVelo(numeroSerie);
      if (velo != null) {
          velo.accept(visitor);
      } else {
          System.out.println("Vélo non trouvé.");
      }
  }
  
  @Override
  public void addObserver(Observer o) {
      observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
      observers.remove(o);
  }

  @Override
  public void notifyObservers() {
      for (Observer o : observers) {
          o.update();
      }
  }

  // Méthodes pour ajouter, supprimer et mettre à jour les vélos
  public void ajouterVelo(String modele, Integer puissance, String marqueBatterie, String marquePneu) {
      Velo v = usine.creer_velo(modele, puissance, marqueBatterie, marquePneu);
      velos.add(v);
      notifyObservers();
  }

  public int supprimerVelo(int numeroSerie) {
      for (Velo v : velos) {
          if (v.getNumeroSerie() == numeroSerie) {
              velos.remove(v);
              notifyObservers();
              return 1;
          }
      }
      return 0;
  }
  
  

}

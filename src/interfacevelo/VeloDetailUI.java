package interfacevelo;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import facade.GarageVelo;
import observer.Observer;
import velo.Velo;

public class VeloDetailUI extends JFrame implements Observer {
    private Velo velo;
    private GarageVelo garageVelo;
    private JTextArea textArea;

    public VeloDetailUI(Velo velo, GarageVelo garageVelo) {
        this.velo = velo;
        this.garageVelo = garageVelo;
        garageVelo.addObserver(this);

        setTitle("Détails du Vélo");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        update();
    }

    public void updateVelo(Velo velo) {
        this.velo = velo;
        update();
    }

    @Override
    public void update() {
        if (velo != null) {
            textArea.setText("");
            textArea.append("Velo: " + velo.getNumeroSerie() + "\n");
            textArea.append("Modele: " + velo.getModele() + "\n");
            textArea.append("Marque: " + velo.getMarque().getMarque() + "\n");
            textArea.append("Pneu Avant: Marque: " + velo.getPneu_avant().getMarque().getMarque() + ", Largeur: " + velo.getPneu_avant().getLargeur() + "mm, Tubeless: " + velo.getPneu_avant().getEstTubeless() + "\n");
            textArea.append("Pneu Arrière: Marque: " + velo.getPneu_arriere().getMarque().getMarque() + ", Largeur: " + velo.getPneu_arriere().getLargeur() + "mm, Tubeless: " + velo.getPneu_arriere().getEstTubeless() + "\n");
            textArea.append("Batterie: Marque: " + velo.getBatterie().getMarque().getMarque() + ", Puissance: " + velo.getBatterie().getPuissance() + "W\n");
        }
    }
}

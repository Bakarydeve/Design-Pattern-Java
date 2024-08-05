package interfacevelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import facade.GarageVelo;
import velo.Velo;

public class VeloFormUI extends JFrame {
    private GarageVelo garageVelo;
    private Velo velo;
    
    private JTextField modeleField;
    private JTextField puissanceField;
    private JTextField marqueBatterieField;
    private JTextField marquePneuField;
    private JButton saveButton;

    public VeloFormUI(GarageVelo garageVelo, Velo velo) {
        this.garageVelo = garageVelo;
        this.velo = velo;

        setTitle(velo == null ? "Ajouter Vélo" : "Modifier Vélo");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Modèle:"));
        modeleField = new JTextField(velo != null ? velo.getModele() : "");
        add(modeleField);

        add(new JLabel("Puissance:"));
        puissanceField = new JTextField(velo != null ? String.valueOf(velo.getBatterie().getPuissance()) : "");
        add(puissanceField);

        add(new JLabel("Marque Batterie:"));
        marqueBatterieField = new JTextField(velo != null ? velo.getBatterie().getMarque().getMarque() : "");
        add(marqueBatterieField);

        add(new JLabel("Marque Pneu:"));
        marquePneuField = new JTextField(velo != null ? velo.getPneu_avant().getMarque().getMarque() : "");
        add(marquePneuField);

        saveButton = new JButton(velo == null ? "Ajouter" : "Modifier");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (velo == null) {
                    garageVelo.ajouterVelo(
                        modeleField.getText(),
                        Integer.parseInt(puissanceField.getText()),
                        marqueBatterieField.getText(),
                        marquePneuField.getText()
                    );
                } else {
                    // Code pour modifier le vélo (à ajouter)
                }
                dispose();
            }
        });
        add(saveButton);
    }
}


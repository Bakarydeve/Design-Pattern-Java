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

public class VeloDetailUI extends JFrame {
    private GarageVelo garageVelo;
    private Velo velo;

    private JTextField modeleField;
    private JTextField puissanceField;
    private JTextField marqueBatterieField;
    private JTextField marquePneuField;
    private JButton saveButton;

    public VeloDetailUI(GarageVelo garageVelo, Velo velo) {
        this.garageVelo = garageVelo;
        this.velo = velo;

        setTitle("Détails du Vélo");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Modèle:"));
        modeleField = new JTextField(velo.getModele());
        add(modeleField);

        add(new JLabel("Puissance:"));
        puissanceField = new JTextField(String.valueOf(velo.getBatterie().getPuissance()));
        add(puissanceField);

        add(new JLabel("Marque Batterie:"));
        marqueBatterieField = new JTextField(velo.getBatterie().getMarque().getMarque());
        add(marqueBatterieField);

        add(new JLabel("Marque Pneu:"));
        marquePneuField = new JTextField(velo.getPneu_avant().getMarque().getMarque());
        add(marquePneuField);

        saveButton = new JButton("Sauvegarder");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (velo != null) {
                    velo.getBatterie().setPuissance(Integer.parseInt(puissanceField.getText()));
                    velo.getBatterie().getMarque().setMarque(marqueBatterieField.getText());
                    velo.getPneu_avant().getMarque().setMarque(marquePneuField.getText());
                    velo.getPneu_arriere().getMarque().setMarque(marquePneuField.getText());
                    velo.setModele(modeleField.getText());
                    garageVelo.changerBatterieVeloCourant(Integer.parseInt(puissanceField.getText()));
                }
                dispose();
            }
        });
        add(saveButton);
    }

    public void updateVelo(Velo velo) {
        this.velo = velo;
        modeleField.setText(velo.getModele());
        puissanceField.setText(String.valueOf(velo.getBatterie().getPuissance()));
        marqueBatterieField.setText(velo.getBatterie().getMarque().getMarque());
        marquePneuField.setText(velo.getPneu_avant().getMarque().getMarque());
    }
}

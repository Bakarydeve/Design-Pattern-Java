package interfacevelo;

import java.awt.GridLayout;
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
        modeleField = new JTextField(this.velo != null ? velo.getModele() : "");
        add(modeleField);

        add(new JLabel("Puissance:"));
        puissanceField = new JTextField(this.velo != null ? String.valueOf(velo.getBatterie().getPuissance()) : "");
        add(puissanceField);

        add(new JLabel("Marque Batterie:"));
        marqueBatterieField = new JTextField(this.velo != null ? velo.getBatterie().getMarque().getMarque() : "");
        add(marqueBatterieField);

        add(new JLabel("Marque Pneu:"));
        marquePneuField = new JTextField(this.velo != null ? velo.getPneu_avant().getMarque().getMarque() : "");
        add(marquePneuField);

        saveButton = new JButton("Sauvegarder");
        add(saveButton);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void updateVelo(Velo velo) {
        this.velo = velo;
        modeleField.setText(velo.getModele());
        puissanceField.setText(String.valueOf(velo.getBatterie().getPuissance()));
        marqueBatterieField.setText(velo.getBatterie().getMarque().getMarque());
        marquePneuField.setText(velo.getPneu_avant().getMarque().getMarque());
    }

    public Velo getVelo() {
        if (velo != null) {
            velo.setModele(modeleField.getText());
            velo.getBatterie().setPuissance(Integer.parseInt(puissanceField.getText()));
            velo.getBatterie().getMarque().setMarque(marqueBatterieField.getText());
            velo.getPneu_avant().getMarque().setMarque(marquePneuField.getText());
        }
        return velo;
    }
}

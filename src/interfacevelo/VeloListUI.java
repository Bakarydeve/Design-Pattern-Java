package interfacevelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import facade.GarageVelo;
import observer.Observer;
import velo.Velo;

public class VeloListUI extends JFrame implements Observer {
    private GarageVelo garageVelo;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private VeloDetailUI detailUI;

    public VeloListUI(GarageVelo garageVelo) {
        this.garageVelo = garageVelo;
        garageVelo.addObserver(this);
        
        setTitle("Liste des Vélos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton viewButton = new JButton("Voir Détails");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    Velo selectedVelo = garageVelo.getVelos().get(index);
                    if (detailUI == null) {
                        detailUI = new VeloDetailUI(selectedVelo, garageVelo);
                    } else {
                        detailUI.updateVelo(selectedVelo);
                    }
                    detailUI.setVisible(true);
                }
            }
        });

        add(listScrollPane, "Center");
        add(viewButton, "South");

        update();
    }

    @Override
    public void update() {
        listModel.clear();
        for (Velo v : garageVelo.getVelos()) {
            listModel.addElement("Velo " + v.getNumeroSerie());
        }
    }
    
    public static void main(String[] args) {
        GarageVelo garageVelo = new GarageVelo("Usine1");
        garageVelo.ajouterVelo("Modele1", 250, "MarqueBatterie1", "MarquePneu1");
        garageVelo.ajouterVelo("Modele2", 300, "MarqueBatterie2", "MarquePneu2");

        VeloListUI listUI = new VeloListUI(garageVelo);
        listUI.setVisible(true);
    }
}

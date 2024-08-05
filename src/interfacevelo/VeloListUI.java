package interfacevelo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
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

    // Champs et boutons pour ajouter, modifier, supprimer et afficher les détails
    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JButton detailButton;

    public VeloListUI(GarageVelo garageVelo) {
        this.garageVelo = garageVelo;
        garageVelo.addObserver(this);

        setTitle("Liste des Vélos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);

        // Initialisation des boutons
        addButton = new JButton("Ajouter Vélo");
        modifyButton = new JButton("Modifier Vélo");
        deleteButton = new JButton("Supprimer Vélo");
        detailButton = new JButton("Détails Vélo");

        // Ajouter des actions aux boutons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VeloFormUI(garageVelo, null).setVisible(true);
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    Velo selectedVelo = garageVelo.getVelos().get(index);
                    new VeloFormUI(garageVelo, selectedVelo).setVisible(true);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    Velo selectedVelo = garageVelo.getVelos().get(index);
                    garageVelo.supprimerVelo(selectedVelo.getNumeroSerie());
                }
            }
        });

        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list.getSelectedIndex();
                if (index != -1) {
                    Velo selectedVelo = garageVelo.getVelos().get(index);
                    if (detailUI == null) {
                        detailUI = new VeloDetailUI(garageVelo, selectedVelo);
                    } else {
                        detailUI.updateVelo(selectedVelo);
                    }
                    detailUI.setVisible(true);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(detailButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

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

            VeloListUI veloListUI = new VeloListUI(garageVelo);
            veloListUI.setVisible(true);
        }

}

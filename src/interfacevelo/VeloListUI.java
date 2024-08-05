package interfacevelo;

import java.awt.BorderLayout;
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

public class VeloListUI extends JFrame {
    private GarageVelo garageVelo;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private VeloDetailUI detailUI;

    private JButton addButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private JButton detailButton;

    public VeloListUI(GarageVelo garageVelo) {
        this.garageVelo = garageVelo;
        garageVelo.addObserver(new Observer() {
            @Override
            public void update() {
                listModel.clear();
                for (Velo v : garageVelo.getVelos()) {
                    listModel.addElement("Velo " + v.getNumeroSerie());
                }
            }
        });

        setTitle("Liste des Vélos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);

        addButton = new JButton("Ajouter Vélo");
        modifyButton = new JButton("Modifier Vélo");
        deleteButton = new JButton("Supprimer Vélo");
        detailButton = new JButton("Détails Vélo");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(detailButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        update();
    }
    
    public void update() {
        listModel.clear();
        for (Velo v : garageVelo.getVelos()) {
            listModel.addElement("Velo " + v.getNumeroSerie());
        }
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addModifyButtonListener(ActionListener listener) {
        modifyButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addDetailButtonListener(ActionListener listener) {
        detailButton.addActionListener(listener);
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }
}


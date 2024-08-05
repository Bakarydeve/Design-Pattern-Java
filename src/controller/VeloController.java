package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import facade.GarageVelo;
import interfacevelo.VeloDetailUI;
import interfacevelo.VeloFormUI;
import interfacevelo.VeloListUI;
import velo.Velo;

public class VeloController {
    private GarageVelo model;
    private VeloListUI listView;
    private VeloDetailUI detailView;

    public VeloController(GarageVelo model, VeloListUI listView, VeloDetailUI detailView) {
        this.model = model;
        this.listView = listView;
        this.detailView = detailView;

        // Register action listeners for listView
        this.listView.addAddButtonListener(new AddButtonListener());
        this.listView.addModifyButtonListener(new ModifyButtonListener());
        this.listView.addDeleteButtonListener(new DeleteButtonListener());
        this.listView.addDetailButtonListener(new DetailButtonListener());

        // Register action listeners for detailView
        this.detailView.addSaveButtonListener(new SaveButtonListener());
    }

    // Listeners for VeloListUI buttons
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new VeloFormUI(model, null).setVisible(true);
        }
    }

    private class ModifyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listView.getSelectedIndex();
            if (index != -1) {
                Velo selectedVelo = model.getVelos().get(index);
                new VeloFormUI(model, selectedVelo).setVisible(true);
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listView.getSelectedIndex();
            if (index != -1) {
                Velo selectedVelo = model.getVelos().get(index);
                model.supprimerVelo(selectedVelo.getNumeroSerie());
            }
        }
    }

    private class DetailButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = listView.getSelectedIndex();
            if (index != -1) {
                Velo selectedVelo = model.getVelos().get(index);
                if (detailView == null) {
                    detailView = new VeloDetailUI(model, selectedVelo);
                } else {
                    detailView.updateVelo(selectedVelo);
                }
                detailView.setVisible(true);
            }
        }
    }

    // Listener for VeloDetailUI save button
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (detailView != null) {
                Velo updatedVelo = detailView.getVelo();
                model.updateVelo(updatedVelo);
                model.notifyObservers(); // Notify observers to update the list
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GarageVelo garageVelo = new GarageVelo("Ma Usine");
            garageVelo.ajouterVelo("Modele1", 250, "MarqueBatterie1", "MarquePneu1");
            garageVelo.ajouterVelo("Modele2", 300, "MarqueBatterie2", "MarquePneu2");
            VeloListUI listView = new VeloListUI(garageVelo);
            VeloDetailUI detailView = new VeloDetailUI(garageVelo, null);

            VeloController controller = new VeloController(garageVelo, listView, detailView);

            listView.setVisible(true);
            detailView.setVisible(true);
        });
    }
}

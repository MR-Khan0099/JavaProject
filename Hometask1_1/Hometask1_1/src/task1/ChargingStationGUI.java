package task1;

import javax.swing.*;
import java.awt.*;

public class ChargingStationGUI {
    private JFrame frame;
    private JLabel weatherLabel;
    private JLabel energySourceLabel;
    private JLabel queueLabel;
    private JLabel[] chargingSlots;

    public ChargingStationGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Electric Car Charging Station Simulation");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        weatherLabel = new JLabel("Weather: ");
        frame.add(weatherLabel);

        energySourceLabel = new JLabel("Energy Source: ");
        frame.add(energySourceLabel);

        queueLabel = new JLabel("Queue: 10 Cars");
        frame.add(queueLabel);

        JPanel chargingPanel = new JPanel(new FlowLayout());
        chargingSlots = new JLabel[5];
        for (int i = 0; i < chargingSlots.length; i++) {
            chargingSlots[i] = new JLabel("Slot " + (i + 1) + ": Empty");
            chargingPanel.add(chargingSlots[i]);
        }
        frame.add(chargingPanel);

        frame.setVisible(true);
    }

    public void updateWeather(String weather) {
        SwingUtilities.invokeLater(() -> weatherLabel.setText("Weather: " + weather));
    }

    public void updateEnergySource(String source) {
        SwingUtilities.invokeLater(() -> energySourceLabel.setText("Energy Source: " + source));
    }

    public void updateQueue(int size) {
        SwingUtilities.invokeLater(() -> queueLabel.setText("Queue: " + size + " Cars"));
    }

    public void updateChargingSlot(int slot, String status) {
        SwingUtilities.invokeLater(() -> chargingSlots[slot].setText("Slot " + (slot + 1) + ": " + status));
    }
}

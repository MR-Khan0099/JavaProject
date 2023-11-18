package task1;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChargingStationGUI gui = new ChargingStationGUI();

            Weather weather = new Weather(gui);
            EnergyManagement energyManagement = new EnergyManagement(weather, gui);
            CarQueue carQueue = new CarQueue(gui);
            ChargingStation station = new ChargingStation(energyManagement, carQueue, gui);

            station.startChargingProcess();
        });
    }
}

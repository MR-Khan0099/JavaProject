package task1;
public class EnergyManagement {
    private final Weather weather;
    private ChargingStationGUI gui;

    public EnergyManagement(Weather weather, ChargingStationGUI gui) {
        this.weather = weather;
        this.gui = gui;

        // Start a thread to continuously update the energy source based on the weather
        new Thread(() -> {
            while (true) {
                try {
                    updateEnergySource();
                    Thread.sleep(1000); // Update every second to stay in sync with weather changes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateEnergySource() {
        String source = weather.isSunny() ? "Solar" : "Grid";
        gui.updateEnergySource(source);
    }

    public String getCurrentEnergySource() {
        return weather.isSunny() ? "Solar" : "Grid";
    }
}

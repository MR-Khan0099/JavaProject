package task1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChargingStation {
    private final int slots = 5;
    private final EnergyManagement energyManagement;
    private final CarQueue carQueue;
    private final ExecutorService chargingSlots;
    private final ChargingStationGUI gui;

    public ChargingStation(EnergyManagement energyManagement, CarQueue carQueue, ChargingStationGUI gui) {
        this.energyManagement = energyManagement;
        this.carQueue = carQueue;
        this.gui = gui;
        this.chargingSlots = Executors.newFixedThreadPool(slots);
    }

    public void startChargingProcess() {
        for (int i = 0; i < slots; i++) {
            final int slot = i;
            chargingSlots.submit(() -> chargeCar(slot));
        }
    }

    private void chargeCar(int slot) {
        while (true) {
            Car car = carQueue.getNextCar();
            if (car != null) {
                String energySource = energyManagement.getCurrentEnergySource();
                gui.updateChargingSlot(slot, "Occupied by " + car.getLicensePlate() + " using " + energySource);
                try {
                    Thread.sleep(5000); // Charging time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gui.updateChargingSlot(slot, "Empty");
                carQueue.returnCar(car);
            }
        }
    }
}

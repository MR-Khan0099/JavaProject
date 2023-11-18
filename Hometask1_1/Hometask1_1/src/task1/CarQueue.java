package task1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CarQueue {
    private final Queue<Car> cars = new ConcurrentLinkedQueue<>();
    private ChargingStationGUI gui;

    public CarQueue(ChargingStationGUI gui) {
        this.gui = gui;
        // Initialize with 10 cars
        for (int i = 0; i < 10; i++) {
            cars.offer(new Car("Car " + (i + 1)));
        }
    }

    public Car getNextCar() {
        Car car = cars.poll();
        gui.updateQueue(cars.size());
        return car;
    }

    public void returnCar(Car car) {
        cars.offer(car);
        gui.updateQueue(cars.size());
    }
}

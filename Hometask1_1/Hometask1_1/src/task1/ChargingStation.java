package task1;
import java.util.ArrayList;
import java.util.List;

public class ChargingStation {
	    private int capacity; // Number of charging spots
	    private List<Car> cars; // Cars at the station

	    public ChargingStation(int capacity) {
	        this.capacity = capacity;
	        this.cars = new ArrayList<>();
	    }

	    public void chargeCar(Car car) throws ChargingExceptions {
	        try {
	            if (cars.size() < capacity) {
	                cars.add(car);
	                // Simulate charging process
	                Thread.sleep(car.getChargingTime());
	            } else {
	                throw new ChargingExceptions("No available charging spots.");
	            }
	        } catch (InterruptedException e) {
	            // Re-throwing an exception (Feature b
	            throw new ChargingExceptions("Charging was interrupted", e);
	        } catch (ChargingExceptions e) {
	            // Chaining exceptions (Feature d)
	            throw new ChargingExceptions("Failed to charge the car: " + car, e);
	        } finally {
	            // Resource management, ensuring the car is always removed (Feature c)
	            cars.remove(car);
	        }
	    }
	};




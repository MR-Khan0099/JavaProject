package task1;

public class Main {
	  public static void main(String[] args) {
	        ChargingStation station = new ChargingStation(5);
	        Car car1 = new Car(5000, 1000);
	        try {
	            station.chargeCar(car1);
	        } catch (ChargingExceptions e) {
	            System.err.println("Error: " + e.getMessage());
	            	        }
	    }
	};




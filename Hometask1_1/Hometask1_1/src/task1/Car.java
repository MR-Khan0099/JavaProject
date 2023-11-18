package task1;

public class Car {
	    private int chargingTime; // in milliseconds
	    private int maxWaitTime; // in milliseconds

	    public Car(int chargingTime, int maxWaitTime) {
	        this.chargingTime = chargingTime;
	        this.maxWaitTime = maxWaitTime;
	    }

	    public int getChargingTime() {
	        return chargingTime;
	    }

	    public int getMaxWaitTime() {
	        return maxWaitTime;
	    }
	};


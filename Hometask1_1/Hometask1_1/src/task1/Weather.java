package task1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Weather {
    private final AtomicBoolean isSunny = new AtomicBoolean(true);
    private ChargingStationGUI gui;

    public Weather(ChargingStationGUI gui) {
        this.gui = gui;
        new Thread(() -> {
            while (true) {
                boolean currentWeather = isSunny.get();
                gui.updateWeather(currentWeather ? "Sunny" : "Rainy");
                isSunny.set(!currentWeather);
                try {
                    Thread.sleep(currentWeather ? 10000 : 5000); // 10 seconds sunny, 5 seconds rainy
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean isSunny() {
        return isSunny.get();
    }
}

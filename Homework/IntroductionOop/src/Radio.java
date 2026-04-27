public class Radio {
    private boolean on = false;
    private float volume = 0.5f;
    private int frequencyMhz = 100;
    private int frequencyKhz = 0;
    private Battery battery = new Battery();

    private static final int actionBatteryConsumption = 5;

    public Radio() {}

    public Radio(boolean on) {
        if (on) {
            turnOn();
        }
    }

    public Radio(boolean on, float volume) {
        this(on);

        if (volume < 0 || volume > 1) {
            throw new IllegalArgumentException("Volume must be between 0 and 1");
        }

        this.volume = volume;
    }

    public Radio(boolean on, float volume, String frequency) {
        this(on, volume);
        setFrequency(frequency);
    }

    public Radio(boolean on, float volume, String frequency, Battery battery) {
        this(on, volume, frequency);
        this.battery = battery;
    }

    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public float getVolume() {
        return volume;
    }

    public float volumeUp() {
        if (! isOn()) {
            throw new IllegalStateException("Radio is off");
        }

        boolean chargeApplied = battery.consume(actionBatteryConsumption);
        if (! chargeApplied) {
            throw new IllegalStateException("Battery is empty");
        }

        float newVolume = volume + 0.05f;

        if (newVolume <= 1.0f) {
            volume = newVolume;
        }

        return volume;
    }

    public float volumeDown() {
        if (! isOn()) {
            throw new IllegalStateException("Radio is off");
        }

        boolean chargeApplied = battery.consume(actionBatteryConsumption);
        if (! chargeApplied) {
            throw new IllegalStateException("Battery is empty");
        }

        float newVolume = volume - 0.05f;

        if (newVolume >= 0f) {
            volume = newVolume;
        }

        return volume;
    }

    public String getFrequency() {
        return String.format("%d.%d", frequencyMhz, frequencyKhz);
    }

    public void setFrequency(String frequency) {
        if (! isOn()) {
            throw new IllegalStateException("Radio is off");
        }

        boolean chargeApplied = battery.consume(actionBatteryConsumption);
        if (! chargeApplied) {
            throw new IllegalStateException("Battery is empty");
        }

        if (! frequency.matches("^[0-9]{2,3}(\\.[0-9]{1,2})?$")) {
            throw new IllegalArgumentException("Invalid frequency format");
        }

        int newFreqMhz = Integer.parseInt(frequency.split("\\.")[0]);

        if (newFreqMhz < 100 || newFreqMhz > 300) {
            throw new IllegalArgumentException("MHz frequency must be between 100 and 300 MHz");
        }

        frequencyMhz = newFreqMhz;

        if (frequency.contains(".")) {
            int newFreqKhz = Integer.parseInt(frequency.split("\\.")[1]);

            if (newFreqKhz < 0 || newFreqKhz > 99) {
                throw new IllegalArgumentException("KHz Frequency must be between 0 and 99 KHz");
            }

            frequencyKhz = newFreqKhz;
        }
    }

    public Battery getBattery() {
        return battery;
    }

    @Override
    public String toString() {
        return String.format("Radio: %s, Volume: %.2f, Frequency: %s", on ? "ON" : "OFF", volume, getFrequency());
    }
}

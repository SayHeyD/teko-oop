public class Battery {
    private int charge;
    private int capacity = 100;

    public Battery() {
        this.charge = this.capacity;
    }

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public int getCharge() {
        return charge;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean charge(int amount) {
        if (charge + amount > capacity) {
            return false;
        }

        charge += amount;
        return true;
    }

    public boolean consume(int amount) {
        if (charge - amount < 0) {
            return false;
        }

        charge -= amount;
        return true;
    }
}

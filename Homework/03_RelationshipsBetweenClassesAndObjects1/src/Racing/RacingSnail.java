package Racing;

public class RacingSnail {
    private final String name;
    private final Ethnicity ethnicity;
    private final int maxSpeed;
    private float distanceMoved = 0f;

    public RacingSnail(String name, Ethnicity ethnicity, int maxSpeed) {
        this.name = name;
        this.ethnicity = ethnicity;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public float getDistanceMoved() {
        return distanceMoved;
    }

    public void crawl() {
        float distanceToMove = 1 + (float)(Math.random() * maxSpeed);
        distanceMoved += distanceToMove;
    }

    public String getData() {
        return toString();
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Ethnicity: %s, Max Speed: %d, Distance Moved: %.2f", name, ethnicity, maxSpeed, distanceMoved);
    }
}

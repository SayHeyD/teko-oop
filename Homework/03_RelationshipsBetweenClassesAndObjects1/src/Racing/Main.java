package Racing;

public class Main {
    public static void main(String[] args) {
        RacingSnail copseSnail = new RacingSnail("Snail1", Ethnicity.COPSE_SNAIL, 10);
        RacingSnail gardenSnail = new RacingSnail("Snail2", Ethnicity.GARDEN_SNAIL, 8);

        Race mainEvent = new Race("Main Event", new RacingSnail[]{copseSnail, gardenSnail}, 100);

        RennHandler raceHandler = new RennHandler();
        raceHandler.setRennen(mainEvent);
        raceHandler.start();

        System.out.println(raceHandler.rennen);
    }
}
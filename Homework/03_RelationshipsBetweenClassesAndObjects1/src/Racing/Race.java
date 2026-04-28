package Racing;

public class Race extends Rennstruktur {
    private final String name;
    // Would normally use an ArrayList here, but sticking to an array for the exercise sake here
    private RacingSnail[] participants;
    private final float distance;
    private boolean winnerPresent = false;

    public Race(String name, RacingSnail[] participants, float distance) {
        this.name = name;
        this.participants = participants;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public float getDistance() {
        return distance;
    }

    public RacingSnail[] getParticipants() {
        return participants;
    }

    public void addParticipant(RacingSnail participant) {
        RacingSnail[] newParticipants = new RacingSnail[participants.length + 1];
        System.arraycopy(participants, 0, newParticipants, 0, participants.length);
        newParticipants[participants.length] = participant;
        participants = newParticipants;
    }

    public void removeParticipant(RacingSnail participant) {
        participants = new RacingSnail[participants.length - 1];
        int index = 0;
        for(RacingSnail p : participants){
            if(p != participant){
                participants[index] = p;
                index++;
            }
        }
    }

    // We don't need an extra property to track the number of participants,
    // as we already have access to that information
    public int getParticipantsCount() {
        return participants.length;
    }

    public boolean letThemRace() {
        // Always race all participants
        // Do not terminate looping when a snail reaches the finish line,
        // there could be more than one participant winning
        for (RacingSnail participant : participants) {
            participant.crawl();
        }

        for (RacingSnail participant : participants) {
            if (participant.getDistanceMoved() >= distance) {
                winnerPresent = true;
                break;
            }
        }

        return winnerPresent;
    }

    @Override
    public boolean durchfuehren() {
        return letThemRace();
    }

    public boolean ermittleGewinner() {
        return winnerPresent;
    }

    public String getData() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder(String.format("Name: %s, Distance: %.2f, Participant Count: %d\n", name, distance, participants.length));
        message.append("\nParticipants:\n\n");

        if (getParticipantsCount() == 0)
            message.append("No participants");

        for (RacingSnail participant : participants) {
            // We don't need getData() here as we
            // have overridden toString() in RacingSnail
            message.append(participant).append("\n");
        }

        return message.toString();
    }
}

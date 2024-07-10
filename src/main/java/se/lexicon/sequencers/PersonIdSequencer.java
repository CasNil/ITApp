package se.lexicon.sequencers;

public class PersonIdSequencer {
    private static int currentID;

    public static int nextId() {
        return 0;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        PersonIdSequencer.currentID = currentID;
    }
}

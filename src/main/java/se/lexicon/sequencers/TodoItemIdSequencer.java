package se.lexicon.sequencers;

public class TodoItemIdSequencer {
    private static int currentID;

    private static int sequencer = 0;

    public static int nextId() {
        return ++sequencer;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentId) {
        TodoItemIdSequencer.currentID = currentId;
    }
}

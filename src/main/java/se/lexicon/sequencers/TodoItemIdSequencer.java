package se.lexicon.sequencers;

public class TodoItemIdSequencer {
    private static int currentID;

    public static int nextId() {
        return 0;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(int currentID) {
        TodoItemIdSequencer.currentID = currentID;
    }
}

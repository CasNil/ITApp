package se.lexicon.sequencers;

public class TodoItemTaskIdSequencer {
    private static int currentId;

    private static int sequencer = 0;

    public static int nextId() {
        return ++sequencer;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}

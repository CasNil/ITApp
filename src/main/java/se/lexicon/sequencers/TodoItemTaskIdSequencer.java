package se.lexicon.sequencers;

public class TodoItemTaskIdSequencer {
    private static int currentId;

    public static int nextId() {
        return 0;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}

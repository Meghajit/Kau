package Kau.data.receipt;

public enum Receipt {
    SENT(0),
    DELIVERED(1);

    private final int priority;

    Receipt(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

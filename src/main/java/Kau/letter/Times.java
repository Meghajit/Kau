package Kau.letter;

import Kau.receipt.Receipt;

import java.time.Instant;

public class Times {
    private Receipt receipt;
    private Instant time;

    public Times(Receipt receipt, Instant time) {
        this.receipt = receipt;
        this.time = time;
    }
}

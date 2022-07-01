package Kau.data.user.preference;

import Kau.data.receipt.Receipt;

import static Kau.data.receipt.Receipt.SENT;
import static Kau.data.user.preference.PreferenceType.RECEIPT;

public class ReceiptPreference extends Preference {
    private static final PreferenceType PREFERENCE_TYPE = RECEIPT;

    public ReceiptPreference(Receipt receipt) {
        super(PREFERENCE_TYPE, receipt);
    }

    public ReceiptPreference() {
        super(PREFERENCE_TYPE, SENT);
    }
}

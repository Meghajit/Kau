package Kau.user.preference;

import Kau.receipt.Receipt;

public class ReceiptPreference extends Preference {

    public ReceiptPreference(PreferenceType preferenceType, Receipt highestPriorityReceiptAllowed) {
        super(preferenceType, highestPriorityReceiptAllowed);
    }
}

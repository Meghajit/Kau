package Kau.data.user.preference;

import Kau.data.receipt.Receipt;

public class ReceiptPreference extends Preference {

    public ReceiptPreference(PreferenceType preferenceType, Receipt highestPriorityReceiptAllowed) {
        super(preferenceType, highestPriorityReceiptAllowed);
    }
}

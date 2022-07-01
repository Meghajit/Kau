package Kau.data.user.preference;

import java.util.List;
import java.util.UUID;

import static Kau.data.user.preference.PreferenceType.LAST_SEEN;

public class LastSeenPreference extends Preference {
    private static final PreferenceType PREFERENCE_TYPE = LAST_SEEN;

    /* value can be null for EVERYBODY and NOBODY last seen types */

    public LastSeenPreference(LastSeenPreferenceType lastSeenPreferenceType, List<UUID> value) {
        super(PREFERENCE_TYPE, value);
    }

    public enum LastSeenPreferenceType {
        EVERYBODY,
        NOBODY,
        SELECTED;
    }
}

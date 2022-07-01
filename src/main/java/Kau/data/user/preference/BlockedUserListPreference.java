package Kau.data.user.preference;

import java.util.List;
import java.util.UUID;

import static Kau.data.user.preference.PreferenceType.BLOCKED_USERS;

public class BlockedUserListPreference extends Preference {
    private static final PreferenceType PREFERENCE_TYPE = BLOCKED_USERS;

    public BlockedUserListPreference(List<UUID> value) {
        super(PREFERENCE_TYPE, value);
    }
}

package Kau.data.user.preference;

import java.util.List;
import java.util.UUID;

import static Kau.data.user.preference.PreferenceType.MUTED_USERS;

public class MutedUserListPreference extends Preference {
    private static final PreferenceType PREFERENCE_TYPE = MUTED_USERS;

    public MutedUserListPreference(List<UUID> value) {
        super(MUTED_USERS, value);
    }
}

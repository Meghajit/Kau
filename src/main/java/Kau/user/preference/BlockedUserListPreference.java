package Kau.user.preference;

import Kau.user.User;

import java.util.List;

public class BlockedUserListPreference extends Preference {
    public BlockedUserListPreference(PreferenceType preferenceType, List<User> value) {
        super(preferenceType, value);
    }
}

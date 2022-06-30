package Kau.data.user.preference;

import Kau.data.user.User;

import java.util.List;

public class BlockedUserListPreference extends Preference {
    public BlockedUserListPreference(PreferenceType preferenceType, List<User> value) {
        super(preferenceType, value);
    }
}

package Kau.user.preference;

import Kau.user.User;

import java.util.List;

public class MutedUserListPreference extends Preference {
    public MutedUserListPreference(PreferenceType preferenceType, List<User> value) {
        super(preferenceType, value);
    }
}

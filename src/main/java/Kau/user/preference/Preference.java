package Kau.user.preference;

public abstract class Preference {
    private final PreferenceType preferenceType;
    private final Object value;

    public Preference(PreferenceType preferenceType, Object value) {
        this.preferenceType = preferenceType;
        this.value = value;
    }
}

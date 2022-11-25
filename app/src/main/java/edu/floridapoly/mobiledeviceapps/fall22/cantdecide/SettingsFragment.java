package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() { /* Required empty public constructor */ }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootkey) {
        setPreferencesFromResource(R.xml.preferences, rootkey);
        ListPreference regionsPreference = findPreference("Region Filter");
        regionsPreference.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance());
    }

}
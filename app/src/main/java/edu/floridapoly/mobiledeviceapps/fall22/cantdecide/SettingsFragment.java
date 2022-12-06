package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragmentCompat {

    public SettingsFragment() { /* Required empty public constructor */ }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootkey) {
        setPreferencesFromResource(R.xml.preferences, rootkey);
        ListPreference regionsPreference = findPreference("Region Filter");
        ListPreference causePreference = findPreference("Cause Filter");
        regionsPreference.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance());
        causePreference.setSummaryProvider(ListPreference.SimpleSummaryProvider.getInstance());
        regionsPreference.setDefaultValue(null);
        causePreference.setDefaultValue(null);
    }

}
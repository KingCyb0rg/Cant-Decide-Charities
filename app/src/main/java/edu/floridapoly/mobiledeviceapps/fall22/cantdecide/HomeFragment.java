package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private RandomizerFragment randomizerFragment;


    public HomeFragment() { /* Required empty public constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Button startRandomizerBtn = rootView.findViewById(R.id.RandomizeButton);
        Spinner causesSpinner = rootView.findViewById(R.id.CausesSpinner);
        TextView regionText = rootView.findViewById(R.id.RegionText);
        TextView duplicatesText = rootView.findViewById(R.id.DuplicateText);
        TextView saveText = rootView.findViewById(R.id.SaveText);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        regionText.setText(sharedPreferences.getString("Region Filter", ""));
        duplicatesText.setText(String.valueOf(sharedPreferences.getBoolean("Enable Duplicates", false)));
        saveText.setText(String.valueOf(sharedPreferences.getBoolean("Save Charities", true)));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.causes, android.R.layout.simple_spinner_item);
        causesSpinner.setAdapter(adapter);

        startRandomizerBtn.setOnClickListener(view -> {
            randomizerFragment = new RandomizerFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, randomizerFragment).commit();
        });

        return rootView;
    }
}
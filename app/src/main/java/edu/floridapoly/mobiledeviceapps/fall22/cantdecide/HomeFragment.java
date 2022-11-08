package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private Button startRandomizerBtn;
    private Spinner causesSpinner;
//    private Switch enableDuplicates;
    private View rootView;
    private RandomizerFragment randomizerFragment;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    public HomeFragment() { /* Required empty public constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        startRandomizerBtn = rootView.findViewById(R.id.RandomizeButton);
        causesSpinner = rootView.findViewById(R.id.CausesSpinner);
//        enableDuplicates = rootView.findViewById(R.id.EnableDuplicatesHome);

        sharedPreferences = getActivity().getSharedPreferences("Randomizer Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

//        enableDuplicates.setOnCheckedChangeListener(null);
//        enableDuplicates.setChecked(sharedPreferences.getBoolean("Enable Duplicates", true));
//        enableDuplicates.setOnCheckedChangeListener((compoundButton, b) -> {
//            editor.putBoolean("Enable Duplicates", b);
//            Toast.makeText(getActivity(), "Enable Duplicates is " + (b ? "on" : "off") + ". State added to Shared Preference", Toast.LENGTH_SHORT).show();
//        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.causes, android.R.layout.simple_spinner_item);
        causesSpinner.setAdapter(adapter);

        startRandomizerBtn.setOnClickListener(view -> {
            randomizerFragment = new RandomizerFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, randomizerFragment).commit();
        });

        return rootView;
    }
}
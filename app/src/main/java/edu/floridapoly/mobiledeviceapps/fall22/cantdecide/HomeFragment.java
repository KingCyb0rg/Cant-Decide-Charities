package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private Button startRandomizerBtn;
    private Spinner causesSpinner;
    private View rootView;
    private RandomizerFragment randomizerFragment;


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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.causes, android.R.layout.simple_spinner_item);
        causesSpinner.setAdapter(adapter);

        startRandomizerBtn.setOnClickListener(view -> {
            randomizerFragment = new RandomizerFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, randomizerFragment).commit();
        });
        return rootView;
    }
}
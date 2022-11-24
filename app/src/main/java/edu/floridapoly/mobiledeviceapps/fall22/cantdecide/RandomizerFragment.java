package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RandomizerFragment extends Fragment {

    View rootView;
    Button acceptButton, declineButton, websiteButton;
    TextView charityResult;

    public RandomizerFragment() {/* Required empty public constructor */}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_randomizer, container, false);

        acceptButton = rootView.findViewById(R.id.ApproveButton);
        declineButton = rootView.findViewById(R.id.DeclineButton);
        websiteButton = rootView.findViewById(R.id.WebsiteButton);

        acceptButton.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Charity accepted, added to rolled charity listing", Toast.LENGTH_SHORT).show();
        });
        declineButton.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Charity declined, rolling next charity", Toast.LENGTH_SHORT).show();
        });
        websiteButton.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pledge.to/organizations"));
            startActivity(browserIntent);
        });

        return rootView;
    }
}
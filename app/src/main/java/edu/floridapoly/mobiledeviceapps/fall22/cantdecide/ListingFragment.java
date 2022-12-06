package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.floridapoly.mobiledeviceapps.fall22.cantdecide.utils.MyDividerItemDecoration;
import edu.floridapoly.mobiledeviceapps.fall22.cantdecide.utils.RecyclerTouchListener;


public class ListingFragment extends Fragment {
    private CharityAdapter charityAdapter;
    private TextView noCharitiesView;
    private DBHelper dbHelper;
    private List<Charity> charityList = new ArrayList<>();
    private RecyclerView recyclerView;

    public ListingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        dbHelper = new DBHelper(getContext());
        charityList = dbHelper.getAllCharities();
        noCharitiesView = view.findViewById(R.id.no_charities_text);
        recyclerView = view.findViewById(R.id.recyclerView);

        charityAdapter = new CharityAdapter(view.getContext(), charityList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL, 5));
        recyclerView.setAdapter(charityAdapter);

        toggleEmptyView();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(view.getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Toast.makeText(getContext(), "Getting Charity Website", Toast.LENGTH_SHORT).show();

                        Charity charity = charityList.get(position);
                        String url = charity.getWebsite();

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(browserIntent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {}
                }));
        // Inflate the layout for this fragment
        return view;
    }

    private void toggleEmptyView() {
        if (dbHelper.getCharityCount() > 0)
            noCharitiesView.setVisibility(View.GONE);
        else
            noCharitiesView.setVisibility(View.VISIBLE);
    }
}
package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Button startRandomizerBtn;
    String apiKey = "62c0b716a7f2b4e7ed7a47b062545cbf";
    String pledgeUrl = "https://api.pledge.to/v1/organizations";

    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    ListingFragment listingFragment = new ListingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true).add(R.id.fragmentContainerView, homeFragment, null)
                    .commit();
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, homeFragment).commit();
                    return true;
                case R.id.settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, settingsFragment).commit();
                    return true;
                case R.id.charities:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, listingFragment).commit();
                    return true;
            }

            return false;
        });

        generateCharityDatabase();

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    protected void generateCharityDatabase() {

    }

    class getWebServiceData extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }

}
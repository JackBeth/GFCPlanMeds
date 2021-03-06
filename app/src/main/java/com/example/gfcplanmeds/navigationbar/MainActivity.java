package com.example.gfcplanmeds.navigationbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.SignInActivity;
import com.example.gfcplanmeds.data.User;
import com.example.gfcplanmeds.navigationbar.AlarmSettings.TimePickerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

public class MainActivity extends AppCompatActivity {

    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            currentUser = (User) bundle.get("Data");
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new InformationFragment(currentUser)).commit();

        SignOutButton();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.InformationFragment:
                    selectedFragment = new InformationFragment(currentUser);
                    break;
                case R.id.DoctorFragment:
                    selectedFragment = new DoctorFragment(currentUser);
                    break;
                case R.id.MedicineFragment:
                    selectedFragment = new MedicineFragment(currentUser);
                    break;
                case R.id.TimePickerFragment:
                    selectedFragment = new TimePickerFragment(currentUser);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();

            return true;
        }
    };

    private void SignOutButton() {
        Button SignOutButton = findViewById(R.id.button);
        SignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignInActivity();
            }
        });
    }

    private void goToSignInActivity() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }
}
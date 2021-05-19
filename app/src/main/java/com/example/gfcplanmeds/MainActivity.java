package com.example.gfcplanmeds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.NavController;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.med_nav)
        val navController = findNavController(R.id.fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.InformationFragment, R.id.MedicineFragment, R.id.AlarmFragment, R.id.DoctorFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
}
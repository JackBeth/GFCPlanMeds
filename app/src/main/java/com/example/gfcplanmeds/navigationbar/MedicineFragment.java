package com.example.gfcplanmeds.navigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.data.User;

public class MedicineFragment extends Fragment {

    public MedicineFragment(User currentUser) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine, container, false);
    }
}
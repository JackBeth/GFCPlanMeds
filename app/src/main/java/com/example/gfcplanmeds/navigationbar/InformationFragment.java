package com.example.gfcplanmeds.navigationbar;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.SignInActivity;
import com.example.gfcplanmeds.SignInViewModel;
import com.example.gfcplanmeds.data.User;

public class InformationFragment extends Fragment {


    private User currentUser;

    public InformationFragment(User currentUser) {

        this.currentUser = currentUser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        TextView userNameView = (TextView) view.findViewById(R.id.InfoUserName);
        TextView passwordView = (TextView) view.findViewById(R.id.InfoPassword);
        TextView emailView = (TextView) view.findViewById(R.id.EmailAddress);
        TextView phoneNoView = (TextView) view.findViewById(R.id.PhoneNo);

        userNameView.setText(currentUser.UserName);
        passwordView.setText(currentUser.Password);
        emailView.setText(currentUser.Email);
        phoneNoView.setText(currentUser.PhoneNo);

        return view;
    }
}
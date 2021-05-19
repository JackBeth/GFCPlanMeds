package com.example.gfcplanmeds.navigationbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.data.User;

public class DoctorFragment extends Fragment {
    private User currentUser;

    public DoctorFragment(User currentUser) {
        this.currentUser = currentUser;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        Button callButton = (Button) view.findViewById(R.id.CallDoctor);
        Button homePageButton = (Button) view.findViewById(R.id.LinkToHomePage);
        TextView DoctorNameView = (TextView) view.findViewById(R.id.DoctorName);
        TextView OfficeNameView = (TextView) view.findViewById(R.id.OfficeName);

        DoctorNameView.setText(currentUser.DoctorName);
        OfficeNameView.setText(currentUser.OfficeName);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345678"));
                startActivity(intent);
            }
        });

        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.sundhed.dk";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        return view;
    }
}
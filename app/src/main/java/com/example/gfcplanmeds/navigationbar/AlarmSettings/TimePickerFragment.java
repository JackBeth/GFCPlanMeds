package com.example.gfcplanmeds.navigationbar.AlarmSettings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.data.User;

public class TimePickerFragment extends Fragment{

    private User currentUser;

    public TimePickerFragment(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_picker, container, false);
        Button button = view.findViewById(R.id.SetAlarmButton);
        EditText textHours = view.findViewById(R.id.AlarmHours);
        EditText textMin = view.findViewById(R.id.AlarmMinutes);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, textHours.getText());
                intent.putExtra(AlarmClock.EXTRA_MINUTES, textMin.getText());

                startActivity(intent);
            }
        });
        return view;
    }
}
package com.example.gfcplanmeds;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gfcplanmeds.data.UserLiveData;
import com.example.gfcplanmeds.data.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class SignInViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public SignInViewModel(Application app){
        super(app);
        userRepository = UserRepository.getInstance(app);
    }

    public LiveData<UserLiveData> getCurrentUser(){
        return userRepository.getCurrentUser();
    }
}

package com.example.gfcplanmeds;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gfcplanmeds.data.User;

public class SignInViewModel extends ViewModel {

    private MutableLiveData<User> currentUser;

    public LiveData<User> getUser() {
        return null;
    }

    private void LoadUser() {

    }
}

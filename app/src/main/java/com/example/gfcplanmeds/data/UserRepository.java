package com.example.gfcplanmeds.data;

import android.app.Application;

import androidx.lifecycle.LiveData;


public class UserRepository {
    private final UserLiveData currentUser;
    private final Application app;
    private static UserRepository instance;

    private UserRepository(Application app) {
        this.app = app;
        currentUser = new UserLiveData();
    }

    public static synchronized UserRepository getInstance(Application app) {
        if (instance == null)
            instance = new UserRepository(app);
        return instance;
    }

    public LiveData<UserLiveData> getCurrentUser() {
        return currentUser;
    }

    public void signOut() {

    }
}

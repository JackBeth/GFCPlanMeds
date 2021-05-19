package com.example.gfcplanmeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.gfcplanmeds.data.User;
import com.example.gfcplanmeds.navigationbar.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 42;
    private SignInViewModel viewModel;
    private FirebaseFirestore userDatabase = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = userDatabase.collection("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        checkIfSignedIn();
        setContentView(R.layout.signin_activity);
    }

    private void checkIfSignedIn() {
   /* viewModel.getCurrentUser().observe(this, user ->{
        if (user != null)
            goToMainActivity();
    });*/

        Button SignInButton = findViewById(R.id.button2);
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView UserNameView = findViewById(R.id.SignInUserName);
                TextView PasswordView = findViewById(R.id.SignInPassword);
                collectionReference
                        .whereEqualTo("UserName", UserNameView.getText())
                        .whereEqualTo("Password", PasswordView.getText())
                        .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        List<User> userList = querySnapshot.toObjects(User.class);
                        User user = userList.get(0);
                        goToMainActivity(user);
                    }
                });
            }
        });
    }

    private void goToMainActivity(User user) {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.putExtra("Data", user);

        startActivity(new Intent(this, MainActivity.class));
        //finish();
    }

}

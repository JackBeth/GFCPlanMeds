package com.example.gfcplanmeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        setContentView(R.layout.signin_activity);
        checkIfSignedIn();
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
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
                        .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {


                        List<User> userList = querySnapshot.toObjects(User.class);
                        User currentUser = new User();
                        boolean success = false;

                        for (User user : userList) {
                            if (user.Password.equals(PasswordView.getText().toString())
                                    && user.UserName.equals(UserNameView.getText().toString())) {
                                currentUser = user;

                               String b = querySnapshot.getDocuments().get(0).getId();
                                Iterable<CollectionReference> collectionReferences = (Iterable<CollectionReference>) collectionReference.document(b).collection("Medicines");

                                success=true;
                                goToMainActivity(currentUser);
                            }
                        }
                        if (!success)
                        Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void goToMainActivity(User user) {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        intent.putExtra("Data", user);

        startActivity(intent);
        //finish();
    }

}

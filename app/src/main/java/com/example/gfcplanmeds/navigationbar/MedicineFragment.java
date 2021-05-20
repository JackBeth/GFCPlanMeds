package com.example.gfcplanmeds.navigationbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.data.Medicine;
import com.example.gfcplanmeds.data.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MedicineFragment extends Fragment {

    private User currentUser;
    private FirebaseFirestore userDatabase = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = userDatabase.collection("users");

    public MedicineFragment(User currentUser) {
        this.currentUser = currentUser;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        CollectionReference collectionReferences = collectionReference.document(currentUser.Uid).collection("Medicines");

        collectionReferences.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<Medicine> medicineList = queryDocumentSnapshots.toObjects(Medicine.class);

                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(medicineList, getActivity());
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });


        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;

    }
}
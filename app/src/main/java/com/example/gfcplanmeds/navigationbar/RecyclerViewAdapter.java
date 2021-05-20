package com.example.gfcplanmeds.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gfcplanmeds.R;
import com.example.gfcplanmeds.data.Medicine;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<Medicine> medicineNames;
    private Context context;

    public RecyclerViewAdapter (List<Medicine> medicineNames, Context context) {
        this.medicineNames =  medicineNames;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         holder.medicineName.setText(medicineNames.get(position).MedicineName);
         holder.parent_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 TextView textViewName = (TextView) ((Activity) context).findViewById(R.id.MedicineName);
                 TextView textViewDosage = (TextView) ((Activity) context).findViewById(R.id.Dosage);
                 TextView textViewTakenAt = (TextView) ((Activity) context).findViewById(R.id.TakenAt);
                 TextView textViewDay = (TextView) ((Activity) context).findViewById(R.id.DuringTheDay);
                 TextView textViewWeek = (TextView) ((Activity) context).findViewById(R.id.DuringTheWeek);

                 textViewName.setText(medicineNames.get(position).MedicineName);
                 textViewDosage.setText(medicineNames.get(position).Dosage);
                 textViewTakenAt.setText(medicineNames.get(position).ShouldBeTaken);
                 textViewDay.setText(medicineNames.get(position).TimesDay);
                 textViewWeek.setText(medicineNames.get(position).TimesWeek);
             }
         });
    }

    @Override
    public int getItemCount() {
        return medicineNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView medicineName;
        RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
          
            super(itemView);
            medicineName = itemView.findViewById(R.id.MedicineName1);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

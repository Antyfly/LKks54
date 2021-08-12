package com.example.proba;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class spisok_gr extends Fragment {

List ListUserTasks;
List<Spisok> listAdd ;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.spisok_gr, container, false);

        ListUserTasks = v.findViewById(R.id.spisor_gr);
        DatabaseReference  myRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference  commandmyRef = myRef.child("spisok_gr").child("spis_3_isp9_4");
        ValueEventListener listner = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {
                };
                ListUserTasks = dataSnapshot.child("spisok_gr").child("spis_3_isp9_4").getValue(t);
               /* for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Spisok spisok = ds.getValue(Spisok.class);
                    assert spisok != null;
                    listAdd.add(spisok);
                }


                updata();
                */
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
           // commandmyRef.addListenerForSingleValueEvent(listner);

        return v;
    }
    /*
    private void updata()
    {
        ArrayAdapter<String> adapter  =  new  ArrayAdapter<String>(Context, android.R.layout.simple_list_item_1);

        ListUserTasks.setAdapter(adapter);
    }
*/
}
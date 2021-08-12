package com.example.proba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;


public class stud_kab extends Fragment {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private String user = "user";
    private TextView text;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stud_kab,
                container, false);

        text = (TextView) view.findViewById(R.id.fio_student2);
        myRef = FirebaseDatabase.getInstance().getReference(user);
        getData();
        /*
        FirebaseUser user = mAuth.getCurrentUser();
        myRef.child(user.getUid()).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<TextView> t = new GenericTypeIndicator<TextView>() {};
                text = snapshot.child("user").getValue(t);
                updateUI();
            }
            private void updateUI() {
                ArrayAdapter <String> adapter = new ArrayAdapter<String>(getBaseContext(),);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         */
        return view;
    }

    private void getData()
    {
        ValueEventListener vList = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //user user = snapshot.getValue(autoriz_win.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        myRef.addValueEventListener(vList);

        }
    }



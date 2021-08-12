package com.example.proba;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.List;

public class news_prepod extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private List<String> News;

    ListView NewsUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        getSupportActionBar().hide();
        NewsUser = (ListView) findViewById(R.id.newslist);

        myRef = FirebaseDatabase.getInstance().getReference();

        FirebaseUser user = mAuth.getInstance().getCurrentUser();


        ImageButton addnew = findViewById(R.id.addnew);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent01 = new Intent(news_prepod.this, addnewsActivity.class);
                startActivity(intent01);
            }
        });


        myRef.child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<List<String>> t = new GenericTypeIndicator<List<String>>() {};
                News = snapshot.child("id_news").getValue(t);

                updateUI();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void updateUI() {
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1);

        NewsUser.setAdapter(adapter);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        Class fragmentClass = null;

        int id = item.getItemId();
        if(id == R.id.news)
        {
            Toast.makeText(getApplicationContext(),"Данный раздел в разработке!!!!",Toast.LENGTH_SHORT).show();
            //fragmentClass = news_prepod.class;
        }
        else if (id == R.id.profile_prepod) {
            // Handle the camera action

            fragmentClass = prepod_kab.class;
        }
        else if (id == R.id.nav_gallery) {

            fragmentClass = raspis_gr.class;

        } else if (id == R.id.nav_slideshow) {
          //  fragmentClass = raspis_prepod.class;
            Toast.makeText(getApplicationContext(),"Данный раздел в разработке!!!!",Toast.LENGTH_SHORT).show();
        }
         else if (id == R.id.zach)
        {
            Toast.makeText(getApplicationContext(),"Данный раздел в разработке!!!!",Toast.LENGTH_SHORT).show();
        }
         else if(id == R.id.spr)
        {
            Toast.makeText(getApplicationContext(),"Данный раздел в разработке!!!!",Toast.LENGTH_SHORT).show();
            //fragmentClass = spisok_gr.class;
        }

        try
        {
            fragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_prepod, fragment).commit();
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}




       /* FloatingActionButton addnewbtn = (FloatingActionButton) findViewById(R.id.addnewbtn);
        addnewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnew = new Intent(news_prepod.this, addnew_wind.class);
                startActivity(intentnew);
            }
        });

        */
        





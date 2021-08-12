package com.example.proba;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class autoriz_win extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    public EditText Login, Password;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseDatabase mDataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autoriz_win);
        //убирает тулбар сверху
        getSupportActionBar().hide();
        Intent intent = getIntent();
        //mAuth = FirebaseAuth.getInstance();
        Login = findViewById(R.id.usernameTXT);
        Password = findViewById(R.id.passwordTXT);
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance();

        ImageButton vklink = (ImageButton) findViewById(R.id.vklink);
        vklink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/ks54ru"));
                startActivity(intent);
            }
        });


        ImageButton instalink = (ImageButton) findViewById(R.id.instalink);
        instalink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ks54ru/"));
                startActivity(intent);
            }
        });

        ImageButton facebooklink = (ImageButton) findViewById(R.id.facebooklink);
        facebooklink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ks54ru/"));
                startActivity(intent);
            }
        });
        TextView link = (TextView) findViewById(R.id.link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ks54.ru/lk/forgot-password"));
                startActivity(intent);
            }
        });


        ImageButton login = (ImageButton) findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Login == null || Password == null) {
                    Toast.makeText(getApplicationContext(), "Введите данные!!!!!", Toast.LENGTH_SHORT).show();
                }
                proba();
                perexod(Login.getText().toString(), Password.getText().toString());
            }
        });
    }


    public void perexod(final String email, String password) {

        //  if (!TextUtils.isEmpty(Login.getText().toString()) && !TextUtils.isEmpty(Password.getText().toString()))
        mAuth.signInWithEmailAndPassword(Login.getText().toString(), Password.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    if (UserStatic.role == 2) {
                        Intent intent = new Intent(autoriz_win.this, MainActivity.class);
                        intent.putExtra("index", (Integer) 1); // счетчик для определения страницы
                        startActivity(intent);
                    }

                    if (UserStatic.role == 1) {
                        Intent intent = new Intent(autoriz_win.this, news_prepod.class);
                        intent.putExtra("index", (Integer) 2); // счетчик для определения страницы
                        startActivity(intent);
                    }
                    // Toast.makeText(getApplicationContext(),"Пользователь вошел успешно",Toast.LENGTH_SHORT).show();
                    //qwe();
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка!!! Проверьте свои данные", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public  void proba() {
        final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("base").child("user");

        myRef.orderByChild("email").equalTo(Login.getText().toString()).addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                User user = snapshot.getValue(User.class);
                UserStatic.sname = user.sname;
                UserStatic.email = user.email;
                UserStatic.group = user.group;
                UserStatic.role = user.role;
                UserStatic.fathername = user.fathername;
                UserStatic.obras = user.obras;
                UserStatic.data_rogd = user.data_rogd;
                UserStatic.raspis = user.raspis;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}



package com.example.proba;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

public class addnewsActivity  extends AppCompatActivity {

   // private FirebaseDatabase database;
  //  private DatabaseReference myRef;
    @IgnoreExtraProperties
    static class Item implements Serializable{
        static String text;

        public Item(){}
        Item(String text){
            Item.text = text;
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew_wind);
        EditText etNew = findViewById(R.id.etNew);
        ImageButton publicbtn = findViewById(R.id.publicnew);
        ItemsAdapter adapter = new ItemsAdapter();
        ListView newslist = findViewById(R.id.newslist);
        newslist.setAdapter(adapter);
        publicbtn.setOnClickListener(v -> adapter.add( new Item(etNew.getText().toString())));


    }

    private class ItemsAdapter extends ArrayAdapter<Item> {
        ItemsAdapter() {
            super(addnewsActivity.this, R.layout.item); }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view =  getLayoutInflater().inflate(R.layout.item, null);
            Item item = getItem(position);
            ((TextView) view.findViewById(R.id.newscase)).setText(item.text);
            return view;
        }

    }

}









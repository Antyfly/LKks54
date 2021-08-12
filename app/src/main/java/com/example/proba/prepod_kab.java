package com.example.proba;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class prepod_kab extends Fragment {
    private TextView  Login;
    String fname;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.prepod_kab, container, false);
/*
        Login = v.findViewById(R.id.fioprepod_txt);
        fname = UserStatic.fname;
        Login.setText(fname);

*/
        return v;
    }
}


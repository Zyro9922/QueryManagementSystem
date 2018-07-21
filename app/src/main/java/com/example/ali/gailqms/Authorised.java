package com.example.ali.gailqms;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Authorised extends AppCompatActivity {

    EditText passCode;
    CardView access;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorised);

        //setting with VIEWS
        passCode = findViewById(R.id.pass);
        access = findViewById(R.id.access);

        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pass = passCode.getText().toString();

                if(pass.equals("QMS@1234"))
                {
                    Intent intent = new Intent(Authorised.this,Staff.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(Authorised.this,"WRONG PASSCODE",Toast.LENGTH_LONG).show();
                }

            }
        });


    }



}

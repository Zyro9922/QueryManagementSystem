package com.example.ali.gailqms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CardView loginButton;
    EditText userName;
    EditText password;
    CardView authorised;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideNavigationBar();

        loginButton = findViewById(R.id.cardView);
        userName = findViewById(R.id.name);
        password = findViewById(R.id.pass);
        authorised = findViewById(R.id.auth);

        //LOGIN BUTTON
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FirebaseActivity.class);

                Config config = new Config(userName.getText().toString().trim(),password.getText().toString().trim());

                startActivity(intent);
            }
        });

        //AUTHORISED PERSON ONLY
        authorised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Authorised.class);
                startActivity(intent);
            }
        });

    }

    private void hideNavigationBar()
    {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

}

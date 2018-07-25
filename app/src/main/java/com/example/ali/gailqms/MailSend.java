package com.example.ali.gailqms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MailSend extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
    private TextView nameOfDept;
    private EditText editTextSubject;
    private EditText editTextMessage;

    //Send button
    private Button buttonSend;
    private TextView infoDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_send);

        //Initializing the views
        nameOfDept = findViewById(R.id.deptName);
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        editTextMessage = (EditText) findViewById(R.id.editTextMessage);
        infoDialog = findViewById(R.id.moreinfo);

        Intent intent = getIntent();

        String deptName = intent.getStringExtra(FirebaseActivity.DEPT_NAME);

        nameOfDept.setText(deptName);

        buttonSend = (Button) findViewById(R.id.buttonSend);

        //Adding click listener
        buttonSend.setOnClickListener(this);

        infoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();

                String description = intent.getStringExtra(FirebaseActivity.DEPT_DESC);

                showDialog(description);
            }
        });
    }


    private void sendEmail() {
        //Getting content for email

        Intent intent = getIntent();

        String email = intent.getStringExtra(FirebaseActivity.DEPT_EMAIL);
        String subject = editTextSubject.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message+"\n\n\nSend from QMS Application");

        //Executing sendmail to send email
        sm.execute();
    }



    private void showDialog(String desc){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.info_dialog,null);

        dialogBuilder.setView(dialogView);

        final TextView description = dialogView.findViewById(R.id.info);

        description.setText(desc);


        dialogBuilder.setTitle("About the department");

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
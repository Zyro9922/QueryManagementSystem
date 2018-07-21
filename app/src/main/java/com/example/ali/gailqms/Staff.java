package com.example.ali.gailqms;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Staff extends AppCompatActivity {

    EditText deptName;
    EditText emailID;
    EditText desc;
    Button buttonAddDept;

    ListView listView;

    List<Department> deptList;

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        //referencing
        ref = FirebaseDatabase.getInstance().getReference("Departments");

        //setting with VIEWS
        deptName = findViewById(R.id.editTextDeptName);
        emailID = findViewById(R.id.editTextEmail);
        desc = findViewById(R.id.editTextDesc);
        buttonAddDept = findViewById(R.id.buttonAddDept);
        listView = findViewById(R.id.listViewDept);
        deptList = new ArrayList<>();

        //BUTTON CALLS addDept METHOD
        buttonAddDept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDept();
            }
        });


        //POPULATING LISTVIEW WITH VALUES
        //MOST AWESOME PART
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //TO CLEAR AFTER CHANGES
                deptList.clear();

                for(DataSnapshot artistSnapshot : dataSnapshot.getChildren())
                {
                    Department artist = artistSnapshot.getValue(Department.class);
                    deptList.add(artist);
                }
                final AuthCustomAdapter adapter = new AuthCustomAdapter(Staff.this,deptList);

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Department dept = deptList.get(position);

                showUpdateDialog(dept.getId(),dept.getDeptName());

                return false;
            }
        });
    }


    //UPDATE DIALOG
    private void showUpdateDialog(final String deptId, String deptName)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.update_dialog,null);

        dialogBuilder.setView(dialogView);

        final EditText updateDeptName = dialogView.findViewById(R.id.updateDeptName);
        final EditText updateEmail = dialogView.findViewById(R.id.updateEmail);
        final EditText updateDescription = dialogView.findViewById(R.id.updateDescription);
        final Button buttonDelete = dialogView.findViewById(R.id.deleteButton);
        final Button updateButton = dialogView.findViewById(R.id.updateButton);


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDept(deptId);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = updateDeptName.getText().toString().trim();
                String email = updateEmail.getText().toString().trim();
                String desc = updateDescription.getText().toString().trim();

                if(TextUtils.isEmpty(name))
                {
                    updateDeptName.setError("Name required");
                    return;
                }

                updateDept(name,email,desc,deptId);

            }
        });

        dialogBuilder.setTitle("Updating Artist "+deptName);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }

    //TO DELETE ENTRY
    private void deleteDept(String id){

        DatabaseReference drDept = FirebaseDatabase.getInstance().getReference("Departments").child(id);
        drDept.removeValue();

        Toast.makeText(this,"Artist Entry deleted",Toast.LENGTH_LONG).show();

    }

    //TO UPDATE ENTRY
    private void updateDept(String deptName,String emailId, String description ,String id){

        DatabaseReference dref = FirebaseDatabase.getInstance().getReference("Departments").child(id);

        Department dept = new Department(deptName,emailId,description,id);

        dref.setValue(dept);

        Toast.makeText(this,"Artist update",Toast.LENGTH_LONG).show();

    }

    //TO ADD DEPARTMENT IN FIREBASE
    private void addDept(){

        String nameOfDept = deptName.getText().toString().trim();
        String nameOfEmail = emailID.getText().toString().trim();
        String nameOfDesc = desc.getText().toString().trim();

        if(!TextUtils.isEmpty(nameOfDept))
        {
            String id = ref.push().getKey();

            Department dept = new Department(nameOfDept,nameOfEmail,nameOfDesc,id);

            ref.child(id).setValue(dept);

            Toast.makeText(this,"Department Added",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"Enter Department name",Toast.LENGTH_LONG).show();
        }
    }
}

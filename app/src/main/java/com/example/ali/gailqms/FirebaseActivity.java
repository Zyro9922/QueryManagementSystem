package com.example.ali.gailqms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseActivity extends AppCompatActivity implements CustomAdapter.CustomAdapterListener {

    public static final String DEPT_NAME = "artistName";
    public static final String DEPT_EMAIL = "artistEmail";
    public static final String DEPT_DESC = "desc";


    private CustomAdapter adapter;

    private List<Department> deptList;
    private  RecyclerView recyclerView;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        ref = FirebaseDatabase.getInstance().getReference("Departments");
        recyclerView = findViewById(R.id.listViewDepartments);
        deptList = new ArrayList<>();

        adapter = new CustomAdapter(FirebaseActivity.this,deptList,this);


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

                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(FirebaseActivity.this));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        SearchView searchView = findViewById(R.id.search_View);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                recyclerView.setAdapter(adapter);

                return false;
            }
        });

    }

    @Override
    public void onDepartmentSelected(Department dept) {

        Intent intent = new Intent(this,MailSend.class);

        intent.putExtra(DEPT_NAME,dept.getDeptName());
        intent.putExtra(DEPT_EMAIL,dept.getEmailId());
        intent.putExtra(DEPT_DESC,dept.getDescription());

        startActivity(intent);

    }
}

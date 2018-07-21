package com.example.ali.gailqms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AuthCustomAdapter extends ArrayAdapter<Department> {

    private Context context;
    private List<Department> deptList;

    public AuthCustomAdapter(@NonNull Context context, List<Department> deptList) {
        super(context,R.layout.layout_departments, deptList);

        this.context = context;
        this.deptList = deptList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View customView = inflater.inflate(R.layout.layout_departments,parent,false);

        TextView text1 = customView.findViewById(R.id.textViewDepartment);
        TextView text2 = customView.findViewById(R.id.textViewEmail);

        Department dept = getItem(position);

        text1.setText(dept.getDeptName());
        text2.setText("Email-ID " + dept.getEmailId());

        return customView;

    }
}

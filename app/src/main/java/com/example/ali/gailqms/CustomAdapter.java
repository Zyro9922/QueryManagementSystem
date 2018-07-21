package com.example.ali.gailqms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
        implements Filterable {

    private Context context;
    private List<Department> deptList;
    private List<Department> deptListFiltered;
    private CustomAdapterListener listener;

    public interface CustomAdapterListener {
        void onDepartmentSelected(Department department);
    }

    public CustomAdapter(Context context, List<Department> placeList, CustomAdapterListener listener) {

        this.context = context;
        this.listener = listener;
        this.deptList = placeList;
        this.deptListFiltered = placeList;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_departments, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView departmentName,departmentEmail;

        public MyViewHolder(View view) {
            super(view);
            departmentName = view.findViewById(R.id.textViewDepartment);
            departmentEmail = view.findViewById(R.id.textViewEmail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onDepartmentSelected(deptListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        final Department dept = deptListFiltered.get(position);
        holder.departmentName.setText(dept.getDeptName());
        holder.departmentEmail.setText(dept.getEmailId());
    }

    @Override
    public int getItemCount() {
        return deptListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    deptListFiltered = deptList;
                }
                else {
                    List<Department> filteredList = new ArrayList<Department>();

                    for (Department row : deptList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getDeptName().toLowerCase().contains(charString.toLowerCase()) || row.getEmailId().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    deptListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = deptListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                deptListFiltered = (List<Department>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}

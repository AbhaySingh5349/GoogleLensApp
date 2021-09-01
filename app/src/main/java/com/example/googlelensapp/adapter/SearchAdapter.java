package com.example.googlelensapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlelensapp.R;
import com.example.googlelensapp.model.SearchDataModel;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private Context context;
    private ArrayList<SearchDataModel> searchDataModelArrayList;

    public SearchAdapter(Context context, ArrayList<SearchDataModel> searchDataModelArrayList) {
        this.context = context;
        this.searchDataModelArrayList = searchDataModelArrayList;
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        SearchDataModel searchDataModel = searchDataModelArrayList.get(position);

        holder.titleTextView.setText(searchDataModel.getTitle());
        holder.infoTextView.setText(searchDataModel.getSnippet());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(searchDataModel.getLink()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchDataModelArrayList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, infoTextView;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
        }
    }
}

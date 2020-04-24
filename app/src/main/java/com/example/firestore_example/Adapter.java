package com.example.firestore_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private ArrayList<MSG> texts;
    onClick activity;
    public interface onClick{
        void onItemClicked(int index);
    }

    public Adapter(Context context,ArrayList<MSG> list){
        texts=list;
        activity=(onClick)context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView una,ts,msg;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            una=itemView.findViewById(R.id.una);
            ts=itemView.findViewById(R.id.ts);
            msg=itemView.findViewById(R.id.msg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(texts.indexOf(itemView.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.itemView.setTag(texts.get(position));
        holder.una.setText(texts.get(position).getUsername());
        holder.ts.setText(texts.get(position).getTimestamp());
        holder.msg.setText(texts.get(position).getMessage());

    }

    @Override
    public int getItemCount() {

        return texts.size();
    }
}

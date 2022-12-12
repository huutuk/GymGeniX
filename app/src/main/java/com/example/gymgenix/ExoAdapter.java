package com.example.gymgenix;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExoAdapter extends RecyclerView.Adapter<ExoAdapter.ExoViewHolder> {

    private Context context;
    private Cursor cursor;


    public ExoAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;

    }

    @NonNull
    @Override
    public ExoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.exo_item, parent, false);
        return new ExoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExoViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(SeanceStringUtils.ExoEntry.COLUMN_EXO_NAME));
        @SuppressLint("Range") int repAmount = cursor.getInt(cursor.getColumnIndex(SeanceStringUtils.ExoEntry.COLUMN_EXO_REP));
        @SuppressLint("Range") int weightAmount = cursor.getInt(cursor.getColumnIndex(SeanceStringUtils.ExoEntry.COLUMN_EXO_WEIGHT));
        @SuppressLint("Range") long id = cursor.getLong(cursor.getColumnIndex(SeanceStringUtils.ExoEntry._ID));

        holder.nameExo.setText(name);
        holder.countRep.setText(String.valueOf(repAmount));
        holder.countWeight.setText(String.valueOf(weightAmount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }


    public static class ExoViewHolder extends RecyclerView.ViewHolder {
        public TextView nameExo;

        public TextView countRep;
        public TextView countWeight;


        public ExoViewHolder(@NonNull View itemView) {
            super(itemView);
            nameExo = itemView.findViewById(R.id.tv_exo_name);
            countRep = itemView.findViewById(R.id.tv_amount_rep);
            countWeight = itemView.findViewById(R.id.tv_amount_weight);

        }
    }
}

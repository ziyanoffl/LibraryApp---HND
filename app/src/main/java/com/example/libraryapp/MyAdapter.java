package com.example.libraryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Book> list;

    public MyAdapter(Context context, ArrayList<Book> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = list.get(position);
        holder.bookNameTxt.setText(book.getName());
        holder.bookAuthorTxt.setText(book.getAuthor());
        holder.bookDescriptionTxt.setText(book.getSynopsis());
        holder.bookPriceTxt.setText(book.getPrice());
        holder.bookTypeTxt.setText(book.getType());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView bookNameTxt, bookAuthorTxt, bookDescriptionTxt, bookPriceTxt, bookTypeTxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookNameTxt = itemView.findViewById(R.id.tv_bookTitle);
            bookAuthorTxt = itemView.findViewById(R.id.tv_bookAuthor);
            bookDescriptionTxt = itemView.findViewById(R.id.tv_bookDescription);
            bookPriceTxt = itemView.findViewById(R.id.tv_price);
            bookTypeTxt = itemView.findViewById(R.id.tv_bookType);
        }
    }
}

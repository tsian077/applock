package com.example.applock2.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applock2.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView app_name;
    public ImageView app_icon , lock_app;

    public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);

        app_name=itemView.findViewById(R.id.App_name);
        app_icon=itemView.findViewById(R.id.App_icon);
        lock_app=itemView.findViewById(R.id.Lock_app);
    }
}

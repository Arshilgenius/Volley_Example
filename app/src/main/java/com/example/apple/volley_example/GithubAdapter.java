package com.example.apple.volley_example;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by apple on 04/06/18.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {



    private Context context;
    private User[] data;

    public GithubAdapter(Context context,User[] data)
    {
    this.context = context;
    this.data = data;
    }


    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_user_layout,parent,false);
        return new GithubViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {

        User user = data[position];
        holder.txtUser.setText(user.getLogin());
        Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder {

        ImageView imgUser;
        TextView txtUser;

        public GithubViewHolder(View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            txtUser = itemView.findViewById(R.id.txtUser);
        }
    }
}

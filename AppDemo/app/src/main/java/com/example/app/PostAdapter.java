package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> mPosts;

    public PostAdapter(List<Post> posts) {

        this.mPosts = posts;
    }

    //From Blog post(loasd.tistory, zynar.tistory, aries574.tistory) 5/17/24
    //From Youtube 'Roon Sky' 5/23/24
    //Mod by Chaeyoon Song 5/23/24
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.titleTextView.setText(post.getTitle());
        holder.contentsTextView.setText(post.getContents());
        holder.usernameTextView.setText(post.getUsername());

        List<String> imageUrls = post.getImageUrls();
        if (imageUrls != null) {
            if (imageUrls.size() > 0) {
                Glide.with(holder.itemView.getContext()).load(imageUrls.get(0)).into(holder.imageView1);
            }
            if (imageUrls.size() > 1) {
                Glide.with(holder.itemView.getContext()).load(imageUrls.get(1)).into(holder.imageView2);
            }
            if (imageUrls.size() > 2) {
                Glide.with(holder.itemView.getContext()).load(imageUrls.get(2)).into(holder.imageView3);
            }
        }
    }

    @Override
    public int getItemCount() {

        return mPosts.size();
    }

    //From Youtube 'Roon Sky' 5/23/24
    //Mod by Chaeyoon Song 5/23/24
    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView contentsTextView;
        TextView usernameTextView;
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.item_post_title);
            contentsTextView = itemView.findViewById(R.id.item_post_contents);
            usernameTextView = itemView.findViewById(R.id.item_post_username);
            imageView1 = itemView.findViewById(R.id.item_post_image1);
            imageView2 = itemView.findViewById(R.id.item_post_image2);
            imageView3 = itemView.findViewById(R.id.item_post_image3);
        }
    }
}

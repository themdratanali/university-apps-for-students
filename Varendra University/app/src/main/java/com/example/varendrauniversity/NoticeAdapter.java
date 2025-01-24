package com.example.varendrauniversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private Context context;
    private final ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout,parent,false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {
        NoticeData currentItem = list.get(position);

        holder.noticeTitel.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null && !currentItem.getImage().isEmpty()) {
                Picasso.get().load(currentItem.getImage()).into(holder.noticeImage);
            } else {
                // If image URL is null or empty, you can set a placeholder image or hide the image view
                holder.noticeImage.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle Picasso or any other exception that might occur during image loading
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView noticeTitel,date,time;
        private ImageView noticeImage;
        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            noticeTitel = itemView.findViewById(R.id.noticeTitel);
            noticeImage = itemView.findViewById(R.id.noticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }
}

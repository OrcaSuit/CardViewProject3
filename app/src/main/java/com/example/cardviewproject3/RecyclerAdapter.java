package com.example.cardviewproject3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<ItemInCardView> list;

    public RecyclerAdapter(Context context, List<ItemInCardView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int position) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, null);
       return new ViewHolder(v)/
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        final ItemIncardView oneItem = list.get(position);
        Drawable drawable = context.getResources().getDrawable(oneItem.getImg());
        String title = oneItem.getTitle();

        holder.img.setImageDrawable(drawable);
        holder.textView.setText(title);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(context, oneItem.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { return list.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView cardView;
        TextView textView;

        public ViewHolder(View itemView){
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.mImage);
            cardView = (CardView)itemView.findViewById(R.id.cardView);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}

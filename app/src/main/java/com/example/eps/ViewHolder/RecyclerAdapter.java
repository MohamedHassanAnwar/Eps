package com.example.eps.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.model.Model;
import com.example.eps.AnotherActivity;
import com.example.eps.Interface.ItemClickListener;
import com.example.eps.Model.Item;
import com.example.eps.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mTitle,mDes;
    public CircleImageView mImg;

    ItemClickListener itemClickListener;

     RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = (TextView)itemView.findViewById(R.id.titleTv);
        mDes= (TextView)itemView.findViewById(R.id.descriptionTv);
        mImg = (CircleImageView)itemView.findViewById(R.id.imageIv);

        itemView.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
         this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {

         this.itemClickListener = ic;
    }


}
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private ArrayList<Item> models;
    private Context context;

    public RecyclerAdapter(ArrayList<Item> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,null);

        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, int position) {
        holder.mTitle.setText(models.get(position).getTitle());
        holder.mDes.setText(models.get(position).getDescription());
        holder.mImg.setImageResource(models.get(position).getImg());


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {

                String gTitle = models.get(position).getTitle();
                String gDesc = models.get(position).getDescription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.mImg.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context, AnotherActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);
                context.startActivity(intent);
            }
        });

        /*holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                if (models.get(position).getTitle().equals("people")){

                }
                if (models.get(position).getTitle().equals("myphoto")){

                }
                if (models.get(position).getTitle().equals("notes")){

                }

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

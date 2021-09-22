package com.leemurking.leemurkingstore;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.leemurking.leemurkingstore.Model.Products;
import com.leemurking.leemurkingstore.ViewHolder.ProductViewHolder;
import com.squareup.picasso.Picasso;

public class FirebaseRecyclerAdapter<T, T1> extends RecyclerView.Adapter {
    public FirebaseRecyclerAdapter(FirebaseRecyclerOptions<T> options) {
    }

    public FirebaseRecyclerAdapter(com.firebase.ui.database.FirebaseRecyclerOptions<T> options) {
    }

    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull final Products model)
    {
        holder.txtProductName.setText(model.getPname());
        holder.txtProductDescription.setText(model.getDescription());
        holder.txtProductPrice.setText("Price = " + model.getPrice() + "Rs.");
        Picasso.get().load(model.getImage()).into(holder.imageView);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home.this,ProductDetailsActivity.class);
//                intent.putExtra("pid",model.getPid());
//                startActivity(intent);
//            }
//
//            private void startActivity(Intent intent) {
//            }
//        });
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void startListening() {
    }
}

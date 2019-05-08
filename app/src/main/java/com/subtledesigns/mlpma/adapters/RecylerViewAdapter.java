package com.subtledesigns.mlpma.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.subtledesigns.mlpma.R;
import com.subtledesigns.mlpma.model.Product;

import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Product> mData;
    RequestOptions option;

    public RecylerViewAdapter(Context mContext, List<Product> mData){
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.product_row_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.productName.setText(mData.get(i).getName());
        myViewHolder.productPrice.setText(mData.get(i).getPrice());
        myViewHolder.productVendor.setText(mData.get(i).getVendor());
        myViewHolder.productCategory.setText(mData.get(i).getCategory());

        // Load image from the internet and set it into the image view
        Glide.with(mContext).load(mData.get(i).getImg_url()).apply(option).into(myViewHolder.imgThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productName;
        TextView productCategory;
        TextView productPrice;
        TextView productVendor;
        ImageView imgThumbnail;

        public MyViewHolder(View itemView){

            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            productCategory = itemView.findViewById(R.id.product_category);
            productPrice = itemView.findViewById(R.id.product_price);
            productVendor = itemView.findViewById(R.id.product_vendor);
            imgThumbnail = itemView.findViewById(R.id.product_thumbnail);
        }
    }
}

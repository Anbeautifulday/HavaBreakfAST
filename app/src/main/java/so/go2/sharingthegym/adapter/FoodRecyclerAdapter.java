package so.go2.sharingthegym.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import so.go2.sharingthegym.MyApplication;
import so.go2.sharingthegym.PayActivity;
import so.go2.sharingthegym.R;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Food> foods = new ArrayList<>();

    public FoodRecyclerAdapter(Context context, List<Food> foods) {
        this.foods = foods;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PayActivity.class);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Food ad = foods.get(position);
        holder.ad_img.setImageResource(ad.getImgId());
        holder.ad_title.setText(ad.getInfo());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView ad_title;
        ImageView ad_img;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ad_title = (TextView) itemView.findViewById(R.id.foodTxt);
            ad_img = (ImageView) itemView.findViewById(R.id.foodPic);
        }
    }

}

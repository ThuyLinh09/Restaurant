package com.example.ordercheftmobile;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordercheftmobile.my_interface.IClickItemRestaurantListener;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private final List<Restaurant> restaurants;
    private IClickItemRestaurantListener iClickItemRestaurantListener;
    public RestaurantAdapter(List<Restaurant> restaurants,IClickItemRestaurantListener listener) {
        this.restaurants = restaurants;
        this.iClickItemRestaurantListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);
        if(restaurant == null){return;}
        holder.restaurantName.setText(restaurant.getName());
        holder.restaurantLastAccess.setText(restaurant.getLastAccess());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemRestaurantListener.onClickItemRestaurant(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (restaurants != null) {
            return restaurants.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView restaurantName;
        private final TextView restaurantLastAccess;
        private final LinearLayout layoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurant_name);
            restaurantLastAccess = itemView.findViewById(R.id.restaurant_last_access);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }
    }
}

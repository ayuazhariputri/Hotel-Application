package com.example.hotelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {
    private Context mCtx;
    private List<Hotel> hotelList;
    private final RecyclerViewInterface recyclerViewInterface;

    public HotelAdapter(Context mCtx, List<Hotel> hotelList, RecyclerViewInterface recyclerViewInterface) {
        this.mCtx = mCtx;
        this.hotelList = hotelList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.hotel_list, null);
        HotelViewHolder holder = new HotelViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HotelViewHolder holder, int position) {
        Hotel hotel =hotelList.get(position);

        holder.hotelName.setText(hotel.getName());
        holder.hotelDesc.setText(hotel.getShortDesc());
        holder.hotelPrice.setText(hotel.getPrice());

        holder.hotelImage.setImageDrawable(mCtx.getResources().getDrawable(hotel.getImage()));
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    class HotelViewHolder extends RecyclerView.ViewHolder {

        ImageView hotelImage;
        TextView hotelName, hotelDesc, hotelPrice;

        public HotelViewHolder(View itemView) {
            super(itemView);

            hotelImage = itemView.findViewById(R.id.hotel_image);
            hotelName = itemView.findViewById(R.id.nama_hotel);
            hotelDesc = itemView.findViewById(R.id.desc_hotel);
            hotelPrice = itemView.findViewById(R.id.harga_hotel);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}

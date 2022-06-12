package com.example.BikeApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    ArrayList<StationVelo> mesStationsVelo = new ArrayList<>();
    Context context;
    RecyclerViewAdapter( Context context,ArrayList<StationVelo> mesStationsVelo){
        this.mesStationsVelo = mesStationsVelo;
        this.context = context;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.display(mesStationsVelo.get(position));
    }

    @Override
    public int getItemCount() {
        return mesStationsVelo.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private TextView nom_API, nom_station_API, address_API;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            nom_API = itemView.findViewById(R.id.nom_API);
            nom_station_API = itemView.findViewById(R.id.nom_station_API);
            address_API = itemView.findViewById(R.id.address_API);

        }
        void display (StationVelo stationVelo){
            if(stationVelo.getField().getContract_name() != null){
                nom_API.setText(stationVelo.getField().getContract_name());
            }else{
                nom_API.setVisibility(View.GONE);
            }
            nom_station_API.setText(stationVelo.getField().getName());
            address_API.setText(stationVelo.getField().getAddress());
        }
    }
}

package com.example.BikeApp;

import java.util.ArrayList;

public class Records {
    private ArrayList<StationVelo> records = new ArrayList<StationVelo>();

    public Records(ArrayList<StationVelo> records){
        this.records = records;
    }
    public ArrayList<StationVelo> getListStationVelo() {
        return records;
    }
}

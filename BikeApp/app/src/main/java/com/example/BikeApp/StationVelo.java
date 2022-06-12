package com.example.BikeApp;

public class StationVelo {
    private Fields fields;
    private Geometry geometry;

    public StationVelo(Fields fields, Geometry geometry){
        this.geometry = geometry;
        this.fields = fields;

    }
    public Fields getField() {
        return fields;
    }
    public Geometry getGeometry() {
        return geometry;
    }
}

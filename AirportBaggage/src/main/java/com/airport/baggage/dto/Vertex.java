package com.airport.baggage.dto;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class Vertex {

	final private int id;
    final private String name;
 
    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }

}

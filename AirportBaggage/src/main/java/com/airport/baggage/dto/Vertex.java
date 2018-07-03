package com.airport.baggage.dto;

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

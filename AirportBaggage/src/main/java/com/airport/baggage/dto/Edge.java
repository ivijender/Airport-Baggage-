package com.airport.baggage.dto;

/**
 * Created by inavoulv on 7/2/2018.
 */
public class Edge {
   private Vertex source;
    private Vertex destination;
    private int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Edge(){
    	
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
        return weight;
    }

    public void setSource(Vertex source) {
		this.source = source;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
    public String toString() {
        return source + " " + destination;
    }
}

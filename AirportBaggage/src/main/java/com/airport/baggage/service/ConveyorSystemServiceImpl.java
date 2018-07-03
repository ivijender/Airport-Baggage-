package com.airport.baggage.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.airport.baggage.constent.AirportBaggageConstent;
import com.airport.baggage.dto.Edge;
import com.airport.baggage.dto.Graph;
import com.airport.baggage.dto.Vertex;
import com.airport.baggage.util.OptimalRouteSearchUtil;

public class ConveyorSystemServiceImpl {
	private List<Vertex> nodes = AirportBaggageConstent.NODES;

	public LinkedList<Vertex> forwardSearch(List<Edge> edges, int source, int destination) {
		Graph graph = new Graph(nodes, edges);
		OptimalRouteSearchUtil search = new OptimalRouteSearchUtil(graph);
		ArrayList<Vertex> settledNodes=search.executeOptimalRouteSearch(nodes.get(source));
		LinkedList<Vertex> path = search.getPath(nodes.get(destination));
	
		return path;
	}
	public LinkedList<Vertex> backwordSearch(List<Edge> edges, int source, int destination) {
		Graph graph = new Graph(nodes, edges);
		OptimalRouteSearchUtil search = new OptimalRouteSearchUtil(graph);
		ArrayList<Vertex> settledNodes=search.executeOptimalRouteSearch(nodes.get(source));
		LinkedList<Vertex> path = search.getPath(nodes.get(destination));
		if(path==null) {
			int size=settledNodes.size()-1;
			if(settledNodes.get(size).getId()==destination) {
	        	path = search.getPath(nodes.get(destination));
	        }else {
	        	path = search.getPath(nodes.get(settledNodes.get(size).getId()));
	        	path.removeLast();
	        }
		}
	 
		return path;
	}

	public LinkedList<Vertex> getPath(Graph graph, Vertex target) {
		OptimalRouteSearchUtil dijkstra = new OptimalRouteSearchUtil(graph);
		LinkedList<Vertex> path = dijkstra.getPath(target);
		return path;
	}
}

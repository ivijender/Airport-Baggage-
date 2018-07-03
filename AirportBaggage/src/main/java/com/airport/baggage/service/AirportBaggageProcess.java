package com.airport.baggage.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.airport.baggage.constent.AirportBaggageConstent;
import com.airport.baggage.dto.Departures;
import com.airport.baggage.dto.Edge;
import com.airport.baggage.dto.Vertex;
import com.airport.baggage.vo.AirportBaggageResVO;
import com.airport.baggage.vo.BaggageReqVO;
import com.airport.baggage.vo.BaggageResVO;

public class AirportBaggageProcess {
	private List<Vertex> nodes;
	private List<Edge> edges;
	private ConveyorSystemServiceImpl conveyorSystemServiceImpl;

	public AirportBaggageProcess() {
		nodes = AirportBaggageConstent.NODES;
		edges = new ArrayList<Edge>();
		addLane(0, 5, 5);
		addLane(5, 11, 5);
		addLane(5, 10, 4);
		addLane(5, 1, 6);
		addLane(1, 2, 1);
		addLane(2, 3, 1);
		addLane(3, 4, 1);
		addLane(10, 9, 1);
		addLane(9, 8, 1);
		addLane(8, 7, 1);
		addLane(7, 6, 1);
	}

	public BaggageResVO processAirportBaggage(String bagNumber, String entryPoint, String flightId) {
		BaggageResVO baggageResVO = new BaggageResVO();
		baggageResVO.setId(bagNumber);
		List<Departures> departures = AirportBaggageConstent.DEPARTURES_LIST;
		String flightGate = null;
		boolean isFlightGateFound = false;
		for (Departures departure : departures) {
			if (departure.getFlightId().equals(flightId)) {
				flightGate = departure.getFlightGate();
				isFlightGateFound = true;
			}
			if (flightId.equals(AirportBaggageConstent.ARRIVAL)) {
				flightGate = AirportBaggageConstent.BAGGAGE_CLAIM;
				isFlightGateFound = true;
			}
		}

		if (isFlightGateFound) {
			conveyorSystemServiceImpl = new ConveyorSystemServiceImpl();

			int src = 0;
			int dest = 0;
			for (Vertex vertex : nodes) {
				if (vertex.getName().equals(entryPoint)) {
					src = vertex.getId();
				}
				if (vertex.getName().equals(flightGate)) {
					dest = vertex.getId();
				}
			}
			// Lets check from location Loc_1 to Loc_10
			LinkedList<Vertex> path = conveyorSystemServiceImpl.forwardSearch(edges, src, dest);

			if (path == null) {
				List<Edge> backWordEdges = new ArrayList<Edge>();
				for (Edge edge : edges) {
					Edge bEdge = new Edge();
					bEdge.setDestination(edge.getSource());
					bEdge.setSource(edge.getDestination());
					bEdge.setWeight(edge.getWeight());
					backWordEdges.add(bEdge);
				}
				path = conveyorSystemServiceImpl.backwordSearch(backWordEdges, src, dest);

				if (path.getLast().getId() != dest) {
					LinkedList<Vertex> tempPath = new LinkedList<Vertex>();
					for (Vertex vx : path) {
						tempPath.add(vx);
					}
					tempPath.removeLast();
					baggageResVO.setBagPath(path.toString());
					int count1 = getTotalTimeTravel(path, backWordEdges);

					path = conveyorSystemServiceImpl.forwardSearch(edges, path.getLast().getId(), dest);
					int count2 = getTotalTimeTravel(path, edges);
					tempPath.addAll(path);
					baggageResVO.setBagPath(tempPath.toString());
					baggageResVO.setTimeTravel(count1 + count2);
					System.out.println(baggageResVO);
					baggageResVO.setMessage("SUCCESS");
					return baggageResVO;
				} else {
					baggageResVO.setBagPath(path.toString());
					baggageResVO.setTimeTravel(getTotalTimeTravel(path, backWordEdges));
				}
			} else {
				baggageResVO.setBagPath(path.toString());
				baggageResVO.setTimeTravel(getTotalTimeTravel(path, edges));
			}
			baggageResVO.setMessage("SUCCESS");
		}else {
			baggageResVO.setMessage("Fight Gate Not Found. Please check with admin");
		}
		System.out.println(baggageResVO);
		return baggageResVO;
	}

	private void addLane(int sourceLocNo, int destLocNo, int duration) {
		Edge lane = new Edge(nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}

	public int getTotalTimeTravel(LinkedList<Vertex> path, List<Edge> edges) {
		int count = 0;
		int srs = 0;
		int dst = 1;
		for (int i = 1; i < path.size(); i++) {

			count = count + getTrivelTime(edges, path.get(srs).getId(), path.get(dst).getId());

			srs++;
			dst++;
		}
		return count;
	}

	public int getTrivelTime(List<Edge> edges, int sourceLocNo, int destLocNo) {
		int count = 0;
		for (Edge edge : edges) {
			if (edge.getSource().getId() == sourceLocNo && edge.getDestination().getId() == destLocNo) {
				count = edge.getWeight();
			}
		}
		return count;
	}
}

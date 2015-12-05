import java.util.*;

public class Algo_Solver {
	//private Queue of events
	//AVLTree of current segmentsion

	public Algo_Solver(Graph g) {
		//TODO: Preprocess shit
	}

	public List<Point> find_intersection_points() {
		//while queue not empty

		return null;
	}

	private void preprocess_segments(Segment[] segments) {
		//Make segments into events
	}

	private EndpointEvent make_event() {
		return null;
	}

	private void handle_event(EndpointEvent e) {
		switch (e.getType()) {
			case LEFT:
				//insert e.segment
				//find neighbors
				//Check for intersections with neighbors
				//If intersects:
				//	create new intersect point, insert in queue
				break;

			case RIGHT:
				//Delete e.segment from tree
				break;

			case TOP:
				//insert e.segment
				//find neighbors
				//Check for intersections with neighbors
				//If intersects:
				//	create new intersect point, insert in queue
				break;

			case BOTTOM:
				//Delete e.segment from tree
				break;

			case INTERSECT:

				break;
		}
	}




}
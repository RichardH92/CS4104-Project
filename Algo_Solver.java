import java.util.*;

public class Algo_Solver {
	//private Queue of events
	private Stack<EndpointEvent> queue;
	//private Tree of segments
	//AVLTree of current segmentsion

	public Algo_Solver(Graph g) {

		// Building array of events
		build_event_queue(g);
	}

	public void build_event_queue(Graph g) {
		// Building array of events
		Segment[] segments = g.get_segments();
		EndpointEvent[] events = new EndpointEvent[2 * segments.length];

		int event_i = 0;
		for (int i = 0; i < segments.length; i++) {
			Segment segment = segments[i];
			Point point1 = segment.get_point_a();
			Point point2 = segment.get_point_b();
			EndpointEvent event1;
			EndpointEvent event2;

			if (segment.is_horizontal()) {
				event1 = new EndpointEvent(point1, segment, Type.LEFT);
				event2 = new EndpointEvent(point2, segment, Type.RIGHT);
			}
			else {
				event1 = new EndpointEvent(point1, segment, Type.TOP);
				event2 = new EndpointEvent(point2, segment, Type.BOTTOM);
			}

			events[event_i] = event1;
			events[event_i+1] = event2;

			event_i += 2; 
		}
		
		// Sorting 
		Arrays.sort(events, new EndpointComparator());

		for (int i = 0; i < events.length; i++) {
			queue.push(events[i]);
		}
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
import java.util.*;

public class Algo_Solver {
	//private Queue of events
	private Stack<EndpointEvent> queue;
	//private Tree of segments

	public Algo_Solver(Graph g) {

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

				break;

			case RIGHT:

				break;

			case TOP:

				break;

			case BOTTOM:

				break;

			case INTERSECT:

				break;
		}
	}


}
import java.util.*;

public class Algo_Solver {
	Stack<EndpointEvent> queue;
	private AVLTree<Segment> t;
	private ArrayList<Point> i_points;

	public Algo_Solver(Graph g) {
		queue = new Stack<EndpointEvent>();
		// Building queue of events
		build_event_queue(g);
		t = new AVLTree<Segment>();
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
		i_points = new ArrayList<Point>();

		while (!queue.empty()) {
			handle_event(queue.pop());
		}

		return i_points;
	}

	private void handle_event(EndpointEvent e) {
		switch (e.getType()) {
			case LEFT:
				intersection_check_helper(e);
				break;

			case RIGHT:
				t.remove(e.segment);
				break;

			case TOP:
				intersection_check_helper(e);
				break;

			case BOTTOM:
				t.remove(e.segment);
				break;

			case INTERSECT:
				intersection_event_helper((IntersectEvent) e);

				break;
		}
	}

	private void intersection_check_helper(EndpointEvent e) {
		t.insert(e.segment);
		Segment neighbors[] = get_neighbors(e.segment);

		for (int i = 0; i < 3; i++) {
			if (neighbors[i] != null) {

				Point temp = e.segment.intersects(neighbors[i]);
				if (temp != null) {
					i_points.add(temp);
					IntersectEvent ie = new IntersectEvent(temp, e.segment, Type.INTERSECT, neighbors[i]);
					queue.push(ie);
				}
			}
		}

	}

	private void intersection_event_helper(IntersectEvent e) {

		AVLNode<Segment> temp = t.find(e.i_segment);
		AVLNode<Segment> parent = t.get_parent(temp);
		if (parent != null && parent.getLeft() == temp) {
			Point tempPoint = e.segment.intersects(parent.getElement());
			if (tempPoint != null) {
				i_points.add(tempPoint);
				IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, parent.getElement());
				queue.push(ie);	
			}
		}

		if (temp.getRight() != null) {
			Point tempPoint = e.segment.intersects(temp.getRight().getElement());
			if (tempPoint != null) {
				i_points.add(tempPoint);
				IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, temp.getRight().getElement());
				queue.push(ie);
			}
		}
	}

	private Segment[] get_neighbors(Segment s) {

		AVLNode<Segment> temp = t.find(s);
		Segment[] neighbors = new Segment[3];

		if (temp != null) {
			if (temp.getLeft() != null)
				neighbors[0] = temp.getLeft().getElement();

			if (temp.getRight() != null)
				neighbors[1] = temp.getRight().getElement();

			if (t.get_parent(temp) != null)
				neighbors[2] = t.get_parent(temp).getElement();
		}	
 
		return neighbors;

	}
}
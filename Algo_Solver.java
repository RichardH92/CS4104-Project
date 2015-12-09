import java.util.*;

public class Algo_Solver {
	Stack<EndpointEvent> queue;
	AVLTree<Segment> t;
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
			} else {
				event1 = new EndpointEvent(point1, segment, Type.TOP);
				event2 = new EndpointEvent(point2, segment, Type.BOTTOM);
			}

			events[event_i] = event1;
			events[event_i + 1] = event2;

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
			ArrayList<Segment> intersections = searchRange(t.rootAbove.getLeft(), e.segment.get_point_a().get_x_coord(), e.segment.get_point_b().get_x_coord());
			for (Segment segment : intersections) {
				i_points.add(e.segment.intersects(segment));
			}
			break;

		case TOP:
			t.insert(e.segment);
			break;

		case BOTTOM:
			t.remove(e.segment);
			break;
		}
	}

	/**
	 * Modified from:
	 * http://blog.welkinlan.com/2015/05/22/search-range-in-binary-search-tree-lintcode-java/
	 * @param  root The root of the AVL tree to start the range search on.
	 * @param  k1   The minimum range bound.
	 * @param  k2   The maximum range bound;
	 * @return      A list of segments within the desired range.
	 */
	public ArrayList<Segment> searchRange(AVLNode<Segment> root, double k1, double k2) {
		// write your code here
		ArrayList<Segment> result = new ArrayList<Segment>();
		if (root == null) {
			return result;
		}
		LinkedList<AVLNode<Segment>> stack = new LinkedList<AVLNode<Segment>>();
		while (root != null || !stack.isEmpty()) {
			//left
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				//root
				root = stack.pop();
				if (root.getElement().get_point_a().get_x_coord() >= k1 && root.getElement().get_point_a().get_x_coord() <= k2) {
					result.add(root.getElement());
				} else if (root.getElement().get_point_a().get_x_coord() > k2) {
					break;
				}
				//right
				root = root.getRight();
			}
		}
		return result;
	}
}
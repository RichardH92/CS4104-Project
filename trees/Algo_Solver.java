import java.util.*;

public class Algo_Solver {
	//private Queue of events
	//AVLTree of current segments
	AVLTree tree = new AVLTree();

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

				break;

			case RIGHT:

			break;

			case TOP:
				// e is upper Endpoint event
				if (!g.get_segments().is_horizontal) {
					tree.insert(g.get_segments());
					
				}
				break;

			case BOTTOM:
				// e is a bottom endpoint event 
				if (!g.get_segments().is_horizontal()) {
					tree.delete(g.get_segments());
				}
				break;

			case INTERSECT:

				break;
		}
	}


}
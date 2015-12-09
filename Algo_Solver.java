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
			EndpointEvent event = queue.pop();
			//System.out.println("Handling event: " + event.toString());
			//System.out.println("\n");
			handle_event(event);
		}

		return i_points;
	}

	private void handle_event(EndpointEvent e) {

		switch (e.getType()) {
		case LEFT:
			//BTreePrinter.printNode(t.rootAbove.getLeft());
			ArrayList<Segment> intersections = searchRange(t.rootAbove.getLeft(), e.segment.get_point_a().get_x_coord(), e.segment.get_point_b().get_x_coord());
			for (Segment segment : intersections) {
				i_points.add(e.segment.intersects(segment));
			}
			//intersection_check_helper(e);
			//BTreePrinter.printNode(t.rootAbove.getLeft());
			break;

		case RIGHT:
			//System.out.println("Removing: " + e.toString());
			//t.remove(e.segment);

			break;

		case TOP:
			t.insert(e.segment);
			break;

		case BOTTOM:
			t.remove(e.segment);
			break;

		/*case INTERSECT:
			intersection_event_helper((IntersectEvent) e);

			break;*/
		}
		//BTreePrinter.printNode(t.rootAbove.getLeft());
		//
		//System.out.println('\n');
	}

	private void intersection_check_helper(EndpointEvent e) {
		t.insert(e.segment);

		//Segment neighbors[] = get_neighbors(e.segment);

		/*for (int i = 0; i < 4; i++) {
			if (neighbors[i] != null) {

				Point temp = e.segment.intersects(neighbors[i]);
				if (temp != null) {
					//System.out.println("FIRST");
					i_points.add(temp);
					IntersectEvent ie = new IntersectEvent(temp, e.segment, Type.INTERSECT, neighbors[i]);
					queue.push(ie);
				}
			}
		}*/

		AVLNode<Segment> temp = t.find(e.segment);
		AVLNode<Segment> rNeighb = t.get_right_neighbor(temp);
		AVLNode<Segment> lNeighb = t.get_left_neighbor(temp);

		if (lNeighb != null) {
			Point tempPoint = e.segment.intersects(lNeighb.getElement());
			if (tempPoint != null)
				i_points.add(tempPoint);
		}
		if (rNeighb != null) {
			Point tempPoint = e.segment.intersects(rNeighb.getElement());
			if (tempPoint != null) {
				i_points.add(tempPoint);
				IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, rNeighb.getElement());
				queue.push(ie);
			}
		}

	}

	private void intersection_event_helper(IntersectEvent e) {

		AVLNode<Segment> temp = t.find(e.i_segment);
		AVLNode<Segment> rNeighb = t.get_right_neighbor(temp);
		if (rNeighb != null) {
			Point tempPoint = e.segment.intersects(rNeighb.getElement());
			if (tempPoint != null) {
				i_points.add(tempPoint);
				IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, rNeighb.getElement());
				queue.push(ie);
			}
		}

		//System.out.println(e);
		//System.out.println(temp);
		//BTreePrinter.printNode(t.rootAbove.getLeft());
		/*AVLNode<Segment> parent = t.get_parent(temp);
		if (parent != null && parent.getLeft() == temp) {
			Point tempPoint = e.segment.intersects(parent.getElement());
			if (tempPoint != null) {
				//System.out.println("SECOND");
				i_points.add(tempPoint);
				IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, parent.getElement());
				queue.push(ie);
			}
		}

		if (temp.getRight() != null) {
			if (temp.getRight().getLeft() != null && e.segment.intersects(temp.getRight().getLeft().getElement()) != null) {
				Point tempPoint = e.segment.intersects(temp.getRight().getLeft().getElement());
				if (tempPoint != null) {
					//System.out.println("THIRD");
					i_points.add(tempPoint);
					IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, temp.getRight().getLeft().getElement());
					queue.push(ie);
				}
			} 
			else {
				Point tempPoint = e.segment.intersects(temp.getRight().getElement());
				if (tempPoint != null) {
					//System.out.println("THIRD");
					i_points.add(tempPoint);
					IntersectEvent ie = new IntersectEvent(tempPoint, e.segment, Type.INTERSECT, temp.getRight().getElement());
					queue.push(ie);
				}
			}
		}*/


	}

	private Segment[] get_neighbors(Segment s) {

		AVLNode<Segment> temp = t.find(s);
		Segment[] neighbors = new Segment[5];

		if (temp != null) {
			if (temp.getLeft() != null) {
				neighbors[0] = temp.getLeft().getElement();
			}


			if (temp.getRight() != null) {
				neighbors[1] = temp.getRight().getElement();
			}


			/*if (t.get_parent(temp) != null) {
				neighbors[2] = t.get_parent(temp).getElement();
				AVLNode<Segment> parent = t.get_parent(temp);
				AVLNode<Segment> grandparent = t.get_parent(parent);

				if (grandparent != null) {
					if (temp.getElement().compareTo(parent.getElement()) == 1 &&  temp.getElement().compareTo(grandparent.getElement()) == -1) {
						neighbors[3] = grandparent.getElement();
					} else if (temp.getElement().compareTo(parent.getElement()) == -1 && temp.getElement().compareTo(grandparent.getElement()) == 1) {
						neighbors[3] = grandparent.getElement();
					}
				}
				/*if ((t.get_parent(temp)).getRight() != null && (t.get_parent(temp)).getRight() != temp) {
					neighbors[3] = t.get_parent(temp).getRight().getElement();
				}*/
				/*if ((t.get_parent(temp)).getLeft() != null && (t.get_parent(temp)).getLeft() != temp) {
					neighbors[4] = t.get_parent(temp).getLeft().getElement();
				}*/
			}


		

		return neighbors;

	}

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
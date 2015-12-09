import java.util.*;

public class Temp_Tests {
	public static void Test_EndpointEvent_Sorting() {
		Graph graph = new Graph(10);

		EndpointEvent[] points = new EndpointEvent[20];

		int j = 0;
		Segment[] segments = graph.get_segments();
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

			points[j] = event1;
			points[j+1] = event2;

			j += 2;
		}

		System.out.println("Before sorting...\n");

		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].toString());
		}

		System.out.println("After sorting...\n");

		Arrays.sort(points, new EndpointComparator());
		Stack<EndpointEvent> queue = new Stack<EndpointEvent>();
		for (int i = 0; i < points.length; i++) {
			queue.push(points[i]);
		}

		while (!queue.empty()) {
			EndpointEvent event = queue.pop();
			System.out.println(event.toString());
		}

		
	}

	public static void Test_AVLTree_getParent() {
		AVLTree<Segment> t = new AVLTree<Segment>();
		Segment seg1 = new Segment(new Point(1, 1), new Point(1, 0));
		Segment seg2 = new Segment(new Point(0, 1), new Point(2, 1));
		Segment seg3 = new Segment(new Point(2, 2), new Point(2, 1));
		t.insert(seg1);
		t.insert(seg2);
		t.insert(seg3);
		System.out.println("The parent of segment3 is " + t.get_parent(new AVLNode<Segment>(seg3)));
	}

	public static void Test_OverlappingSegmentIntersection() {
		Segment seg1 = new Segment(new Point(2, 2), new Point(5, 2));
		Segment seg2 = new Segment(new Point(3, 2), new Point(6, 2));
		Segment seg3 = new Segment(new Point(4, 4), new Point(4, 1));

		Segment[] segments = new Segment[3];
		segments[0] = seg1;
		segments[1] = seg2;
		segments[2] = seg3;
		Graph graph = new Graph(segments);

		Algo_Solver solver = new Algo_Solver(graph);
		List<Point> intersections = solver.find_intersection_points();

		System.out.println("Our algorithm:");
		for (int i = 0; i < intersections.size(); i++) {
			System.out.println(intersections.get(i).toString());
		}
		System.out.println("\n");
	}

	public static void Test_IntersectionReporting() {
		Segment[] segments = new Segment[4];

		Segment seg1 = new Segment(new Point(3.9997594942063444, 1.1787070260415378), 
			new Point(3.9997594942063444, 0.020000261528278496));

		Segment seg2 = new Segment(new Point(3.7861635976619903, 0.8320158657143462), 
			new Point(4.037321062602126, 0.8320158657143462));

		Segment seg3 = new Segment(new Point(3.889217227240601, 4.160527207318134), 
			new Point(4.468254571218756, 4.160527207318134));

		Segment seg4 = new Segment(new Point(0, 1), new Point(8, 1));

		Segment seg5 = new Segment(new Point(2, 2), new Point(2, 0));

		Segment seg6 = new Segment(new Point(4, 2), new Point(4, 0));

		Segment seg7 = new Segment(new Point(6, 2), new Point(6, 0));

		Segment seg8 = new Segment(new Point(2, 4), new Point(4, 4));

		Segment seg9 = new Segment(new Point(194.62791389197014, 478.92097998303024), new Point(194.62791389197014, 221.18980378165082));
		Segment seg10 = new Segment(new Point(252.8850765852797, 401.47227276218854), new Point(252.8850765852797, 41.457411169691426));
		Segment seg11 = new Segment(new Point(16.37750393168225, 440.1702393356628), new Point(16.37750393168225, 33.144565826296876));
		Segment seg12 = new Segment(new Point(75.95545391377867, 391.2431797582355), new Point(381.5430936774257, 391.2431797582355));
		segments[0] = seg9; // 1
		segments[1] = seg10; // 6
		segments[2] = seg11; // 7
		segments[3] = seg12; // 9
		Graph graph = new Graph(segments);

		Algo_Solver solver = new Algo_Solver(graph);
		// Checking initial queue status
		/*for (int i = 0; i < 6; i++) {
			System.out.println(solver.queue.pop().toString());
		}*/
		Brute_Force_Solver s = new Brute_Force_Solver();
		
		List<Point> i_points = s.solve(graph);
		System.out.println("Brute-force algorithm:");
		for (int i = 0; i < i_points.size(); i++) {
			System.out.println(i_points.get(i).toString());
		}
		System.out.println("\n");
		List<Point> intersections = solver.find_intersection_points();

		System.out.println("Our algorithm:");
		for (int i = 0; i < intersections.size(); i++) {
			System.out.println(intersections.get(i).toString());
		}
		System.out.println("\n");
	}



}
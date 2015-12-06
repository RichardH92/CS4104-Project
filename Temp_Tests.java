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
}
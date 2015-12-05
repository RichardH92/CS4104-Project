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
		
		AVLTree<Integer> t = new AVLTree<Integer>();
		Integer n1 = new Integer(10);
		Integer n2 = new Integer(2);
		Integer n3 = new Integer(13);
		Integer n4 = new Integer(1);
		Integer n5 = new Integer(5);
		Integer n6 = new Integer(11);
		Integer n7 = new Integer(14);
		Integer n8 = new Integer(16);
		t.insert(n1);
		t.insert(n2);
		t.insert(n3);
		t.insert(n4);
		t.insert(n5);
		t.insert(n6);
		t.insert(n7);
		t.insert(n8);
		System.out.println("The parent of " + n8 + " is " + t.get_parent(new AVLNode<Integer>(n8)));
	}
}
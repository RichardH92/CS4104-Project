import java.util.*;
import trees.*;

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

		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].toString());
		}
		AVLTree t = new AVLTree();
		t.insert(10); 
		t.insert(1);
		t.insert(3);
		System.out.println(t.get_parent(t.insert(1)));
	}
}
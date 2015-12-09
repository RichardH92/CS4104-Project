import java.util.*;
import java.io.*;
public class Test_Segment {

	public static boolean Test_Intersection_True() {
		System.out.print("Test_Intersection_True...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 0);
		Point b2 = new Point(2, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && (s.intersects(t) != null);
		ret = ret && (t.intersects(s) != null);

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Intersection_False() {
		System.out.print("Test_Intersection_False...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(5, 8);
		Point b2 = new Point(5, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && s.intersects(t) == null;
		ret = ret && t.intersects(s) == null;

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Intersection_Same_Orientation() {
		System.out.print("Test_Intersection_Same_Orientation...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(4, 1);
		Point b2 = new Point(6, 1);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);


		boolean ret = true;

		Point test_one = s.intersects(t);
		Point test_two = t.intersects(s);

		ret = ret && s.intersects(t) != null;
		ret = ret && t.intersects(s) != null;
		ret = ret && test_one.Equals(test_two);
		ret = ret && test_one.Equals(new Point(4, 1));

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Intersection_Equal_Endpoints() {
		System.out.print("Test_Intersection_Equal_Endpoints...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(0, 1);
		Point b2 = new Point(0, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);


		boolean ret = true;

		Point test_one = s.intersects(t);
		Point test_two = t.intersects(s);

		ret = ret && s.intersects(t) != null;
		ret = ret && t.intersects(s) != null;
		ret = ret && test_one.Equals(test_two);
		ret = ret && test_one.Equals(new Point(0, 1));

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Intersection_Overlap_Endpoint() {
		System.out.print("Test_Intersection_Overlap_Endpoint...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(1, 1);
		Point b2 = new Point(1, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);


		boolean ret = true;

		ret = ret && s.intersects(t) != null;
		ret = ret && t.intersects(s) != null;

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;

	}

	public static boolean Test_Is_Horizontal() {
		System.out.print("Test_Is_Horizontal...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 0);
		Point b2 = new Point(2, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && s.is_horizontal();
		ret = ret && !t.is_horizontal();

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Overlaps_True() {
		System.out.print("Test_Overlaps_True...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 1);
		Point b2 = new Point(6, 1);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && s.overlaps(t);
		ret = ret && t.overlaps(s);

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Overlaps_False() {
		System.out.print("Test_Overlaps_False...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 3);
		Point b2 = new Point(6, 3);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && !s.overlaps(t);
		ret = ret && !t.overlaps(s);

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static boolean Test_Overlaps_Equal_Endpoints() {
		System.out.print("Test_Overlaps_Equal_Endpoints...\t");

		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(0, 1);
		Point b2 = new Point(0, 3);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && !s.overlaps(t);
		ret = ret && !t.overlaps(s);

		if (ret)
			System.out.println("Pass\r\n");
		else
			System.out.println("Fail\r\n");

		return ret;
	}

	public static void Test_Running_Time_For_n_Segments(int n) {
		String filename = "IntersectionsFor" + n + "Segments.txt";
		System.out.println("---------------------------------\n");
		System.out.println("Outputting to " + filename);
		File file = new File(filename);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			Graph graph = new Graph(n);

			long startTime = System.nanoTime();
			List<Point> bruteForce_i_points = Brute_Force_Solver.solve(graph);
			long endTime = System.nanoTime();

			long totalTime = (endTime - startTime) / 1000000;
			String bruteForceRunTime = "Brute force algorithm with " + n + " segments ran for " + totalTime + " milliseconds\nReported " + bruteForce_i_points.size() / 2 + " intersection points.\n";
			System.out.println(bruteForceRunTime);

			Algo_Solver solver = new Algo_Solver(graph);
			startTime = System.nanoTime();
			List<Point> algo_i_points = solver.find_intersection_points();
			endTime = System.nanoTime();

			totalTime = (endTime - startTime) / 1000000;
			String algorithmRunTime = "Our algorithm with " + n + " segments ran for " + totalTime + " milliseconds\nReported " + algo_i_points.size() + " intersection points.\n";
			System.out.println(algorithmRunTime);
			
			writer.println("Summary:");
			writer.println(bruteForceRunTime);
			writer.println(algorithmRunTime);
			writer.println("Segments:");
			for (Segment segment : graph.get_segments()) {
				writer.println(segment);
			}
			writer.println("\n");
			writer.println("Intersections:");
			for (Point point : algo_i_points) {
				writer.println(point);
			}
			writer.close();


		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}







	}
}
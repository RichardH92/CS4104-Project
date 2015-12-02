public class Test_Segment {

	public static boolean Test_Segment_Intersections() {
		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 0);
		Point b2 = new Point(2, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && s.intersects(t) != null;
		ret = ret && t.intersects(s) != null;

		return ret;
	}

	public static boolean Test_Is_Horizontal() {
		Point a1 = new Point(0, 1);
		Point a2 = new Point(4, 1);

		Point b1 = new Point(2, 0);
		Point b2 = new Point(2, 4);

		Segment s = new Segment(a1, a2);
		Segment t = new Segment(b1, b2);

		boolean ret = true;

		ret = ret && !s.is_horizontal();
		ret = ret && t.is_horizontal();

		return ret;
	}
}
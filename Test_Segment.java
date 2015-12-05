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
}
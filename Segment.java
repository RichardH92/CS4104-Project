public class Segment {
	private Point a = null;
	private Point b = null;

	public Segment(Point p_a, Point p_b) {
		a = p_a;
		b = p_b;
	}

	public Point get_point_a() {
		return a;
	}

	public Point get_point_b() {
		return b;
	} 

	public Point intersects(Segment t) {
		return null;
	}

}

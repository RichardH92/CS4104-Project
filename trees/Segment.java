import java.util.*;

public class Segment implements Comparable<Segment>{
	private final double DEFAULT_MIN_X = 0.0;
	private final double DEFAULT_MAX_X = 100.0;
	private final double DEFAULT_MIN_Y = 0.0;
	private final double DEFAULT_MAX_Y = 100.0;

	private Point a = null;
	private Point b = null;

	@Override
	public int compareTo(Segment otherSegment) {
		double thisXCoord = this.get_point_a().get_x_coord();
		double otherXCoord = otherSegment.get_point_a().get_x_coord();

		if (thisXCoord > otherXCoord) {
			return 1;
		}
		else if (thisXCoord < otherXCoord) {
			return -1;
		}
		else {
			return 0;
		}
	}

	public Segment(Point p_a, Point p_b) {
		assert(a.get_x_coord() == b.get_x_coord() || a.get_y_coord() == b.get_y_coord());
		a = p_a;
		b = p_b;
	}

	public Segment() {
		contsructor_helper(DEFAULT_MIN_X, DEFAULT_MAX_X, DEFAULT_MIN_Y, DEFAULT_MAX_Y);
	}

	public Segment(double min_x, double max_x, double min_y, double max_y) {
		contsructor_helper(min_x, max_x, min_y, max_y);
	}

	private void contsructor_helper(double min_x, double max_x, double min_y, double max_y) {
		Random random = new Random();
		int horizontal = random.nextInt(2) + 0;

		if (horizontal == 1) {
			double x1 = min_x + (max_x - min_x) * random.nextDouble();
			double x2 = min_x + (max_x - min_x) * random.nextDouble();
			double y = min_y + (max_y - min_y) * random.nextDouble();

			a = new Point(x1, y);
			b = new Point(x2, y);
		}
		else {
			double y1 = min_y + (max_y - min_y) * random.nextDouble();
			double y2 = min_y + (max_y - min_y) * random.nextDouble();
			double x = min_x + (max_x - min_x) * random.nextDouble();

			a = new Point(x, y1);
			b = new Point(x, y2);	
		}
	}
	public Point get_point_a() {
		return a;
	}

	public Point get_point_b() {
		return b;
	}

	public Point intersects(Segment t) {
		boolean this_horiz = is_horizontal();
		boolean t_horiz = t.is_horizontal();

		Point t_a = t.get_point_a();
		Point t_b = t.get_point_b();

		//Same orientations
		if (this_horiz == t_horiz) {

			if (t_a.Equals(a) || t_a.Equals(b))
				return t_a;
			else if (t_b.Equals(b) || t_b.Equals(a))
				return t_b;
			
			return null;
		}


		//Different orientations
		double x1, x2, h_y;
		double y1, y2, v_x;

		if (this_horiz) {
			x1 = a.get_x_coord();
			x2 = b.get_x_coord();
			h_y = a.get_y_coord();
			y1 = t_a.get_y_coord();
			y2 = t_b.get_y_coord();
			v_x = t_a.get_x_coord();
		}
		else {
			x1 = t_a.get_x_coord();
			x2 = t_b.get_x_coord();
			h_y = t_a.get_y_coord();
			y1 = a.get_y_coord();
			y2 = b.get_y_coord();
			v_x = a.get_x_coord();
		}

		if (x2 < x1) {
			double temp = x2;
			x2 = x1;
			x1 = temp;
		}
		if (y2 < y1) {
			double temp = y2;
			y2 = y1;
			y1 = temp;
		}

		if ((x1 <= v_x) && (v_x <= x2) && (y1 <= h_y) && (h_y <= y2))
			return new Point(v_x, h_y);

		return null;
	}

	public boolean overlaps(Segment t) {
		boolean this_horizontal = this.is_horizontal();
		boolean t_horizontal = t.is_horizontal();
		
		// Segments are different orientations
		if (this_horizontal != t_horizontal)
			return false;
	
		// Both segments are horizontal
		if (t_horizontal) {
			assert(t.get_point_a().get_y_coord() == t.get_point_b().get_y_coord());
			assert(a.get_y_coord() == b.get_y_coord());

			if (a.get_y_coord() == t.get_point_a().get_y_coord()) {
				double x1 = a.get_x_coord();
				double x2 = b.get_x_coord();
				if (x2 < x1) {
					double temp = x2;
					x2 = x1;
					x1 = temp; 
				}

				double x3 = t.get_point_a().get_x_coord();
				double x4 = t.get_point_b().get_x_coord();
				if (x4 < x3) {
					double temp = x4;
					x4 = x3;
					x3 = temp; 
				}

				if (x1 <= x3 && x2 >= x3) {
					return true;
				}
				else if (x3 <= x1 && x4 >= x1) {
					return true;
				}
				//TODO: Check if the x coordinates overlap
			}

			return false;
		}

		// Both segments are vertical
		else {
			if (a.get_x_coord() == t.get_point_a().get_x_coord()) {
				double y1 = a.get_y_coord();
				double y2 = b.get_y_coord();
				if (y2 < y1) {
					double temp = y2;
					y2 = y1;
					y1 = temp; 
				}

				double y3 = t.get_point_a().get_y_coord();
				double y4 = t.get_point_b().get_y_coord();
				if (y4 < y3) {
					double temp = y4;
					y4 = y3;
					y3 = temp; 
				}

				if (y1 <= y3 && y2 >= y3) {
					return true;
				}
				else if (y3 <= y1 && y4 >= y1) {
					return true;
				}
			}

			return false;
		}
	}

	public boolean is_horizontal() {
		if (a.get_x_coord() == b.get_x_coord())
			return false;

		assert(a.get_y_coord() == b.get_y_coord());
			return true;
	}

	public boolean Equals(Segment t) {
		if (a.Equals(t.get_point_a()) && b.Equals(t.get_point_b()))
			return true;

		return false;	
	}

	public String toString() {
		String ret = "{" + a.toString() + ", " + b.toString() + "}";

		return ret;
	}
}


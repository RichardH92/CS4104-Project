public class Point {
	private double x_coord = 0.0;
	private double y_coord = 0.0;

	public Point(double p_x, double p_y) {
		x_coord = p_x;
		y_coord = p_y;
	}

	public double get_x_coord() {
		return x_coord; 
	}

	public double get_y_coord() {
		return y_coord;
	}

	public boolean Equals(Point p) {
		if (x_coord == p.get_x_coord() && y_coord == p.get_y_coord())
			return true;

		else return false;	
	}

	public String toString() {
		String ret = "(" + x_coord + "," + " " + y_coord + ")";

		return ret;
	}

	@Override
	public boolean equals(Object other) {
		Point p = (Point) other;

		return x_coord == p.get_x_coord() && y_coord == p.get_y_coord();
	}
}

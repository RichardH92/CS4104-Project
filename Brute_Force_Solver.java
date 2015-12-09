import java.util.*;

public class Brute_Force_Solver {
	
	private ArrayList<Segment> horizontal;
	private ArrayList<Segment> vertical;

	public Brute_Force_Solver() {
		horizontal = new ArrayList<Segment>();
		vertical = new ArrayList<Segment>();
	}

	public void preProcessSegments(Graph g) {
		Segment[] s = g.get_segments();
		for (int i = 0; i < s.length; i++) {
			if (s[i].is_horizontal()) {
				horizontal.add(s[i]);
			}
			else {
				vertical.add(s[i]);
			}
		}
	}

	public List<Point> solve(Graph g) {
		ArrayList<Point> i_list = new ArrayList<Point>();

		for (int i = 0; i < horizontal.size(); i++) {
			for (int j = 0; j < vertical.size(); j++) {
					Point p = horizontal.get(i).intersects(vertical.get(j));

					if (p != null)
						i_list.add(p);
			}
		}
		return i_list;
	}
}
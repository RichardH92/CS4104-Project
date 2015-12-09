import java.util.*;

public class Brute_Force_Solver {
	
	public static List<Point> solve(Graph g) {
		Segment[] s = g.get_segments();
		ArrayList<Point> i_list = new ArrayList<Point>();

		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				if (i != j) {
					Point p = s[i].intersects(s[j]);

					if (p != null)
						i_list.add(p);
				}
			}
		}

		return i_list;
	}
}
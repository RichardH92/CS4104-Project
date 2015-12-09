public class Graph {
	private final int DEFAULT_NUM_SEGMENTS = 2000;
	private final double DEFAULT_MIN_X = 0.0;
	private final double DEFAULT_MAX_X = 100000.0;
	private final double DEFAULT_MIN_Y = 0.0;
	private final double DEFAULT_MAX_Y = 100000.0;
	private Segment[] segments;

	public Graph() {
		constructer_helper(DEFAULT_NUM_SEGMENTS);
	}

	public Graph(int num_segments) {
		constructer_helper(num_segments);
	}

	public Graph(Segment[] p_segments) {
		segments = p_segments;
	}

	private void constructer_helper(int num_segments) {
		segments = new Segment[2 * num_segments];

		for(int i = 0; i < num_segments; i++) {

			segments[i] = new Segment(DEFAULT_MIN_X, DEFAULT_MAX_X, DEFAULT_MIN_Y, DEFAULT_MAX_Y, true);
		}
		for(int i = num_segments; i < 2 * num_segments; i++) {

			segments[i] = new Segment(DEFAULT_MIN_X, DEFAULT_MAX_X, DEFAULT_MIN_Y, DEFAULT_MAX_Y, false);
		}
			/*boolean overlaps = true;
			Segment temp = null;

			while (overlaps) {
				overlaps = false;
				temp = new Segment(DEFAULT_MIN_X, DEFAULT_MAX_X, DEFAULT_MIN_Y, DEFAULT_MAX_Y);
				for (int i = 0; i < num)
				/*for(int j = 0; j < i; j++) {
					if (i != j) {
						if (temp.overlaps(segments[j])) {
							overlaps = true;
							break;
						}
					}
				}
			}

			segments[i] = temp;
		}*/
	}

	public String toString() {
		String ret = "";

		for (int i = 0; i < segments.length; i++) {
			ret += segments[i].toString() + "\n";
		}

		return ret;
	}

	public Segment[] get_segments() {
		return segments;
	}

}

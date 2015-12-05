import java.util.*;

public class EndpointComparator implements Comparator<EndpointEvent> {

	@Override
	public int compare(EndpointEvent a, EndpointEvent b) {
		if (a.point.get_y_coord() > b.point.get_y_coord()) {
			return 1;
		}
		else if (a.point.get_y_coord() < b.point.get_y_coord()) {
			return -1;
		}
		else {
			return 0;
		}
	}
}